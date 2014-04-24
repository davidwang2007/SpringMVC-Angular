/***
 * Index Controller
 */
'use strict';
angular.module('david.system').controller('IndexController',['$scope','$http','toaster','confirm',
    function($scope,$http,toaster,confirm){
		$http.get('./test').success(function(data){
			$scope.info = data;
		});
		$scope.makeToast = function(){
			toaster.info('info message');
			toaster.warn('warning message');
			toaster.success('success message');
			toaster.error('error message');
		};
		$scope.makeConfirm = function(){
			confirm('So GA').then(function(){
				console.log('you click yes',arguments);
			},function(){
				console.log('you click no',arguments);
			});
		};
}]);