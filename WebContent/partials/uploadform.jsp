<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<%
	String ctx = request.getContextPath();

	pageContext.setAttribute("inputtype", "text");

	pageContext.setAttribute("inputvalue", "");
%>

<h3>Input ${head} data</h3>

<div>

	<form class="form-horizontal" action="<%=ctx%>/${action}" method="post">

		<c:forEach var="entry" items="${entityMap}">


			<div class="form-group">

				<label class="control-label col-sm-2" for="${entry.key}">${entry.value}</label>

				<div class="col-sm-10">

					<c:choose>

						<c:when test="${fn:contains(entry.key, 'Record')}">

							<input type="checkbox" id="${entry.key}" name="${entry.key}"
								checked>
							<label for="${entry.key}">Check to add the new
								${entry.value}</label>

						</c:when>

						<c:otherwise>

							<input type="text" id="${entry.key}" name="${entry.key}"
								placeholder="Input ${entry.value}" />

						</c:otherwise>

					</c:choose>

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