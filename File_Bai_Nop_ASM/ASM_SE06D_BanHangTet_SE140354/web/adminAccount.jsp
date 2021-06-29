<%-- 
    Document   : adminAccount
    Created on : Jan 27, 2021, 2:51:38 PM
    Author     : phucd
--%>

<%@page import="java.util.List"%>
<%@page import="phucdn.dtos.AccountDTO"%>
<%@page import="phucdn.dao.AccountDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link href="mainTemp/css/bootstrap.min.css" rel="stylesheet">
        <link href="mainTemp/css/font-awesome.min.css" rel="stylesheet">
        <link href="mainTemp/css/prettyPhoto.css" rel="stylesheet">
        <link href="mainTemp/css/price-range.css" rel="stylesheet">
        <link href="mainTemp/css/animate.css" rel="stylesheet">
        <link href="mainTemp/css/main.css" rel="stylesheet">
        <link href="mainTemp/css/responsive.css" rel="stylesheet">

        <link rel="icon" type="image/png" href="mainTemp/images/icons/MainPage.ico" />

        <script src="mainTemp/js/jquery.js"></script>
        <script src="mainTemp/js/bootstrap.min.js"></script>
        <script src="mainTemp/js/jquery.scrollUp.min.js"></script>
        <script src="mainTemp/js/price-range.js"></script>
        <script src="mainTemp/js/jquery.prettyPhoto.js"></script>
        <script src="mainTemp/js/main.js"></script>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <h1>Welcome to Admin Management Account!</h1>
        <%

            List<AccountDTO> listAcc = null;
            listAcc = (List<AccountDTO>) request.getAttribute("SearchAccINFO");
//            String search
        %>
        <form action="AdminMainController" method="POST">
            Account <input type="text" name="txtAccount" value="${txtAccount}" />
            <input type="submit" value="SearchAccount" name="AAction" />
            <input type="submit" value="ResetAccount" name="AAction" />
        </form>

        <%
            if (listAcc != null) {
                if (listAcc.size() > 0) {
        %>
        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Username</th>
                        <th>Fullname</th>
                        <th>Address</th>
                        <th>Phone</th>
                        <th>Email</th>
                        <th>Status</th>
                        <th>Delete</th>
                        <th>Edit</th>
                    </tr>
                </thead>
                <%
                    int countAcc1 = 0;
                    for (AccountDTO dto : listAcc) {
                        countAcc1++;
                        if (dto.isStatus() != false) {

                %>
                <tr id="ajaxReActAcc">
                    <td>
                        <%= countAcc1%>
                    </td>
                    <td>
                        <%= dto.getUsername()%>

                    </td>
                    <td>
                        <%= dto.getFullname()%>

                    </td>
                    <td>
                        <%= dto.getAddress()%>

                    </td>
                    <td>
                        <%= dto.getPhone()%>

                    </td>
                    <td>
                        <%= dto.getEmail()%>

                    </td>
                    <td>
                        <input type="checkbox" name="chkStatus" value="ADMIN" 
                               <%
                                   if (dto.isStatus()) {
                               %>
                               checked="checked"
                               <%
                                   }
                               %>
                               />
                    </td>
                    <td>
                        <a href="AdminMainController?AAction=DeleteAccount&id=<%= dto.getUsername()%>&txtAccount=<%= request.getParameter("txtAccount")%>">
                            Delete</a> 
                    </td>
                    <td>
                        <form action="AdminMainController" method="POST">
                            <input type="hidden" name="txtUsername" value="<%= dto.getUsername()%>" />
                            <input type="hidden" name="txtAccount" value="<%= request.getParameter("txtAccount")%>" />
                            <input type="submit" value="Edit Account" name="AAction" />
                        </form>
                    </td>
                </tr>
                <%
                } else {
                %>
                <font color="red">
                <h1>Acc bị ban</h1>
                </font>
                <button onclick="adminOpenAccount(this)" class="btn btn-default get" value="${txtAccount}">Do you want to open <%= dto.getUsername()%>?</button>
                <%
                        }
                    }
                } else {
                %>
                <font color = "red"> 
                No record found.
                </font>
                <%
                    }
                } else {
                    int countAcc2 = 0;
                    AccountDAO accDAO = new AccountDAO();
                    listAcc = accDAO.findByLikeUsername("");
                %>
                <table class="table table-condensed">
                    <thead>
                        <tr class="cart_menu">
                            <th>No</th>
                            <th>Username</th>
                            <th>Fullname</th>
                            <th>Address</th>
                            <th>Phone</th>
                            <th>Email</th>
                        </tr>
                    </thead>
                    <%
                        for (AccountDTO dto : listAcc) {
                            countAcc2++;
                    %>
                    <tr>
                        <td><%= countAcc2%></td>
                        <td><%= dto.getUsername()%></td>
                        <td><%= dto.getFullname()%></td>
                        <td><%= dto.getAddress()%></td>
                        <td><%= dto.getPhone()%></td>
                        <td><%= dto.getEmail()%></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                    </tbody>
                </table>
        </div>
        <form action="AdminMainController" method="POST">
            <input type="submit" value="Role Back" name="AAction"/>
        </form>


        <jsp:include page="footer.jsp"></jsp:include>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript">

                    function adminOpenAccount(param) {
                        var txtAccReAct = param.value;
                        var result = confirm("Do you want to re-activate " + txtAccReAct + "?");

                        if (result) {
                            $.ajax({
                                //duong dan chay den servlet giai quyet viec load them 3 san pham
                                url: "/ASM_SE06D_BanHangTet_SE140354/AdminReActivateAccServlet",
                                type: "get", //send it through get method
                                data: {
                                    txtAccount: txtAccReAct
                                },
                                success: function (data) {
                                    var row = document.getElementById("ajaxReActAcc");
                                    row.innerHTML = data;

                                },
                                error: function (xhr) {
                                    //Do Something to handle error
                                }
                            });
                            location.reload();
                        } else {
                            alert("Bye!");
                        }
                    }

        </script>
    </body>
</html>
