package edu.awieclawski.service;

import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;

import edu.awieclawski.base.BaseEntity;
import edu.awieclawski.util.EntityUtils;

/**
 * build & get appropriate persist order of entities
 * 
 * @author AWieclawski
 *
 */
public class PersistOrderService {

	private static int marker = -1; // marker of initial run in recurrence

	public static Stack<Pair> getPersistPairsStack(BaseEntity entity) {
		BaseEntity currentParent = null;
		BaseEntity previousParent = null;
		marker = -1;
		Stack<Pair> stack = buildPersistPairsStack(entity, currentParent, previousParent);
		return stack;
	}

	/**
	 * Recurrent building the Stack of entities to save in appropriate order
	 * 
	 * @param entity
	 * @return
	 */
	public static Stack<BaseEntity> getPersistEntitiesStack(BaseEntity entity) {
		Stack<BaseEntity> stackEntities = new Stack<>();

		if (entity != null)
			stackEntities.push(entity);

		Map<String, BaseEntity> entityMap = EntityUtils.getMapOfRecordFieldsFromClass((BaseEntity) entity);

		for (Entry<String, BaseEntity> entry : entityMap.entrySet()) {

			BaseEntity value = entry.getValue();

			if (value != null)
				stackEntities.push(value);

			Map<String, BaseEntity> innerMap = EntityUtils.getMapOfRecordFieldsFromClass((BaseEntity) value);

			if (innerMap.size() > 0) {
				stackEntities.pop(); // remove just pushed 'value' - it will be pushed as 'entity'
				stackEntities.addAll(getPersistEntitiesStack(value));
			}
		}
		return stackEntities;
	}

	/**
	 * Recurrent building the Stack of entities pairs to save in appropriate order
	 * 
	 * @param entity
	 * @return
	 */
	private static Stack<Pair> buildPersistPairsStack(BaseEntity entity, BaseEntity currentParent,
			BaseEntity previousParent) {
		Stack<Pair> stackPairs = new Stack<>();

		if (entity != null)
			if (marker < 0) {
				stackPairs.push(new Pair(null, entity));
				previousParent = entity;
			} else {
				stackPairs.push(new Pair(currentParent, entity));
			}

		Map<String, BaseEntity> entityMap = EntityUtils.getMapOfRecordFieldsFromClass((BaseEntity) entity);

		if (entityMap.size() > 0)
			currentParent = entity;

		for (Entry<String, BaseEntity> entry : entityMap.entrySet()) {

			BaseEntity value = entry.getValue();

			if (value != null) {
				stackPairs.push(new Pair(currentParent, value));
			}

			Map<String, BaseEntity> innerMap = EntityUtils.getMapOfRecordFieldsFromClass((BaseEntity) value);

			if (innerMap.size() > 0) {
				previousParent = currentParent;
				stackPairs.pop();
				marker = stackPairs.size();
				stackPairs.addAll(buildPersistPairsStack(value, currentParent, previousParent));
			} else
				currentParent = previousParent;
		}
		return stackPairs;
	}

}
