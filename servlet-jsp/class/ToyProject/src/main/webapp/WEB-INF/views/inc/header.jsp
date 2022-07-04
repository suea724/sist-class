<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	.fa-solid.fa-splotch {
	
		<c:if test="${not empty auth and lv == 1}">
			color: gold;
		</c:if>
		<c:if test="${not empty auth and lv == 2}">
			color: plum;	
		</c:if>
	}
	
	header > h1 > span {
		font-size: 16px;
		color: #777;
	}
</style>

<header>
	<h1>
		<i class="fa-solid fa-splotch"></i> 
		Toy Project
		<c:if test="${not empty auth}">
			<span>${auth}님 환영합니다.</span>
		</c:if>
	</h1>
	<nav>
		<ul>
			<li><a href="/toy/index.do">Home</a></li>
			
			<c:if test="${empty auth}">
			<li><a href="/toy/member/register.do">Register</a></li>
			<li><a href="/toy/member/login.do">Login</a></li>
			</c:if>
			
			<c:if test="${not empty auth}">
			<li><a href="/toy/member/logout.do">Logout</a></li>
			<li><a href="/toy/member/info.do">Info</a></li>
			</c:if>
			
			<li><a href="/toy/board/list.do">Board</a></li>
			<li><a href="/toy/etc/chart.do">Chart</a></li>
			<li><a href="/toy/etc/food.do">Food</a></li>
		</ul>
	</nav>
</header>