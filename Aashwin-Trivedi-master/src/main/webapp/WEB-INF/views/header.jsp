<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<div>
<img src="resources/Logo.png">

</div>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
    <a class="navbar-brand" href="#">Mobigo</a>
    </div>
    <ul class="nav navbar-nav">
    <li>Welcome <c:out value="${UserName}"></c:out></li>
     
            <a href="home" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-home"></span> home
        </a>
      
      
      
           <a href="ViewProd" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-search"></span> products
        </a>
    
    
            <a href="contact" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-envelope"></span> contactus
        </a>
        
     
          <a href="abtus"  class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-info-sign"></span> aboutus
        </a></li></ul>
        
        
        <ul class="nav navbar-nav navbar-right">
        
          
          <a href="Register" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-user"></span> register</a></li>
          
            
        <c:choose>
 <c:when test="${UserLoggedIn}">
 <c:out value="${cnt}"></c:out><a href="showCart" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-shopping-cart"></span>Cart</a>
<a href="perform_logout" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-log-in"></span> Logout  </a></ul>
</c:when>
  <c:otherwise>
     <a href="Login" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-log-in"></span> login 
           </a></ul>
     </c:otherwise>
</c:choose>
    
  </div>
</nav>
</body>
</html>
