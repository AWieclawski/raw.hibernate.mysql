package edu.awieclawski.test;

import java.util.List;
import java.util.Map;

import edu.awieclawski.base.AllowedEntities;
//import edu.awieclawski.dao.EntitiesDao;
import edu.awieclawski.model.Address;
import edu.awieclawski.model.Person;
import edu.awieclawski.util.DateUtils;
import edu.awieclawski.util.EntityUtils;

public class EntityUtilTests {

	public static void main(String[] args) {

		Address post = new Address();
		post.setCountry("Poland");
		post.setCity("Warszawa");
		post.setPostalCode("23-213");
		post.setStreetName("Postowa");
		post.setStreetNumber("23D");

		Person pers = new Person();
		pers.setBirthDate(DateUtils.parse("1989-09-23"));
		System.out.println(" -- " + pers.getBirthDate());
		pers.setFirstName("Andy");
		pers.setLastName("Rewinsky");
		pers.setGovermentNo("XX-334-545-765");
//		pers.setAddressRecord(post);

		Person obj = pers;

		// new ArrayList<>(Arrays.asList(Address.class, Person.class));
		List<?> list = AllowedEntities.getEntityClassesList();

		System.out.println("id=" + EntityUtils.getEntityTypeIdIdByBaseEntity(obj, list));
		System.out.println("mark=" + EntityUtils.getEntityTypeMarkByBaseEntity(obj, list));
		System.out.println("link=" + EntityUtils.getEntityLinkByBaseEntity(obj, list));
		System.out.println("head=" + EntityUtils.getEntityHeaderByBaseEntity(obj, list));
		Map<String, Object> labelsMap = EntityUtils.getMapOfFieldsAndValuesFromClass(obj);
		System.out.println("valuesmap=" + labelsMap.toString());

		System.out.println("entityFromMap=" + EntityUtils.getEntityFromMap(labelsMap, obj).toString());
		System.out.println("mapOfRecordFieldsFromClass=" + EntityUtils.getMapOfRecordFieldsFromClass(obj).toString());

		System.out.println(" - obj class name=" + obj.getClass().getName());
		System.out.println("entityClassesList=" + AllowedEntities.getEntityClassesList());
		System.out.println(
				"entityClassFromString=" + AllowedEntities.getAllowedEntityClassByName(obj.getClass().getName()));
		System.out.println("entityFromString=" + AllowedEntities.getAllowedEntityByName(obj.getClass().getName()));
		System.out.println("uploadPathMap=" + AllowedEntities.getAllowedUploadPathMap().toString());
		System.out.println("listPathMap=" + AllowedEntities.getAllowedListPathMap().toString());

		// save test

//		EntitiesDao entityDao = new EntitiesDao();
//
//		if (entityDao.saveAddress(obj) != null)
//			System.out.println("Entity not saved: " + obj.toString());

	}

}
