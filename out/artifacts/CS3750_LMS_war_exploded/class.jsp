<%--
  Created by IntelliJ IDEA.
  User: alexbrown
  Date: 9/29/19
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Class</title>
    <link rel="stylesheet" href="style_class_page.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<div class="topnav">
    <p style="color:red">User Profile: ${lName}, ${fName}, Class Id: ${id}</p>
    <hr>
</div>

<div class="icon-bar">
    <a href="/userLandingPage.jsp"><i class="fa fa-home"></i></a>
    <a href="/editUser.jsp "><i class="fa fa-user"></i></a>
    <a href="/login.jsp"><i class="fa fa-sign-out"></i></a>
    <a href="#"><i class="fa fa-globe"></i></a>
    <a href="#"><i class="fa fa-trash"></i></a>
</div>

<div class="class-info">

    <h2>Class name and other information</h2>
    <hr>

    <h2>Assignemnts</h2>
    <hr>

</div>

</body>
</html>
