<%-- 
    Document   : confirmAcc
    Created on : May 11, 2021, 10:28:36 AM
    Author     : ASUS
--%>

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
        
        <!-- JS -->
        <script src="signUpTemp/vendor/jquery/jquery.min.js"></script>
        <script src="signUpTemp/js/main.js"></script>
        <!--===============================================================================================-->
    </head>
    <body>
        <div class="main">


            <section class="signup">
                <div class="container">
                    <div class="signup-content">
                        <form method="POST" id="signup-form" class="signup-form" action="MainController">
                            <h2 class="form-title">Confirm account</h2>
                            
                            
                            <div class="form-group">
                                <input type="text" class="form-input" name="txtVerifyCode" id="name" placeholder="Your Confirm Code"/>
                                <input type="hidden" name="txtUsername" value="${sessionScope.txtUsername}" />
                            </div>


                            <div class="alert alert-danger" role="alert" style="color: red">
                                ${requestScope.errorConfirm}
                            </div>

                            

                            <!--                        <div class="form-group">
                                                        <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                                                        <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                                                    </div>-->
                            <div class="form-group">
                                <input type="submit" name="action" id="submit" class="form-submit" value="Confirm new Account" />
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
    </body>
</html>
