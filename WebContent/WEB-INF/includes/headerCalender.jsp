<!DOCTYPE html>

<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset='utf-8' />
<link href='assets/css/main.css' rel='stylesheet' />
<script src='assets/js/main.js'></script>

<style>

  body {
    margin: 40px 10px;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  #loading {
    display: none;
    position: absolute;
    top: 10px;
    right: 10px;
  }

  #calendar {
    max-width: 1100px;
    margin: 0 auto;
  }

</style>
</head>
<body>





	<c:forEach items="${list }" var="list">
		
		<c:set var="bo_date" value="${list.bo_date} " />
		<c:set var="m_id" value="${list.m_id}"/>
		<c:set var="t_no" value="${list.t_no}"/>
		
			</c:forEach>
		
				<c:out value="${bo_date}"></c:out>
				<c:out value="${m_id}"></c:out>
				<c:out value="${t_no}"></c:out>
				

<script>



  document.addEventListener('DOMContentLoaded', function() {
	  


	  
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {

      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,listYear'
      },
      eventSources: [
          // your event source
          {
            events: function(fetchInfo, successCallback, failureCallback) {
               
               $.ajax({
                  url:"http://localhost:8080/day12_0810/list.do"
                  ,dateType:"json"
                  ,type:'GET'
                  ,data:{
                	  date :${bo_date}
                  ,id :"${m_id}"
                  ,no :${t_no}
                  }
                  ,success : function (data) {
					
                	  console.log(data);
				}
               });
              // ...
            },
            color: 'yellow',   // an option!
            textColor: 'black' // an option!
          }
          // any other sources...
        ],

      displayEventTime: false, // don't show the time column in list view

      // THIS KEY WON'T WORK IN PRODUCTION!!!
      // To make your own Google API key, follow the directions here:
      // http://fullcalendar.io/docs/google_calendar/
      googleCalendarApiKey: 'AIzaSyDcnW6WejpTOCffshGDDb4neIrXVUA1EAE',

      // US Holidays
      events: 'en.usa#holiday@group.v.calendar.google.com',

      eventClick: function(arg) {
        // opens events in a popup window
        window.open(arg.event.url, 'google-calendar-event', 'width=700,height=600');

        arg.jsEvent.preventDefault() // don't navigate in main tab
      },

      loading: function(bool) {
        document.getElementById('loading').style.display =
          bool ? 'block' : 'none';
      }

    });

    calendar.render();
  });

</script>









<!--
const data = {title : list.value,
		content : contentTextarea.value,
		writer : writerInput.value,
		attachList: attachList
		
}
-->


  <div id='loading'>loading...</div>

  <div id='calendar'></div>
  

</body>
</html>

