<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<style>
	ul#main-menu {
		list-style: none;
	}
	
	ul#main-menu a {
		text-decoration: none;
		color: black;
	}
	
	ul#main-menu .sub-menu {
		display: none;
	}
	
	ul#main-menu li:hover .sub-menu {
		display: block;
	}
</style>
</head>
<body style="margin-left: 100px; margin-right: 100px;">
	<div class="header" style="display: flex; margin-bottom: 30px;">
		<img alt="" src="https://mega.com.vn/media/banner/logo_logo%20web.png"
			style="width: 180px; height: 80px;">
		<div class="timkiem"
			style="width: 800px; height: 40px; margin-top: 30px;">
			<input placeholder="Nhập từ khóa tìm kiếm"
				style="width: 80%; height: 40px;">
			<button>
				<a href="">Tìm kiếm</a>
			</button>
		</div>
	</div>
	<div class="dropdown">
		<button class="btn btn-secondary dropdown-toggle" type="button"
			data-bs-toggle="dropdown" aria-expanded="false">DANH MỤC SẢN
			PHẨM</button>
		<ul class="dropdown-menu">
			<ul id="main-menu">
				<c:forEach items="${type}" var="type">
					
					<li><a href="categoryMega?id=${type.getId()}">${type.getType()}</a>
					
				</c:forEach>
					
			</ul>
		</ul>
	</div>
	<div class="products"
		style="display: flex; flex-wrap: wrap; align-content: flex-start;">
		<c:forEach items="${all}" var="megas">
			<div class="card" style="width: 220px; margin: 10px;">
				<img
					src="https://mega.com.vn/media/product/250_24693_lcd_asus_va24ehf.jpg"
					class="card-img-top" alt="..." style="width: 200px; height: 175px">
				<div class="card-body">
					<h5 class="card-title">${megas.getProduct_name()}</h5>
				</div>
			</div>
		</c:forEach>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>
