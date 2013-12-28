var enableEdit = function() {
	$('#switcher').html('预览');
	$('#edit').css('display','block');
	$('#preview').css('display','none');
};
var disableEdit = function() {
	$('#switcher').html('编辑');
	$('#edit').css('display','none');
	$('#preview').css('display','block');
};
function tab() {
	$('#edit').css('display','none');
	$(document).foundation();
	$('th').each(function() {
		$(this).attr('align','center');
	});
	$('td').each(function() {
		$(this).attr('align','center');
	});
	$('#switcher').click(function() {
		if($('#switcher').html()=='编辑') {
			$('#switcher').html('预览');
			$('#edit').css('display','block');
			$('#preview').css('display','none');
		}else{
			$('#switcher').html('编辑');
			$('#edit').css('display','none');
			$('#preview').css('display','block');
		}
	});
}
tecmgrApp.controller('profileInfoController',function($scope,$routeParams,recordService) {
	$scope.teacherId = $routeParams.teacherId;
	$scope.record = recordService.get($scope.teacherId);
});

tecmgrApp.controller('basicInfoController',function($scope,$routeParams,basicInfoService,workExpService,honourService) {
	tab();
	function initDatePicker(id) {
		return $('#'+id).fdatepicker({
			format: 'yyyy-mm-dd'
		}).on('changeDate', function(ev){
			$('#'+id).val(ev.date.valueOf());
			$scope.cur['birth'] = new Date($('#birth').val());
		});
	}
	$scope.handleGender = function(o) {
		if(o=='1') {
			return '男';
		}else if(o=='0'){
			return '女';
		}else {
			return '请选择性别';
		}
	};
	$scope.dataPicker = initDatePicker('birth');
	$scope.startPicker = initDatePicker('start');
	$scope.endPicker = initDatePicker('end');
	$scope.teacherId = $routeParams.teacherId;
	$scope.initDatePickerSingle = function(id) {initDatePicker(id);};
	
	$scope.saveBasicInfo = function() {
		if($scope.cur.gender=='-1') {alert('请选择性别');return;}
		$scope.cur.teacherId = $scope.teacherId;
		if($scope.cur&&$scope.cur.teacherId&&$scope.cur.native_&&$scope.cur.nation&&$scope.cur.politicsStatus&&$scope.cur.subject&&$scope.cur.highestDegree&&$scope.cur.professionalTitle&&$scope.cur.position&&$scope.cur.photo&&$scope.cur.phone&&$scope.cur.qq&&$scope.cur.email&&$scope.cur.departmentName&&$scope.cur.talent&&$scope.cur.remark2){
			$scope.cur['birth'] = new Date($('#birth').val());
			basicInfoService.save($scope.cur);
			$scope.curHonour.teacherid =  $scope.teacherId;
			honourService.save($scope.curHonour);
			disableEdit();
		}else {
			alert('请完整填写信息');
		}
	};
	//data
	//基本信息
	$scope.cur = basicInfoService.get($scope.teacherId);
	if(!$scope.cur.teacherId)$scope.cur.teacherId =$scope.teacherId;
	if(!$scope.cur.photo)$scope.cur.photo ='照片暂无';
	if(!$scope.cur.departmentName)$scope.cur.departmentName ='成成中学';
	$scope.curHonour =honourService.get($scope.teacherId); 
	$scope.dataPicker.fdatepicker('setValue', $scope.cur.birth);
	
	$scope.saveHonour = function() {
		$scope.curHonour.teacherid =  $scope.teacherId;
		honourService.save($scope.curHonour);
		disableEdit();
	};
	
}) ;

