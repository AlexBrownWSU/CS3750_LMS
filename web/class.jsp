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
    <title>FFDP - ${cName}</title>
    <link rel="stylesheet" href="style_class_page.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<div class="topnav">
    <p style="color:red">User Profile: ${lName}, ${fName}, Instructor Id: ${instructorId} Class Id: ${cId}</p>
    <hr>
</div>

<div class="icon-bar">
    <div class="tooltip">
        <a href="${pageContext.request.contextPath}/login?userId=${instructorId}"><i class="fa fa-home"></i></a>
        <span class="tooltiptext">Home</span>
    </div>
    <div class="tooltip">
        <a href="${pageContext.request.contextPath}/editUserInfo?userId=${instructorId}"><i class="fa fa-user"></i></a>
        <span class="tooltiptext">User Profile</span>
    </div>

    <div class="tooltip">
        <a href="${pageContext.request.contextPath}/login.jsp"><i class="fa fa-sign-out"></i></a>
        <span class="tooltiptext">Logout</span>
    </div>

    <div class="tooltip">
        <a href="#"><i class="fa fa-Calendar"></i></a>
        <span class="tooltiptext">Calendar</span>
    </div>

    <div class="tooltip">
        <a href="#"><i class="fa fa-trash"></i></a>
        <span class="tooltiptext">Trash</span>
    </div>
</div>

<div class="class-info">

    <button  class="collapseBtn" id="toggleInfoBtn" onclick="showHideInfo()">CLASS INFORMATION</button>
    <hr>
    <div id="classInfo" style="display:none">
        <p>Class Name: ${cName}</p>
        <p>Meeting Time: ${meetingTime}</p>
    </div>
    <br>
    <div id="enrollmentsToggle">
        <button class="collapseBtn" id="toggleEnrollBtn" onclick="showHideEnroll()">ENROLLMENTS</button>
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
        <button class="collapseBtn" id="toggleAssignmentsBtn" onclick="showHideAssignments()">ASSIGNMENTS</button>
        <div id="assignmentsMain" style="display:none">
            <button class="addButton" id="collapseBtn" onclick="showHideNewAssign()"><i class="fa fa-plus"></i></button>
            <button class="addButton" id="toggleAssignBtn" onclick="showHideAssign()"><i class="fa fa-bars"></i></button>

            <div id="newAssignmentDiv">
                <h3>NEW ASSIGNMENT</h3>
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
                    </table>
                </form>

        </div>
        <div id="assignments" style="display:none">
                <h3>ASSIGNMENT LIST</h3>
                <table class="assignmentsTable" id="assignmentsTable">
                    <tr>
                        <th>ASSIGNMENT NAME</th>
                        <th>TOTAL POINTS</th>
                        <th>OPEN DATE</th>
                        <th>DUE DATE</th>
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
        </div>
    </div>
        <hr>
    <!--<button id="myBtn">Open Modal</button>-->
    <div id="myModal" class="modal">

        <!-- Modal content -->
        <div class="modal-content">
            <span class="close">&times;</span>
            <h1>Assignment Name: <span id="className"></span></h1>
            <hr>
            <br>

            <button id="quetsionsBtn" onclick="showQuestions()">Question(s)</button>
            <button id="submissionsBtn" onclick="showSubmissions()">Submission(s)</button>
            <span id="studentGradeName" style="display:none;"></span>


            <div id="questions">
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
                                    <input type="submit" value="Add"/>
                                </div>
                            </td>
                        </tr>
                    </table>
                </form>

                <div id="scrolltable">
                    <table class="questionTable" id="questionTable" name="questionTable">
                        <tr>
                            <th>Question</th>
                            <th>Points</th>
                            <th></th>
                        </tr>
                    </table>
                </div>

            </div>

            <div id="submissions" style="display: none;">
                <br>
                <h3>Need To Grade</h3>
                <table class="modalTable" id="submissionsTable" name="submissionsTable">
                    <tr>
                        <th>Student Name</th>
                        <th>Submission Date</th>
                        <th>Status</th>
                        <th>aId</th>
                        <th>sId</th>
                        <th>subId</th>
                    </tr>
                </table>
                <h3>Graded</h3>
                <table class="modalTable" id="gradedSubmissionTable" name="gradedSubmissionTable">
                    <tr>
                        <th>Student Name</th>
                        <th>Submission Date</th>
                        <th>GradedDate</th>
                    </tr>
                </table>

            </div>

            <div id="grade" style="display:none;">
                <br>
                <form id="gradeForm" method="post">
                    <table class="gradeTable" id="gradeTable" >
                        <tr>
                            <th>Question</th>
                            <th>Response</th>
                            <th>Total Points</th>
                            <th>Grade</th>
                        </tr>
                    </table>
                    <br>
                    <button id="downloadFile">View File</button>
                    <input type="text" name="fileGrade" id="fileGrade" width="30" placeholder="File Grade" required="required"/>
                    <!--<label for="fileGrade">File Grade</label>-->
                    <input type="hidden" name="sId" id="sId">
                    <input type="hidden" name="aId" id="aId2">
                    <input type="hidden" name="submissionId" id="submissionId">
                    <!--<a href="path_to_file" download="proposed_file_name">Download</a>-->
                    <input type="submit" value="Done">

                </form>
            </div>

        </div>

    </div>

