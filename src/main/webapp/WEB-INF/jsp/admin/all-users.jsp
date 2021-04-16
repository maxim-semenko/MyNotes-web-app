<%--
  Created by IntelliJ IDEA.
  User: makss
  Date: 3/18/2021
  Time: 12:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.user == null}">
    ${sessionScope.isLogout = true}
    <c:redirect url="/controller?command=signIn-page"/>
</c:if>

<html>
<head>
    <title>Cabinet</title>
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
    <!-- Profile widget -->
    <div class="bg-white shadow rounded overflow-hidden">
        <div class="px-4 pt-0 pb-4 cover">
            <div class="media align-items-end profile-head">
                <div class="profile mr-3">
                    <img src="https://i.stack.imgur.com/l60Hf.png"
                         alt="..." width="130" class="rounded mb-2 img-thumbnail">
                    <a href="/controller?command=user-edit" class="btn btn-outline-dark btn-sm btn-block">Edit
                        profile</a>
                </div>
                <div class="media-body mb-5 text-white">
                    <h4 class="mt-0 mb-0">${sessionScope.user.firstname} ${sessionScope.user.lastname}</h4>
                    <p class="small mb-4"></p>
                </div>
            </div>
        </div>
        <div class="bg-light p-4 d-flex justify-content-end text-center">
            <ul class="list-inline mb-0">
                <li class="list-inline-item">
                    <h5 class="font-weight-bold mb-0 d-block">215</h5><small class="text-muted">Photos</small>
                </li>
                <li class="list-inline-item">
                    <h5 class="font-weight-bold mb-0 d-block">745</h5><small class="text-muted">Followers</small>
                </li>
            </ul>
        </div>
        <div class="px-4 py-3">
            <form action="<c:url value="/controller"/>" method="post">
                <input type="submit" class="btn btn-outline-dark btn-sm btn-block" value="Back">
                <input hidden name="command" value="signOutUser">
            </form>
        </div>
        <div class="py-4 px-4">
            <table class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>login</th>
                    <th>firstname</th>
                    <th>lastname</th>
                    <th>email</th>
                    <th>action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${requestScope.allUsers}">
                    <tr>
                        <td><c:out value="${user.login}"/></td>
                        <td><c:out value="${user.firstname}"/></td>
                        <td><c:out value="${user.lastname}"/></td>
                        <td><c:out value="${user.email}"/></td>
                        <td>
                            <form action="<c:url value="/controller"/>" method="post">
                                <input hidden name="command" value="remove-user-by-admin">
                                <label><input type="number" hidden name="id" value="${user.id}"></label>
                                <button class="btn btn-success btn-block" type="submit">
                                    Delete
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>

</html>
