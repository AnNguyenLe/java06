<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<h1>QUẢN LÝ SẢN PHẨM</h1>
	<form action="products" method="post">
		<div class="mb-3">
			<label for="product-name">Tên sản phẩm</label>
			<input id="product-name" class="form-control" name="name" value=""/>
		</div>
		
		<div class="mb-3">
			<label for="product-quantity">Số lượng</label>
			<input id="product-quantity" class="form-control" placeholder="1" name="quantity"  type="number" value="1"/>
		</div>
		
		<div class="mb-3">
			<label for="product-price">Giá bán</label>
			<input id="product-price" class="form-control" name="price" placeholder="1" type="number" value="1"/>
		</div>

		<c:if test="${errorMessage != null}">
		    <div class="alert alert-warning" role="alert">
			    ${errorMessage}
			</div>
		</c:if>
		
		<button class="btn btn-primary">Lưu lại</button>
	</form>
	
	<table class="table">
	  <tr>
	    <th>STT</th>
	    <th>Tên sản phẩm</th>
	    <th>Số lượng</th>
	    <th>Giá bán</th>
	  </tr>
	  <tr>
	  	<c:forEach var="item" items="${products}" varStatus="loop">
			<td>${loop.index + 1}</td>
			<td>${item.name}</td>
			<td>${item.quantity}</td>
			<td>${item.price}</td>
		</c:forEach>
	  </tr>
	</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>