package edu.awieclawski.util;

import java.util.List;
import java.util.Map;

import edu.awieclawski.base.EntitiesList;
import edu.awieclawski.dao.EntitiesDao;
import edu.awieclawski.model.Address;
import edu.awieclawski.model.Person;

public class EntityUtilTests {

	public static void main(String[] args) {

		Address post = new Address();
		post.setCountry("Poland");
		post.setCity("Warszawa");
		post.setPostalCode("23-213");
		post.setStreetName("Postowa");
		post.setStreetNumber("23D");

		Person pers = new Person();
		pers.setBirthDate(DateUtility.parse("1989-09-23"));
		System.out.println(" -- " + pers.getBirthDate());
		pers.setFirstName("Andy");
		pers.setLastName("Rewinsky");
		pers.setGovermentNo("XX-334-545-765");
		pers.setAddress(post);

		Person obj = pers;

		List<?> list = EntitiesList.getEntityClassesList(); // new ArrayList<>(Arrays.asList(Address.class,
															// Person.class));

		System.out.println("id=" + EntityUtils.getEntityTypeIdIdByBaseEntity(obj, list));
		System.out.println("mark=" + EntityUtils.getEntityTypeMarkByBaseEntity(obj, list));
		System.out.println("link=" + EntityUtils.getEntityLinkByBaseEntity(obj, list));
		System.out.println("head=" + EntityUtils.getEntityHeaderByBaseEntity(obj, list));
		Map<String, Object> labelsMap = EntityUtils.getMapOfFieldsAndValuesFromClass(obj);
		System.out.println("valuesmap=" + labelsMap.toString());
		System.out.println("labelsmap=" + EntityUtils.getMapOfFieldsAndLabelsFromClass(obj).toString());
		System.out.println("entityFromMap=" + EntityUtils.getEntityFromMap(labelsMap, obj));

		System.out.println(" - obj class name=" + obj.getClass().getName());
		System.out.println("entityClassesList=" + EntitiesList.getEntityClassesList());
		System.out
				.println("entityClassFromString=" + EntitiesList.getAllowedEntityClassByName(obj.getClass().getName()));
		System.out.println("entityFromString=" + EntitiesList.getAllowedEntityByName(obj.getClass().getName()));
		System.out.println("uploadPathMap=" + EntitiesList.getAllowedUploadPathMap().toString());
		System.out.println("listPathMap=" + EntitiesList.getAllowedListPathMap().toString());

		// save test

		EntitiesDao entityDao = new EntitiesDao();

		if (entityDao.saveAddress(obj) != null)
			System.out.println("Entity not saved: " + obj.toString());

	}

}
