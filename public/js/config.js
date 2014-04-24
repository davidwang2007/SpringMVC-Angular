'use strict';
//设置日期的默认toJSON

Date.prototype.toJSON = function(){
	return this.getTime();
};

// Setting up route
angular.module('david').config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider){
	// For unmatched routes:
	$urlRouterProvider.otherwise('/');

	$stateProvider.state('home',{
		url: '/',
		templateUrl: '/public/views/index.html',
		controller: 'IndexController',
		title: '首页'
	}).state('crm',{
		url: '/crm',
		templateUrl: '/public/views/crm.html',
		title: 'CRM'
	}).state('user-list',{
		url: '/user-list',
		templateUrl: '/public/views/user/list.html',
		controller: 'UserList',
		title: '用户列表'
	}).state('user-create',{
		url: '/user-create',
		templateUrl: '/public/views/user/create.html',
		controller: 'UserCreate',
		title: '新增用户'
	}).state('user-update',{
		url: '/user-update/:id',
		templateUrl: '/public/views/user/update.html',
		controller: 'UserUpdate',
		title: '更新用户'
	});
}]).config(['$locationProvider',function($locationProvider){
	$locationProvider.hashPrefix('!');		
}]).config(['$httpProvider',function($httpProvider){
	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';		
	$httpProvider.interceptors.push('interceptor401');

}]).constant('pageSize',10)
.run(['$rootScope','$state','$stateParams',function($rootScope,$state,$stateParams){
	$rootScope.$state = $state;
	$rootScope.$stateParams = $stateParams;
}]);
