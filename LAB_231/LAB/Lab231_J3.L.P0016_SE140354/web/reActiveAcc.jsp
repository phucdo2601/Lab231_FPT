<%-- 
    Document   : reActiveAcc
    Created on : May 20, 2021, 6:15:52 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Re-Activate Account Page</title>

        <!-- Font Icon -->
        <link rel="stylesheet" href="signUpTemp/fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="signUpTemp/css/style.css">

        <!-- JS -->
        <script src="signUpTemp/vendor/jquery/jquery.min.js"></script>
        <script src="signUpTemp/js/main.js"></script>
        <!--===============================================================================================-->
    </head>
    <body>
        <div class="main">

            <c:set var="waringMessage" value="${requestScope.AccNotActivate}" />
            <c:set var="txtUserIDReAct" value="${requestScope.txtUsernameReAcc}"/>
            <c:if test="${txtUserIDReAct != null}">
                <section class="signup">
                    <div class="container">
                        <div class="signup-content">
                            <form method="POST" id="signup-form" class="signup-form" action="MainController">
                                <h2 class="form-title">Re-Activate account</h2>
                                <div class="form-group">
                                    <input type="text" class="form-input" name="txtUsername" id="name" placeholder="Your Re-Activate Email" value="${txtUserIDReAct}" readonly/>

                                </div>


                                <div class="alert alert-danger" role="alert" style="color: red">
                                    ${waringMessage}
                                </div>





                                <!--                        <div class="form-group">
                                                            <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                                                            <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                                                        </div>-->
                                <div class="form-group">
                                    
                                    <button name="action" id="submit" class="form-submit" value="SendReActAcc">Next</button>
                                </div>

                                <c:if test="${requestScope.errorMessage != null}">
                                    <div class="alert alert-danger" role="alert" style="color: red">
                                        ${requestScope.errorMessage}
                                    </div>
                                </c:if>
                            </form>

                            <p class="loginhere">
                                Have already an account ? <a href="login.jsp" class="loginhere-link">Login here</a>
                            </p>
                            <p style="text-align: center; color: #555; font-weight: 500">
                                OR Come Back Home Page ? <a href="MainController" class="loginhere-link">Home Page</a>
                            </p>
                        </div>
                    </div>
                </section>
            </c:if>

        </div>
    </body>
</html>