tecmgrApp.controller('workExpController',function($scope,$routeParams,workExpService) {
	tab();
	function initDatePicker(id) {
		return $('#'+id).fdatepicker({
			format: 'yyyy-mm-dd'
		}).on('changeDate', function(ev){
			$('#'+id).val(ev.date.valueOf());
		});
	}
	$scope.startPicker = initDatePicker('start');
	$scope.endPicker = initDatePicker('end');
	$scope.teacherId = $routeParams.teacherId;
	$scope.initDatePickerSingle = function(id) {initDatePicker(id);};
	
	//个人简历
	$scope.curExpList = workExpService.get($scope.teacherId);
	$scope.curExp = {};
	$scope.saveWorkExp = function() {
		if($scope.curExp.uintOrDepartment&&$scope.curExp.postOrProtitle&&$scope.curExp.remark3) {
			$scope.curExp.teacherid = $scope.teacherId;
			$scope.curExp['startTime'] = new Date($('#start').val());
			$scope.curExp['endTime'] = new Date($('#end').val());
			workExpService.save($scope.curExp);
			disableEdit();$scope.curExp={};
			$scope.curExpList = workExpService.get($scope.teacherId,$scope.curExpList);
		}else {
			alert('请完整填写信息');
		}
	};
	$scope.updateWorkExp = function() {
		//设置时间
		for(var i=0;i<$scope.curExpList.length;i+=1) {
			$scope.curExpList[i] = updateDate($scope.curExpList[i]);
		}
		workExpService.update($scope.curExpList);
		disableEdit();
		$scope.curExpList = workExpService.get($scope.teacherId,$scope.curExpList);
	};
	
	function updateDate(we) {
		we.startTime = new Date($('#s'+we.id).val());
		we.endTime = new Date($('#e'+we.id).val());
		return we;
	}
}) ;



tecmgrApp.controller('wholeGrowPlanController',function($scope,$routeParams,wholeGrowPlanService) {
	tab();
	function initDatePicker(id) {
		return $('#'+id).fdatepicker({
			format: 'yyyy-mm-dd'
		}).on('changeDate', function(ev){
			$('#'+id).val(ev.date.valueOf());
			if(id=='pt') {
				$scope.cur['planTime'] = new Date($('#pt').val());
			}
		});
	}
	$scope.teacherId = $routeParams.teacherId;
	$scope.dataPicker = initDatePicker('pt');
	$scope.cur = wholeGrowPlanService.get($scope.teacherId);
	$scope.cur.teacherId = $scope.teacherId;
	$scope.dataPicker.fdatepicker('setValue', $scope.cur.planTime);
	
	$scope.saveWholePlan = function() {
		if($scope.cur&&$scope.cur.eduIdea&&$scope.cur.advanced&&$scope.cur.disadvanced&&$scope.cur.planDetail&&$scope.cur.remark){
			$scope.cur.teacherId = $scope.teacherId;
			$scope.cur['planTime'] = new Date($('#pt').val());
			wholeGrowPlanService.save($scope.cur);
			disableEdit();
			$scope.cur = wholeGrowPlanService.get($scope.teacherId,$scope.cur);
			$scope.dataPicker.fdatepicker('setValue', $scope.cur.planTime);
		}else {
			alert('请完整填写信息');
		}
	};
}) ;


tecmgrApp.controller('periodGrowPlanController',function($scope,$routeParams,periodGrowPlanService) {
	tab();
	$scope.teacherId = $routeParams.teacherId;
	$scope.cur = periodGrowPlanService.get($scope.teacherId);
	$scope.cur.teacherId = $scope.teacherId;
	
	$scope.savePeriodPlan = function() {
		var check = $scope.cur.timeZone&&$scope.cur.growPlan&&$scope.cur.selfCheckRealized&&$scope.cur.selfCheckUnrealized&&$scope.cur.goalRevise&&$scope.cur.remark;
		if(check){
			$scope.cur.teacherId = $scope.teacherId;
			periodGrowPlanService.save($scope.cur);
			disableEdit();
			$scope.cur = periodGrowPlanService.get($scope.teacherId,$scope.cur);
		}else {
			alert('请完整填写信息');
		}
	};
	
}) ;

tecmgrApp.controller('periodGrowPlanY1Controller',function($scope,$routeParams,periodGrowPlanService) {
	tab();
	$scope.teacherId = $routeParams.teacherId;
	$scope.sl1 = periodGrowPlanService.gettiny($scope.teacherId,1);
	$scope.saveSl1 = function() {
		var check = $scope.sl1.rethink&&$scope.sl1.practice&&$scope.sl1.learnEachOther&&$scope.sl1.schoolBasedEdu&&$scope.sl1.reading&&$scope.sl1.classExperience&&$scope.sl1.visitHome&&$scope.sl1.devote&&$scope.sl1.remark;
		if(check){
			$scope.sl1.num = 1;
			$scope.sl1.teacherid = $scope.teacherId;	;
			periodGrowPlanService.savetiny($scope.sl1);
			disableEdit();
			$scope.sl1 = periodGrowPlanService.gettiny($scope.teacherId,1,$scope.sl1);
		}else {
			alert('请完整填写信息');
		}
	};
	
}) ;

