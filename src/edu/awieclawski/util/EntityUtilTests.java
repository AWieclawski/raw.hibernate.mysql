package edu.awieclawski.util;

import java.util.List;
import java.util.Map;

import edu.awieclawski.base.EntitiesList;
import edu.awieclawski.model.Address;

public class EntityUtilTests {

	public static void main(String[] args) {

		Address post = new Address();
		post.setCountry("Poland");
		post.setCity("Warszawa");
		post.setPostalCode("23-213");
		post.setStreetName("Postowa");
		post.setStreetNumber("23D");
		Address obj = post;

		List<?> list = EntitiesList.getEntityClassesList(); // new ArrayList<>(Arrays.asList(Address.class,
															// Person.class));

		System.out.println("id=" + EntityUtils.getEntityTypeIdIdByBaseEntity(obj, list));
		System.out.println("mark=" + EntityUtils.getEntityTypeMarkByBaseEntity(obj, list));
		System.out.println("link=" + EntityUtils.getEntityLinkByBaseEntity(obj, list));
		System.out.println("head=" + EntityUtils.getEntityHeaderByBaseEntity(obj, list));
		Map<String, Object> labelsMap = EntityUtils.getMapOfFieldsAndValuesFromClass(obj);
		System.out.println("valuesmap=" + labelsMap.toString());
		System.out.println("labelsmap=" + EntityUtils.getMapOfFieldsAndLabelsFromClass(obj).toString());
		System.out.println("entityFromMap=" + EntityUtils.getEntityFromMap(labelsMap, post));
		System.out.println(" - post class name=" + post.getClass().getName());
		System.out.println(
				"entityClassFromString=" + EntitiesList.getAllowedEntityClassByName(post.getClass().getName()));
		System.out.println("entityFromString=" + EntitiesList.getAllowedEntityByName(post.getClass().getName()));
		System.out.println("uploadPathMap=" + EntitiesList.getAllowedUploadPathMap().toString());
		System.out.println("listPathMap=" + EntitiesList.getAllowedListPathMap().toString());

	}

}
