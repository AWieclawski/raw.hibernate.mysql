<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var = "labels" scope = "page" value = "${labelsMap}"/>

<div class="card">

	<div class="card-body">

		<c:forEach var="entry" items="${valuesMap}">

			<pre> <c:out value="${labelsMap[entry.key]}"/>: ${entry.value} </pre>

		</c:forEach>

	</div>

</div>