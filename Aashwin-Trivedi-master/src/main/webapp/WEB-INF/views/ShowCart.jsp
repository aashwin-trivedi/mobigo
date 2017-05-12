<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Cart</title>
<style type="text/css">
  body{background-image:url("resources/29.jpg");}
  
  </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<h2><center><bold> Cart List </bold></center></h2>
<table class="table table-bordered">
  <thead>
   <tr>
    <th><center>Cart ID</center></th>
    <th><center>Cart User</center></th>
    <th><center>Product ID</center></th>
    <th><center>Product Name</center></th>
    <th><center>Product Price</center></th>
    <th><center>Quantity</center></th>
    <th><center>Total</center></th>
    
    </tr>
  </thead>
  <c:forEach items="${crt }" var="cl">
  <tr>
    <td><c:out value="${cl.cartid}"/></td>
    <td><c:out value="${cl.cartuser}"/></td>
     <td><c:out value="${cl.productid}"/></td>
    <td><c:out value="${cl.prodname}"/></td>
    <td><c:out value="${cl.prodprice}"/></td>
    <td><c:out value="${cl.quantity}"/></td>
    <td><c:out value="${cl.carttotal}"/></td>
    <td><a href="removecart?crd=${cl.cartid}">Remove Item</a></td>
</c:forEach>
</table>
<br/><br/><br/><br/><br/>

<p align="left"><a href="ViewProd"> Continue Shopping </a>
<p align="right">
<c:forEach items="${crt }" var="cl"><a href="OrderConfirm"></c:forEach> Check Out </a>


<br/><br/><br/>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>