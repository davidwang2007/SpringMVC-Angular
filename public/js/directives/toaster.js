/**
 * AngularJS Toaster for sale platform
 * Version: 0.1
 *
 * Copyright 2014 D.W.  
 * All Rights Reserved.  
 * Use, reproduction, distribution, and modification of this code is subject to the terms and 
 * conditions of the MIT license, available at http://www.opensource.org/licenses/mit-license.php
 * @date 2014-4-24
 * @thanks to Jiri Kavulak
 */
'use strict';
angular.module('sale.base')
	.factory('toaster',['$rootScope',function($rootScope){
		return {
			/**
			 * call this function to pop out toaster
			 * @param type [info,success,error,warning]
			 * @param title  The title of the toaster
			 * @param body The content of the toaster
			 * @param timeout time to fade out
			 * */
			pop: function(type,title,body,timeout){
				$rootScope.$broadcast('toaster-newToast',{
					type: type,
					title: title,
					body: body,
					timeout: timeout
				});
			},
			info: function(title,body,timeout){
				timeout = timeout || (typeof body == 'number' && body);
				typeof body != 'string' && (body = title,title = '');
				this.pop('info',title,body,timeout);
			},
			error: function(title,body,timeout){
				timeout = timeout || (typeof body == 'number' && body);
				typeof body != 'string' && (body = title,title = '');
				this.pop('error',title,body,timeout);
			},
			success: function(title,body,timeout){
				timeout = timeout || (typeof body == 'number' && body);
				typeof body != 'string' && (body = title,title = '');
				this.pop('success',title,body,timeout);
			},
			warn: function(title,body,timeout){
				timeout = timeout || (typeof body == 'number' && body);
				typeof body != 'string' && (body = title,title = '');
				this.pop('warning',title,body,timeout);
			},
			handle: function(data,successMsg,errorMsg){
				if(data.result == 0)
					this.success(successMsg || data.reason || '操作成功');
				else
					this.error(errorMsg || data.reason || '操作失败');
			},
			clear : function(){
				$rootScope.$broadcast('toaster-clearToasts');
			}
		};
	}])
	//default config for the toaster
	.constant('toasterConfig',{
		limit: 5, // limits max number of toasts,0 -> none limit
		tapToDismiss: true,//click to dismiss
		newestOnTop: true,// append new toast to top
		timeout: 2000,
		iconClasses: {
			error: 'toast-error',
			info: 'toast-info',
			success: 'toast-success',
			warning: 'toast-warning'
		},
		iconClass: 'toast-info',
	})
	// define the toaster directive
	.directive('toasterContainer',['$compile','$timeout','toasterConfig','toaster',
	    function($compile,$timeout,toasterConfig,toaster){
		return {
			replace: true,
			restrict: 'EA',
			scope: true,//create an internal scope for this directve
			link: function(scope,ele,attrs){
				var id = 0;
				scope.configureTimer = function(toast){
					toast.timeout = $timeout(function(){
						scope.removeToast(toast.id);
					},toast.timeout || toasterConfig.timeout);
					//console.log('after configureTimer',toast);
				};
				function addToast(toast){
					toast.type = toasterConfig.iconClasses[toast.type] || toasterConfig.iconClass;
					id++;
					angular.extend(toast,{id: id});
					scope.configureTimer(toast);
					scope.toasters.unshift(toast);
					if(scope.toasters.length > toasterConfig.limit)
						scope.toasters.pop();
				};
				
				function $setTimeout(toast,time){
					toast.timeout = $timeout(function(){
						scope.removeToast(toast.id);
					},time);
				}
				
				scope.toasters = [];
	            scope.$on('toaster-newToast', function ($evt,$toast) {
	            	//console.log('new toast',arguments);
	                addToast($toast);
	            });

	            scope.$on('toaster-clearToasts', function () {
	                scope.toasters.splice(0, scope.toasters.length);
	            });
			},
			controller: ['$scope','$element','$attrs',function($scope,$element,$attrs){
				$scope.stopTimer = function(toast){
					if(toast.timeout){
						$timeout.cancel(toast.timeout);
						toast.timeout = null;
					}
				};
				$scope.restartTimer = function(toast){
					$scope.configureTimer(toast);
				};
				$scope.removeToast = function(id){
					$scope.toasters.some(function(toast,index){
						if(toast.id == id){
							$scope.toasters.splice(index,1);
							return true;
						}
						return false;
					});
				};
			}],
			template: '<div  id="toast-container" class="toast-top-middle-width">' +
				            '<div ng-repeat="toaster in toasters" class="toast" ng-class="toaster.type" ng-click="removeToast(toaster.id)" ng-mouseover="stopTimer(toaster)"  ng-mouseout="restartTimer(toaster)">' +
				            '<div class="toast-title">{{toaster.title}}</div>' +
				            '<div class="toast-message">' +
				              '<div>{{toaster.body}}</div>' +
				            '</div>' +
				          '</div>' +
				      '</div>'
		};
	}]);