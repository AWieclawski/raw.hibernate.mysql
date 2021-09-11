package edu.awieclawski.base;

import java.util.Arrays;
import java.util.List;

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
	public static List<Class<? extends BaseEntity>> getEntitiesList() {
		return (Arrays.asList(Address.class, Person.class));
	}

	public static Class<? extends BaseEntity> getAllowedEntityByName(String entityName) {
		List<Class<? extends BaseEntity>> list = (List<Class<? extends BaseEntity>>) getEntitiesList();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(entityName)) {
				return (Class<? extends BaseEntity>) list.get(i);
			}
		}

		return null;
	}

}
