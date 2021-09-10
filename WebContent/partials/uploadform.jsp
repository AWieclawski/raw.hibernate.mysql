<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String ctx = request.getContextPath();
%>

<h3>Input ${head} data</h3>

<div>

	<form class="form-horizontal" action="<%=ctx%>/${link}" method="post">

		<c:forEach var="entry" items="${entityMap}">

			<div class="form-group">

				<label class="control-label col-sm-2" for="${entry.key}">${entry.value}</label>

				<div class="col-sm-10">

					<input type="text" id="${entry.key}" name="${entry.key}"
						placeholder="Input ${entry.value}" />

					<!--  <form:errors class="alert alert-warning" path="city" />  -->

				</div>

			</div>

		</c:forEach>

		<div class="form-group">

			<div class="col-sm-offset-2 col-sm-10">

				<button class="btn btn-primary" type="submit" name="submit">Submit</button>

				<!-- 	<button class="btn btn-secondary" type="submit" name="reset">Reset</button> -->

			</div>

		</div>


	</form>

</div>