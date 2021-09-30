package edu.awieclawski.util;

import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;

import edu.awieclawski.base.BaseEntity;
import edu.awieclawski.service.Pair;

/**
 * build & get appropriate persist order of entities
 * 
 * @author AWieclawski
 *
 */
public class PersistOrderUtils {

	private static int marker = -1; // marker of FIRST initial run in recurrence loops
	private static BaseEntity currentParent = null;
	private static BaseEntity previousParent = null;

	public static Stack<Pair> getPersistPairsStack(BaseEntity entity) {
		initialFieldsReset();
		Stack<Pair> stack = buildPersistPairsStack(entity);
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
	private static Stack<Pair> buildPersistPairsStack(BaseEntity entity) {
		Stack<Pair> stackPairs = new Stack<>();

		if (entity != null)
			if (marker < 0) {
				stackPairs.push(new Pair(null, entity));
				previousParent = entity;
			} else
				stackPairs.push(new Pair(currentParent, entity));

		Map<String, BaseEntity> entityMap = EntityUtils.getMapOfRecordFieldsFromClass((BaseEntity) entity);

		if (entityMap.size() > 0)
			currentParent = entity;

		for (Entry<String, BaseEntity> entry : entityMap.entrySet()) {

			BaseEntity value = entry.getValue();

			if (value != null)
				stackPairs.push(new Pair(currentParent, value));

			Map<String, BaseEntity> innerMap = EntityUtils.getMapOfRecordFieldsFromClass((BaseEntity) value);

			if (innerMap.size() > 0) {
				previousParent = currentParent;
				stackPairs.pop();
				marker = stackPairs.size(); // after first run should be > 0
				stackPairs.addAll(buildPersistPairsStack(value));
			} else
				currentParent = previousParent;
		}
		return stackPairs;
	}

	/**
	 * fields should be reset before each static method calling
	 */
	private static void initialFieldsReset() {
		currentParent = null;
		previousParent = null;
		marker = -1;
	}

}
