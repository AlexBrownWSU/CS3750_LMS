<%--
  Created by IntelliJ IDEA.
  User: alexbrown
  Date: 10/25/19
  Time: 11:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!--TODO: CSS Styling-->

<html>
<head>
    <title>Student</title>
    <link rel="stylesheet" href="style_student_class.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>

<body>

    <div class="topnav">
        <p style="color:red">STUDENT: ${lName}, ${fName} STUDENT ID: ${studentId}, Class Name: </p>
        <hr>
    </div>

    <div class="icon-bar">
        <a class="active" href="#"><i class="fa fa-home"></i></a>
        <a href="/editUserInfo?userId=${studentId}"><i class="fa fa-user"></i></a>
        <a href="/login.jsp"><i class="fa fa-sign-out"></i></a>
        <a href="/getCalendar?studentId=${studentId}&fName=${fName}&lName=${lName}"><i class="fa fa-calendar"></i></a>
        <a href="#"><i class="fa fa-trash"></i></a>
    </div>

    <div class="pageContent">

        <div class="w3-container">

            <h2>Dynamic Progress Bar with Labels</h2>
            <p>Left-aligned label:</p>

            <div class="w3-light-grey">
                <div id="myBar" class="w3-container w3-green" style="width:20%">20%</div>
            </div>
            <br>
            <button class="w3-button w3-green" onclick="move()">Click Me</button>
        </div>


        <div class="classAverages">
            <h2>Class Average</h2>
            <div class="progress">
                <div class="progress-bar bg-danger progress-bar-striped progress-bar-animated" style="width:39%">
                    Low: 39%
                </div>
                <div class="progress-bar bg-warning progress-bar-striped progress-bar-animated" style="width:20%">
                    Medium: 59%
                </div>
                <div class="progress-bar bg-success progress-bar-striped progress-bar-animated" style="width:20%">
                    High: 79%
                </div>
            </div>
        </div>

        <!--<div class="bar_container">
            <div id="main_container">
                <div id="pbar" class="progress-pie-chart" data-percent="0">
                    <div class="ppc-progress">
                        <div class="ppc-progress-fill"></div>
                    </div>
                    <div class="ppc-percents">
                        <div class="pcc-percents-wrapper">
                            <span>%</span>
                        </div>
                    </div>
                </div>

                <progress style="display: none" id="progress_bar" value="0" max="100"></progress>
            </div>
        </div>-->

        <div>

            <h1>MY ASSIGNMENTS</h1>
            <table>
                <tr>
                    <th>NAME</th>
                    <th>POINTS</th>
                    <th>START DATE</th>
                    <th>DUE DATE</th>
                </tr>
                <c:forEach items="${assignments}" var="assignments">
                    <tr class="clickable-row" data-href="/viewClass?id=${classes.id}&fName=${fName}&lName=${lName}&instructorId=${instructorId}">
                        <td>${assignments.aName}</td>
                        <td>${assignments.tPoints}</td>
                        <td>${assignments.startDate}</td>
                        <td>${assignments.dueDate}</td>
                        <td style="display:none">${assignments.aId}</td>
                    </tr>
                </c:forEach>
            </table>


        </div>

        <button id="myBtn">Open Modal</button>

        <div id="myModal" class="modal">
            <!-- Modal content -->
            <div class="modal-content">

                <span class="close">&times;</span>

                <h1>Assignment: <span id="assignmentName"></span></h1>
                <hr>

                <form id="submissionForm" method="post" enctype="multipart/form-data"> <!--action="/submitAssignment"-->
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
                        <input type="hidden" id="sId" name="sId" value="${studentId}">
                        <input type="hidden" id="aId" name="aId">
                        <input type="hidden" id="cId" name="cId" value="${id}">
                        <input type="submit" value="submit"/>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js"></script>
    <script>

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
    }

    //JQuery detect row click
    jQuery(document).ready(function($) {
        $(".clickable-row").click(function() {

            //Show modal
            modal.style.display ="block";

            //Get var
            var $aId = $(this).find("td:nth-child(5)").html();

            //Set var
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

    //Submit assigniment through ajax
    $("form#submissionForm").submit(function(e) {
        e.preventDefault();
        var formData = new FormData(this);

        //var tableFirstColumn=$("tr").find("td:first");

        $.ajax({
            url: "submitAssignment",
            type: 'POST',
            data: formData,
            success: function (data) {
                //Hide modal
                $('#myModal').hide();

                //Send alert
                alert("Assignment submitted successfully." );

                //Clear table
                $("questionTable").find("tr:gt(0)").remove();
            },
            cache: false,
            contentType: false,
            processData: false
        });
    });

    //Pie chart
    $(document).ready(function() {
        var progressbar = $('#progress_bar');
        max = progressbar.attr('max');
        time = (1000 / max) * 5;
        value = progressbar.val();

        var loading = function() {
            value += 1;
            addValue = progressbar.val(value);

            $('.progress-value').html(value + '%');
            var $ppc = $('.progress-pie-chart'),
                deg = 360 * value / 100;
            if (value > 50) {
                $ppc.addClass('gt-50');
            }

            $('.ppc-progress-fill').css('transform', 'rotate(' + deg + 'deg)');
            $('.ppc-percents span').html(value + '%');

            if (value == max) {
                clearInterval(animate);
            }
        };

        var animate = setInterval(function() {
            loading();
        }, time);
    });

    </script>

</body>
</html>
