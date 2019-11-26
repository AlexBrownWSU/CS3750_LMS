<%--
  Created by IntelliJ IDEA.
  User: plisk
  Date: 11/7/2019
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Assignment</title>
    <link rel="stylesheet" href="style_student_assignment.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="topnav">

    <p style="color:red">STUDENT: ${lName}, ${fName}</p>

    <hr>

</div>



<div class="icon-bar">

    <a href="${pageContext.request.contextPath}/login?userId=${id}"><i class="fa fa-home"></i></a>
    <a href="${pageContext.request.contextPath}/editUserInfo?userId=${id}"><i class="fa fa-user"></i></a>
    <a href="${pageContext.request.contextPath}/login.jsp"><i class="fa fa-sign-out"></i></a>
    <a href="#"><i class="fa fa-globe"></i></a>
    <a href="#"><i class="fa fa-trash"></i></a>
</div>

<div class="pageContent">
    <br>
    <br>

    <p class="heading">Questions</p>
    <hr>
    <button class="addButton" id="collapseAllClasses" onclick="showHideAllQuestions()"><i class="fa fa-plus"></i></button>
    <div id="Questions" name="Questions" >


            <c:forEach items="${questions}" var="questions">
                <label id="question" name="question">${questions.question}</label>
                 <br>

                <input id="answer" name="answer" type="text">
                <br>

            </c:forEach>


    </div>
</div>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script>
    jQuery(document).ready(function($) {
        $(".clickable-row").click(function() {
            // window.location = $(this).data("href");

        });
    });

    function showHideAllQuestions() {
        var x = document.getElementById("Questions");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }
</script>
</body>
</html>
