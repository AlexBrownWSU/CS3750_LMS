<%--
  Created by IntelliJ IDEA.
  User: alexbrown
  Date: 9/26/19
  Time: 7:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


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

    <p class="heading">ALL CLASSES</p>
    <hr>
    <button class="addButton" id="collapseAllClasses" onclick="showHideAllClasses()"><i class="fa fa-plus"></i></button>
    <div id="allClasses" name="allClasses">
        <table class="allClassTable" id="allClassTable">

        <tr class="clickable-row">
            <th>CRN</th>
            <th>Instructor Name</th>
            <th>Name</th>
            <th>Date & Time</th>
        </tr>

        <c:forEach items="${classes}" var="classes">
            <tr>
                <td>${classes.id}</td>
                <td>${classes.iLName}, ${classes.iFName}</td>
                <td>${classes.cName}</td>
                <td>${classes.meetingTime}</td>
            </tr>
        </c:forEach>

    </table>
    </div>

    <p class="heading">MY CLASS ENROLLMENTS</p>
    <hr>
    <button class="addButton" id="collapseMyClasses" onclick="showHideMyClasses()"><i class="fa fa-plus"></i></button>
    <div id="myClasses" name="myClasses">
        <table class="myClassesTable" id="myClassesTable">

            <tr>
                <td>Class Name</td>
                <td>Meeting Time</td>
            </tr>


        </table>
    </div>
</div>

<script>

    //Show / hide all class div
    function showHideAllClasses() {
        var x = document.getElementById("allClasses");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }

    //Show / hide my class div
    function showHideMyClasses() {
        var x = document.getElementById("myClasses");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }

</script>

</body>

</html>

