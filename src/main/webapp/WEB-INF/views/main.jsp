
<%--
  Created by IntelliJ IDEA.
  User: Юлия
  Date: 18.12.2016
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
main page! Hello ${user.name} !!!
<spring:form method="post"  modelAttribute="user" action="search">
    <spring:button >Find game  </spring:button>
</spring:form>
</body>
</html>
