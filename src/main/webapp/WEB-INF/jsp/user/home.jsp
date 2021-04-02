<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Home</title>
    <%@include file="../common/bootstrap.jsp" %>
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
          rel="stylesheet" type="text/css">

    <style>
        <%@include file="/WEB-INF/vendor/fontawesome-free/css/all.min.css"%>
        <%@include file="/WEB-INF/css/home.css"%>
    </style>

</head>
<body id="page-top">
<!-- Header -->
<header class="masthead d-flex">
    <div class="container text-center my-auto">
        <h1 class="mb-1">My notes</h1>
        <h3 class="mb-5"><em>An easy way to keep everything under control</em></h3>

        <form action="<c:url value="/controller"/>" method="get" style="display:inline-block;">
            <label>
                <input hidden name="command" value="signIn-page">
                <input class="btn btn-primary btn-xl js-scroll-trigger" type="submit" value="Sign in">
            </label>
        </form>
        <form action="${pageContext.request.contextPath}/controller" method="get" style="display:inline-block;">
            <label>
                <input hidden name="command" value="signUp-page">
                <input class="btn btn-primary btn-xl js-scroll-trigger" type="submit" value="Sign up">
            </label>
        </form>
        <div class="overlay"></div>
    </div>
</header>

</body>

</html>