tecmgrApp.controller('periodGrowPlanY2Controller',function($scope,$routeParams,periodGrowPlanService) {
	tab();
	$scope.teacherId = $routeParams.teacherId;
	$scope.sl2 = periodGrowPlanService.gettiny($scope.teacherId,2);
	
	$scope.saveSl2 = function() {
		var check = $scope.sl2.rethink&&$scope.sl2.practice&&$scope.sl2.learnEachOther&&$scope.sl2.schoolBasedEdu&&$scope.sl2.reading&&$scope.sl2.classExperience&&$scope.sl2.visitHome&&$scope.sl2.devote&&$scope.sl2.remark;
		if(check){
			$scope.sl2.num = 2;
			$scope.sl2.teacherid = $scope.teacherId;
			periodGrowPlanService.savetiny($scope.sl2);
			disableEdit();
			$scope.sl2 =  periodGrowPlanService.gettiny($scope.teacherId,2,$scope.sl2);
		}else {
			alert('请完整填写信息');
		}
	};
	
}) ;

tecmgrApp.controller('periodGrowPlanY3Controller',function($scope,$routeParams,periodGrowPlanService) {
	tab();
	$scope.teacherId = $routeParams.teacherId;
	$scope.sl3 = periodGrowPlanService.gettiny($scope.teacherId,3);
	
	$scope.saveSl3 = function() {
		var check =$scope.sl3.rethink&&$scope.sl3.practice&&$scope.sl3.learnEachOther&&$scope.sl3.schoolBasedEdu&&$scope.sl3.reading&&$scope.sl3.classExperience&&$scope.sl3.visitHome&&$scope.sl3.devote&&$scope.sl3.remark;
		if(check){
			$scope.sl3.num = 3;
			$scope.sl3.teacherid = $scope.teacherId;
			periodGrowPlanService.savetiny($scope.sl3);
			disableEdit();
			$scope.sl3 = periodGrowPlanService.gettiny($scope.teacherId,3,$scope.sl3);
		}else {
			alert('请完整填写信息');
		}
	};
	
}) ;

tecmgrApp.controller('workLectureController',function($scope,$routeParams,workListService) {
	tab();
	function initDatePicker(id) {
		return $('#'+id).fdatepicker({
			format: 'yyyy-mm-dd'
		}).on('changeDate', function(ev){
			$('#'+id).val(ev.date.valueOf());
		});
	}
	$scope.reqname = 'workLecture';
	$scope.dataPicker = initDatePicker('time');
	$scope.teacherId = $routeParams.teacherId;
	$scope.initDatePickerSingle = function(id) {initDatePicker(id);};
	
	$scope.curWlList = workListService.get($scope.teacherId,$scope.reqname);
	$scope.newwl = {};
	$scope.saveWorkLecture = function() {
		if($scope.newwl.name&&$scope.newwl.range&&$scope.newwl.org&&$scope.newwl.proff&&$scope.newwl.remark) {
			$scope.newwl.teacherid = $scope.teacherId;
			$scope.newwl['time'] = new Date($('#time').val());
			workListService.save($scope.newwl,$scope.reqname);
			disableEdit();$scope.newwl={};
			$scope.curWlList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWlList);
		}else {
			alert('请完整填写信息');
		}
	};
	
	$scope.updateWorkLecture = function() {
		//设置时间
		for(var i=0;i<$scope.curWlList.length;i+=1) {
			$scope.curWlList[i] = updateDate($scope.curWlList[i]);
		}
		workListService.update($scope.curWlList,$scope.reqname);
		disableEdit();
		$scope.curWlList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWlList);
	};
	
	function updateDate(we) {
		we.time = new Date($('#time'+we.id).val());
		return we;
	}
	
}) ;

