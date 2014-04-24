/**
 * 进行延迟加载的指示符
 * 当滚动到底部时ajax request server
 * 用法:
 *   将lazy-render="User" 加到ng-repeat="user in users"所在的ele中
 *   User为实体类查询的Service
 *   注意书写规范  User --> users
 * @author D.W.
 */
'use strict';
angular.module('sale.system')
	.directive('lazyRender',['$timeout','pageSize','$injector',function($timeout,pageSize,$injector){
		/***
		 * 此处的topScope是指ng-repeat处用的controller中的scope
		 */
		function judgeBottomOrLast(ele,scope,attrs){
			var topScope = scope.$parent.$parent;
			return function(){
				//如果当前还处于可见区域且不是最后一页则继续加载
				if(ele.offset().top + ele.height() < $(document).scrollTop() + $(window).height()
						&& !topScope.isLastPage){
					//找出查询的service
					var service = $injector.get(attrs.lazyRender);
					//这是ng-repeat的名称
					var arrayName = attrs.lazyRender.replace(/^\w/,function(str){return str.toLowerCase();})+'s';
					topScope.pageIndex = topScope.pageIndex + 1 || 2;
					//支持附加参数
					service.query(angular.extend({needPage:true,pageIndex:topScope.pageIndex},scope.queryParamGenerator()),function(rawArr){
						//如果返回的数组长度不等于pageSize,说明已经请求完了 不用再请求
						topScope.isLastPage = rawArr.length != pageSize;//angular.element(document).injector().get('pageSize');
						topScope[arrayName] = topScope[arrayName].concat(rawArr);
					});
				}
			};
		}
		
		return {
			restrict: 'A',
			scope:{
				queryParamGenerator:'&'
			},
			link: function(scope,ele,attrs){
				if(scope.$parent.$last){//表示是最后一个了
					//如果是最后一个，那么马上检测是否还要加载
					var listener = judgeBottomOrLast(ele,scope,attrs);
					$timeout(listener,0);
					
					//当又从后台加载了记录时会调用此方法true->false
					scope.$parent.$watch('$last',function(n,o){
						if(n == o) return;//不是真正的改变
						//console.log('$last属性改变了',arguments);
						//当此属性改变时变将listener从document上移除
						$(document).unbind('scroll',listener);
						$(window).unbind('resize',listener);
					});
					
					scope.$on('$destroy',function(){
						$(document).unbind('scroll',listener);
						$(window).unbind('resize',listener);
					});
					
					$(document).bind('scroll',listener);
					$(window).bind('resize',listener);
					
				}
			}
		};
	}]);