angular.module('david.system').factory('User',['$resource',function($resource){
	return $resource('./user/:id',{id:'@id'},{
		update:{method:'PUT'}
	});
}]);