package edu.awieclawski.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.awieclawski.model.Address;
import edu.awieclawski.model.Company;
import edu.awieclawski.model.JobContract;
import edu.awieclawski.model.Person;

/**
 * builds list of classes used by servlets
 * 
 * get class from list of allowed by name
 * 
 * @author AWieclawski
 *
 */
public class AllowedEntities {

	/**
	 * list of allowed entity classes
	 * 
	 * @return
	 */
	public static List<Class<? extends BaseEntity>> getEntityClassesList() {
		List<Class<? extends BaseEntity>> list = new ArrayList<>();
		for (BaseEntity tmpEntity : getEntitiesList())
			list.add(tmpEntity.getClass());
		return list;
	}

	/**
	 * 
	 * list of allowed entities
	 * 
	 * @return
	 */
	public static List<BaseEntity> getEntitiesList() {
		return (Arrays.asList(new Address(), new Person(),new Company(),new JobContract()));
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
		for (BaseEntity tmpEntity : getEntitiesList()) {
			if (tmpEntity.getClass().getName().equals(entityName)) {
				if (tmpEntity != null)
					return tmpEntity;
			}
		}
		return null;
	}

	public static BaseEntity getAllowedEntityContainingName(String entityName) {
		for (BaseEntity tmpEntity : getEntitiesList()) {
			if (tmpEntity.getClass().getName().toLowerCase().contains(entityName.toLowerCase())) {
				if (tmpEntity != null)
					return tmpEntity;
			}
		}
		return null;
	}

	// used in menu.jsp
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
