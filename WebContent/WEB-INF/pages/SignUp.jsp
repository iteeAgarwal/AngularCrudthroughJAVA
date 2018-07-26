<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<script src="js/angular.js"></script>
<body ng-controller="validateCtrl">
<div style="float:left">
<h2>Registration Form</h2>

<form name="myForm" method="get" novalidate>
<p>Username:<br>
<input type="text" name="user1" ng-model="user1" required>
<span style="color:red" ng-show="myForm.user1.$dirty && myForm.user1.$invalid">
<span ng-show="myForm.user1.$error.required">Username is required.</span>
</span>
</p>

<p>Email:<br>
<input type="email" name="email1" ng-model="email1" required>
<span style="color:red" ng-show="myForm.email1.$dirty && myForm.email1.$invalid">
<span ng-show="myForm.email1.$error.required">Email is required.</span>
<span ng-show="myForm.email1.$error.email">Invalid email address.</span>
</span>
</p>

<p>Phone number:<br>
<input type="text" name="pnumber1" ng-model="pnumber1" ng-pattern="/^[6-9][0-9]{9}$/" required>
<span style="color:red" ng-show="myForm.pnumber1.$dirty && myForm.pnumber1.$invalid">
<span ng-show="myForm.pnumber1.$error.required">Phonenumber is required.</span>
<span ng-show="myForm.pnumber1.$error.pattern">Please Enter Correct Phone number</span>
</span>
</p>

 <p>Password:-<br>
<input type="password" name="pass1" ng-model="pass1" required>
<span style="color:red" ng-show="myForm.pass1.$dirty && myForm.pass1.$invalid">
<span ng-show="myForm.pass1.$error.required">Password is required</span>
</span>
<p>

<p>ConfirmPassword:-<br>
<input type="password" name="cpass" ng-model="cpass" compare-to="pass1" required>
<span style="color:red" ng-show="myForm.cpass.$dirty && myForm.cpass.$invalid">
<span ng-show="myForm.cpass.$error.required">ConfirmPassword is required</span>
<span ng-show="myForm.cpass.$error.compareTo">Confirm Password Must match Password</span>
</span>
<br/><br/>
<button
ng-disabled="myForm.user1.$dirty && myForm.user1.$invalid ||  
myForm.email1.$dirty && myForm.email1.$invalid || 
myForm.pnumber1.$dirty && myForm.pnumber1.$invalid || myForm.pass1.$dirty && myForm.pass1.$invalid "
ng-click="signup()" >Submit </button>
</p>
</form>
</div><br/><br/>
<div style="float:left; margin-left:5%; border:solid; border-collapse: collapse;">
<table>
<tr>
<th>User Name</th>&nbsp;&nbsp;<th>Phone-Number</th>&nbsp;&nbsp;<th>Email</th>&nbsp;&nbsp;&nbsp;&nbsp;<th>Operation</th>
</tr>
<tr ng-repeat="data in jsonData1" >
<td>{{ data.user }}</td>&nbsp;&nbsp;&nbsp;&nbsp;
<td>{{ data.pnumber }} </td>&nbsp;&nbsp;
<td> {{ data.email }}</td>&nbsp;&nbsp;
<td><button ng-click="fetch(data.pnumber)" method="get">Update</td>
<td><button ng-click="de(data.pnumber)" method="get">Delete</button></td>
</tr>
</table>
</div>
<div style="margin-left:5%;float:left; border:solid;" ng-hide="myVar">
<form>
<table>
<tr>
<td><th colspan="4">UserName</th></td>
<td><input type="text" name="unname" ng-model="username"/></td>
</tr>
<tr><td><th colspan="4">PhoneNumber</th></td>

<td><input type="text" name="pnumber" ng-model="ppnumber" readonly> </td>
</tr>
<tr><td><th colspan="4">Email</th></td>
<td><input type="email" name="eemail" ng-model="eemail"> </td>
</tr>
<tr>
<td colspan="6" style="padding-left:40%;"><input type="button" value="submit" ng-click="update(username,ppnumber,eemail)"></td>
<!-- <td colspan="6" style="padding-left:40%;"><input type="button" value="clear" ng-click="clear()"></td> -->
</tr>
</table>
</form>
</div>
<script>
 var app = angular.module('myApp', []);
