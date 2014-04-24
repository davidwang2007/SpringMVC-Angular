/**
 * Created by david on 2014-4-1
 * */
'use strict';
angular.module('sale',['sale.office']);
angular.module('sale.office',['sale.system']);
angular.module('sale.system',['sale.base']);

angular.module('sale.base',['ngCookies','ngResource','ui.bootstrap','ui.router','ngAnimate']);


