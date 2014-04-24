/**
 * 处理全部与办公协作相关业务
 * @author D.W.
 * @date 2014-4-23 11:11:52
 * */
'use strict';

angular.module('sale.office')
	.config(['$stateProvider','$urlRouterProvider',function($stateProvider,$urlRouterProvider){
		$stateProvider
			/**office**/
			.state('office',{
				abstract: true,
				url: '/office',
				templateUrl: '/public/views/office/office.html',
				/**使用resolve属性通过异步方式向其controller中注入需要的属性*/
				resolve: {
					menus:['officeMenus',function(officeMenus){
						return officeMenus.all();
					}]
				},
				/**
				 * ADD FIELD IN THIS ABSTRACT PARENT'S SCOPE
				 * SO THAT ALL CHILD STATE VIEWS CAN ACCESS IT IN THEIR SCOPES
				 * */
				controller:	['$scope','$state','menus','utils',function($scope,$state,menus,utils){
					$scope.menus = menus;
				}]
			})
			.state('office.home',{
				url: '',
				templateUrl: '/public/views/office/office.home.html'
			})
			.state('office.notice',{
				url: '/notice',
				templateUrl: '/public/views/office/office.notice.html'
			});
	}]);
