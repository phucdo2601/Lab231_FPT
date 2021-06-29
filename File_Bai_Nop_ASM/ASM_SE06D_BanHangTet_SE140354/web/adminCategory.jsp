<%-- 
    Document   : adminCategory
    Created on : Jan 25, 2021, 6:52:04 PM
    Author     : phucd
--%>

<%@page import="java.util.List"%>
<%@page import="phucdn.dao.CategoryDAO"%>
<%@page import="phucdn.dtos.CategoryDTO"%>
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

            <h1>Welcome to Admin Management Category!</h1>
            <!--chua truyen cate tu trang search qua dc-->
            <form action="AdminMainController" method="POST">
                Category: <input type="text" name="txtCategory" value="${txtCategory}" />
            <input type="submit" value="SearchCate" name="AAction" /> 
            <input type="submit" value="Reset Category" name="AAction" />
            </br>
            <p><a  class="btn btn-fefault cart" href="adminInsertCategory.jsp">
                    <i class="fa fa-shopping-cart"></i>
                    Insert a Category
                </a></p>
        </form></br> 

        <%
            List<CategoryDTO> listCate = null;
            listCate = (List<CategoryDTO>) request.getAttribute("SearchCateInfo");
            if (listCate != null) {
                if (listCate.size() > 0) {
        %>
        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                    <tr class="cart_menu">
                        <th>No</th>
                        <th>Category ID</th>
                        <th>Category Name</th>
                        <th>Description</th>
                        <th>Buying</th>
                        <th>Delete</th>
                        <th>Edit</th>
                        <th>Add a Product</th>
                    </tr>
                </thead>
                <%
                    int countCate1 = 0;
                    for (CategoryDTO cateDto : listCate) {
                        countCate1++;
                        if (cateDto.isStatus() != false) {
                %>
                <tr id="ajaxReActCate">
                    <td><%= countCate1%></td>
                    <td><%= cateDto.getCategoryID()%></td>
                    <td><%= cateDto.getCategoryName()%></td>
                    <td><%= cateDto.getDescription()%></td>
                    <td>
                        <input type="checkbox" name="chkCateStatus" value="ADMIN" 
                               <%
                                   if (cateDto.isStatus()) {
                               %>
                               checked="checked"
                               <%
                                   }
                               %>
                               />
                    </td>
                    <td>
                        <a href="AdminMainController?AAction=DeleteCategory&id=<%= cateDto.getCategoryID()%>&txtCategory=<%= request.getParameter("txtCategory")%>">
                            Delete</a> 
                    </td>
                    <td>
                        <form action="AdminMainController" method="POST">
                            <input type="hidden" name="txtCategoryID" value="<%= cateDto.getCategoryID()%>" />
                            <input type="hidden" name="txtCategory" value="<%= request.getParameter("txtCategory")%>" />
                            <input type="submit" value="Edit Category" name="AAction" />
                        </form>
                    </td>
                    <td>
                        <form action="AdminMainController" method="POST">
                            <input type="hidden" name="txtCategoryID" value="<%= cateDto.getCategoryID()%>" />
                            <input type="hidden" name="txtCategory" value="<%= request.getParameter("txtCategory")%>" />
                            <!--<input type="submit" value="Add Product in cart" name="AAction" />-->
                             <button  name="AAction" value="ViewProductOutOfCateID">Add Product on Cart</button>
                        </form>
                    </td>
                </tr>
                <%
                } else {
                %>
                <font color="red">
                <h1>Category bị ban</h1>
                </font>
                <button onclick="adminOpenCate(this)" class="btn btn-default get" value="${txtCategory}">Do you want to open <%= cateDto.getCategoryName()%>?</button>
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
                    int countCate2 = 0;
                    CategoryDAO cateDAO = new CategoryDAO();
                    listCate = cateDAO.findCategoryByCateID("");
                %>
                <table class="table table-condensed">
                    <thead>
                        <tr class="cart_menu">
                            <th>No</th>
                            <th>Category ID</th>
                            <th>Category Name</th>
                            <th>Description</th>
                        </tr>
                    </thead>
                    <%
                        for (CategoryDTO cateDto : listCate) {
                            countCate2++;
                    %>
                    <tr>
                        <td><%= countCate2%></td>
                        <td><%= cateDto.getCategoryID()%></td>
                        <td><%= cateDto.getCategoryName()%></td>
                        <td><%= cateDto.getDescription()%></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                    </tbody>
                </table>
        </div>
                    <section id="do_action">
                        <div class="container">
                            <div class="heading">
                                <h1>
                                    <font color="green">
                                    ${requestScope.SUCCESS}
                                    </font>
                                </h1>
                            </div>
                        </div>
                    </section>
        <form action="AdminMainController" method="POST">
            <input type="submit" value="Role Back" name="AAction"/>
        </form>

        <jsp:include page="footer.jsp"></jsp:include>  

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">

        function adminOpenCate(param) {
            var txtAccReAct = param.value;
            var result = confirm("Do you want to re-activate " + txtAccReAct + "?");

            if (result) {
                $.ajax({
                    //duong dan chay den servlet giai quyet viec load them 3 san pham
                    url: "/ASM_SE06D_BanHangTet_SE140354/AdminReActivateCateServlet",
                    type: "get", //send it through get method
                    data: {
                        txtCategory: txtAccReAct
                    },
                    success: function (data) {
                        var row = document.getElementById("ajaxReActCate");
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
