'use strict';
angular.module('sale.system').controller('AuthController',['$scope','$location','$http','$window',function($scope,$location,$http,$window){
	$scope.logon = function(){
		$http.post('./logon',$scope.user).success(function(data){
			if(data.result === 0)
				$window.location.href = './home';
		});
	};
}]);
