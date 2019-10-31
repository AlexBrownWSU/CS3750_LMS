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
    <a href="${pageContext.request.contextPath}/editUserInfo?userId=${studentId}"><i class="fa fa-user"></i></a>
    <a href="${pageContext.request.contextPath}/login.jsp"><i class="fa fa-sign-out"></i></a>
    <a href="#"><i class="fa fa-globe"></i></a>
    <a href="#"><i class="fa fa-trash"></i></a>
</div>

<div class="pageContent">
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

        <c:forEach items="${allclasses}" var="allclasses">
            <tr class="clickable-row">
                <td>${allclasses.id}</td>
                <td>${allclasses.iLName}, ${allclasses.iFName}</td>
                <td>${allclasses.cName}</td>
                <td>${allclasses.meetingTime}</td>
                <td>${allclasses.enrollments}</td>
            </tr>
        </c:forEach>

    </table>
    </div>

    <br>
    <br>

    <p class="heading">MY CLASS ENROLLMENTS</p>
    <hr>
    <button class="addButton" id="collapseMyClasses" onclick="showHideMyClasses()"><i class="fa fa-plus"></i></button>
    <div id="myClasses" name="myClasses">
        <table class="myClassesTable" id="myClassesTable">

            <tr class="clickable-row-gtc">
                <th>CRN</th>
                <th>Name</th>
                <th>Date & Time</th>

            </tr>

            <c:forEach items="${classes}" var="classes">
                <tr class="clickable-row-gtc">
                    <td>${classes.id}</td>
                    <td>${classes.cName}</td>
                    <td>${classes.meetingTime}</td>

                </tr>
            </c:forEach>

        </table>
    </div>

    <button id="myBtn">Open Modal</button>
    <div id="myModal" class="modal">
        <!-- Modal content -->
        <div class="modal-content">
            <span class="close">&times;</span>
            <h1><span id="className"></span></h1>
            <hr>
            <h3><span id="meetingTime"></span></h3>
            <h3><span id="registration"></span></h3>

            <form id="enrollStudent">
                <input type="hidden" name="cId" id="cId"/>
                <input type="hidden" name="studentId" id="studentId" value="${studentId}"/>
                <input type="submit" value="Enroll"/>
            </form>

        </div>

    </div>

<div id = "viewClass">
    <input type="hidden" name = "classId" id="classId" >
    <input type="hidden" name="sId" id="sId" value="${studentId}"/>
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
    var btn = document.getElementById("myBtn");

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks the button, open the modal
    btn.onclick = function() {
        modal.style.display = "block";
    }
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

    jQuery(document).ready(function($) {
        $(".clickable-row").click(function() {

            //Get vars
            var $name = $(this).find("td:nth-child(3)").html();
            var $cId = $(this).find("td:nth-child(1)").html();
            var $meetingTime = $(this).find("td:nth-child(4)").html();
            var $enrollments = $(this).find("td:nth-child(5)").html();



            //Set vars in modal
            document.getElementById("className").innerHTML = $name;
            document.getElementById("meetingTime").innerHTML = $meetingTime;

            //Set hidden element
            $('input[name="cId"]').val($cId);

            var regis = document.getElementById("registration");

            if (parseInt($enrollments, 10) === 30) {
                //allow registration
                var form = document.forms["enrollStudent"].getElementsByTagName("input");
                for (var i = 0; i < form.length; i++) {
                    form[i].disabled = true;
                }

                regis.innerHTML = "Registration Unavailable";
            } else {
                regis.innerHTML = "Registration Available";
            }

            modal.style.display ="block"

        });
    });







    //Ajax call for enrolling student
    $(document).ready(function() {
        $('#enrollStudent').submit(function() {
            $.ajax({
                url: "enrollStudent",
                type: "POST",
                dataType: "json",
                data: $('#enrollStudent').serialize(),
                success: function(data) {
                }
            });

            return false;

        });
    });

    //Ajax call for go to student class

    jQuery(document).ready(function($) {
        $(".clickable-row-gtc").click(function() {
            


       });
    });



</script>

</body>

</html>

