<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>XXXX平台  | 登录</title>
    <%@include file="./head.jsp" %>
    <style type="text/css">
    	/**
    	登录页面风格
    	edit by www 2014-4-15 11:07:18
    	*/
    	html,body{
    		padding-top:0 !important;
    		height:100%;
    		width:100%;
    	}
    	.wrapper{
    		height:100%;
    		width:100%;
    		min-width:960px;
    	}
    	.left-img {
			width: 40%;
			height: 100%;
			float: left;
			display: block;
			background-image: url(/public/img/left_cover.jpg);
			background-position: center;
			background-size: cover;
			background-repeat: no-repeat;
		}
		.right-content {
			width: 60%;
			height: 100%;
			float: right;
			position: relative;
		}
		.form-container{
			margin-top:150px;
			position:relative;
			padding:15px;
		}
		.logo{
			height: 42px;
			width: 204px;
			background: url(/public/img/hhyi.png) left center no-repeat;
		}
		h2,h4{
			font-family:"微软雅黑",sans-serif;
		}
    </style>
  </head>
  <body ng-cloak>
  	<%@include file="./foot.jsp" %>
    <div class="wrapper">
    	<div class="left-img"></div>
    	<div class="right-content">
    		<div class="form-container">
    			<div class="row">
	    			<div class="col-sm-4 col-sm-offset-2">
	    				<h2>惠昊XXXX</h2>
	    				<h4>登录</h4>
	    			</div>
    			</div>
	    		<form class="form-horizontal" name="form" role="form" novalidate 
	    			ng-submit="logon()" ng-controller="AuthController">
	    			<div class="form-group">
	    				<label class="col-sm-2 control-label">用户名:</label>
	    				<div class="col-sm-4">
	    					<input class="form-control" type="text" name="username" ng-model="user.username"
	    						autocomplete="off"
	    						ng-required="true" placeholder="请输入用户名"/>
	    				</div>
	    			</div>
	    			<div class="form-group">
	    				<label class="col-sm-2 control-label">密码:</label>
	    				<div class="col-sm-4">
	    					<input class="form-control" type="password" name="password" ng-model="user.password"
	    						autocomplete="off"
	    						ng-required="true" placeholder="请输入密码"/>
	    				</div>
	    			</div>
	    			<div class="form-group">
	    				<div class="col-sm-4 col-sm-offset-2">
	    					<input type="submit" value="登录" class="btn btn-success" ng-disabled="form.$invalid"/>
	    				</div>
	    			</div>
	    		</form>
    		</div>
    	</div>
    </div>
  </body>
</html>
