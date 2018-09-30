<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    <%@include file="../styles/styles.css"%>
</style>
<body>
    <form class="dropdown-main" method="post" action="" name="langForm">
        <select name="lang" onchange="">
            <option class="lang_en" value="en">English</option>
            <option class="lang_ru" value="ru">Russian</option>
        </select>
        <input class="lang-submit" type="submit" value="Ok" name="dropdown">
        </form>
</body>
</html>
