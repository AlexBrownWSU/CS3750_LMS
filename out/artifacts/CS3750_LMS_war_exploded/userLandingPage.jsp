<%--
  Created by IntelliJ IDEA.
  User: alexbrown
  Date: 9/25/19
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Instructor</title>
    <link rel="stylesheet" href="style_landing_page.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

<div class="topnav">
    <p style="color:red">INSTRUCTOR: ${lName}, ${fName} INSTRUCTOR ID: ${instructorId}</p>
    <hr>
</div>

<div class="icon-bar">
    <a class="active" href="#"><i class="fa fa-home"></i></a>
    <!--<a href="/editUser.jsp "><i class="fa fa-user"></i></a>-->
    <a href="/editUserInfo?userId=${instructorId}"><i class="fa fa-user"></i></a>
    <a href="/login.jsp"><i class="fa fa-sign-out"></i></a>
    <a href="#"><i class="fa fa-globe"></i></a>
    <a href="#"><i class="fa fa-trash"></i></a>
</div>

<div class="pageContent">

    <br>
    <p class="heading">MY CLASSES</p>

    <table class="classTable">
        <tr class="clickable-row">
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

    <button class="addButton" id="collapseBtn" onclick="showHide()"><i class="fa fa-plus"></i></button>

    <br>
    <br>
    <div class="newClass" id="newClass" style="display:none">
        <p>CREATE NEW CLASS</p>
        <hr>
        <form action="/addClass" method="post">
            <table class="newClassTable" style="width:100%">
                <tr>
                    <td>
                        <div class="text-input">
                            <input type="text" name="cName" width="30" placeholder="Class Name"/>
                        </div>
                    </td>
                    <td>
                        <div class="text-input">
                            <input type="text" name="dateTime" width="30" placeholder="Date & Time"/>
                        </div>
                    </td>
                    <td>
                        <div class="button">
                            <input type="submit" value="Add"/>
                        </div>
                    </td>
                </tr>
            </table>
            <input type="hidden" value="${instructorId}" name="instructorId">
        </form>
        <!--
                <input type="text" name="cName" width="60" placeholder="Class Name:"/>
                <input type="text" name="dateTime" width="60" placeholder="Date & Time"/>
                <button class="button">CREATE</button>
                -->
    </div>

</div>

<script>
    function showHide() {
        var x = document.getElementById("newClass");
        var y = document.getElementById("collapseBtn")
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }

    jQuery(document).ready(function($) {
        $(".clickable-row").click(function() {
            window.location = $(this).data("href");
        });
    });


</script>

</body>

</html>
