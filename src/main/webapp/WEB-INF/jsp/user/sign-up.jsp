<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <%@include file="../common/bootstrap.jsp" %>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <style>
        <%@include file="/WEB-INF/css/sign-up.css"%>
    </style>
</head>
<body>

<div class="container register">
    <div class="py-5 text-center">
        <a href="<c:url value="/controller?command=home"/>" style="color: white">
            <h1>HOME</h1></a>
    </div>
    <div class="row">
        <div class="col-md-3 register-left">
            <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt=""/>
            <h3>Welcome</h3>
            <p>quick sign up to join us</p>
            <form action="${pageContext.request.contextPath}/controller" method="get">
                <label>
                    <input hidden name="command" value="signIn-page">
                </label>
                <input type="submit" name="" value="Sign in"/><br/>
            </form>
        </div>

        <div class="col-md-9 register-right">
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <h3 class="register-heading">Register form</h3>

                    <form action="<c:url value="/controller"/>" method="get">
                        <input hidden name="command" value="signUpUser">
                        <div class="row register-form">
                            <div class="col-md-6">
                                <c:if test="${requestScope.isExistEmail == true}">
                                    <div class="alert alert-danger alert-dismissible fade show">
                                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                                        Email is exist!
                                    </div>
                                </c:if>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="firstname" placeholder="Firstname*"
                                           required/>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="lastname" placeholder="Lastname*"
                                           required/>
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control" name="email" placeholder="Email*"
                                           required/>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <c:if test="${requestScope.isExistLogin == true}">
                                    <div class="alert alert-danger alert-dismissible fade show">
                                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                                        Login is exist!
                                    </div>
                                </c:if>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="login" placeholder="Login*" required/>
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" name="password" placeholder="Password*"
                                           minlength="8" maxlength="255" required/>
                                </div>
                                <input type="submit" class="btnRegister" value="Sign up"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
