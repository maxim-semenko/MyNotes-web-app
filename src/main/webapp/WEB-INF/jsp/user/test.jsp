<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: makss
  Date: 3/6/2021
  Time: 1:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>WTF&&&&&&&&!!!!!</h1>
<form action="<c:url value="/controller"/>" method="get">
    <input hidden name="command" value="execute">
    Enter 1st number: <input type="text" name="num1" value="${requestScope.num1}">
    Enter 2st number: <input type="text" name="num2" value="${requestScope.num2}">
    <input type="submit">
</form>

<h1>Результат: ${requestScope.result}</h1>bootstrap.jsp

</body>
</html>
