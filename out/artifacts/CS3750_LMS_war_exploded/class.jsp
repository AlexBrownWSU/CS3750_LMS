<%--
  Created by IntelliJ IDEA.
  User: alexbrown
  Date: 9/29/19
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Class</title>
    <link rel="stylesheet" href="style_class_page.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<div class="topnav">
    <p style="color:red">User Profile: ${lName}, ${fName}, Instructor Id: ${instructorId} Class Id: ${cId}</p>
    <hr>
</div>

<div class="icon-bar">
    <a href="${pageContext.request.contextPath}/userLandingPage.jsp"><i class="fa fa-home"></i></a>
    <a href="${pageContext.request.contextPath}/editUser.jsp "><i class="fa fa-user"></i></a>
    <a href="${pageContext.request.contextPath}/login.jsp"><i class="fa fa-sign-out"></i></a>
    <a href="#"><i class="fa fa-globe"></i></a>
    <a href="#"><i class="fa fa-trash"></i></a>
</div>

<div class="class-info">

    <h2>CLASS INFORMATION</h2>
    <hr>
    <p>Class Name: ${cName}</p>
    <p>Meeting Time: ${meetingTime}</p>
    <br>
    <div id="enrollmentsToggle">
        <h2>CLASS ENROLLMENTS</h2>
        <button class="addButton" id="toggleEnrollBtn" onclick="showHideEnrol()"><i class="fa fa-bars"></i></button>
        <div id="enrollments" style="display:none">
            <table class="enrollmentsTable" id="enrolmentsTable">
                <tr>
                    <th>Student Id</th>
                    <th>Name</th>
                </tr>

                <c:forEach items="${enrollments}" var="enrollments">
                    <tr>
                        <td>${enrollments.sId}</td>
                        <td>${enrollments.sLName}, ${enrollments.sFName}</td>
                    </tr>
                </c:forEach>

            </table>
        </div>
        <hr>
    </div>
    <br>
    <div id="assignmentsToggle">
        <h2>ASSIGNMENTS</h2>
        <button class="addButton" id="collapseBtn" onclick="showHideNewAssign()"><i class="fa fa-plus"></i></button>
        <button class="addButton" id="toggleAssignBtn" onclick="showHideAssign()"><i class="fa fa-bars"></i></button>
    </div>
        <div id="newAssignmentDiv">
            <form action="${pageContext.request.contextPath}/addAssignment" method="post">
                <table class="newAssignment" id="newAssignment">
                    <tr>
                        <td>
                            <div class="text-input">
                                <input type="text" name="aName" width="30" placeholder="Assignment Name"/>
                            </div>
                        </td>
                        <td>
                            <div class="text-input">
                                <input type="text" name="tPoints" width="30" placeholder="Total Points"/>
                            </div>
                        </td>
                        <td>
                            <div class="text-input">
                                <label for="startDate">Start Date & Time</label>
                                <input type="datetime-local" id="startDate" name="startDate" width="30" placeholder="Start Date"/>
                            </div>
                        </td>
                        <td>
                            <div class="text-input">
                                <label for="dueDate">Due Date & Time</label>
                                <input type="datetime-local" id="dueDate" name="dueDate" width="30" placeholder="Due Date"/>
                            </div>
                        </td>
                        <td>
                            <div class="button">
                                <input type="hidden" name="cId" value="${cId}"/>
                                <input type="hidden" name="id" value="${cId}"/>
                                <input type="hidden" name="instructorId" value="${instructorId}"/>
                                <input type="hidden" name="fName" value="${fName}"/>
                                <input type="hidden" name="lName" value="${lName}"/>
                                <input type="submit" value="Add"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                    </tr>
                </table>
            </form>

        </div>
        <div id="assignments" style="display:none">
            <h1>Assignment Lists</h1>
                <table class="assignmentsTable" id="assignmentsTable">
                    <tr>
                        <th>Assignment Name</th>
                        <th>Total Points</th>
                        <th>Open Date</th>
                        <th>Due Date</th>
                    </tr>

                    <c:forEach items="${assignments}" var="assignments">
                        <tr class="clickable-row" data-href="/viewClass?id=${classes.id}&fName=${fName}&lName=${lName}&instructorId=${instructorId}">
                            <td>${assignments.aName}</td>
                            <td>${assignments.tPoints}</td>
                            <td>${assignments.startDate}</td>
                            <td>${assignments.dueDate}</td>
                            <td style="display:none">${assignments.aId}</td>
                            <td>
                                <button type="button">Delete</button>
                            </td>
                        </tr>
                    </c:forEach>

                </table>
        </div>
        <hr>
    <button id="myBtn">Open Modal</button>
    <div id="myModal" class="modal">

        <!-- Modal content -->
        <div class="modal-content">
            <span class="close">&times;</span>
            <h1>Assignment Name: <span id="className"></span></h1>
            <hr>
            <br>
            <div>
                <h3>CREATE NEW QUESTION</h3>
                <form id="addQuestion">
                    <table id="questionsTable">
                        <tr>
                            <td>
                                <div class="text-input">
                                    <input type="text" name="question" id="question" width="30" placeholder="Question"/>
                                </div>
                                <div class="text-input">
                                    <input type="number" name="qPoints" id="qPoints" width="30" placeholder="Points"/>
                                </div>
                                <div class="button">
                                    <input type="hidden" name="aId" id="aId" />
                                    <!--<input type="hidden" name="cId" value="${cId}"/>
                                    <input type="hidden" name="id" value="${cId}"/>
                                    <input type="hidden" name="instructorId" value="${instructorId}"/>
                                    <input type="hidden" name="fName" value="${fName}"/>
                                    <input type="hidden" name="lName" value="${lName}"/>-->
                                    <input type="submit" value="Add"/>
                                </div>
                                <!--<button type="button" onclick="addQuestionRow()">Add Question</button>-->
                            </td>
                        </tr>
                    </table>
                </form>
            </div>

            <table class="questionTable" id="questionTable" name="questionTable">
                <tr>
                    <th>Question</th>
                    <th>Points</th>
                    <th></th>
                </tr>
            </table>
        </div>

    </div>

