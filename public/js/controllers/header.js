'use strict';
angular.module('sale.system').controller('HeaderController',['$scope',function($scope){
	
	$scope.menu = [{
		title:'首页',
		link: 'home',
		state: 'home'
	},{
		'title' : '办公协作',
		'link' : 'office',
		state: 'office.home'
	},{
		title: 'CRM',
		link: 'crm',
		state: 'crm'
	},{
		title: '用户管理',
		link: 'user-manager',
		state: 'user-list'
	}];

	$scope.isCollapsed = false;
}]);
