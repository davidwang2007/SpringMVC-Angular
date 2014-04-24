/**
 * 定义用户管理的相关Controller
 * */
angular.module('sale.system')
	.controller('UserList',['$scope','$window','User','$timeout','toaster','confirm',function($scope,$window,User,$timeout,toaster,confirm){
		$scope.users = User.query({needPage:true});
		$scope.removeConfirm = function($index){
			confirm('确定删除此用户吗?').then(function(){
				$scope.users[$index].$remove(function(data){
					toaster.handle(data,'删除成功');
					if(data.result == 0)
						$scope.users.splice($index,1);
				});
			});
		};
		
		$scope.queryParamGenerator = function(){
			return {
				yes: 0,
				no: 1
			};
		};
		
	}])
	.controller('UserCreate',['$scope','User','$state','toaster',function($scope,User,$state,toaster){
		$scope.doCreate = function(){
			console.log($scope.user);
			new User($scope.user).$save(function(data){
				toaster.handle(data,'成功添加用户信息');
				if(data.result == 0)
					$state.go('user-list');
			});
		};
	}])
	.controller('UserUpdate',['$scope','User','$state','$stateParams','toaster',function($scope,User,$state,$stateParams,toaster){
		$scope.user = User.get({id:$stateParams.id},function(user){
			//console.log(user);
			$scope.oldUser = angular.copy(user);
		});
		$scope.doUpdate = function(){
			$scope.user.$update(function(data){
				$scope.message = data.reason;
				toaster.handle(data);
				if(data.result == 0)
					$state.go('user-list');
			});
		};
		$scope.isUnchanged = function(){
			return angular.equals($scope.user,$scope.oldUser);
		};
	}]);