tecmgrApp.controller('workSurveyController',function($scope,$routeParams,workListService) {
	tab();
	function initDatePicker(id) {
		return $('#'+id).fdatepicker({
			format: 'yyyy-mm-dd'
		}).on('changeDate', function(ev){
			$('#'+id).val(ev.date.valueOf());
		});
	}
	
	$scope.reqname = 'workSurvey';
	$scope.dataPicker = initDatePicker('time');
	$scope.teacherId = $routeParams.teacherId;
	$scope.initDatePickerSingle = function(id) {initDatePicker(id);};
	
	$scope.curWsList = workListService.get($scope.teacherId,$scope.reqname);
	$scope.newws = {};
	$scope.saveWorkSurvey = function() {
		if($scope.newws.jobDetails&&$scope.newws.org&&$scope.newws.proff&&$scope.newws.remark) {
			$scope.newws.teacherid = $scope.teacherId;
			$scope.newws['time'] = new Date($('#time').val());
			workListService.save($scope.newws,$scope.reqname);
			disableEdit();$scope.newws={};
			$scope.curWsList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWsList);
		}else {
			alert('请完整填写信息');
		}
	};
	
	$scope.updateWorkSurvey = function() {
		//设置时间
		for(var i=0;i<$scope.curWsList.length;i+=1) {
			$scope.curWsList[i] = updateDate($scope.curWsList[i]);
		}
		workListService.update($scope.curWsList,$scope.reqname);
		disableEdit();
		$scope.curWsList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWsList);
	};
	
	function updateDate(we) {
		we.time = new Date($('#time'+we.id).val());
		return we;
	}
	
}) ;

tecmgrApp.controller('workAwardController',function($scope,$routeParams,workListService) {
	tab();
	function initDatePicker(id) {
		return $('#'+id).fdatepicker({
			format: 'yyyy-mm-dd'
		}).on('changeDate', function(ev){
			$('#'+id).val(ev.date.valueOf());
		});
	}
	
	$scope.reqname = 'workAward';
	$scope.dataPicker = initDatePicker('time');
	$scope.teacherId = $routeParams.teacherId;
	$scope.initDatePickerSingle = function(id) {initDatePicker(id);};
	
	$scope.curWaList = workListService.get($scope.teacherId,$scope.reqname);
	$scope.newwa = {};
	$scope.saveWorkAward = function() {
		if($scope.newwa.name&&$scope.newwa.award&&$scope.newwa.org&&$scope.newwa.proff&&$scope.newwa.remark) {
			$scope.newwa.teacherid = $scope.teacherId;
			$scope.newwa['time'] = new Date($('#time').val());
			workListService.save($scope.newwa,$scope.reqname);
			disableEdit();$scope.newwa={};
			$scope.curWaList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWaList);
		}else {
			alert('请完整填写信息');
		}
	};
	
	$scope.updateWorkAward = function() {
		//设置时间
		for(var i=0;i<$scope.curWaList.length;i+=1) {
			$scope.curWaList[i] = updateDate($scope.curWaList[i]);
		}
		workListService.update($scope.curWaList,$scope.reqname);
		disableEdit();
		$scope.curWaList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWaList);
	};
	
	function updateDate(we) {
		we.time = new Date($('#time'+we.id).val());
		return we;
	}
	
}) ;


tecmgrApp.controller('workTeachResearchController',function($scope,$routeParams,workListService) {
	tab();
	function initDatePicker(id) {
		return $('#'+id).fdatepicker({
			format: 'yyyy-mm-dd'
		}).on('changeDate', function(ev){
			$('#'+id).val(ev.date.valueOf());
		});
	}
	$scope.reqname = 'workTeachResearch';
	$scope.dataPicker = initDatePicker('time');
	$scope.teacherId = $routeParams.teacherId;
	$scope.initDatePickerSingle = function(id) {initDatePicker(id);};
	
	$scope.curWtrList = workListService.get($scope.teacherId,$scope.reqname);
	$scope.newwtr = {};
	$scope.saveWorkTeachResearch = function() {
		if($scope.newwtr.name&&$scope.newwtr.org&&$scope.newwtr.role&&$scope.newwtr.finishedDetails&&$scope.newwtr.proff&&$scope.newwtr.remark) {
			$scope.newwtr.teacherid = $scope.teacherId;
			$scope.newwtr['time'] = new Date($('#time').val());
			workListService.save($scope.newwtr,$scope.reqname);
			disableEdit();$scope.newwtr={};
			$scope.curWtrList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWtrList);
		}else {
			alert('请完整填写信息');
		}
	};
	
	$scope.updateWorkTeachResearch = function() {
		//设置时间
		for(var i=0;i<$scope.curWtrList.length;i+=1) {
			$scope.curWtrList[i] = updateDate($scope.curWtrList[i]);
		}
		workListService.update($scope.curWtrList,$scope.reqname);
		disableEdit();
		$scope.curWtrList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWtrList );
	};
	
	function updateDate(we) {
		we.time = new Date($('#time'+we.id).val());
		return we;
	}
	
}) ;

