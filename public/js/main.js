/**
 * Created by david on 2014-4-1
 * */
'use strict';
angular.module('david',['sale.office']);
angular.module('david.office',['sale.system']);
angular.module('david.system',['sale.base']);

angular.module('david.base',['ngCookies','ngResource','ui.bootstrap','ui.router','ngAnimate']);


