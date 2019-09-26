<%--
  Created by IntelliJ IDEA.
  User: alexbrown
  Date: 9/26/19
  Time: 7:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
    <link rel="stylesheet" href="style_landing_page.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

<div class="topnav">
    <p style="color:red">STUDENT: ${lName}, ${fName} STUDENT ID: ${studentId}</p>
    <hr>
</div>

<div class="icon-bar">
    <a class="active" href="#"><i class="fa fa-home"></i></a>
    <!--<a href="/editUser.jsp "><i class="fa fa-user"></i></a>-->
    <a href="/editUserInfo?userId=${studentId}"><i class="fa fa-user"></i></a>
    <a href="/login.jsp"><i class="fa fa-sign-out"></i></a>
    <a href="#"><i class="fa fa-globe"></i></a>
    <a href="#"><i class="fa fa-trash"></i></a>
</div>

<div class="pageContent">
    <br>
    <br>

    <br>
    <p class="heading">MY CLASSES</p>

    <table class="classTable">
        <tr>
            <th>CRN</th>
            <th>Name</th>
            <th>Date & Time</th>
        </tr>
        <tr>
            <td>12345</td>
            <td>CS3750</td>
            <td>TR 9:30 - 11:20</td>
        </tr>
        <tr>
            <td>12346</td>
            <td>CS3100</td>
            <td>MW 5:30 - 7:20</td>
        </tr>
        <tr>
            <td>12346</td>
            <td>CS3100</td>
            <td>MW 5:30 - 7:20</td>
        </tr>
        <tr>
            <td>12346</td>
            <td>CS3100</td>
            <td>MW 5:30 - 7:20</td>
        </tr>

    </table>
</div>

<script>

</script>

</body>

</html>

