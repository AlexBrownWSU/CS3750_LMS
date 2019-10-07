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

<body onload="onPageStart()">

<div class="topnav">
    <p style="color:red">STUDENT: ${lName}, ${fName} STUDENT ID: ${studentId}</p>
    <hr>
</div>

<div class="icon-bar">
    <a class="active" href="#"><i class="fa fa-home"></i></a>
    <!--<a href="/editUser.jsp "><i class="fa fa-user"></i></a>-->
    <a href="${pageContext.request.contextPath}/editUserInfo?userId=${studentId}"><i class="fa fa-user"></i></a>
    <a href="${pageContext.request.contextPath}/login.jsp"><i class="fa fa-sign-out"></i></a>
    <a href="#"><i class="fa fa-globe"></i></a>
    <a href="#"><i class="fa fa-trash"></i></a>
</div>

<div class="pageContent">
    <br>
    <br>

    <br>
    <p class="heading">MY CLASSES</p>

    <table class="currentClassesTable" id="cClasses">
        <tr>
            <th>CRN</th>
            <th>Name</th>
            <th>Date & Time</th>
        </tr>


    </table>
    <br>
    <br>

    <p class="heading">AVAILABLE CLASSES</p>
    <table class="availableClassTable" id = "aClasses">

        <tr>
            <th>CRN</th>
            <th>Name</th>
            <th>Date & Time</th>
        </tr>

    </table>
    <br>



    <button class="addButton" id="collapseBtn" onclick="promptWindow()"><i class="fa fa-plus"></i></button>


 </div>

<script>

    jQuery(document).ready(function($) {
        $(".clickable-row").click(function() {
            window.location = $(this).data("href");
        });
    });

    function addClassFunction() {
        var table = document.getElementById("cClasses");
        var row = table.insertRow(1);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        cell1.innerHTML = "NEW CELL1";
        cell2.innerHTML = "NEW CELL2";
        cell3.innerHTML = "NEW CELL3";

    }

    function onPageStart(){
        var table = document.getElementById("cClasses");
        for(i = 1; i < 5; i++){
            var row = table.insertRow(i);
            for(j = 0; j < 3; j++){
                var cell = row.insertCell(j);
                cell.innerHTML = "cc"+(j+1);
            }
        }

        var table1 = document.getElementById("aClasses");
        for(i = 1; i < 5; i++){
            var row = table1.insertRow(i);
            for(j = 0; j < 3; j++){
                var cell = row.insertCell(j);
                cell.innerHTML = "ac"+(j+1);
            }
        }


    }



    function promptWindow(){

        var r = confirm("Do you want to add this \"(Available Class)\" to your Current Class list ");

        if(r === true){
            addClassFunction();
        }
        else{

        }


    }
</script>
</body>

</html>

