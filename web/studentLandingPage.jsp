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
    <a href="/getCalendar?studentId=${studentId}&fName=${fName}&lName=${lName}"><i class="fa fa-globe"></i></a>
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
            <th>Enrolled</th>
        </tr>

        <c:forEach items="${classes}" var="classes">
            <tr class="clickable-row">
                <td>${classes.id}</td>
                <td>${classes.iLName}, ${classes.iFName}</td>
                <td>${classes.cName}</td>
                <td>${classes.meetingTime}</td>
                <td>${classes.enrollments}</td>
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

            <c:forEach items="${studentClasses}" var="studentClasses">
            <tr class="clickable-row-my-classes" data-href="/viewStudentClass?id=${studentClasses.id}&fName=${fName}&lName=${lName}&studentId=${studentId}">
                <td>${studentClasses.cName}</td>
                <td>${studentClasses.meetingTime}</td>
            </tr>
            </c:forEach>

        </table>
    </div>

    <!--<button id="myBtn">Open Modal</button>-->
    <div id="myModal" class="modal">
        <!-- Modal content -->
        <div class="modal-content">

            <span class="close">&times;</span>

                <h1>Class: <span id="className"></span></h1>
                <hr>
                <h3>Meeting Time: <span id="meetingTime"></span></h3>
                <h3>Registration: <span id="registrationDot" class="registrationDot" ></span></h3>

                <form id="enrollStudent">
                    <input type="hidden" name="cId" id="cId"/>
                    <input type="hidden" name="studentId" id="studentId" value="${studentId}"/>
                    <input type="submit" value="Enroll"/>
                </form>
        </div>

    </div>
</div>



<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
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

    // Get the modal
    var modal = document.getElementById("myModal");

    // Get the button that opens the modal
    //var btn = document.getElementById("myBtn");

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks the button, open the modal
    //btn.onclick = function() {
      //  modal.style.display = "block";
    //}

    jQuery(document).ready(function($) {
        $(".clickable-row").click(function() {

            //Get vars
            var $name = $(this).find("td:nth-child(3)").html();
            var $cId = $(this).find("td:nth-child(1)").html();
            var $meetingTime = $(this).find("td:nth-child(4)").html();
            var $enrollments = $(this).find("td:nth-child(5)").html();

            alert($meetingTime);

            //Set vars in modal
            document.getElementById("className").innerHTML = $name;
            document.getElementById("meetingTime").innerHTML = $meetingTime;

            //Set hidden element
            $('input[name="cId"]').val($cId);

            var regis = document.getElementById("registrationDot");

            if (parseInt($enrollments, 10) === 30) {
                var form = document.forms["enrollStudent"].getElementsByTagName("input");
                for (var i = 0; i < form.length; i++) {
                    form[i].disabled = true;
                }

                //regis.innerHTML = "Registration Unavailable";
                regis.style.color = "red";
            } else {
                //regis.innerHTML = "Registration Available";
                regis.style.color = "green";
            }

            modal.style.display ="block"

        });
    });

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";

        //Remove questions from table
        $('#questionTable').find("tr:gt(0)").remove();
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";

            //Remove questions from table
            $('#questionTable').find("tr:gt(0)").remove();
        }
    }

    //Ajax call for enrolling student
    $(document).ready(function() {
        $('#enrollStudent').submit(function() {
            $.ajax({
                url: "enrollStudent",
                type: "POST",
                dataType: "json",
                data: $('#enrollStudent').serialize(),
                success: function(data) {

                    //alert(data);

                }
            });

            return false;

        });
    });

    jQuery(document).ready(function($) {
        $(".clickable-row-my-classes").click(function() {
            window.location = $(this).data("href");
            /*alert('You clicked row ' + ($(this).index()) + ' ' + $(this).attr('data-href'));
            thisData = $(this).attr('data-href');
            console.log(thisdata);*/

            //window.location = thisData;
        });
    });
    
    //TODO: Student analytics, high, low, medium and student. for each assignment and overall just student.

</script>

</body>

</html>

