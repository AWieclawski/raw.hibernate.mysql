package edu.awieclawski.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import edu.awieclawski.base.BaseEntity;
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

		List<?> list = new ArrayList<>(Arrays.asList(Address.class, Message.class, Post.class));

		System.out.println("id=" + EntityUtils.getEntityTypeIdIdByBaseEntity(obj, list));
		System.out.println("mark=" + EntityUtils.getEntityTypeMarkByBaseEntity(obj, list));
		System.out.println("link=" + EntityUtils.getEntityLinkByBaseEntity(obj, list));
		System.out.println("head=" + EntityUtils.getEntityHeaderByBaseEntity(obj, list));
		Map<String, Object> labelsMap = EntityUtils.getMapOfFieldsAndValuesFromClass(obj);
		System.out.println("valuesmap=" + labelsMap.toString());
		System.out.println("labelsmap=" + EntityUtils.getMapOfFieldsAndLabelsFromClass(obj).toString());
		System.out.println("makeEntity=" + EntityUtils.getEntityFromMap(labelsMap, post));

	}

}

// inner classes for tests only
class Comment extends BaseEntity {

	private int id;
	private String label;
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", label=" + label + ", date=" + date + ", entityTypeId=" + getEntityTypeId()
				+ ", entityTypeMark=" + getEntityTypeMark() + ", entityHeaderName=" + getEntityHeaderName() + "]";
	}

	@Override
	public String getEntityHeaderName() {
		// TODO Auto-generated method stub
		return "Comment";
	}

	@Override
	public int getEntityTypeId() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String getEntityTypeMark() {
		// TODO Auto-generated method stub
		return "COM";
	}

	@Override
	public String getEntityLink() {
		// TODO Auto-generated method stub
		return null;
	}

}

class Message extends BaseEntity {

	private int id;
	private String label;
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", label=" + label + ", date=" + date + ", entityTypeId=" + getEntityTypeId()
				+ ", entityTypeMark=" + getEntityTypeMark() + ", entityHeaderName=" + getEntityHeaderName() + "]";
	}

	@Override
	public String getEntityHeaderName() {
		// TODO Auto-generated method stub
		return "Message";
	}

	@Override
	public int getEntityTypeId() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String getEntityTypeMark() {
		// TODO Auto-generated method stub
		return "MSG";
	}

	@Override
	public String getEntityLink() {
		// TODO Auto-generated method stub
		return null;
	}

}

class Post extends BaseEntity {

	private int id;
	private String label;
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", label=" + label + ", date=" + date + ", entityTypeId=" + getEntityTypeId()
				+ ", entityTypeMark=" + getEntityTypeMark() + ", entityHeaderName=" + getEntityHeaderName() + "]";
	}

	@Override
	public String getEntityHeaderName() {
		// TODO Auto-generated method stub
		return "Post";
	}

	@Override
	public int getEntityTypeId() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String getEntityTypeMark() {
		// TODO Auto-generated method stub
		return "PST";
	}

	@Override
	public String getEntityLink() {
		// TODO Auto-generated method stub
		return null;
	}

}