tecmgrApp.controller('workBookWriteController',function($scope,$routeParams,workListService) {
	tab();
	function initDatePicker(id) {
		return $('#'+id).fdatepicker({
			format: 'yyyy-mm-dd'
		}).on('changeDate', function(ev){
			$('#'+id).val(ev.date.valueOf());
		});
	}
	$scope.reqname = 'workBookWrite';
	$scope.dataPicker = initDatePicker('time');
	$scope.teacherId = $routeParams.teacherId;
	$scope.initDatePickerSingle = function(id) {initDatePicker(id);};
	
	$scope.curWbwList = workListService.get($scope.teacherId,$scope.reqname);
	$scope.newwbw = {};
	$scope.saveWorkBookWrite = function() {
		if($scope.newwbw.name&&$scope.newwbw.role&&$scope.newwbw.publicAndHonour&&$scope.newwbw.proff&&$scope.newwbw.remark) {
			$scope.newwbw.teacherid = $scope.teacherId;
			$scope.newwbw['time'] = new Date($('#time').val());
			workListService.save($scope.newwbw,$scope.reqname);
			disableEdit();$scope.newwbw={};
			$scope.curWbwList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWbwList);
		}else {
			alert('请完整填写信息');
		}
	};
	
	$scope.updateWorkBookWrite = function() {
		//设置时间
		for(var i=0;i<$scope.curWbwList.length;i+=1) {
			$scope.curWbwList[i] = updateDate($scope.curWbwList[i]);
		}
		workListService.update($scope.curWbwList,$scope.reqname);
		disableEdit();
		$scope.curWbwList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWbwList);
	};
	
	function updateDate(we) {
		we.time = new Date($('#time'+we.id).val());
		return we;
	}
	
}) ;

tecmgrApp.controller('workTeachingController',function($scope,$routeParams,workListService) {
	tab();
	function initDatePicker(id) {
		return $('#'+id).fdatepicker({
			format: 'yyyy-mm-dd'
		}).on('changeDate', function(ev){
			$('#'+id).val(ev.date.valueOf());
		});
	}
	$scope.reqname = 'workTeaching';
	$scope.dataPicker = initDatePicker('time');
	$scope.teacherId = $routeParams.teacherId;
	$scope.initDatePickerSingle = function(id) {initDatePicker(id);};
	
	$scope.curWtList = workListService.get($scope.teacherId,$scope.reqname);
	$scope.newwt = {};
	$scope.saveWorkTeaching = function() {
		if($scope.newwt.stunum&&$scope.newwt.learnGuide&&$scope.newwt.honour&&$scope.newwt.proff&&$scope.newwt.remark) {
			if(isNaN($scope.newwt.stunum)) {alert('学生人数必须是数字');return;}else {
				$scope.newwt.teacherid = $scope.teacherId;
				$scope.newwt['time'] = new Date($('#time').val());
				workListService.save($scope.newwt,$scope.reqname);
				disableEdit();$scope.newwt={};
				$scope.curWtList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWtList);
			}
		}else {
			alert('请完整填写信息');
		}
	};
	
	$scope.updateWorkTeaching = function() {
		//设置时间
		for(var i=0;i<$scope.curWtList.length;i+=1) {
			$scope.curWtList[i] = updateDate($scope.curWtList[i]);
		}
		workListService.update($scope.curWtList,$scope.reqname);
		disableEdit();
		$scope.curWtList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWtList );
	};
	
	function updateDate(we) {
		we.time = new Date($('#time'+we.id).val());
		return we;
	}
	
}) ;

