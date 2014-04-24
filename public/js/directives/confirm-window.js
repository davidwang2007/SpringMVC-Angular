/**
 * confirm window solve the default window.confirm ugly theme
 * Version 0.1
 * @author D.W.
 * @email davidwang2006@outlook.com
 * @date 2014-4-24
 * Copy Right 2014 D.W.
 * Use, reproduction, distribution, and modification of this code is subject to the terms and 
 * conditions of the MIT license, available at http://www.opensource.org/licenses/mit-license.php
 * */
'use strict';
angular.module('sale.base')
	.factory('confirm',['$rootScope','$timeout','$q',function($rootScope,$timeout,$q){
		return function(type,msg){
			msg || (msg = type,type = 'warn');
			var deferred = $q.defer();
			$rootScope.$broadcast('confirm-window-open',{
				type: type,
				msg: msg,
				defer: deferred
			});
			return deferred.promise;
		};
	}])
	//confirm-window directive to show the confirm window
	.directive('confirmWindowContainer',['$compile','$timeout','$rootScope','utils',function($compile,$timeout,$rootScope,utils){
		
		return {
			restrict: 'EA',
			replace: true,
			scope: {},//create isolate scope
			link: function(scope,ele,attrs){
				
				scope.$on('confirm-window-open',function($evt,params){
					scope.type = params.type;
					scope.message = params.msg;
					scope.defer = params.defer;
					scope.show = true;
					utils.disableJump();
					utils.disableScroll();
					//禁止滚动条
					//此步是一定执行的，保证不论是单击确定或者取消都会关闭对话框
					scope.defer.promise.finally(function(){
						scope.show = false;
						utils.enableJump();
						utils.enableScroll();
					});
				});
				
			},
			controller:['$scope','$element','$attrs',function($scope,$element,$attrs){
				$scope.ok = function(){
					$scope.defer.resolve('OK');
					console.log($scope.defer);
				};
				$scope.cancel = function(){
					$scope.defer.reject('CANCEL');
				};
			}],
			template: '<div class="confirm-window-overlay" ng-show="show">' + 
							'<div class="confirm-window">' +
								'<div class="confirm-window-content">' +
									'<!-- div class="confirm-window-header">' +
										'<button type="button" class="close" >&times;</button>' +
										'<h4 class="modal-title">Modal title</h4>' +
									'</div -->' +
									'<div class="confirm-window-body text-center">'+
										'{{message}}' +
									'</div>' +
									'<div class="confirm-window-footer text-center">' +
										'<button type="button" class="btn btn-warning" ng-click="ok()">确认</button>' +
										'&nbsp;&nbsp;' +
										'<button type="button" class="btn btn-default" ng-click="cancel()">取消</button>' +
									'</div>' +
								'</div>' +
							'</div>' +
						'</div>'
					
		};
	}]);