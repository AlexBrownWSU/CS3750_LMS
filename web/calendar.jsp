<%--
  Created by IntelliJ IDEA.
  User: alexbrown
  Date: 11/21/19
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Title</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <link rel="stylesheet" href="style_calendar.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href='fullCalendar.css' rel='stylesheet' />
    <link href='fullCalendar.print.css' rel='stylesheet' media='print' />
</head>
<body>

<div class="topnav">
    <p style="color:red">User Profile: ${lName}, ${fName}, Student Id: ${studentId}</p>
    <hr>
</div>

<div class="icon-bar">
    <a href="/userLandingPage.jsp"><i class="fa fa-home"></i></a>
    <a href="/editUser.jsp "><i class="fa fa-user"></i></a>
    <a href="/login.jsp"><i class="fa fa-sign-out"></i></a>
    <a href="#"><i class="fa fa-globe"></i></a>
    <a href="#"><i class="fa fa-trash"></i></a>
</div>

<div id='wrap'>

    <div id='calendar'></div>

    <div style='clear:both'></div>
</div>


<div class="calendar-info">

</div>


<script src='jquery-1.10.2.js' type="text/javascript"></script>
<script src='jquery-ui.custom.min.js' type="text/javascript"></script>
<script src='fullCalendar.js' type="text/javascript"></script>


<script>

    $(document).ready(function() {
        var date = new Date();
        var d = date.getDate();
        var m = date.getMonth();
        var y = date.getFullYear();
        /*  className colors
        className: default(transparent), important(red), chill(pink), success(green), info(blue)
        */
        /* initialize the external events
        -----------------------------------------------------------------*/
        $('#external-events div.external-event').each(function() {
            // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
            // it doesn't need to have a start or end
            var eventObject = {
                title: $.trim($(this).text()) // use the element's text as the event title
            };
            // store the Event Object in the DOM element so we can get to it later
            $(this).data('eventObject', eventObject);
            // make the event draggable using jQuery UI
            $(this).draggable({
                zIndex: 999,
                revert: true,      // will cause the event to go back to its
                revertDuration: 0  //  original position after the drag
            });
        });
        /* initialize the calendar
        -----------------------------------------------------------------*/
        var myObj = [];

        $.each(${calendarEvents}, function (i, item) {

            var dateObj = new Date(item.event);
            var year = dateObj.getFullYear();
            var month = dateObj.getMonth();
            var day = dateObj.getDate();
            var hour = dateObj.getHours();
            var minutes = dateObj.getMinutes();

            //alert(year + " " + month + " " + day + " " + hour + " " + minutes);

            var x = {
                title: item.title,
                start: new Date(year, month, day, hour, minutes),
                allDay: item.allDay,
                className: item.className
            };
            myObj.push(x);
            //alert(JSON.stringify(myObj));
        });

var calendar =  $('#calendar').fullCalendar({
            header: {
                left: 'title',
                center: 'agendaDay,agendaWeek,month',
                right: 'prev,next today'
            },
            editable: true,
            firstDay: 1, //  1(Monday) this can be changed to 0(Sunday) for the USA system
            selectable: true,
            defaultView: 'month',
            axisFormat: 'h:mm',
            columnFormat: {
                month: 'ddd',    // Mon
                week: 'ddd d', // Mon 7
                day: 'dddd M/d',  // Monday 9/7
                agendaDay: 'dddd d'
            },
            titleFormat: {
                month: 'MMMM yyyy', // September 2009
                week: "MMMM yyyy", // September 2009
                day: 'MMMM yyyy'                  // Tuesday, Sep 8, 2009
            },
            allDaySlot: false,
            selectHelper: true,
            select: function(start, end, allDay) {
                var title = prompt('Event Title:');
                if (title) {
                    calendar.fullCalendar('renderEvent',
                        {
                            title: title,
                            start: start,
                            end: end,
                            allDay: allDay
                        },
                        true // make the event "stick"
                    );
                }
                calendar.fullCalendar('unselect');
            },
            droppable: true, // this allows things to be dropped onto the calendar !!!
            drop: function(date, allDay) { // this function is called when something is dropped
                // retrieve the dropped element's stored Event Object
                var originalEventObject = $(this).data('eventObject');
                // we need to copy it, so that multiple events don't have a reference to the same object
                var copiedEventObject = $.extend({}, originalEventObject);
                // assign it the date that was reported
                copiedEventObject.start = date;
                copiedEventObject.allDay = allDay;
                // render the event on the calendar
                // the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
                $('#calendar').fullCalendar('renderEvent', copiedEventObject, true);
                // is the "remove after drop" checkbox checked?
                if ($('#drop-remove').is(':checked')) {
                    // if so, remove the element from the "Draggable Events" list
                    $(this).remove();
                }
            },
            events: myObj
        });
    });

</script>

</body>
</html>
