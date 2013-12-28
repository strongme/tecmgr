/**
 * Created with JetBrains WebStorm.
 * User: walter
 * Date: 13-11-14
 * Time: 下午10:07
 * To change this template use File | Settings | File Templates.
 */

var tecmgrApp = angular.module('tecmgrApp',[]);

tecmgrApp.config(function($routeProvider) {
    $routeProvider
	    .when('/profileinfo/:teacherId',{
	        controller: 'profileInfoController',
	        templateUrl: basepath+'/resources/page/profileInfo.html'
	    })
        //基本信息
        .when('/basicInfo/:teacherId',{
            controller: 'basicInfoController',
            templateUrl: basepath+'/resources/page/basicInfo.html'
        })
        //个人简历
        .when('/workExp/:teacherId',{
        	controller: 'workExpController',
        	templateUrl: basepath+'/resources/page/workExp.html'
        })
       //总体成长规划
        .when('/wholeGrowPlan/:teacherId',{
            controller: 'wholeGrowPlanController',
            templateUrl: basepath+'/resources/page/wholeGrowPlan.html'
        })
        //阶段成长规划
          .when('/periodGrowPlan/:teacherId',{
            controller: 'periodGrowPlanController',
            templateUrl: basepath+'/resources/page/periodGrowPlan.html'
        })
        .when('/periodGrowPlanY1/:teacherId',{
        	controller: 'periodGrowPlanY1Controller',
        	templateUrl: basepath+'/resources/page/periodGrowPlanY1.html'
        })
        .when('/periodGrowPlanY2/:teacherId',{
        	controller: 'periodGrowPlanY2Controller',
        	templateUrl: basepath+'/resources/page/periodGrowPlanY2.html'
        })
        .when('/periodGrowPlanY3/:teacherId',{
        	controller: 'periodGrowPlanY3Controller',
        	templateUrl: basepath+'/resources/page/periodGrowPlanY3.html'
        })
        //个人成就展示
          //演讲公开课
        .when('/workLecture/:teacherId',{
            controller: 'workLectureController',
            templateUrl: basepath+'/resources/page/workLecture.html'
        })
        //测试命题等
        .when('/workSurvey/:teacherId',{
            controller: 'workSurveyController',
            templateUrl: basepath+'/resources/page/workSurvey.html'
        })
         //教学竞赛
        .when('/workAward/:teacherId',{
            controller: 'workAwardController',
            templateUrl: basepath+'/resources/page/workAward.html'
        })
        //教育教学科研和论文编写教材
        .when('/workTeachResearch/:teacherId',{
            controller: 'workTeachResearchController',
            templateUrl: basepath+'/resources/page/workTeachResearch.html'
        })
        //教育教学科研和论文编写教材
        .when('/workBookWrite/:teacherId',{
            controller: 'workBookWriteController',
            templateUrl: basepath+'/resources/page/workBookWrite.html'
        })
        //指导学生
        .when('/workTeaching/:teacherId',{
            controller: 'workTeachingController',
            templateUrl: basepath+'/resources/page/workTeaching.html'
        })
        //拜师
        .when('/workLearning/:teacherId',{
            controller: 'workLearningController',
            templateUrl: basepath+'/resources/page/workLearning.html'
        })
          //继续教育
        .when('/workContinueLearn/:teacherId',{
            controller: 'workContinueLearnController',
            templateUrl: basepath+'/resources/page/workContinueLearn.html'
        })
        //教育技能培训
        .when('/workTeachSkill/:teacherId',{
            controller: 'workTeachSkillController',
            templateUrl: basepath+'/resources/page/workTeachSkill.html'
        })
        //教师交流支教
        .when('/workCommSupport/:teacherId',{
            controller: 'workCommSupportController',
            templateUrl: basepath+'/resources/page/workCommSupport.html'
        })
       //职业道德
        .when('/workProMoral/:teacherId',{
            controller: 'workProMoralController',
            templateUrl: basepath+'/resources/page/workProMoral.html'
        });

});
