<%-- 
    Document   : createAcc
    Created on : May 11, 2021, 9:26:50 AM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!-- Font Icon -->
        <link rel="stylesheet" href="signUpTemp/fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="signUpTemp/css/style.css">
    </head>
    <body>
        <div class="main">


            <section class="signup">
                <!-- <img src="images/signup-bg.jpg" alt=""> -->
                <div class="container">
                    <div class="signup-content">
                        <c:set var="errorInput" value="${requestScope.InsertedErr}"/>
                        <c:set var="MailNotHaving" value="${requestScope.NotHavingAcc}"/>
                        <form method="POST" id="signup-form" class="signup-form" action="MainController">
                            <h2 class="form-title">Create account</h2>
                            <c:if test="${MailNotHaving != null}">
                                <div class="alert alert-danger" role="alert" style="color: red">
                                    ${MailNotHaving}
                                </div>
                            </c:if>
                            <div class="form-group">
                                <input type="text" class="form-input" name="txtUsername" id="name" placeholder="Your Username" <c:if test="${requestScope.txtUsernameGmail != null}">
                                       value="${requestScope.txtUsernameGmail}"
                                    </c:if> required/>
                            </div>


                            <div class="alert alert-danger" role="alert" style="color: red">
                                ${errorInput.userIDErr}
                            </div>

                            <div class="form-group">
                                <input type="text" class="form-input" name="txtFullname" id="email" placeholder="Your Fullname" required/>
                            </div>

                            <div class="alert alert-danger" role="alert" style="color: red">

                            </div>

                            <div class="form-group">
                                <input type="text" class="form-input" name="txtAddress" id="email" placeholder="Your Address" required/>
                            </div>

                            <div class="alert alert-danger" role="alert" style="color: red">

                            </div>

                            <div class="form-group">
                                <input type="text" class="form-input" name="txtPhone" id="email" placeholder="Your Phone" required/>
                            </div>

                            <div class="alert alert-danger" role="alert" style="color: red">

                            </div>

                            <div class="form-group">
                                Role: <select class="form-input"  name="cboRole" required>
                                    <c:forEach items="${requestScope.listRoleUser}" var="listRole">
                                        <option>${listRole.roleName}</option>                                       
                                    </c:forEach>
                                </select>
                            </div>


                            <div class="alert alert-danger" role="alert" style="color: red">

                            </div>

                            <div class="form-group">
                                <input type="password" class="form-input" name="txtPassword" id="password" placeholder="Password" required/>
                                <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                            </div>


                            <div class="alert alert-danger" role="alert" style="color: red">

                            </div>

                            <div class="form-group">
                                <input type="password" class="form-input" name="txtConfirm" id="re_password" placeholder="Repeat your password" required/>
                                <span toggle="#re_password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                            </div>

                            <div class="alert alert-danger" role="alert" style="color: red">
                                ${errorInput.confirmPasswordErr}
                            </div>

                            <!--                        <div class="form-group">
                                                        <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                                                        <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                                                    </div>-->
                            <div class="form-group">
                                <input type="submit" name="action" id="submit" class="form-submit" value="Create new Account" />
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

        </div>

        <!-- JS -->
        <script src="signUpTemp/vendor/jquery/jquery.min.js"></script>
        <script src="signUpTemp/js/main.js"></script>
        <!--===============================================================================================-->


    </body>
</html>
