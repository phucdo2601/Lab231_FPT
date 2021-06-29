<%-- 
    Document   : adminUpdateAccount
    Created on : Feb 21, 2021, 10:51:05 PM
    Author     : phucd
--%>

<%@page import="phucdn.dtos.AccountDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <%
            AccountDTO accDTO = (AccountDTO) request.getAttribute("accDTO");
        %>
        <section id="form">
            <div class="container">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="signup-form">
                            <h1>Welcome to Update Account!</h1>
                            <form action="AdminMainController" method="POST">

                                Username: <input type="text" name="txtUsername" value="<%= accDTO.getUsername() %>" readonly="true" />
                                
                                </br>
                                Fullname: <input type="text" name="txtFullname" value="<%= accDTO.getFullname() %>" readonly="true"/>
                                
                                </br>
                                Address: <input type="text" name="txtAddress" value="<%= accDTO.getAddress() %>" readonly="true"/>

                                </br>
                                Phone: <input type="text" name="txtPhone" value="<%= accDTO.getPhone() %>" readonly="true"/>
                                
                                </br>
                                Email: <input type="text" name="txtEmail" value="<%= accDTO.getEmail() %>" readonly="true"/>
                                
                                <br>
                                Activate: <input type="checkbox" name="checkActivateAcc"  
                                                 <%
                                                     if (accDTO.isStatus()) {
                                                             %>
                                                             checked="checked"
                                                 <%
                                                         }
                                                 %>
                                                 />
                                <font color="red">
                                
                                </font>
                                </br>
                                <input type="hidden" name="txtAccount" value="<%= request.getParameter("txtAccount") %>" />
                                <button type="submit" value="UpdateAccount" name="AAction" class="btn btn-default">Update Account</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
