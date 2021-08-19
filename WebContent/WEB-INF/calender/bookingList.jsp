<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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

   <jsp:include page="../includes/header.jsp" />


<script>





  document.addEventListener('DOMContentLoaded', function() {
     
     


   const showModal= $('#showModal'); 
 
     console.log(showModal);
     
    var calendarEl = document.getElementById('calendar');
    
    
   

      var calendar = new FullCalendar.Calendar(calendarEl, {
          height: '700px', // calendar 높이 설정
          expandRows: true, // 화면에 맞게 높이 재설정
          slotMinTime: '08:00', // Day 캘린더에서 시작 시간
          slotMaxTime: '20:00', // Day 캘린더에서 종료 시간
         headerToolbar: {
           left: 'prev,next today',
           center: 'title',
           right: 'dayGridMonth,listYear'
         },
         navLinks: true, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
         editable: true, // 수정 가능?
         selectable: true, // 달력 일자 드래그 설정가능
         nowIndicator: true, // 현재 시간 마크
         dayMaxEvents: true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
         locale: 'ko', // 한국어 설정
         eventAdd: 
            
    function(data){ // 이벤트가 추가되면 발생하는 이벤트
       
                 console.log('추가');
                 $.ajax({
                    url:"http://localhost:8080/project_group3/bookingList.data"
                    ,dateType:"json"
                    ,type:'GET'
                    ,success : function (data) {
                       successCallback(data);
                  
              },error : function(xhr){
                 console.log('error',xhr);
              }
                 });
           
         },
         eventChange: function(obj) { // 이벤트가 수정되면 발생하는 이벤트
         console.log(obj);
         },
         eventRemove: function(obj){ // 이벤트가 삭제되면 발생하는 이벤트
         console.log(obj);
         },
         eventSources: [
             // your event source
             {
               events: function(fetchInfo, successCallback, failureCallback) {
                  console.log('aaa');
                  $.ajax({
                     url:"http://localhost:8080/project_group3/bookingList.data"
                     ,dateType:"json"
                     ,type:'GET'
                     ,success : function (data) {
                        successCallback(data);
                       
                      
                        
               },error : function(xhr){
                  console.log('error',xhr);
               }
                  });
                 // ...
               },
               color: 'yellow',   // an option!
               textColor: 'black' // an option!
             }
             // any other sources...
           ],
           
   
         displayEventTime: true, // don't show the time column in list view

         // THIS KEY WON'T WORK IN PRODUCTION!!!
         // To make your own Google API key, follow the directions here:
         // http://fullcalendar.io/docs/google_calendar/
         googleCalendarApiKey: 'AIzaSyDcnW6WejpTOCffshGDDb4neIrXVUA1EAE',

         // US Holidays
         events: 'en.usa#holiday@group.v.calendar.google.com',

         eventClick: function(arg,calEvent, jsEvent, view) {
           // opens events in a popup window
             //  window.open(arg.event.url, 'google-calendar-event', 'width=700,height=600');
         
           
           
        
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
  
<jsp:include page="../includes/footer.jsp" />
</body>
</html>
