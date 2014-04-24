/**
 * office service definition
 * @author D.W.
 * @date 2014-4-23 11:20:39
 */
'use strict';
angular.module('david.office')
	.factory('officeMenus',['$http','utils',function($http,utils){
		var path = './office/menus';
		var menus = $http.get(path).then(function(resp){
			return resp.data;
		});
		return {
			/**得到所有办公协作下的菜单用于在左侧显示**/
			all: function(){return menus;},
			get: function(id){
				return menus.then(function(){
					return utils.findById(menus,id);
				});
			}
		};
	}]);