</div>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script>

    //Show / hide enrolments div
    function showHideEnrol() {
        var x = document.getElementById("enrollments");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }

    //Show / hide assignments div
    function showHideAssign() {
        var x = document.getElementById("assignments");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }

    //Show / hide new assignment creator div
    function showHideNewAssign() {
        var x = document.getElementById("newAssignmentDiv");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }

    //Add new question row
    function addQuestionRow() {
        var table = document.getElementById('questionTable');
        var row = table.insertRow(-1);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        cell1.innerHTML = document.getElementById("question").value;
        cell2.innerHTML = document.getElementById("qPoints").value;
        cell3.innerHTML = "<input type='button' value='Remove' onclick='removeRow(this)'/>";
        return false;
    }

    //Delete question row
    function removeRow(elem) {
        var table = elem.parentNode.parentNode.parentNode;
        var rowCount = table.rows.length;

        // get the "<tr>" that is the parent of the clicked button
        var row = elem.parentNode.parentNode;
        row.parentNode.removeChild(row); // remove the row
    }

    //Convert question table to array
    function getQuestions(){
        var row  =$(".questionTable tr")
        var questions=new Array();
        row.each(function(){
            var que = $(this).find("td div").html();
            console.log(que);
            Questions.push(que);

        });
        return questions;
    }

    //Get the modal
    var modal = document.getElementById("myModal");

    // Get the button that opens the modal
    var btn = document.getElementById("myBtn");

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks the button, open the modal
    btn.onclick = function() {
        modal.style.display = "block";
    }

    //JQuery detect row click
    jQuery(document).ready(function($) {
        $(".clickable-row").click(function() {
            //Show modal
            modal.style.display ="block"

            //Get vars
            var $name = $(this).find("td:nth-child(1)").html();
            var $aId = $(this).find("td:nth-child(5)").html();
            //alert($aId);

            document.getElementById("className").innerHTML = $name;
            $('input[name="aId"]').val($aId);

            $.ajax({
                url: "addQuestion",
                type: "GET", //send it through get method
                data: {"aId": $aId},
                success: function(response) {
                    var trHTML = '';
                    $.each(response, function (i, item) {
                        trHTML += '<tr><td>' + item.question + '</td><td>' + item.qPoints + '</td><td>';
                    });
                    $('#questionTable').append(trHTML);
                },
                error: function(xhr) {
                    //Do Something to handle error
                }
            });

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

    //Ajax call for adding questions
    $(document).ready(function() {
        $('#addQuestion').submit(function() {
            $.ajax({
                url: "addQuestion",
                type: "POST",
                dataType: "json",
                data: $('#addQuestion').serialize(),
                success: function(data) {

                    var trHTML = '';
                        trHTML += '<tr><td>' + data.question + '</td><td>' + data.qPoints + '</td><td>';

                    $('#questionTable').append(trHTML);

                }
            });

            $('input[name="question"]').val("");
            $('input[name="qPoints"]').val("");

            return false;

        });
    });


</script>

</body>
</html>
