<%-- 
    Document   : createAccount
    Created on : June 17, 2021, 12:57:44 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Designined by CodingLab - youtube.com/codinglabyt -->
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8">
        <title>Registration Form</title>
        <link rel="stylesheet" href="signUpTemp/style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="container">
            <div class="title">Registration</div>
            <div class="content">
                <form action="ACreateAccount" method="POST">
                    <div class="user-details">
                        <div class="input-box">
                            <span class="details">Username</span>
                            <c:if test="${requestScope.InsertedErr.userIDErr != null}">
                                <span class="errors">${requestScope.InsertedErr.userIDErr}</span>
                            </c:if>
                            <input type="text" placeholder="Enter your username" name="txtUsername" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Fullname</span>

                            <input type="text" placeholder="Enter your name" name="txtFullname" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Email</span>
                            <c:if test="${requestScope.InsertedErr.emailErr != null}">
                                <span class="errors">${requestScope.InsertedErr.emailErr}</span>
                            </c:if>
                            <input type="text" placeholder="Enter your email" name="txtEmail" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Phone Number</span>
                            <c:if test="${requestScope.InsertedErr.phoneErr != null}">
                                <span class="errors">${requestScope.InsertedErr.phoneErr}</span>
                            </c:if>
                            <input type="text" placeholder="Enter your number" name="txtPhone" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Role</span>
                            <select name="cboRole">
                                <c:forEach items="${requestScope.listRole}" var="dto">
                                    <option>${dto.roleName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="input-box">
                            <span class="details">Password</span>

                            <input type="password" name="txtPassword" placeholder="Enter your password" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Confirm Password</span>
                            <c:if test="${requestScope.InsertedErr.confirmPassErr != null}">
                                <span class="errors">${requestScope.InsertedErr.confirmPassErr}</span>
                            </c:if>
                            <input type="password" name="txtConfirm" placeholder="Confirm your password" required>
                        </div>
                    </div>
                    <!--                    <div class="gender-details">
                                            <input type="radio" name="gender" id="dot-1">
                                            <input type="radio" name="gender" id="dot-2">
                                            <input type="radio" name="gender" id="dot-3">
                                            <span class="gender-title">Gender</span>
                                            <div class="category">
                                                <label for="dot-1">
                                                    <span class="dot one"></span>
                                                    <span class="gender">Male</span>
                                                </label>
                                                <label for="dot-2">
                                                    <span class="dot two"></span>
                                                    <span class="gender">Female</span>
                                                </label>
                                                <label for="dot-3">
                                                    <span class="dot three"></span>
                                                    <span class="gender">Prefer not to say</span>
                                                </label>
                                            </div>
                                        </div>-->
                    <div class="button">
                        <input type="submit" value="Register">
                    </div>
                </form>
            </div>
        </div>

    </body>
</html>
