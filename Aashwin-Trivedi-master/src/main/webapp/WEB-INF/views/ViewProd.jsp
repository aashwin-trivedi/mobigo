<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Product</title>
<style type="text/css">
  body{background-image:url("resources/29.jpg");}
  
  </style>



</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form:form action="ViewProd" method="post" commandName="addProd" enctype="multipart/form-data">
<h2 style="background-color:rgb(255, 255, 255)"><center><bold> Product List </bold></center></h2>
<table class="table table-bordered">
  <thead>
   <tr>
    <th><center>Product Id</center></th>
    <th><center>Product Name</center></th>
    <th><center>Quantity</center></th>
    <th><center>Product Price</center></th>
    <th><center>Manufacturing Date</center></th>
    <th><center>Product Description</center></th>
    <th><center>Product Image</center></th>
    </tr>
  </thead>
  <c:forEach items="${pro}" var="prol">
  <tr> 
    <td><center><c:out value="${prol.id}"/></center></td>
    <td><center><c:out value="${prol.name}"/></center></td>
    <td><center><c:out value="${prol.quantity}"/></center></td>
    <td><center><c:out value="${prol.price}"/></center></td>
    <td><center><c:out value="${prol.mfg}"/></center></td>
    <td><center><c:out value="${prol.description}"/></center></td>
    <td><center><c:url var="src" value="/resources/${prol.id}.jpg"></c:url>
    <img src="${src }" width="50" height="50"/></center> </td>
    <td><a href="info?pid=${prol.id}">More Info</a></td>
 </tr>
  </c:forEach>
</table>

</form:form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>