tecmgrApp.controller('workLearningController',function($scope,$routeParams,workListService) {
	tab();
	function initDatePicker(id) {
		return $('#'+id).fdatepicker({
			format: 'yyyy-mm-dd'
		}).on('changeDate', function(ev){
			$('#'+id).val(ev.date.valueOf());
		});
	}
	$scope.reqname = 'workLearning';
	$scope.dataPicker = initDatePicker('time');
	$scope.teacherId = $routeParams.teacherId;
	$scope.initDatePickerSingle = function(id) {initDatePicker(id);};
	
	$scope.curWlList = workListService.get($scope.teacherId,$scope.reqname);
	$scope.newwl = {};
	$scope.saveWorkLearning = function() {
		if($scope.newwl.name&&$scope.newwl.guideInfo&&$scope.newwl.award&&$scope.newwl.proff&&$scope.newwl.remark) {
			$scope.newwl.teacherid = $scope.teacherId;
			$scope.newwl['time'] = new Date($('#time').val());
			workListService.save($scope.newwl,$scope.reqname);
			disableEdit();$scope.newwl={};
			$scope.curWlList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWlList);
		}else {
			alert('请完整填写信息');
		}
	};
	
	$scope.updateWorkLearning = function() {
		//设置时间
		for(var i=0;i<$scope.curWlList.length;i+=1) {
			$scope.curWlList[i] = updateDate($scope.curWlList[i]);
		}
		workListService.update($scope.curWlList,$scope.reqname);
		disableEdit();
		$scope.curWlList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWlList);
	};
	
	function updateDate(we) {
		we.time = new Date($('#time'+we.id).val());
		return we;
	}
	
}) ;

tecmgrApp.controller('workContinueLearnController',function($scope,$routeParams,workListService) {
	tab();
	function initDatePicker(id) {
		return $('#'+id).fdatepicker({
			format: 'yyyy-mm-dd'
		}).on('changeDate', function(ev){
			$('#'+id).val(ev.date.valueOf());
		});
	}
	$scope.reqname = 'workContinueLearn';
	$scope.dataPicker = initDatePicker('time');
	$scope.teacherId = $routeParams.teacherId;
	$scope.initDatePickerSingle = function(id) {initDatePicker(id);};
	$scope.curWclList = workListService.get($scope.teacherId,$scope.reqname);
	$scope.newwcl = {};
	$scope.saveWorkContinueLearn = function() {
		if($scope.newwcl.contentAndScore&&$scope.newwcl.org&&$scope.newwcl.proff&&$scope.newwcl.remark) {
			$scope.newwcl.teacherid = $scope.teacherId;
			$scope.newwcl['time'] = new Date($('#time').val());
			workListService.save($scope.newwcl,$scope.reqname);
			disableEdit();$scope.newwcl={};
			$scope.curWclList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWclList);
		}else {
			alert('请完整填写信息');
		}
	};
	
	$scope.updateWorkContinueLearn = function() {
		//设置时间
		for(var i=0;i<$scope.curWclList.length;i+=1) {
			$scope.curWclList[i] = updateDate($scope.curWclList[i]);
		}
		workListService.update($scope.curWclList,$scope.reqname);
		disableEdit();
		$scope.curWclList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWclList );
	};
	
	function updateDate(we) {
		we.time = new Date($('#time'+we.id).val());
		return we;
	}
	
}) ;

tecmgrApp.controller('workTeachSkillController',function($scope,$routeParams,workListService) {
	tab();
	function initDatePicker(id) {
		return $('#'+id).fdatepicker({
			format: 'yyyy-mm-dd'
		}).on('changeDate', function(ev){
			$('#'+id).val(ev.date.valueOf());
		});
	}
	$scope.reqname = 'workTeachSkill';
	$scope.dataPicker = initDatePicker('time');
	$scope.teacherId = $routeParams.teacherId;
	$scope.initDatePickerSingle = function(id) {initDatePicker(id);};
	$scope.curWtsList = workListService.get($scope.teacherId,$scope.reqname);
	$scope.newwts = {};
	$scope.saveWorkTeachSkill = function() {
		if($scope.newwts.class_&&$scope.newwts.form&&$scope.newwts.score&&$scope.newwts.proff&&$scope.newwts.remark) {
			$scope.newwts.teacherid = $scope.teacherId;
			$scope.newwts['time'] = new Date($('#time').val());
			workListService.save($scope.newwts,$scope.reqname);
			disableEdit();$scope.newwts={};
			$scope.curWtsList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWtsList );
		}else {
			alert('请完整填写信息');
		}
	};
	
	$scope.updateWorkTeachSkill = function() {
		//设置时间
		for(var i=0;i<$scope.curWtsList.length;i+=1) {
			$scope.curWtsList[i] = updateDate($scope.curWtsList[i]);
		}
		workListService.update($scope.curWtsList,$scope.reqname);
		disableEdit();
		$scope.curWtsList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWtsList);
	};
	
	function updateDate(we) {
		we.time = new Date($('#time'+we.id).val());
		return we;
	}
	
}) ;

