<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title ng-bind="'惠昊易 - '+$state.current.title">欢迎使用惠昊易平台</title>
    <%@include file="./head.jsp" %>
    <style>
    	/*
    	.navbar-inverse {
			background-image: -webkit-linear-gradient(top,#5092bd 0,#5092bd 100%);
			background-image: linear-gradient(to bottom,#5092bd 0,#5092bd 100%);
			background-repeat: repeat-x;
			filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#5092bd',endColorstr='#5092bd',GradientType=0);
			filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
		}
		.navbar-inverse {
			background-color: #5092bd;
			border-color: #3a6a8a;
		}
		
		.navbar-inverse .navbar-nav>.active>a {
			background-image: -webkit-linear-gradient(top,#3a6a8a 0,#3a6a8a 100%);
			background-image: linear-gradient(to bottom,#3a6a8a 0,#3a6a8a 100%);
			background-repeat: repeat-x;
			filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#3a6a8a',endColorstr='#3a6a8a',GradientType=0);
			-webkit-box-shadow: inset 0 3px 9px rgba(0,0,0,0.25);
			box-shadow: inset 0 3px 9px rgba(0,0,0,0.25);
		}
		.navbar-inverse .navbar-nav>li:hover>a,.navbar-inverse .navbar-nav>.active>a, .navbar-inverse .navbar-nav>.active>a:hover, .navbar-inverse .navbar-nav>.active>a:focus {
			background-color: #3a6a8a;
		}
		.navbar-inverse .navbar-nav>li:hover>a.navbar-brand{
			background-color: inherit;
		}
		.navbar-inverse .navbar-nav>.open>a, .navbar-inverse .navbar-nav>.open>a:hover, .navbar-inverse .navbar-nav>.open>a:focus {
			background-color: #3a6a8a;	
		}
		.navbar-inverse .navbar-nav>li>a{
			color: #fff;
		}
		*/
		ul.nav li.dropdown:hover ul.dropdown-menu{
    		display: block;    
		}
    </style>
  </head>
  
  <body ng-cloak>
  	<%@include file="./foot.jsp" %>
  	<div class="navbar navbar-inverse navbar-fixed-top" data-role="navigation"
  			data-ng-include="'/public/views/header.html'"></div>
   	<div ui-view class="container slide"></div>
   	<div toaster-container></div>
   	<div confirm-window-container></div>
  </body>
</html>
