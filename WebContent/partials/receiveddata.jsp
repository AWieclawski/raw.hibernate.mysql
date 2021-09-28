<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="edu.awieclawski.ref.LabelAttributes"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	pageContext.setAttribute("hed", request.getAttribute(LabelAttributes.HEAD.getParName()));
%>

<h1>${hed}</h1>

<h3>Data received:</h3>

<div>

	<jsp:include page="sub/entitycard.jsp" />

	<!-- POST confirm / cancel -->

</div>