app.controller('validateCtrl', 
 function($scope,$http,$window)
{ 
    $scope.user1 = 'IteeAgarwal';
    $scope.email1 = 'tggrwl94@gmail.com';
    $scope.pnumber1='9897062032';
    $scope.pass1='';
    $scope.cpass1='';
    $scope.myVar=true;
    /* Clear The Data */
    $scope.clear=function()
    {
    	$scope.myVar=!$scope.myVar;
    }
    /* Finally Update The Data */
  $scope.update = function(username1,ppnumber1,email1)
    {  
    	$window.alert("Updation Process Start"+email1);
    	$http({
    		url:'Update',
    		method:'get',
    		params :{"name":username1,"pnumber":ppnumber1,"email":email1}
    	})
    	.then(function(result){
   		 /* $scope.jsonData1=result.data;  */
   		console.log(result.status+""+result);
   	$window.alert("Result"+result.data);
   	 },
   	function(result){
   	$window.alert("No Data Found For Updation");
   	console.log(result.status); 
   	});		
    }  
    /* Fetch The data for Updating */
     $scope.fetch = function(phonenum)
    {  
       $scope.phone=phonenum;
       $scope.myVar=!$scope.myVar;
    	$window.alert("Phone number"+$scope.phone);
    	$http({
    		url:'/ANgularjswithJspServlet/Fetch',
    	    method:'get',
    		params:{"pnumber":$scope.phone }
    	}).
    	 then(function(result)
    			 { 		
    		 $scope.ppnumber=result.data[0].pnumber;  
    		 $scope.eemail=result.data[0].email;	 
    		$scope.username=result.data[0].user; 
    		/* $scope.eemail=result.data[2].email;  */
    
    		 console.log("FetchData"+$scope.username+"Phonenumber"+$scope.ppnumber);
    		   $window.alert("Fetching the data Sucessfully"+result.data+"Status"+result.status+"FetchData"+$scope.username);
    			 },
    	     function(result)
    	     {
    				 $window.alert("Error in Updation");
    	     }
    	 );
    }
    /* Send data to SignUpServlet */
    $scope.signup = function()
    { 
    	$window.alert($scope.user1+" "+$scope.email1);
   	 $http({
   	 url:'Signup',
   	 method:'get',
   	 params:{
   		 "name":$scope.user1,
   		 "email":$scope.email1,
   		 "pnumber":$scope.pnumber1,
   		 "pass":$scope.pass1
   		 }
	} )
	.then(function(result){
		 $scope.jsonData1=result.data; 
		/*  for(var i in jsonData ){$window.alert(i);} */
		console.log(result.status+""+result);
	$window.alert("Sucess"+$scope.jsonData1+"Result"+result.data);
	 },
	function(result){
	$window.alert("No Data Found ");
	console.log(result.status); 
	});			
	}
   
$scope.de = function(phonenum)
{  
   $scope.phone=phonenum;
 
	$window.alert("Phone number"+$scope.phone);
	$http({
		url:'/ANgularjswithJspServlet/Delete',
	    method:'get',
		params:{
			"pnumber":$scope.phone
		}
	}).
	 then(function(result)
			 {
		   $window.alert("Data Is deleted SucessFully");
			 },
	     function(result)
	     {
				 $window.alert("Error in deletion");
	     }
	 );
}
}
);
/* Delete the Data */
/* Creating Compare to Directive */
  app.directive("compareTo", function() {
      return {
        require: "ngModel",
        scope: {
          cpass: "=compareTo"
        },
        link: function(scope, element, attributes, modelVal) 
        {
          modelVal.$validators.compareTo = function(val) {
            return val == scope.cpass;
          };
          scope.$watch("cpass", function() {
            modelVal.$validate();
          });
        }
      };
    });
</script>
</body>
</html>