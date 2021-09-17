package edu.awieclawski.util;

import java.util.Map;
import java.util.Stack;
import java.util.Map.Entry;

import edu.awieclawski.base.BaseEntity;

public class StackUtils {

	/**
	 * Recurrent building the Stack of entities to save in appropriate order 
	 * 
	 * @param entity
	 * @return
	 */
	public static Stack<BaseEntity> getStackEntitiesToSave(BaseEntity entity) {
		Stack<BaseEntity> stackOut = new Stack<>();

		if (entity != null)
			stackOut.push(entity);

		Map<String, BaseEntity> entityMap = EntityUtils.getMapOfRecordFieldsFromClass((BaseEntity) entity);

		for (Entry<String, BaseEntity> entry : entityMap.entrySet()) {

			BaseEntity value = entry.getValue();

			if (value != null)
				stackOut.push(value);

			Map<String, BaseEntity> innerMap = EntityUtils.getMapOfRecordFieldsFromClass((BaseEntity) value);

			if (innerMap.size() > 0) {
				stackOut.pop(); // remove just pushed 'value' - it will be pushed as 'entity'
				stackOut.addAll(getStackEntitiesToSave(value));
			}
		}
		return stackOut;
	}

}
