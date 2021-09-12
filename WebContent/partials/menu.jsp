<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="edu.awieclawski.base.EntitiesList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
	Map<String, String> uploadPathMap = EntitiesList.getAllowedUploadPathMap();

	String ctx = request.getContextPath();

	pageContext.setAttribute("pathmap", uploadPathMap);
%>

<div class="container-fluid">

	<nav class="navbar-nav mr-auto">

		<div class="navbar-header">

			<a class="navbar-brand"
				href="https://www.javaguides.net/2019/11/hibernate-registration-form-example-with-jsp-servlet-mysql.html"
				target="_blank"> Hibernate </a>

		</div>

		<div class="nav navbar-nav">

			<a class="navbar-brand" href="<%=ctx%>/home"> Home </a>

		</div>

		<!-- "uploadpathmap" -->

		<c:forEach var="entry" items="${pageScope.pathmap}">

			<div class="nav navbar-nav">

				<a class="navbar-brand" href="<%=ctx%>${entry.value}">
					${entry.key} </a>

			</div>

		</c:forEach>


		<div class="nav navbar-nav">

			<span class="navbar-text">${message}</span>

		</div>

	</nav>

</div>
