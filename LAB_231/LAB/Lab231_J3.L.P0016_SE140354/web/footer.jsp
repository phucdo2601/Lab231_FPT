<%-- 
    Document   : footer
    Created on : May 11, 2021, 9:16:42 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>About Us</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">	
        <!-- bootstrap css -->
        <link rel="stylesheet" type="text/css" href="mainTemp/css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" type="text/css" href="mainTemp/css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="mainTemp/css/responsive.css">
        <!-- fevicon -->
        <link rel="icon" href="mainTemp/images/fevicon.png" type="image/gif" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="mainTemp/css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <!-- owl stylesheets --> 
        <link rel="stylesheet" href="mainTemp/css/owl.carousel.min.css">
        <link rel="stylesheet" href="mainTemp/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">

        <script src="mainTemp/js/jquery.min.js"></script>
        <script src="mainTemp/js/popper.min.js"></script>
        <script src="mainTemp/js/bootstrap.bundle.min.js"></script>
        <script src="mainTemp/js/jquery-3.0.0.min.js"></script>
        <script src="mainTemp/js/plugin.js"></script>
        <!-- sidebar -->
        <script src="mainTemp/js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="mainTemp/js/custom.js"></script>
        <!-- javascript --> 
        <script src="mainTemp/js/owl.carousel.js"></script>
        <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
        <!-- Javascript files-->

        <script>
            $(document).ready(function () {
                $(".fancybox").fancybox({
                    openEffect: "none",
                    closeEffect: "none"
                });

                $(".zoom").hover(function () {

                    $(this).addClass('transition');
                }, function () {

                    $(this).removeClass('transition');
                });
            });

        </script> 
    </head>

    <body>
        <div class="layout_padding footer_section">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-md-6 col-lg-3">
                        <div><img src="mainTemp/images/footer-logo.png"></div>
                        <p class="dolor_text">dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et sdolor sit amet,</p>
                    </div>
                    <div class="col-sm-6 col-md-6 col-lg-3">
                        <h1 class="quick_text">Quick links</h1>
                        <div class="chevron_arrow"><img src="mainTemp/images/chevron-arrow.png"><span class="padding-left">Join Us</span></div>
                        <div class="chevron_arrow"><img src="mainTemp/images/chevron-arrow.png"><span class="padding-left">Maintenance</span></div>
                        <div class="chevron_arrow"><img src="mainTemp/images/chevron-arrow.png"><span class="padding-left">Language Packs</span></div>
                        <div class="chevron_arrow"><img src="mainTemp/images/chevron-arrow.png"><span class="padding-left">LearnPress</span></div>
                        <div class="chevron_arrow"><img src="mainTemp/images/chevron-arrow.png"><span class="padding-left">Release Status</span></div>
                    </div>
                    <div class="col-sm-6 col-md-6 col-lg-3">
                        <h1 class="subscribe_text">Subcribe email</h1>
                        <p class="ipsum_text">Lorem ipsum dolor sit amet, consectetur adipiscing elit,</p>
                        <input type="text" class="email_text" placeholder="Your Email" name="Name">
                        <button class="submit_text">Submit</button>
                    </div>
                    <div class="col-sm-6 col-md-6 col-lg-3">
                        <h1 class="quick_text">Contact Us</h1>
                        <div class="map_flag"><img src="mainTemp/images/map-flag.png"><span class="padding-left">London 145 United Kingdom</span></div>
                        <div class="dolor_text"><img src="mainTemp/images/email-icon.png"><span class="padding-left">adsiter@gmail.com</span></div>
                        <div class="dolor_text"><img src="mainTemp/images/phone-icon.png"><span class="padding-left">+12586954775</span></div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
