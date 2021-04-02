<%--
  Created by IntelliJ IDEA.
  User: makss
  Date: 3/6/2021
  Time: 1:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Sign in</title>
    <%@include file="../common/bootstrap.jsp" %>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
          rel="stylesheet" type="text/css">
    <style>
        <%@include file="/WEB-INF/css/sign-in.css"%>
    </style>

</head>
<body class="text-center">
<div class="py-5 text-center">
    <a href="<c:url value="/controller?command=home"/>" style="color: white">
        <h1 style="margin-top: 65px">HOME</h1></a>
</div>

<form class="form-signin" action="${pageContext.request.contextPath}/controller" method="get"
      style="background-color: rgba(250,250,250,0.6)">
    <c:if test="${sessionScope.isLogout == true}">
        <div class="alert alert-danger alert-dismissible fade show" style="margin: auto 0">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
                <%--        <fmt:message key="home.sessionOut"/>--%>Session is out
            <c:set var="isLogout" scope="session" value="false"/>
        </div>
    </c:if>
    <c:if test="${sessionScope.userNotFound == true}">
        <div class="alert alert-danger alert-dismissible fade show" style="margin: auto 0">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
                <%--        <fmt:message key="home.sessionOut"/>--%>User not found! Try again
            <c:set var="userNotFound" scope="session" value="false"/>
        </div>
    </c:if>
    <input hidden name="command" value="signInUser">
    <%--    <img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">--%>
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
    <label for="inputEmail" class="sr-only">Login</label>
    <input type="text" id="inputEmail" class="form-control" name="login" placeholder="Login" required autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
    <div class="checkbox mb-3">
        <label>
            <a href="" style="color: black; margin-top: 10px"><h6>Forgot password?</h6></a>
        </label>
    </div>

    <button class="btn btn-lg btn-primary btn-block" type="submit" style=" margin-top: 25px; margin-bottom: 25px">Sign
        in
    </button>
    <%--    <p class="mt-5 mb-3 text-muted">&copy; 2020-2021</p>--%>
</form>

</body>
</html>
