<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="j" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师信息预览</title>
 <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/foundation.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/foundation-datepicker.css">
  <script src="<%=request.getContextPath() %>/resources/vendor/custom.modernizr.js"></script>
  <style type="text/css">
  body{
  background-image: url("<%=request.getContextPath()%>/resources/images/ecailles.png");
  	background-color: rgba(0,0,0,0.05);
  }
  	table {
  		width: 100%;
  	}
  	th {
  		background-color:  #2795b6;
  	}
  	td{
  		text-align: center;
  	}
  	select{
  		height:32px;
  	}
   #toggle {
  		position: absolute;
  		right: 0px;
  		display: <%=request.getAttribute("toggle")%>;
  		opacity:0.01;
  	} 
   #toggle:hover {
  		opacity:1;
  	} 
  	  .labelname {
  	  	background-color:#2795b6;
          width:150px;
      }
      #preview td {
      	text-align: left;
      }
      #preview tr {
      	height:15px;
      }
      #preview .short {
      	text-align: center;
      }
      .print{
      	opacity: 0.01;
      }
      .print:hover{
      	opacity: 1;
      }
      
  </style>
</head>
<body>
<jsp:include page="preview/basicInfo.jsp"></jsp:include>
<jsp:include page="preview/workexp.jsp"></jsp:include>
<jsp:include page="preview/wholeGrowPlan.jsp"></jsp:include>
<jsp:include page="preview/periodGrowPlan.jsp"></jsp:include>
<jsp:include page="preview/periodGrowPlanY1.jsp"></jsp:include>
<jsp:include page="preview/periodGrowPlanY2.jsp"></jsp:include>
<jsp:include page="preview/periodGrowPlanY3.jsp"></jsp:include>
<jsp:include page="preview/workLecture.jsp"></jsp:include>
<jsp:include page="preview/workSurvey.jsp"></jsp:include>
<jsp:include page="preview/workAward.jsp"></jsp:include>
<jsp:include page="preview/workTeachResearch.jsp"></jsp:include>
<jsp:include page="preview/workBookWrite.jsp"></jsp:include>
<jsp:include page="preview/workTeaching.jsp"></jsp:include>
<jsp:include page="preview/workLearning.jsp"></jsp:include>
<jsp:include page="preview/workContinueLearn.jsp"></jsp:include>
<jsp:include page="preview/workTeachSkill.jsp"></jsp:include>
<jsp:include page="preview/workCommSupport.jsp"></jsp:include>
<jsp:include page="preview/workProMoral.jsp"></jsp:include>
<a class="small button large-12 print" onclick="window.print()">打印</a>



<script src="<%=request.getContextPath() %>/resources/scripts/jquery-1.8.3.js"></script>
<script src="<%=request.getContextPath() %>/resources/scripts/foundation.min.js"></script>
  <script type="text/javascript">
  $(document).foundation();
  </script>
</body>
</html>