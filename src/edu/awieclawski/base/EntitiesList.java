package edu.awieclawski.base;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.awieclawski.model.Address;
import edu.awieclawski.model.Person;

/**
 * builds list of classes used by servlets
 * 
 * get class from list of allowed by name
 * 
 * @author AWieclawski
 *
 */
public class EntitiesList {

	/**
	 * list of allowed classes
	 * 
	 * @return
	 */
	public static List<Class<? extends BaseEntity>> getEntityClassesList() {
		return (Arrays.asList(Address.class, Person.class));
	}

	/**
	 * 
	 * list of allowed entities
	 * 
	 * @return
	 */
	public static List<BaseEntity> getEntitiesList() {
		return (Arrays.asList(new Address(), new Person()));
	}

	public static Class<? extends BaseEntity> getAllowedEntityClassByName(String entityName) {
		List<Class<? extends BaseEntity>> list = (List<Class<? extends BaseEntity>>) getEntityClassesList();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(entityName)) {
				return (Class<? extends BaseEntity>) list.get(i);
			}
		}

		return null;
	}

	public static BaseEntity getAllowedEntityByName(String entityName) {
		System.out.println("entityName=" + entityName);
		for (BaseEntity tmpEntity : getEntitiesList()) {
			if (tmpEntity.getClass().getName().equals(entityName)) {
				if (tmpEntity != null)
				return tmpEntity;
			}
		}
		return null;
	}

	public static Map<String, String> getAllowedUploadPathMap() {
		Map<String, String> map = new HashMap<>();
		for (BaseEntity tmpEntity : getEntitiesList()) {
			map.put(tmpEntity.getEntityHeaderName(), tmpEntity.getEntityUploadPath());
		}
		return map;
	}

	public static Map<String, String> getAllowedListPathMap() {
		Map<String, String> map = new HashMap<>();
		for (BaseEntity tmpEntity : getEntitiesList()) {
			map.put(tmpEntity.getEntityHeaderName(), tmpEntity.getEntityListPath());
		}
		return map;
	}

}
