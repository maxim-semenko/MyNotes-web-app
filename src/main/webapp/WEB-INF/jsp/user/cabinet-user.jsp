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
                <input type="submit" class="btn btn-outline-dark btn-sm btn-block" value="Sign out">
                <input hidden name="command" value="signOutUser">
            </form>
            <form action="<c:url value="/controller"/>" method="post">
                <input type="submit" class="btn btn-outline-dark btn-sm btn-block" value="Delete account">
                <input hidden name="command" value="deleteUser">
            </form>
            <br>
            <h5 class="mb-0">About</h5>
            <div class="p-4 rounded shadow-sm bg-light">
                <p class="font-italic mb-0">login: ${sessionScope.user.login}</p>
                <p class="font-italic mb-0">email: ${sessionScope.user.email}</p>
            </div>
        </div>
        <div class="py-4 px-4">
            <h5 class="mb-0">Notes</h5>
            <br>
            <form action="<c:url value="/controller"/>" method="get">
                <input hidden name="command" value="addNote">
                <input type="text" name="name" placeholder="name">
                <br>
                <br>
                <div class="form-group purple-border">
                    <textarea class="form-control" name="decryption" rows="3" maxlength="255"
                              placeholder="decryption"></textarea>
                </div>
                <input class="btn btn-outline-dark btn-sm btn-block" type="submit" value="Add">
            </form>
            <div class="accordion accordion-flush" id="accordionFlushExample">
                <c:set var="index" scope="page" value="${0}"/>
                <c:forEach var="note" items="${requestScope.allUserNotes}">
                    <strong>
                        <c:set var="index" scope="page" value="${index + 1}"/>
                        <c:out value="${index}"/>.
                    </strong>

                    <form action="<c:url value="/controller"/>" method="post">
                        <input hidden name="command" value="editNote">
                        <input hidden name="id" value="${note.id}">
                        <input hidden name="createdTime" value="${note.createdTime}">
                        <input hidden name="noteStatus" value="${note.noteStatus}">

                        <input type="text" name="name" value="<c:out value="${note.name}"/>">
                        <textarea name="decryption"
                                  style="width: 100%; overflow: hidden; border: none; min-height: 20px"><c:out
                                value="${note.decryption}"/>
                        </textarea>
                        <br>
                        <br>
                        <button type="submit" style="border: none; outline: none; background-color: transparent">
                            <i style='font-size:18px; cursor: pointer' class='far'>&#xf044;</i>
                        </button>
                    </form>
                    <form action="<c:url value="/controller"/>" method="post">

                        <button type="submit" style="border: none; outline: none; background-color: transparent">
                            <input hidden name="command" value="deleteNote">
                            <input hidden name="id" value="${note.id}">
                            <i style='font-size:20px' class='far'>&#xf2ed;</i>
                        </button>
                    </form>
                    <br>
                    Data created: <c:out value="${note.createdTime}"/>

                    <hr>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

</body>

</html>
