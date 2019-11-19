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
        <a href="#"><i class="fa fa-globe"></i></a>
        <a href="#"><i class="fa fa-trash"></i></a>
    </div>

    <div class="pageContent">

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

    </script>

</body>
</html>