tecmgrApp.controller('workCommSupportController',function($scope,$routeParams,workListService) {
	tab();
	function initDatePicker(id) {
		return $('#'+id).fdatepicker({
			format: 'yyyy-mm-dd'
		}).on('changeDate', function(ev){
			$('#'+id).val(ev.date.valueOf());
		});
	}
	$scope.reqname = 'workCommSupport';
	$scope.dataPicker = initDatePicker('time');
	$scope.teacherId = $routeParams.teacherId;
	$scope.initDatePickerSingle = function(id) {initDatePicker(id);};
	$scope.curWcsList = workListService.get($scope.teacherId,$scope.reqname);
	$scope.newwcs = {};
	$scope.saveWorkCommSupport = function() {
		if($scope.newwcs.originalSch&&$scope.newwcs.exchang&&$scope.newwcs.proff&&$scope.newwcs.remark) {
			$scope.newwcs.teacherid = $scope.teacherId;
			$scope.newwcs['time'] = new Date($('#time').val());
			workListService.save($scope.newwcs,$scope.reqname);
			disableEdit();$scope.newwcs={};
			$scope.curWcsList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWcsList);
		}else {
			alert('请完整填写信息');
		}
	};
	
	$scope.updateWorkCommSupport = function() {
		//设置时间
		for(var i=0;i<$scope.curWcsList.length;i+=1) {
			$scope.curWcsList[i] = updateDate($scope.curWcsList[i]);
		}
		workListService.update($scope.curWcsList,$scope.reqname);
		disableEdit();
		$scope.curWcsList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWcsList);
	};
	
	function updateDate(we) {
		we.time = new Date($('#time'+we.id).val());
		return we;
	}
	
}) ;

tecmgrApp.controller('workProMoralController',function($scope,$routeParams,workListService) {
	tab();
	function initDatePicker(id) {
		return $('#'+id).fdatepicker({
			format: 'yyyy-mm-dd'
		}).on('changeDate', function(ev){
			$('#'+id).val(ev.date.valueOf());
		});
	}
	$scope.handleSel = function(val) {
		if(val=='1') {
			return '是';
		}else if(val=='0'){
			return '否';
		}else {
			return '请选择';
		}
	};
	$scope.reqname = 'workProMoral';
	$scope.dataPicker = initDatePicker('time');
	$scope.teacherId = $routeParams.teacherId;
	$scope.initDatePickerSingle = function(id) {initDatePicker(id);};
	
	$scope.curWpmList = workListService.get($scope.teacherId,$scope.reqname);
	$scope.newwpm = {};
	$scope.saveWorkCommSupport = function() {
		if($scope.newwpm.famEdu&&$scope.newwpm.phyPunishiment&&$scope.newwpm.financialRelation&&$scope.newwpm.reference&&$scope.newwpm.remark) {
			$scope.newwpm.teacherid = $scope.teacherId;
			$scope.newwpm['time'] = new Date($('#time').val());
			workListService.save($scope.newwpm,$scope.reqname);
			disableEdit();$scope.newwpm={};
			$scope.curWpmList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWpmList);
		}else {
			alert('请完整填写信息');
		}
	};
	
	$scope.updateWorkCommSupport = function() {
		//设置时间
		for(var i=0;i<$scope.curWpmList.length;i+=1) {
			$scope.curWpmList[i] = updateDate($scope.curWpmList[i]);
		}
		workListService.update($scope.curWpmList,$scope.reqname);
		disableEdit();
		$scope.curWpmList = workListService.get($scope.teacherId,$scope.reqname,$scope.curWpmList);
	};
	
	function updateDate(we) {
		we.time = new Date($('#time'+we.id).val());
		return we;
	}
	
}) ;