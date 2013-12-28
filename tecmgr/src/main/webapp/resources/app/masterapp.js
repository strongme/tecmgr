var master = angular.module('master',[]);

master.service('masterService',function() {
	
	this.query = function(zzmm,subject,degree,title,department,name,teacherid) {
		var result = {};
		$.ajax({
			type: 'POST',
			url: basepath+'/master/query',
			data:'zzmm='+zzmm+'&subject='+subject+'&degree='+degree+'&title='+title+'&department='+department+'&name='+name+'&teacherid='+teacherid,
			dataType: 'json',
			async:false,
			success:function(data, textStatus, jqXHR) {
				result = data;
			}
		});
		return result;
	};
	
});

master.controller('masterController',function($scope,masterService) {
	$scope.result = [];
	$scope.q = {};
	$scope.query = function() {
		$scope.result = masterService.query($scope.q.zzmm||'',$scope.q.subject||'',$scope.q.degree||'',$scope.q.title||'',$scope.q.department||'',$scope.q.name||'',$scope.q.teacherid||'');
	};
	
	$scope.reset = function() {
		$scope.q.zzmm=$scope.q.subject=$scope.q.degree=$scope.q.title=$scope.q.department=$scope.q.name=$scope.q.teacherid='';
	};
	
});