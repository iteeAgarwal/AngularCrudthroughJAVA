<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="products.controller">
<head>
<script src="js/angular.js"></script>
<script>
var app=angular.module("products.controller",[]);
app.controller("products_controller",
		['$scope','$window','$http',
		  function($scope,$window,$http)
		  {
			$scope.productsList=function()
			{
				$window.alert("calling minPrice="+$scope.minPrice+"Calling Max Price"+$scope.maxPrice);
				$http(
				{
					url:"/ANgularjswithJspServlet/searchProducts",
					methods:"get",
					params:
						{
						"minPrice": $scope.minPrice,
						"maxPrice":$scope.maxPrice
						}
				}).then(function(result){
			 $scope.jsonProductList=result.data; 
				/* console.log(result.data+""+$scope.jsonProductList); */
				$window.alert("Sucess"+result.status+""+result.data);
				},
						function(result){
				$window.alert("No Data Found Click Here To create Product Data ");
						});			
				
			}}
		 ]
		);
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-controller="products_controller">
<div>
MinPrice:-<input type="text" ng-model="minPrice">
MaxPrice:-<input type="text" ng-model="maxPrice">
<button ng-click="productsList()">Search</button>
</div>
<div> 
<table>
<tr><th>Product Id</th>
<th>Product Name</th>
<th>Price</th>
<th>Operation</th>
</tr>
<tr ng-repeat="product in jsonProductList">
<td >{{product.pid}}</td>
<td>{{product.pname}}</td>
<td>{{product.price}}</td>
<td>Edit</td>
<td>Delete</td>
</tr>
</table>
<!-- </div> -->
</body>
</html>