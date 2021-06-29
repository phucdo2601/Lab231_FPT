<%-- 
    Document   : search
    Created on : Jun 11, 2021, 5:13:18 AM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Bootshop online Shopping cart</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!--Less styles -->
        <!-- Other Less css file //different less files has different color scheam
             <link rel="stylesheet/less" type="text/css" href="themes/less/simplex.less">
             <link rel="stylesheet/less" type="text/css" href="themes/less/classified.less">
             <link rel="stylesheet/less" type="text/css" href="themes/less/amelia.less">  MOVE DOWN TO activate
        -->
        <!--<link rel="stylesheet/less" type="text/css" href="themes/less/bootshop.less">
        <script src="themes/js/less.js" type="text/javascript"></script> -->

        <!-- Bootstrap style --> 
        <link id="callCss" rel="stylesheet" href="themes/bootshop/bootstrap.min.css" media="screen"/>
        <link href="themes/css/base.css" rel="stylesheet" media="screen"/>
        <!-- Bootstrap style responsive -->	
        <link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet"/>
        <link href="themes/css/font-awesome.css" rel="stylesheet" type="text/css">
        <!-- Google-code-prettify -->	
        <link href="themes/js/google-code-prettify/prettify.css" rel="stylesheet"/>
        <!-- fav and touch icons -->
        <link rel="shortcut icon" href="themes/images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="themes/images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="themes/images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="themes/images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="themes/images/ico/apple-touch-icon-57-precomposed.png">
        <style type="text/css" id="enject"></style>

        <script type="text/javascript">
            function displayImg() {
                var image = document.getElementById('image');
                image.src = document.getElementById('photo').value;
            }
            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function (e) {
                        $('#image')
                                .attr('src', e.target.result)

                    };

                    reader.readAsDataURL(input.files[0]);
                }
            }
        </script>
    </head>
    <body>
        <c:if test="${requestScope.listSearch == null}">
            <div id="mainBody">
                <div class="container">
                    <hr class="soften">
                    <h1>User Management</h1>
                    <hr class="soften" />

                    <div class="page-header">
                        <c:if test="${requestScope.successMSG != null}">
                            <h3>
                                <font color="green">
                                ${requestScope.successMSG}
                                </font>
                            </h3>
                        </c:if>

                        <c:if test="${requestScope.errorMSG != null}">
                            <h3>
                                <font color="red">
                                ${requestScope.errorMSG}
                                </font>
                            </h3>
                        </c:if>
                    </div>
                    <div id="grids">

                        <ul class="nav nav-tabs" id="myTab">
                            <c:forEach begin="1" end="${requestScope.quanRole + 2}" var="i">
                                <c:if test="${sessionScope.txtRole eq 'admin'}">
                                    <c:if test="${i == 1}">
                                        <li><a href="#${i}" data-toggle="tab">All</a></li>
                                        </c:if>
                                        <c:if test="${i == 2}">
                                        <li><a href="#${i}" data-toggle="tab">Admin</a></li>
                                        </c:if>
                                        <c:if test="${i == 3}">
                                        <li class="active"><a href="#${i}" data-toggle="tab">Personal Infomation</a></li>
                                        </c:if>
                                        <c:if test="${i == 4}">
                                        <li><a href="#${i}" data-toggle="tab">User</a></li>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${sessionScope.txtRole eq 'user'}">
                                        <c:if test="${i == 3}">
                                        <li class="active"><a href="#${i}" data-toggle="tab">Personal Infomation</a></li>
                                        </c:if>
                                    </c:if>
                                <!--                            <li class="active"><a href="#two" data-toggle="tab">2 Column page</a></li>
                                                            <li><a data-toggle="tab" href="#three">3 Comumn page</a></li>
                                                            <li><a href="#four" data-toggle="tab">4 Comumn page</a></li>-->
                            </c:forEach>
                        </ul>

                        <div class="tab-content">
                            <div class="tab-pane" id="1">
                                <div class="row-fluid">
                                    <div class="span12">
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>No</th>
                                                    <th>Image</th>
                                                    <th>UserID</th>
                                                    <th>Fullname</th>
                                                    <th>Email</th>
                                                    <th>Phone</th>
                                                    <th>Delete</th>
                                                    <th>Add Promotion</th>
                                                    <th>Up Role</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${requestScope.listAllAcc}" var="dto" varStatus="counter">
                                                    <tr>
                                                        <td>${counter.count}</td>
                                                        <td> <img width="60" src="images/${dto.imgURL}" alt="" /></td>
                                                        <td>${dto.userID}</td>
                                                        <td>${dto.fullname}</td>
                                                        <td>
                                                            ${dto.email}
                                                        </td>
                                                        <td>${dto.phone}</td>


                                                        <c:if test="${dto.promoStatus eq 'Manager'}" >
                                                            <td colspan="3">
                                                                <h4><font color='orange'>This account is the boss of page!!</font></h4>
                                                            </td>
                                                        </c:if>
                                                        <c:if test="${dto.promoStatus != 'Manager'}">
                                                            <td>
                                                                <c:if test="${dto.status eq 'Active'}">
                                                                    <form action="ADeleteAccount" method="POST">
                                                                        <input type="hidden" name="txtUsername" value="${dto.userID}" />
                                                                        <button value="Delete">
                                                                            Delete
                                                                        </button>
                                                                    </form>
                                                                </c:if>
                                                                <c:if test="${dto.status != 'Active'}">
                                                                    <form action="AReActivateAcc" method="POST">
                                                                        <input type="hidden" name="txtUsername" value="${dto.userID}" />
                                                                        <button name="btAction" value="ReActivate">
                                                                            Re-Activate
                                                                        </button>
                                                                    </form>
                                                                </c:if>
                                                            </td>

                                                            <td>
                                                                <c:if test="${dto.promoStatus eq 'NonActive'}">
                                                                    <form action="AAddPromoCart" method="POST">
                                                                        <input type="hidden" name="txtUsernameAdd" value="${dto.userID}" />
                                                                        <input type="hidden" name="txtFullnameAdd" value="${dto.fullname}" />
                                                                        <input type="hidden" name="txtEmailAdd" value="${dto.email}" />
                                                                        <input type="hidden" name="txtPhoneAdd" value="${dto.phone}" />
                                                                        <input type="hidden" name="txtImgUrlAdd" value="${dto.imgURL}" />
                                                                        <button type="submit" name="btAction" value="AddPromoCart">
                                                                            Add Promotion
                                                                        </button>
                                                                    </form>
                                                                </c:if>
                                                                <c:if test="${dto.promoStatus != 'NonActive'}">
                                                                    <h4>
                                                                        <font color="blue">This Account was added into the Promotion List!</font>
                                                                    </h4>
                                                                </c:if>
                                                            </td>
                                                            <td>
                                                                <c:if test="${dto.roleID != 'admin'}">
                                                                    <form action="AUpRole" method="POST">
                                                                        <input type="hidden" name="txtUsername" value="${dto.userID}" />
                                                                        <button value="UpRole">
                                                                            Up-Role
                                                                        </button>
                                                                    </form>
                                                                </c:if>
                                                                <c:if test="${dto.roleID eq 'admin'}">
                                                                    <h4>
                                                                        <font color="green">This Account is admin!</font>
                                                                    </h4>
                                                                </c:if>
                                                            </td>

                                                        </c:if> 

                                                    </tr>
                                                </c:forEach> 
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane " id="2">
                                <div class="row-fluid">
                                    <div class="span12">
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>No</th>
                                                    <th>Image</th>
                                                    <th>UserID</th>
                                                    <th>Fullname</th>
                                                    <th>Email</th>
                                                    <th>Phone</th>
                                                    <th>Delete</th>
                                                    <th>Add Promotion</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${requestScope.listAdmin}" var="dto" varStatus="counter">
                                                    <tr>
                                                        <td>${counter.count}</td>
                                                        <td> <img width="60" src="images/${dto.imgURL}" alt="" /></td>
                                                        <td>${dto.userID}</td>
                                                        <td>${dto.fullname}</td>
                                                        <td>
                                                            ${dto.email}
                                                        </td>
                                                        <td>${dto.phone}</td>


                                                        <c:if test="${dto.promoStatus eq 'Manager'}" >
                                                            <td colspan="3">
                                                                <h4><font color='orange'>This account is the boss of page!!</font></h4>
                                                            </td>
                                                        </c:if>
                                                        <c:if test="${dto.promoStatus != 'Manager'}">
                                                            <td>
                                                                <c:if test="${dto.status eq 'Active'}">
                                                                    <form action="ADeleteAccount" method="POST">
                                                                        <input type="hidden" name="txtUsername" value="${dto.userID}" />
                                                                        <button value="Delete">
                                                                            Delete
                                                                        </button>
                                                                    </form>
                                                                </c:if>
                                                                <c:if test="${dto.status != 'Active'}">
                                                                    <form action="AReActivateAcc" method="POST">
                                                                        <input type="hidden" name="txtUsername" value="${dto.userID}" />
                                                                        <button name="btAction" value="ReActivate">
                                                                            Re-Activate
                                                                        </button>
                                                                    </form>
                                                                </c:if>
                                                            </td>

                                                            <td>
                                                                <c:if test="${dto.promoStatus eq 'NonActive'}">
                                                                    <form action="AAddPromoCart" method="POST">
                                                                        <input type="hidden" name="txtUsernameAdd" value="${dto.userID}" />
                                                                        <input type="hidden" name="txtFullnameAdd" value="${dto.fullname}" />
                                                                        <input type="hidden" name="txtEmailAdd" value="${dto.email}" />
                                                                        <input type="hidden" name="txtPhoneAdd" value="${dto.phone}" />
                                                                        <input type="hidden" name="txtImgUrlAdd" value="${dto.imgURL}" />
                                                                        <button>
                                                                            Add Promotion
                                                                        </button>
                                                                    </form>
                                                                </c:if>
                                                                <c:if test="${dto.promoStatus != 'NonActive'}">
                                                                    <h4>
                                                                        <font color="blue">This Account was added into the Promotion List!</font>
                                                                    </h4>
                                                                </c:if>
                                                            </td>


                                                        </c:if> 

                                                    </tr>
                                                </c:forEach> 
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane active" id="3">
                                <div class="row-fluid">
                                    <div class="span12">

                                        <form action="UpdateInfoController" method="POST" class="form-horizontal" enctype="multipart/form-data" >
                                            <h4>Your personal information</h4>

                                            <div class="control-group">
                                                <label class="control-label" for="inputFname1">Username <sup>*</sup></label>
                                                <div class="controls">
                                                    <input type="text" id="inputFname1" name="txtUsername" value="${requestScope.accLogin.userID}" placeholder="First Name" readonly>
                                                </div>
                                            </div>

                                            <div class="control-group">
                                                <label class="control-label" for="address2">Image<sup>*</sup></label>
                                                <div class="controls">
                                                    <img id="image" width="60" src="images/${requestScope.accLogin.imgURL}" alt="" /> <span><input type="file" name="photo" onchange="readURL(this);" accept="image/gif, image/jpeg, image/png" /></span>
                                                    <input type="hidden" name="imgUrl" value="${requestScope.accLogin.imgURL}" />
                                                </div>
                                            </div>

                                            <div class="control-group">
                                                <label class="control-label" for="inputLnam">Fullname <sup>*</sup></label>
                                                <div class="controls">
                                                    <input type="text" id="inputLnam" value="${requestScope.accLogin.fullname}" name="txtFullname" placeholder="Last Name">
                                                </div>
                                            </div>
                                            <c:if test="${requestScope.UpdateAccErr.emailErr}">
                                                <div class="alert alert-block alert-error fade in">
                                                    <button type="button" class="close" data-dismiss="alert">×</button>
                                                    <strong>${requestScope.UpdateAccErr.emailErr}</strong> 
                                                </div>
                                            </c:if>
                                            <div class="control-group">
                                                <label class="control-label" for="input_email">Email <sup>*</sup></label>
                                                <div class="controls">
                                                    <input type="text" id="input_email" value="${requestScope.accLogin.email}" name="txtEmail" placeholder="Email">
                                                </div>
                                            </div>	
                                            <c:if test="${requestScope.UpdateAccErr.phoneErr != null}">
                                                <div class="alert alert-block alert-error fade in">
                                                    <button type="button" class="close" data-dismiss="alert">×</button>
                                                    <strong>${requestScope.UpdateAccErr.phoneErr}</strong> 
                                                </div>
                                            </c:if>
                                            <div class="control-group">
                                                <label class="control-label" for="mobile">Mobile Phone </label>
                                                <div class="controls">
                                                    <input type="text"  name="txtMobile" id="mobile" value="${requestScope.accLogin.phone}"  placeholder="Mobile Phone"/> 
                                                </div>
                                            </div>

                                            <c:if test="${requestScope.UpdateAccErr.passwordErr != null}">
                                                <div class="alert alert-block alert-error fade in">
                                                    <button type="button" class="close" data-dismiss="alert">×</button>
                                                    <strong>${requestScope.UpdateAccErr.passwordErr}</strong> 
                                                </div>
                                            </c:if>
                                            <div class="control-group">
                                                <label class="control-label" for="inputPassword1">Old Password <sup>*</sup></label>
                                                <div class="controls">
                                                    <input type="password" id="inputPassword1"  name="txtOldPassword" placeholder="Password">
                                                </div>
                                            </div>	  

                                            <c:if test="${requestScope.UpdateAccErr.newPasswordErr != null}">
                                                <div class="alert alert-block alert-error fade in">
                                                    <button type="button" class="close" data-dismiss="alert">×</button>
                                                    <strong>${requestScope.UpdateAccErr.newPasswordErr}</strong> 
                                                </div>
                                            </c:if>
                                            <div class="control-group">
                                                <label class="control-label" for="inputPassword1">New Password <sup>*</sup></label>
                                                <div class="controls">
                                                    <input type="password" id="inputPassword1" name="txtNewPassword" placeholder="Password">
                                                </div>
                                            </div>

                                            <c:if test="${requestScope.UpdateAccErr.confirmPassErr != null}">
                                                <div class="alert alert-block alert-error fade in">
                                                    <button type="button" class="close" data-dismiss="alert">×</button>
                                                    <strong>${requestScope.UpdateAccErr.confirmPassErr}</strong> 
                                                </div>
                                            </c:if>
                                            <div class="control-group">
                                                <label class="control-label" for="inputPassword1">Confirm Password <sup>*</sup></label>
                                                <div class="controls">
                                                    <input type="password" id="inputPassword1" name="txtConfirm" placeholder="Password">
                                                </div>
                                            </div>	

                                            <!--                                            <div class="alert alert-block alert-error fade in">
                                                                                            <button type="button" class="close" data-dismiss="alert">×</button>
                                                                                            <strong>Lorem Ipsum is simply</strong> dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
                                                                                        </div>	
                                            
                                            
                                            
                                                                                        <p><sup>*</sup>Required field	</p>-->

                                            <div class="control-group">
                                                <div class="controls">
                                                    <input type="hidden" name="email_create" value="1">
                                                    <input type="hidden" name="is_new_customer" value="1">
                                                    <input class="btn btn-large btn-success" type="submit" value="Update" />
                                                </div>
                                            </div>		
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane" id="4">
                                <div class="row-fluid">
                                    <div class="span12">
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>No</th>
                                                    <th>Image</th>
                                                    <th>UserID</th>
                                                    <th>Fullname</th>
                                                    <th>Email</th>
                                                    <th>Phone</th>
                                                    <th>Delete</th>
                                                    <th>Add Promotion</th>
                                                    <th>Up Role</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${requestScope.listAllAcc}" var="dto" varStatus="counter">
                                                    <tr>
                                                        <td>${counter.count}</td>
                                                        <td> <img width="60" src="images/${dto.imgURL}" alt="" /></td>
                                                        <td>${dto.userID}</td>
                                                        <td>${dto.fullname}</td>
                                                        <td>
                                                            ${dto.email}
                                                        </td>
                                                        <td>${dto.phone}</td>


                                                        <c:if test="${dto.promoStatus eq 'Manager'}" >
                                                            <td colspan="3">
                                                                <h4><font color='orange'>This account is the boss of page!!</font></h4>
                                                            </td>
                                                        </c:if>
                                                        <c:if test="${dto.promoStatus != 'Manager'}">
                                                            <td>
                                                                <c:if test="${dto.status eq 'Active'}">
                                                                    <form action="ADeleteAccount" method="POST">
                                                                        <input type="hidden" name="txtUsername" value="${dto.userID}" />
                                                                        <button value="Delete">
                                                                            Delete
                                                                        </button>
                                                                    </form>
                                                                </c:if>
                                                                <c:if test="${dto.status != 'Active'}">
                                                                    <form action="AReActivateAcc" method="POST">
                                                                        <input type="hidden" name="txtUsername" value="${dto.userID}" />
                                                                        <button name="btAction" value="ReActivate">
                                                                            Re-Activate
                                                                        </button>
                                                                    </form>
                                                                </c:if>
                                                            </td>

                                                            <td>
                                                                <c:if test="${dto.promoStatus eq 'NonActive'}">
                                                                    <form action="AAddPromoCart" method="POST">
                                                                        <input type="hidden" name="txtUsernameAdd" value="${dto.userID}" />
                                                                        <input type="hidden" name="txtFullnameAdd" value="${dto.fullname}" />
                                                                        <input type="hidden" name="txtEmailAdd" value="${dto.email}" />
                                                                        <input type="hidden" name="txtPhoneAdd" value="${dto.phone}" />
                                                                        <input type="hidden" name="txtImgUrlAdd" value="${dto.imgURL}" />
                                                                        <button>
                                                                            Add Promotion
                                                                        </button>
                                                                    </form>
                                                                </c:if>
                                                                <c:if test="${dto.promoStatus != 'NonActive'}">
                                                                    <h4>
                                                                        <font color="blue">This Account was added into the Promotion List!</font>
                                                                    </h4>
                                                                </c:if>
                                                            </td>
                                                            <td>
                                                                <c:if test="${dto.roleID != 'admin'}">
                                                                    <form action="AUpRole" method="POST">
                                                                        <input type="hidden" name="txtUsername" value="${dto.userID}" />
                                                                        <button value="UpRole">
                                                                            Up-Role
                                                                        </button>
                                                                    </form>
                                                                </c:if>
                                                                <c:if test="${dto.roleID eq 'admin'}">
                                                                    <h4>
                                                                        <font color="green">This Account is admin!</font>
                                                                    </h4>
                                                                </c:if>
                                                            </td>

                                                        </c:if> 

                                                    </tr>
                                                </c:forEach> 
                                            </tbody>
                                        </table>
                                    </div>


                                </div>
                            </div>
                        </div>
                    </div>




                </div>
            </div>
        </c:if>

        <c:if test="${requestScope.listSearch != null}">

            <div id="mainBody">
                <div class="container">
                    <div class="row">
                        <div class="span9">
                            <ul class="breadcrumb">
                                <li><a href="index.html">Home</a> <span class="divider">/</span></li>
                                <li class="active"> SHOPPING CART</li>
                            </ul>
                            <h3>
                                <font color="green">
                                ${requestScope.findSucess}
                                </font>
                            </h3>
                            <h3> List Search[ <small>3 Item(s) </small>]<a href="products.html"
                                                                           class="btn btn-large pull-right"><i class="icon-arrow-left"></i> Continue Shopping </a></h3>
                            <hr class="soft" />

                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>No</th>
                                        <th>Image</th>
                                        <th>UserID</th>
                                        <th>Fullname</th>
                                        <th>Email</th>
                                        <th>Phone</th>
                                        <th>Delete</th>
                                        <th>Add Promotion</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.listSearch}" var="dto" varStatus="counter">
                                        <tr>
                                            <td>${counter.count}</td>
                                            <td> <img width="60" src="images/${dto.imgURL}" alt="" /></td>
                                            <td>${dto.userID}</td>
                                            <td>${dto.fullname}</td>
                                            <td>
                                                ${dto.email}
                                            </td>
                                            <td>${dto.phone}</td>


                                            <c:if test="${dto.promoStatus eq 'Manager'}" >
                                                <td colspan="3">
                                                    <h4><font color='orange'>This account is the boss of page!!</font></h4>
                                                </td>
                                            </c:if>
                                            <c:if test="${dto.promoStatus != 'Manager'}">
                                                <td>
                                                    <c:if test="${dto.status eq 'Active'}">
                                                        <form action="ADeleteAccount" method="POST">
                                                            <input type="hidden" name="txtUsername" value="${dto.userID}" />
                                                            <button value="Delete">
                                                                Delete
                                                            </button>
                                                        </form>
                                                    </c:if>
                                                    <c:if test="${dto.status != 'Active'}">
                                                        <form action="AReActivateAcc" method="POST">
                                                            <input type="hidden" name="txtUsername" value="${dto.userID}" />
                                                            <button name="btAction" value="ReActivate">
                                                                Re-Activate
                                                            </button>
                                                        </form>
                                                    </c:if>
                                                </td>

                                                <td>
                                                    <c:if test="${dto.promoStatus eq 'NonActive'}">
                                                        <form action="AAddPromoCart" method="POST">
                                                            <input type="hidden" name="txtUsernameAdd" value="${dto.userID}" />
                                                            <input type="hidden" name="txtFullnameAdd" value="${dto.fullname}" />
                                                            <input type="hidden" name="txtEmailAdd" value="${dto.email}" />
                                                            <input type="hidden" name="txtPhoneAdd" value="${dto.phone}" />
                                                            <input type="hidden" name="txtImgUrlAdd" value="${dto.imgURL}" />
                                                            <button>
                                                                Add Promotion
                                                            </button>
                                                        </form>
                                                    </c:if>
                                                    <c:if test="${dto.promoStatus != 'NonActive'}">
                                                        <h4>
                                                            <font color="blue">This Account was added into the Promotion List!</font>
                                                        </h4>
                                                    </c:if>
                                                </td>


                                            </c:if> 

                                        </tr>
                                    </c:forEach> 
                                </tbody>
                            </table>
                            <a href="products.html" class="btn btn-large"><i class="icon-arrow-left"></i> Continue Shopping </a>
                            <a href="login.html" class="btn btn-large pull-right">Next <i class="icon-arrow-right"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    </body>
</html>