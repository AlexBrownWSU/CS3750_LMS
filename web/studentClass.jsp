<%--
  Created by IntelliJ IDEA.
  User: alexbrown
  Date: 10/25/19
  Time: 11:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
<head>
    <title>Student</title>
    <link rel="stylesheet" href="style_student_class.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

    <div class="topnav">
        <p style="color:red">STUDENT: ${lName}, ${fName} STUDENT ID: ${studentId}, Class Name: ${cName}</p>
        <hr>
    </div>

    <div class="icon-bar">
        <a class="active" href="#"><i class="fa fa-home"></i></a>
        <a href="/editUserInfo?userId=${studentId}"><i class="fa fa-user"></i></a>
        <a href="/login.jsp"><i class="fa fa-sign-out"></i></a>
        <a href="#"><i class="fa fa-globe"></i></a>
        <a href="#"><i class="fa fa-trash"></i></a>
    </div>

    <div class="pageContent">

    </div>

</body>
</html>
