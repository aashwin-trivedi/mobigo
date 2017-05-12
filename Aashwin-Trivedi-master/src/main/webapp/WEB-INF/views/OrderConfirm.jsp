<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>order confirm</title>
<style type="text/css">
  body{background-image:url("resources/29.jpg");}
  
  </style>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
	</head>
	
<body>
<%@include file="header.jsp"%>
<div>
<table class="table table-bordered table-hover table-striped">	

<tr>
<th>Amount Payable</th>
<th>User name</th>
<th>Mobile</th>
<th>Email</th>
<th>Shipping Address</th>
<th>Billing Address</th>
				
			</tr>
<c:forEach var="ad" items="${UserInfo}">
<tr>
<td>${crtTot}</td>
<td>${ad.userName}</td>
<td>${ad.mobile}</td>
<td>${ad.email}</td>
<td>${ad.shipadd}</td>
<td>${ad.billadd}, ${ad.zipcode}, ${ad.country}</td>
</tr>
</c:forEach>			
</table>
</div>

<div>
<table class="table table-bordered table-hover table-striped">	

<tr>
		
		<h4><th><a href="Product">Cancel Order</a></th></h4>
		<h4><th><a href="Payment">Payment</a></th></h4>
		</tr>	
			
		</table>
</div>



<%@include file="footer.jsp"%>
</body>
</html>

