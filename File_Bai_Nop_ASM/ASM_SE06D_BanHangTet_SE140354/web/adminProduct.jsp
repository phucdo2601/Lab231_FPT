<%-- 
    Document   : adminProduct
    Created on : Jan 27, 2021, 2:51:16 PM
    Author     : phucd
--%>

<%@page import="phucdn.dao.ProductDAO"%>
<%@page import="phucdn.dtos.ProductDTO"%>
<%@page import="java.util.List"%>
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

        <%
            List<ProductDTO> listProduct = null;
            listProduct = (List<ProductDTO>) request.getAttribute("SearchProductInfo");
            String txtValueSearch = (String) request.getParameter("SearchProductInfo");
        %>
        <h1>Welcome to Admin Management Product!</h1>
        <form action="AdminMainController" method="POST">
            Product: <input oninput="adminSearchByProductID(this)" type="text" name="txtProduct" value="${txtProductSeach}" />
            <input type="submit" value="Search Product" name="AAction" />
            <input type="submit" value="Reset Product" name="AAction"/>
            </br>
            <p><a  class="btn btn-fefault cart" href="adminInsertProduct.jsp">
                    <i class="fa fa-shopping-cart"></i>
                    Insert a Product
                </a></p>
        </form></br>  

        <%
            if (listProduct != null) {
                if (listProduct.size() > 0) {
        %>
        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                    <tr class="cart_menu">
                        <th>No</th>
                        <th>Product ID</th>
                        <th>Category ID</th>
                        <th>Product Name</th>
                        <th class="image">image</th>
                        <th class="description">Description</th>
                        <th>Unit</th>
                        <th class="price">Price</th>
                        <th td class="quantity">Quantity</th>
                        <th>Sale</th>
                        <th>Buying</th>
                        <th>Delete</th>
                        <th>Edit</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int countProduct1 = 0;
                        for (ProductDTO dto : listProduct) {
                            countProduct1++;
                            if (dto.isStatus() != false) {
                    %>

                    <tr id="ajaxReActPro">
                        <td><%= countProduct1%></td>
                        <td><%= dto.getProductID()%></td>
                        <td><%= dto.getCategoryID()%></td>
                        <td><%= dto.getProductName()%></td>
                        <td><img src = <%= dto.getImage()%> alt=<%= dto.getProductName()%> style="height: 100px; width: 100px"/></td>
                        <td><%= dto.getDescription()%></td>
                        <td><%= dto.getUnit()%></td>
                        <td><%= dto.getPrice()%></td>
                        <td><%= dto.getQuantity()%></td>
                        <td><%= dto.getSale()%></td>
                        <td>
                            <input type="checkbox" name="chkProStatus" value="ADMIN" 
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
                            <a href="AdminMainController?AAction=DeleteProduct&id=<%= dto.getProductID()%>&txtProduct=<%= request.getParameter("txtProduct")%>">Delete</a> 
                        </td>
                        <td>
                            <form action="AdminMainController" method="POST">
                                <input type="hidden" name="txtProductID" value="<%= dto.getProductID()%>" />
                                <input type="hidden" name="txtProduct" value="<%= request.getParameter("txtProduct")%>" />
                                <input type="submit" value="Edit Product" name="AAction" />
                            </form>
                        </td>
                    </tr>
                    <%
                    } else {
                    %>
                <font color="red">
                <h1>Product bi ngung kinh doanh</h1>
                </font>
                <button onclick="adminOpenProduct(this)" class="btn btn-default get" value="<%= dto.getProductID()%>">Do you want to open <%= dto.getProductName() %>?</button>
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

                %>
                <%                } else {
                    int countProduct2 = 0;
                    ProductDAO proDAO = new ProductDAO();
                    listProduct = proDAO.findProductByProductID("");
                %>
                <table class="table table-condensed">
                    <thead>
                        <tr class="cart_menu">
                            <th>No</th>
                            <th>Product ID</th>
                            <th>Category ID</th>
                            <th>Product Name</th>
                            <th class="image">image</th>
                            <th class="description">Description</th>
                            <th>Unit</th>
                            <th class="price">Price</th>
                            <th td class="quantity">Quantity</th>
                            <th>Sale</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (ProductDTO dto : listProduct) {
                                countProduct2++;
                        %>
                    <div id ="ajaxSearchByProductID">
                        <tr>
                            <td><%= countProduct2%></td>
                            <td><%= dto.getProductID()%></td>
                            <td><%= dto.getCategoryID()%></td>
                            <td><%= dto.getProductName()%></td>
                            <td><img src = <%= dto.getImage()%> alt=<%= dto.getProductName()%> style="height: 100px; width: 100px"/></td>
                            <td><%= dto.getDescription()%></td>
                            <td><%= dto.getUnit()%></td> 
                            <td><%= dto.getPrice()%></td>
                            <td><%= dto.getQuantity()%></td>
                            <td><%= dto.getSale()%></td>

                        </tr>
                    </div>
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
        <script>
            function adminSearchByProductID(param1) {
                var txtSearchProductIDAjax = param1.value;
                $.ajax({
                    //duong dan chay den servlet giai quyet viec search tu dong
                    url: "/ASM_SE06D_BanHangTet_SE140354/AdminSearchByAjaxProductServlet",
                    type: "get", //send it through get method
                    data: {
                        txtProduct: txtSearchProductIDAjax
                    },
                    success: function (data) {
                        var row = document.getElementById("ajaxSearchByProductID");
                        row.innerHTML = data;
                    },
                    error: function (xhr) {
                        //Do Something to handle error
                    }
                });
            }

            function adminOpenProduct(paramPro) {
                var txtAccReAct = paramPro.value;
                var result = confirm("Do you want to re-activate " + txtAccReAct + "?");

                if (result) {
                    $.ajax({
                        //duong dan chay den servlet giai quyet viec load them 3 san pham
                        url: "/ASM_SE06D_BanHangTet_SE140354/AdminReActivateProServlet",
                        type: "get", //send it through get method
                        data: {
                            txtProduct: txtAccReAct
                        },
                        success: function (data) {
                            var row = document.getElementById("ajaxReActPro");
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
