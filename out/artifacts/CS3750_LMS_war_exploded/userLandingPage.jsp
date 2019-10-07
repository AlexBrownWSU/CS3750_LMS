<%--
  Created by IntelliJ IDEA.
  User: alexbrown
  Date: 9/25/19
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
    <a href="${pageContext.request.contextPath}/editUserInfo?userId=${instructorId}"><i class="fa fa-user"></i></a>
    <a href="${pageContext.request.contextPath}/login.jsp"><i class="fa fa-sign-out"></i></a>
    <a href="/viewClass?id=1"><i class="fa fa-globe"></i></a>
    <a href="#"><i class="fa fa-trash"></i></a>
</div>

<div class="pageContent">

    <br>
    <p class="heading">MY CLASSES</p>

    <table class="classTable" id="classTable">
        <tr class="clickable-row">
            <th>CRN</th>
            <th>Name</th>
            <th>Date & Time</th>
        </tr>

        <c:forEach items="${classes}" var="classes">
            <tr class="clickable-row" data-href="/viewClass?id=${classes.id}">
                <td>${classes.id}</td>
                <td>${classes.cName}</td>
                <td>${classes.meetingTime}</td>
            </tr>
        </c:forEach>

    </table>

    <button class="addButton" id="collapseBtn" onclick="showHide()"><i class="fa fa-plus"></i></button>

    <br>
    <br>
    <div class="newClass" id="newClass" style="display:none">
        <p>CREATE NEW CLASS</p>
        <hr>
        <form action="${pageContext.request.contextPath}/addClass" method="post">
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

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script>

    //Show / hide add class div
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
            /*alert('You clicked row ' + ($(this).index()) + ' ' + $(this).attr('data-href'));
            thisData = $(this).attr('data-href');
            console.log(thisdata);

            window.location = thisData;*/
        });
    });


    /*
    jQuery(document).ready(function($) {
        $(".clickable-row").click(function() {
            window.location = $(this).data("href");
        });
    });*/

    //Make table row clickable
    /*$("#classTable tr:not(:first)").click(function() {
    //$('#classTable').delegate('tr', 'click' , function(){
            alert('You clicked row ' + ($(this).index()));
    });*/

//AJAX call for table reload
    /*$(function () {
        $('form').on('submit', function (e) {
            e.preventDefault();
            $.ajax({
                url: "/userLandingPage.jsp", // use original page here
                type: 'POST',
                data: { lName:${lName}, fName:${fName}, instructorId:${instructorId}, classes:${classes} },
                dataType: 'html',
                success: function (html) {

                    // get the content of #myTable from the AJAX result
                    var tableContent = $("#classTable", html).html();

                    // set the content of #myTable to the result of the AJAX call
                    $('#classTable').html(tableContent);

                },
                error: function(xhr, ajaxOptions, thrownError){
                    alert('An error occurred! ' + thrownError);
                }
            });
        });
    });*/


</script>

</body>

</html>
