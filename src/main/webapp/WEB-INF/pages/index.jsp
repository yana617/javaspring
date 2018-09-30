<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>JavaTrouble</title>
</head>
<style>
    <%@include file="../styles/styles.css"%>
</style>
<body>
    <jsp:include page="Header.jsp" />
    <jsp:include page="languageDropdown.jsp" />
    <div class="main">
        <form action="/birthday" method="post">
            <input type="text" name="inputDate" class="input-date" value="${inputDate}">
            <button type="submit" class="button-date">submit</button>

        </form>
        <div class="days-before-birthday">
            <c:if test="${empty daysCount}">Enter the date</c:if>
            <c:if test="${not empty daysCount}">${daysCount}</c:if>
        </div>
    </div>
    <jsp:include page="Footer.jsp" />
</body>
</html>