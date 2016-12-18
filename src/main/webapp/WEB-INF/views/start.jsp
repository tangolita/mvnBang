<%--
  Created by IntelliJ IDEA.
  User: Юлия
  Date: 09.12.2016
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<!-- обратите внимание на spring тэги -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
</head>

<body>
<spring:form method="post"  modelAttribute="user" action="main">

    Name: <spring:input path="name"/>  <br/>
     <br/>
    <spring:button>Next Page</spring:button>

</spring:form>

</body>

</html>