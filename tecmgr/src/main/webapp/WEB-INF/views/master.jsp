<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>管理员</title>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/foundation.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/foundation-datepicker.css">
  <script src="<%=request.getContextPath() %>/resources/vendor/custom.modernizr.js"></script>
<style type="text/css">
  body{
  background-image: url("<%=request.getContextPath()%>/resources/images/ecailles.png");
  	background-color: rgba(0,0,0,0.05);
  }
  th {
  		background-color:  #2795b6;
  	}
  	td{
  		text-align: center;
  		background-color:  rgba(0,0,0,0.006);
  	}
  
</style>
</head>
<body>

    <div data-ng-app="master">
    	<div data-ng-controller="masterController">
    	
    	 	 <nav class="top-bar fixed" data-topbar>
            <ul class="title-area">
                <li class="name">
                    <h1><a>太原成成中学『教师档案管理页』</a></h1>
                </li>
            </ul>
            <section class="top-bar-section">
                <ul class="right">
                    <li class="active"><a>欢迎：<strong class="label">管理员</strong></a></li>
                    <li><a href="/tecmgr">注销登录</a></li>
                </ul>
            </section>
            </nav>
    	
    	<div class="row">
		    <div class="large-12 columns">
			    	<fieldset>
			        <div class="row">
			            <div class="large-3 columns">
			                <label class="label">姓名</label>
			                <input type="text" placeholder="姓名" data-ng-model="q.name">
			            </div>
			            <div class="large-3 columns">
			                <label class="label">教工编号</label>
			                <input type="text" placeholder="教工编号" data-ng-model="q.teacherid">
			            </div>
			            <div class="large-3 columns">
			                <label class="label">政治面貌</label>
			                <input type="text" placeholder="政治面貌" data-ng-model="q.zzmm">
			            </div>
			            <div class="large-3 columns">
			                <label class="label">学科专业</label>
			                <input type="text" placeholder="学科专业" data-ng-model="q.subject">
			            </div>
			        </div>
			        <div class="row">
			        	<div class="large-4 columns">
			                <label class="label">最高学历</label>
			                <input type="text" placeholder="最高学历" data-ng-model="q.degree">
			            </div>
			              <div class="large-4 columns">
			                <label class="label">职称</label>
			                <input type="text" placeholder="职称" data-ng-model="q.title">
			            </div>
			             <div class="large-4 columns">
			                <label class="label">部门名称</label>
			                <input type="text" placeholder="所在单位" data-ng-model="q.department">
			            </div>
			        </div>
			        <div class="row">
			        	<div class="large-12 columns">
			                <a  class="small button large-6 columns" data-ng-click="query()">查询</a>
			                <a  class="small button large-6 columns" data-ng-click="reset()">清空</a>
		                </div>
			        </div>
			    </fieldset>
		    </div>
		</div>
		<div class="row">
			<div class="large-12 columns">
				<table style="width: 100%;">
		     			<tr>
		     				<th>教职工编号</th>
		     				<th>部门名称</th>
		     				<th>教师名称</th>
		     				<th>建档日期</th>
		     			</tr>
		     		<tbody data-ng-repeat="item in result">
		     			<tr>
		     				<td><a target="_blank" href="<%=request.getContextPath()%>/master/queryPreview/{{item.teacherId}}">{{item.teacherId}}</a></td>
		     				<td>{{item.departmentName}}</td>
		     				<td>{{item.teacherName}}</td>
		     				<td>{{item.createProfileTime}}</td>
		     			</tr>
		     		</tbody>
		     	</table>
			</div>
		</div>
		</div>
    </div>
  <script src="<%=request.getContextPath() %>/resources/scripts/ysw.js"></script>
  <script src="<%=request.getContextPath() %>/resources/scripts/jquery-1.8.3.js"></script>
  <script src="<%=request.getContextPath() %>/resources/scripts/angular.js"></script>
  <script src="<%=request.getContextPath() %>/resources/scripts/foundation.min.js"></script>
  <script src="<%=request.getContextPath() %>/resources/scripts/foundation-datepicker.js"></script>
  <script type="text/javascript">var basepath="<%=request.getContextPath()%>";</script>
  <script src="<%=request.getContextPath() %>/resources/app/masterapp.js"></script>
</body>
</html>

