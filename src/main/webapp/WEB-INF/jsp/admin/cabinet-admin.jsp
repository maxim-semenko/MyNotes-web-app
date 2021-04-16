<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.user == null}">
    ${sessionScope.isLogout = true}
    <c:redirect url="/controller?command=signIn-page"/>
</c:if>

<html>
<head>
    <title>Admin</title>
    <%@include file="../common/bootstrap.jsp" %>
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
          rel="stylesheet" type="text/css">
    <style>
        <%@include file="/WEB-INF/vendor/fontawesome-free/css/all.min.css"%>
        <%@include file="/WEB-INF/css/cabinet-user.css"%>
    </style>
    <link href='https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/3.6.95/css/materialdesignicons.css'>
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>
<div class="col-md-5 mx-auto">
    <div class="bg-white shadow rounded overflow-hidden">
        <div class="px-4 pt-0 pb-4 cover">
            <div class="media align-items-end profile-head">
                <div class="profile mr-3">
                    <img src="https://i.stack.imgur.com/l60Hf.png"
                         alt="..." width="130" class="rounded mb-2 img-thumbnail">
                </div>
                <div class="media-body mb-5 text-white">
                    <h4 class="mt-0 mb-0">${sessionScope.user.firstname} ${sessionScope.user.lastname}</h4>
                    <p class="small mb-4"></p>
                </div>
            </div>
        </div>
        <div class="bg-light p-4 d-flex justify-content-end text-center">
        </div>
        <div class="px-4 py-3">
            <form action="<c:url value="/controller"/>" method="post">
                <input type="submit" class="btn btn-outline-dark btn-sm btn-block" value="Sign out">
                <input hidden name="command" value="signOutUser">
            </form>
            <a href="<c:url value="/controller?command=all-users"/>">
                <button style="width: 100%" class="btn btn-outline-dark btn-sm btn-b">All users</button></a>
            <br>
            <br>
            <h5 class="mb-0">About</h5>
            <div class="p-4 rounded shadow-sm bg-light">
                <p class="font-italic mb-0">login: ${sessionScope.user.login}</p>
                <p class="font-italic mb-0">email: ${sessionScope.user.email}</p>
            </div>
        </div>
        <div class="py-4 px-4">

        </div>
    </div>
</div>
</body>
</html>