</div>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
<script>

    //Show / hide class info div
    function showHideInfo() {
        var x = document.getElementById("classInfo");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }

    //Show / hide enrolments div
    function showHideEnroll() {
        var x = document.getElementById("enrollments");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }

    //Show / hide assignments div
    function showHideAssignments() {
        var x = document.getElementById("assignmentsMain");
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

    //Show questions div
    function showQuestions() {
        var x = document.getElementById("questions");
        var y = document.getElementById("submissions");
        var z = document.getElementById("grade");
        if (x.style.display === "none") {
            x.style.display = "block";
            y.style.display = "none";
            z.style.display = "none";
        }
    }

    //Show submissions div
    function showSubmissions() {
        var x = document.getElementById("submissions");
        var y = document.getElementById("questions");
        var z = document.getElementById("grade");
        if (x.style.display === "none") {
            x.style.display = "block";
            y.style.display = "none";
            z.style.display = "none";
        }
    }

    //Set up submission div to grade
    function setSubmissionToGrade() {
        var x = document.getElementById("grade");
        var y = document.getElementById("submissions");
        var z = document.getElementById("studentGradeName");
        if (x.style.display === "none") {
            x.style.display = "block";
            y.style.display = "none";
            z.style.display = "block";
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

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";

        //Remove questions from table
        $('#questionTable').find("tr:gt(0)").remove();

        //Remove submissions from table
        $('#submissionsTable').find("tr:gt(0)").remove();

        //Remove gradedSubmissions from table
        $('#gradedSubmissionTable').find("tr:gt(0)").remove();
    }

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";

            //Remove questions from table
            $('#questionTable').find("tr:gt(0)").remove();

            //Remove submissions from table
            $('#submissionsTable').find("tr:gt(0)").remove();

            //Remove gradedSubmissions from table
            $('#gradedSubmissionTable').find("tr:gt(0)").remove();
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

    //JQuery detect row click
    jQuery(document).ready(function($) {
        $(".clickable-row").click(function() {

            //Show modal
            modal.style.display ="block"

            //Get vars
            var $name = $(this).find("td:nth-child(1)").html();
            var $aId = $(this).find("td:nth-child(5)").html();

            document.getElementById("className").innerHTML = $name;
            $('input[name="aId"]').val($aId);

            //Get Questions
            $.ajax({
                url: "addQuestion",
                type: "GET", //send it through get method
                data: {"aId": $aId},
                success: function(response) {
                    var trHTML = '';
                    $.each(response, function (i, item) {
                        trHTML += '<tr><td>' + item.question + '</td><td>' + item.qPoints + '</td><td>' + '<button>Delete</button>' + '</td></tr>';
                    });
                    $('#questionTable').append(trHTML);
                },
                error: function(xhr) {
                    //Do Something to handle error
                }
            });

            //Get Submissions
            $.ajax({
                url: "getSubmissions",
                type: "GET", //send it through get method
                data: {"aId": $aId},
                success: function(response) {
                    var trHTML = '';
                    var trHTML2 = '';
                    $.each(response, function (i, item) {

                        if (item.status == false) {
                            trHTML += '<tr><td>' + item.lName + ", " + item.fName
                                + '</td><td>' + item.submissionDate
                                + '</td><td>' + item.status
                                + '</td><td class="aId">' + item.aId
                                + '</td><td class="sId">' + item.sId
                                + '</td><td class="submissionId">' + item.submissionId
                                + '</td><td>' + '<button class="getSubmission" onclick="setSubmissionToGrade()">Grade</button>' + '</td></tr>';
                        } else {
                            trHTML2 += '<tr><td>' + item.lName + ", " + item.fName
                                + '</td><td>' + item.submissionDate
                                + '</td><td>' + item.status + '</td></tr>';
                        }
                    });
                    $('#submissionsTable').append(trHTML);
                    $('#gradedSubmissionTable').append(trHTML2);
                },
                error: function(xhr) {
                    //Do Something to handle error
                }
            });

        });
    });

    $(document).on('click', '.getSubmission', function() {
        //alert("testing");

        var $aId = $(this).closest("tr")   // Finds the closest row <tr>
            .find(".aId")     // Gets a descendent with class="aId"
            .text();

        var $sId = $(this).closest("tr")   // Finds the closest row <tr>
            .find(".sId")     // Gets a descendent with class="aId"
            .text();

        var $submissionId = $(this).closest("tr")
            .find(".submissionId")
            .text();

        //alert("aId: " + $aId + "sId: " + $sId);
        $('input[name="sId"]').val($sId);
        $('input[name="aId2"]').val($aId);
        $('input[name="submissionId"]').val($submissionId);

        $.ajax({
            url: "getSubmission",
            type: "GET", //send it through get method
            data: {"aId": $aId, "sId": $sId, "submissionId": $submissionId},
            success: function(response) {
                var trHTML = '';
                $.each(response, function (i, item) {
                trHTML += '<tr><td>' + item.question + '</td><td>' + item.answer + '</td><td>' + item.qPoints + '</td><td>' + '<input type="number" name="grade" required="required">' + '</td></tr>';
                });
                $('#gradeTable').append(trHTML);
            },
            error: function(xhr) {
                //Do Something to handle error
            }
        });
    });

    jQuery(document).ready(function($) {
        $("#downloadFile").click(function() {

            var $sId = document.getElementById("sId").value;
            var $aId = document.getElementById("aId2").value;


            //alert("test: " + $aId + " " + $sId);

            $.ajax({
                url: "getSubmissionFile",
                type: "GET", //send it through get method
                data: {"aId": $aId, "sId": $sId},
                success: function(response) {
                    alert("Home work file has been moved to your Download file");
                },
                error: function(xhr) {
                    //Do Something to handle error
                    alert("Home work file has been moved to your Download file");
                }
            });

        });
    });

    //Grade assignment through ajax
    $("form#gradeForm").submit(function(e) {
        //e.preventDefault();
        //var formData = new FormData(this);

        //alert("testing: working?");

        $.ajax({
            url: "gradeAssignment",
            type: 'POST',
            data: $('#gradeForm').serialize(),
            success: function () {

                //Hide grade
                $('#grade').hide();

                //Show submissions
                $('#submissions').show();

                //Send alert
                alert("Assignment graded successfully." );

                //Clear table
                $("gradeTable").find("tr:gt(0)").remove();

                $('#myModal').show();
            }
        });
    });

    $('#mymodal').on('hidden.bs.modal', function() {
        return false;
    });

    //TODO: Clear questions from grade table

</script>

</body>
</html>
