package edu.awieclawski.service;

import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;

import edu.awieclawski.base.BaseEntity;
import edu.awieclawski.util.EntityUtils;

/**
 * must be initialized to get appropriate persist order of entities
 * 
 * @author AWieclawski
 *
 */
public class PersistOrderService {

	private BaseEntity masterParent = null;
	private BaseEntity currentParent = null;
	private BaseEntity previousParent = null;
	private Stack<Pair> stackPairs = new Stack<>();
	private Stack<BaseEntity> stackEntities = new Stack<>();

	public Stack<Pair> getPersistPairsStack(BaseEntity entity) {
		getPersistEntitiesStack(entity);
		return stackPairs;
	}

	public Stack<BaseEntity> getStackEntities(BaseEntity entity) {
		getPersistEntitiesStack(entity);
		return stackEntities;
	}

	public BaseEntity getMasterParent() {
		return masterParent;
	}

	/**
	 * Recurrent building the Stack of entities pairs to save in appropriate order
	 * 
	 * tested for 2 levels of entity tree
	 * 
	 * @param entity
	 * @return
	 */
	private void getPersistEntitiesStack(BaseEntity entity) {
//		Stack<BaseEntity> stackEntities = new Stack<>();

		if (entity != null) {
			if (stackPairs.size() == 0) {
				stackPairs.push(new Pair(null, entity));
				masterParent = entity;
				previousParent = entity;
			} else {
				stackPairs.push(new Pair(currentParent, entity));
			}
			stackEntities.push(entity);
		}

		Map<String, BaseEntity> entityMap = EntityUtils.getMapOfRecordFieldsFromClass((BaseEntity) entity);

		if (entityMap.size() > 0) {
			currentParent = entity;
		}

		for (Entry<String, BaseEntity> entry : entityMap.entrySet()) {

			BaseEntity value = entry.getValue();

			if (value != null) {
				stackEntities.push(value);
				stackPairs.push(new Pair(currentParent, value));
			}

			Map<String, BaseEntity> innerMap = EntityUtils.getMapOfRecordFieldsFromClass((BaseEntity) value);

			if (innerMap.size() > 0) {
				previousParent = currentParent;
				stackPairs.pop();
				stackEntities.pop(); // remove just pushed 'value' - it will be pushed as 'entity'
				getPersistEntitiesStack(value);
			} else {
				currentParent = previousParent;
			}
		}

	}

}
