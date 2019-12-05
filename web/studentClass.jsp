<%--
  Created by IntelliJ IDEA.
  User: plisk
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
    <title>Student Class</title>
    <link rel="stylesheet" href="style_student_class.css">
    <link rel="stylesheet" href="style_student_analytics.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body onload="onSubmission(${marker})" >

    <div class="topnav">
        <p style="color:red">STUDENT: ${lName}, ${fName} STUDENT ID = ${id} Class: ${cName}</p>
        <hr>
    </div>


        <div class="icon-bar">
            <div class="tooltip">
                <a href="${pageContext.request.contextPath}/login?userId=${id}"><i class="fa fa-home"></i></a>
                <span class="tooltiptext">Home</span>
            </div>
            <div class="tooltip">
                <a href="${pageContext.request.contextPath}/editUserInfo?userId=${id}"><i class="fa fa-user"></i></a>
                <span class="tooltiptext">User Profile</span>
            </div>

            <div class="tooltip">
                <a href="${pageContext.request.contextPath}/login.jsp"><i class="fa fa-sign-out"></i></a>
                <span class="tooltiptext">Logout</span>
            </div>

            <div class="tooltip">
                <a href="${pageContext.request.contextPath}/getCalendar?studentId=${id}&fName=${fName}&lName=${lName}"><i class="fa fa-Calendar"></i></a>
                <span class="tooltiptext">Calendar</span>
            </div>

            <div class="tooltip">
                <a href="#"><i class="fa fa-trash"></i></a>
                <span class="tooltiptext">Trash</span>
            </div>
        </div>



    <div class = "container">
        <div class = "card">
            <div class = "box">
                <div class = "percent">
                    <svg>
                        <circle cx="35" cy="35" r="35"></circle>
                        <circle cx="35" cy="35" r="35"></circle>
                    </svg>
                    <div class = "number">
                        <h2 class = "high">${averages.high}<span>%</span></h2>
                    </div>
                </div>
                <h2 class = "text">Class High</h2>
            </div>

        </div>


        <div class = "card">
            <div class = "box">
                <div class = "percent">
                    <svg>
                        <circle cx="35" cy="35" r="35"></circle>
                        <circle cx="35" cy="35" r="35"></circle>
                    </svg>
                    <div class = "number">
                        <h2 class = "avg"  >${averages.average}<span>%</span></h2>
                    </div>
                </div>
                <h2 class = "text">Class avg</h2>
            </div>

        </div>
        <div class = "card">
            <div class = "box">
                <div class = "percent">
                    <svg>
                        <circle cx="35" cy="35" r="35"></circle>
                        <circle cx="35" cy="35" r="35"></circle>
                    </svg>
                    <div class = "number">
                        <h2 class = "low">${averages.low}<span>%</span></h2>
                    </div>
                </div>
                <h2 class = "text">Class low</h2>
            </div>

        </div>
        <div class = "card">
            <div class = "box">
                <div class = "percent">
                    <svg>
                        <circle cx="35" cy="35" r="35"></circle>
                        <circle cx="35" cy="35" r="35"></circle>
                    </svg>
                    <div class = "number">
                        <h2 class = "userGrade">${averages.studentScore}<span>%</span></h2>
                    </div>
                </div>
                <h2 class = "text">your Grade</h2>
            </div>

        </div>
        <div class = "AssignmentAnalytics" >
            <h2>Assignment Scores</h2>
            <h3 id = "max" ></h3>
            <h3 id = "med"></h3>
            <h3 id = "avg"></h3>
            <h3 id = "low"></h3>
            <h3 id = "sGrade"></h3>
        </div>
    </div>

    <div class="pageContent">
        <br>
        <br>

        <p class="heading">Current Assignments</p>
        <hr>
        <button class="addButton" id="collapseAllClasses" onclick="showHideAllAssignments()"><i class="fa fa-plus"></i></button>
        <div id="Assignments" name="Assignments">
            <table class="AssignmentsTodo" id="AssignmentsTodo">

                <tr class="clickable-row">
                    <th>Assignment Name</th>
                    <th>Total Points</th>
                    <th>Open Date</th>
                    <th>Due Date</th>
                    <th hidden>Assignment Number</th>
                </tr>

                <c:forEach items="${assignments}" var="assignments">
                        <tr class="clickable-row">
                        <td>${assignments.aName}</td>
                        <td>${assignments.tPoints}</td>
                        <td>${assignments.startDate}</td>
                        <td>${assignments.dueDate}</td>
                        <td hidden>${assignments.aId}</td>

                    </tr>
                </c:forEach>

            </table>
        </div>

        <br>
        <br>
        <p class="heading">Submitted Assignments</p>
        <hr>
        <button class="addButton" id="collapseMyClasses" onclick="showHidePastAssignments()"><i class="fa fa-plus"></i></button>
        <div id="AssignmentsFinished" name="AssignmentsFinished">
            <table class="AssignmentsF" id="AssignmentsF">

                <tr  >
                    <th>Assignment Name</th>
                    <th>Total Points</th>
                    <th>Grade</th>
                    <th>Date Submitted</th>
                    <th hidden>aId</th>

                </tr>

                <c:forEach items="${submitted}" var="submitted">
                     <tr class = "clickable-row-analytics">
                        <td>${submitted.aName}</td>
                        <td>${submitted.tPoints}</td>
                        <td>${submitted.grade}</td>
                        <td>${submitted.submissionDate}</td>
                        <td hidden>${submitted.aId}</td>
                    </tr>
                    <div class = "analytics">
                    </div>
                </c:forEach>

            </table>
        </div>


            <button hidden id="myBtn">Open Modal</button>

            <div id="myModal" class="modal">
                <!-- Modal content -->
                <div class="modal-content">

                    <span class="close">&times;</span>

                    <h1>Assignment: <span id="assignmentName"></span></h1>
                    <hr>

                    <form action="${pageContext.request.contextPath}/submitAssignment" method="post" enctype="multipart/form-data">

                        <!--<c:forEach items="${question}" var="questions">

                        <div>
                            <label for="answer">${questions.questionTex}</label>
                            <input type="text" name="answer" id="answer" width="30" placeholder="answer"/>
                        </div>
                    </c:forEach>-->

                        <table id="questionTable">
                            <tr>
                                <th>QUESTION</th>
                                <th>RESPONSE</th>
                            </tr>
                        </table>
                        <div>
                            <input type="file" name="file" id="file" width="30" placeholder="file"/>
                            <label for="file">File Upload</label>
                        </div>

                        <div>
                            <input type="hidden" id="sId" name="sId" value="${id}">
                            <input type="hidden" id="aId" name="aId">
                            <input type="hidden" id="cId" name="cId" value="${cId}">
                            <input type="hidden" id="fName" name ="fName" value="${fName}">
                            <input type="hidden" id="lName" name ="lName" value="${lName}">
                            <input type="submit" value="submit"/>
                        </div>
                    </form>
                </div>
            </div>



        </div>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
    <script>
        //Show / hide all class div
        function showHideAllAssignments() {
            var x = document.getElementById("Assignments");
            if (x.style.display === "none") {
                x.style.display = "block";
            } else {
                x.style.display = "none";
            }
        }

        //Show / hide my class div
        function showHidePastAssignments() {
            var x = document.getElementById("AssignmentsFinished");
            if (x.style.display === "none") {
                x.style.display = "block";
            } else {
                x.style.display = "none";
            }
        }

        var popUp = document.getElementById("AssignmentAnalytics");

        // Get the modal
        var modal = document.getElementById("myModal");

        // Get the button that opens the modal
        var btn = document.getElementById("myBtn");

        // Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close")[0];

        // When the user clicks the button, open the modal
        btn.onclick = function() {modal.style.display = "block";}

        // When the user clicks on <span> (x), close the modal
        span.onclick = function() {
            modal.style.display = "none";
            $('#questionTable').find("tr:gt(0)").remove();
        }

        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";

                //Remove questions from table
                $('#questionTable').find("tr:gt(0)").remove();
            }
        }



        //JQuery detect row click
        jQuery(document).ready(function($) {
            $(".clickable-row").click(function() {

                //Show modal

                //alert("here1");
                modal.style.display ="block";

                //Get vars
                //var $name = $(this).find("td:nth-child(1)").html();
                var $aId = $(this).find("td:nth-child(5)").html();
                //alert($aId);

                //document.getElementById("className").innerHTML = $name;
                $('input[name="aId"]').val($aId);

                $.ajax({
                    url: "viewAssignment",
                    type: "GET", //send it through get method
                    data: {"aId": $aId},
                    success: function(response) {
                        var trHTML = '';
                        $.each(response, function (i, item) {
                            trHTML += '<tr><td>' + item.question + '</td><td>' + '<input type="text" id="response" name="response">' + '</td></tr>';
                        });
                        $('#questionTable').append(trHTML);
                    },

                    error: function(xhr) {
                        //Do Something to handle error
                    }

                });
            });
        });
function onSubmission(marker){
    if(marker === 1){
        alert("!!!SUBMISSION SUCCESSFUL!!!");
    }
}

        jQuery(document).ready(function($) {
            $(".clickable-row-analytics").click(function() {


                var $aId = $(this).find("td:nth-child(5)").html();


                $.ajax({
                    url: "GetAssignmentAnalytics",
                    type: "GET", //send it through get method
                    data: {"aId": $aId, "cId": ${cId}, "sId": ${id}},
                    success: function(response) {
                        var HTML = '';

                        $("#max").text("HIGH: " + response.high);
                        $("#avg").text("AVG: " + response.average.toFixed(2));
                        $("#low").text("LOW: " + response.low);
                        $("#sGrade").text("YOUR GRADE: " + response.studentScore);


                    }
                });

            });
        });






    </script>
</body>
</html>
