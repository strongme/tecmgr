<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8]> 				 <html class="no-js lt-ie9" data-ng-app="tecmgrApp"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" data-ng-app="tecmgrApp"> <!--<![endif]-->
<head>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>教师档案</title>
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
  		opacity:1;
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
      .curLi{
      	color: red;
      }
  </style>
</head>
<body>

    <div data-ng-app="tecmgrApp">
   	 <nav class="top-bar fixed" data-topbar>
            <ul class="title-area">
                <li class="name">
                    <h1><a>太原成成中学『教师档案』</a></h1>
                </li>
            </ul>
            <section class="top-bar-section">
                <ul class="right">
                	<li class="has-dropdown">
			        <a>基本情况</a>
			        <ul class="dropdown">
			          <li><a href="#/basicInfo/${teacher.teacherId}">基本信息</a></li>
			          <li><a href="#/workExp/${teacher.teacherId}">个人简历</a></li>
			        </ul>	
			      </li>
                	<li class="has-dropdown">
			        <a>总体成长规划</a>
			        <ul class="dropdown">
			          <li><a href="#/wholeGrowPlan/${teacher.teacherId}">总体成长规划</a></li>
			        </ul>	
			      </li>
                	<li class="has-dropdown">
			        <a>阶段性成长规划</a>
			        <ul class="dropdown">
			          <li><a href="#/periodGrowPlan/${teacher.teacherId}">阶段成长规划</a></li>
			          <li><a href="#/periodGrowPlanY1/${teacher.teacherId}">过程小结第一年</a></li>
			          <li><a href="#/periodGrowPlanY2/${teacher.teacherId}">过程小结第二年</a></li>
			          <li><a href="#/periodGrowPlanY3/${teacher.teacherId}">过程小结第三年</a></li>
			        </ul>	
			      </li>
                	<li class="has-dropdown">
			        <a>个人成就展示</a>
			        <ul class="dropdown">
			          <li><a href="#/workLecture/${teacher.teacherId}">开课讲座</a></li>
		             <li ><a href="#/workSurvey/${teacher.teacherId}">调研督导</a></li>
                    <li><a href="#/workAward/${teacher.teacherId}">教学竞赛</a></li>
                    <li><a href="#/workTeachResearch/${teacher.teacherId}">教学科研</a></li>
                    <li><a href="#/workBookWrite/${teacher.teacherId}">论文论著编写</a></li>
                    <li><a href="#/workTeaching/${teacher.teacherId}">指导学生</a></li>
                    <li><a href="#/workLearning/${teacher.teacherId}">青年教师</a></li>
                    <li><a href="#/workContinueLearn/${teacher.teacherId}">继续教育</a></li>
                    <li><a href="#/workTeachSkill/${teacher.teacherId}">教育技术培训</a></li>
                    <li><a href="#/workCommSupport/${teacher.teacherId}">交流支教</a></li>
                    <li><a href="#/workProMoral/${teacher.teacherId}">教师职业道德</a></li>
			        </ul>	
			      </li>
                    <li class="active" style="display: <%=request.getAttribute("toggle")%>"><a id="eye" href="#/profileinfo/${teacher.teacherId}">欢迎：<strong>${teacher.teacherName}</strong>&nbsp;老师</a></li>
                    <li><a target="_blank" href="<%=request.getContextPath()%>/master/queryPreview/${teacher.teacherId}" style="display: <%=request.getAttribute("toggle")%>">总体预览</a></li>
                    <li><a href="/tecmgr" style="display: <%=request.getAttribute("toggle")%>">注销登录</a></li>
                </ul>
            </section>
            </nav>
			<div data-ng-view=""></div>
    </div>
    
    
  <script src="<%=request.getContextPath() %>/resources/scripts/ysw.js"></script>
  <script src="<%=request.getContextPath() %>/resources/scripts/jquery-1.8.3.js"></script>
  <script src="<%=request.getContextPath() %>/resources/scripts/angular.js"></script>
  <script src="<%=request.getContextPath() %>/resources/scripts/foundation.min.js"></script>
  <script src="<%=request.getContextPath() %>/resources/scripts/foundation-datepicker.js"></script>
  <script type="text/javascript">var basepath="<%=request.getContextPath()%>";</script>
  <script src="<%=request.getContextPath() %>/resources/app/tecmgrApp.js"></script>
  <script src="<%=request.getContextPath() %>/resources/app/tecmgrController.js"></script>
  <script src="<%=request.getContextPath() %>/resources/app/tecmgrService.js"></script>
  <script type="text/javascript">
  $(document).foundation();
  window.location.href = $('#eye').attr('href');
  $(function(){
	  $('.dropdown li a').click(function() {
		  $(this).css('color','red');
	  });
  });
  </script>
</body>
</html>

