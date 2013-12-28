/**
 * Created with JetBrains WebStorm.
 * User: walter
 * Date: 13-11-14
 * Time: 下午10:07
 * To change this template use File | Settings | File Templates.
 */
tecmgrApp.service('recordService',function(){
	this.get = function(teacherId) {
		var result = {};
		$.ajax({
			type: 'POST',
			url: basepath+'/getRecord',
			data:'teacherId='+teacherId,
			dataType: 'json',
			async:false,
			success:function(data, textStatus, jqXHR) {
				result = data;
			}
		});
		return result;
	};
});

tecmgrApp.service('basicInfoService',function() {
	this.save = function(basicInfo) {
		$.post(
				basepath+'/basicInfo/save',
				basicInfo,
				function(data,status) {
					if(data) {
						alert('保存成功');
						
					}
					else alert('保存失败');
				},'json'
		);
	};
	
	this.get = function(teacherId) {
		var result = {};
		$.ajax({
			type: 'POST',
			url: basepath+'/basicInfo/get',
			data:'teacherId='+teacherId,
			dataType: 'json',
			async:false,
			success:function(data, textStatus, jqXHR) {
				result = data;
			}
		});
		return result;
	};
});

tecmgrApp.service('workExpService',function() {
	this.save = function(workExp) {
		$.post(
				basepath+'/workExp/save',
				workExp,
				function(data,status) {
					if(data) {
						alert('保存成功');
					}
					else alert('保存失败');
				},'json'
		);
	};
	
	this.update = function(list) {
		var flag= false;
		for(var i=0;i<list.length;i+=1) {
			var r = this.updateSingle(list[i]);
			if(!r) {
				alert('更新失败');
				flag=false;
				break;
			}else {
				flag = true;
			}
		}
		if(flag)alert('更新成功');
	};
	this.updateSingle = function(singlewe){
		var result = null;
		$.ajax({
			type: 'POST',
			url: basepath+'/workExp/update',
			data:singlewe,
			dataType: 'json',
			async:false,
			success:function(data, textStatus, jqXHR) {
				result = data;
			}
		});
		return result;
	};	
		
	this.get = function(teacherId,targetholder) {
		var result = {};
		$.ajax({
			type: 'POST',
			url: basepath+'/workExp/get',
			data:'teacherId='+teacherId,
			dataType: 'json',
			async:false,
			success:function(data, textStatus, jqXHR) {
				result = data;
				targetholder = data;
			}
		});
		return result||[];
	};
});


tecmgrApp.service('honourService',function() {
	this.save = function(basicInfo) {
		$.post(
				basepath+'/honour/save',
				basicInfo,
				function(data,status) {
					if(data) {
//						alert('保存成功');
					}
					else alert('保存失败');
				},'json'
		);
	};
	
	this.get = function(teacherId) {
		var result = {};
		$.ajax({
			type: 'POST',
			url: basepath+'/honour/get',
			data:'teacherId='+teacherId,
			dataType: 'json',
			async:false,
			success:function(data, textStatus, jqXHR) {
				result = data;
			}
		});
		return result||[];
	};
});


tecmgrApp.service('wholeGrowPlanService',function() {
	this.save = function(basicInfo) {
		$.post(
				basepath+'/overAllPlan/save',
				basicInfo,
				function(data,status) {
					if(data) {
						alert('保存成功');
					}
					else alert('保存失败');
				},'json'
		);
	};
	
	this.get = function(teacherId,targetholder) {
		var result = {};
		$.ajax({
			type: 'POST',
			url: basepath+'/overAllPlan/get',
			data:'teacherId='+teacherId,
			dataType: 'json',
			async:false,
			success:function(data, textStatus, jqXHR) {
				result = data;
				targetholder = data;
			}
		});
		return result;
	};
});

tecmgrApp.service('periodGrowPlanService',function() {
	this.save = function(basicInfo) {
		$.post(
				basepath+'/sectionSummary/save',
				basicInfo,
				function(data,status) {
					if(data) {
						alert('保存成功');
					}
					else alert('保存失败');
				},'json'
		);
	};
	
	this.savetiny = function(basicInfo) {
		$.post(
				basepath+'/sectionSummary/savetiny',
				basicInfo,
				function(data,status) {
					if(data) {
						alert('保存成功');
					}
					else alert('保存失败');
				},'json'
		);
	};
	this.get = function(teacherId,targetholder) {
		var result = {};
		$.ajax({
			type: 'POST',
			url: basepath+'/sectionSummary/get',
			data:'teacherId='+teacherId,
			dataType: 'json',
			async:false,
			success:function(data, textStatus, jqXHR) {
				result = data;
				targetholder = data;
			}
		});
		return result;
	};
	this.gettiny = function(teacherId,num,targetholder) {
		var result = {};
		$.ajax({
			type: 'POST',
			url: basepath+'/sectionSummary/gettiny',
			data:'teacherId='+teacherId+'&num='+num,
			dataType: 'json',
			async:false,
			success:function(data, textStatus, jqXHR) {
				result = data;
				targetholder = data;
			}
		});
		return result;
	};
});

tecmgrApp.service('workListService',function() {
	this.save = function(workExp,reqname) {
		$.post(
				basepath+'/'+reqname+'/save',
				workExp,
				function(data,status) {
					if(data) {
						alert('保存成功');
					}
					else alert('保存失败');
				},'json'
		);
	};
	
	this.update = function(list,reqname) {
		var flag= false;
		for(var i=0;i<list.length;i+=1) {
			var r = this.updateSingle(list[i],reqname);
			if(!r) {
				alert('更新失败');
				flag=false;
				break;
			}else {
				flag = true;
			}
		}
		if(flag)alert('更新成功');
	};
	this.updateSingle = function(singlewe,reqname){
		var result = null;
		$.ajax({
			type: 'POST',
			url: basepath+'/'+reqname+'/update',
			data:singlewe,
			dataType: 'json',
			async:false,
			success:function(data, textStatus, jqXHR) {
				result = data;
			}
		});
		return result;
	};	
		
	this.get = function(teacherId,reqname,targetholder) {
		var result = {};
		$.ajax({
			type: 'POST',
			url: basepath+'/'+reqname+'/get',
			data:'teacherId='+teacherId,
			dataType: 'json',
			async:false,
			success:function(data, textStatus, jqXHR) {
				result = data;
				targetholder = data;
			}
		});
		return result||[];
	};
});



