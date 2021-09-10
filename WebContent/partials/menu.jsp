<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String ctx = request.getContextPath();
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

		<div class="nav navbar-nav">

			<a class="navbar-brand" href="<%=ctx%>/upaddress"> Address </a>

		</div>

		<div class="nav navbar-nav">

			<span class="navbar-text">${message}</span>

		</div>

	</nav>

</div>
