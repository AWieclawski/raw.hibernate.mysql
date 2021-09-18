<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="edu.awieclawski.base.AllowedEntities"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	Map<String, String> uploadPathMap = AllowedEntities.getAllowedUploadPathMap();
	String ctx = request.getContextPath();
	pageContext.setAttribute("pathmap", uploadPathMap);
%>

<nav class="navbar navbar-inverse">

	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand"
				href="https://www.javaguides.net/2019/11/hibernate-registration-form-example-with-jsp-servlet-mysql.html"
				target="_blank"> Hibernate </a>
		</div>

		<ul class="nav navbar-nav">
			<li class="active"><a href="<%=ctx%>/home"> Home </a>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Upload <span class="caret"></span></a>
				<ul class="dropdown-menu">

					<c:forEach var="entry" items="${pageScope.pathmap}">

						<li class="active"><a href="<%=ctx%>${entry.value}">
								${entry.key} </a></li>

					</c:forEach>

				</ul></li>
		</ul>
	</div>

</nav>
