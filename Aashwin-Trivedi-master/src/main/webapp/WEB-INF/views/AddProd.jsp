<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Add Product </title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css"> 
body {background-image: url("");} 
 </style>
 <style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: center;
    padding: 8px;
}

tr{background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}
</style>
</head>
<body>
<jsp:include page="adheader.jsp"></jsp:include>
    <center><h2> Add Product </h2></center>
    <c:url value="/resources/.jpg" var="url"></c:url>
    <c:set var="prod" scope="session" value="${ed}"/>
    <c:choose>
    <c:when test="${ed==0}">
        <form:form action="AddProd" method="post" commandName="addProd" enctype="multipart/form-data">
     <form>
     <div align="center">
     <div class="form-group">
      <label class="col-md-4 control-label" for="Product ID">Product ID:</label>
       <div class="col-md-4">
      <input type="text" class="form-control" name="id" value="${pData.id}">
      </div> <br/> <br/> <br/>
    </div>
    <div class="form-group">
      <label class="col-md-4 control-label" for="Product Name">Product Name:</label>
       <div class="col-md-4">
      <input type="text" class="form-control" name="name" value="${pData.name}">
      </div> <br/> <br/> <br/>
    </div>
    
    <div class="form-group">
      <label class="col-md-4 control-label" for="Product Quantity">Quantity:</label>
       <div class="col-md-4">
      <input type="text" class="form-control" name="quantity" value="${pData.quantity}">
      </div> <br/> <br/> <br/>
    </div>
    <div class="form-group">
      <label class="col-md-4 control-label" for="Product Price">Price:</label>
       <div class="col-md-4">
      <input type="text" class="form-control" name="price" value="${pData.price}">
      </div> <br/> <br/> <br/>
    </div>
    <div class="form-group">
      <label class="col-md-4 control-label" for="Manufacturing Date">Manufacturing Date:</label>
       <div class="col-md-4">
      <input type="text" class="form-control" name="mfg" value="${pData.mfg}">
      </div> <br/> <br/> <br/>
    </div>
    <div class="form-group">
      <label class="col-md-4 control-label" for="Product Name">Description:</label>
       <div class="col-md-4">
      <input type="text" class="form-control" name="description" value="${pData.description}">
      </div> <br/> <br/> <br/>
    </div>
    
    <div class="form-group">
      <label class="col-md-4 control-label" for="Product Image">Product Image</label>
       <div class="col-md-4">
      <input type="file" class="form-control" name="image" value="${pData.image}">
      </div> <br/> <br/> <br/>
    </div>
    
   <button type="submit" class="btn btn-success">  Add Product  </button>
  </div>
  </form>
</form:form>
</c:when>
<c:otherwise>


<form:form action="editP" method="post" commandName="addProd" enctype="multipart/form-data">
     <form>
     <div align="center">
     <div class="form-group">
      <label class="col-md-4 control-label" for="Product ID">Product ID:</label>
       <div class="col-md-4">
      <input type="text" class="form-control" name="id" value="${pData.id}">
      </div> <br/> <br/> <br/>
    </div>
    <div class="form-group">
      <label class="col-md-4 control-label" for="Product Name">Product Name:</label>
       <div class="col-md-4">
      <input type="text" class="form-control" name="name" value="${pData.name}">
      </div> <br/> <br/> <br/>
    </div>
    
    <div class="form-group">
      <label class="col-md-4 control-label" for="Product Quantity">Quantity:</label>
       <div class="col-md-4">
      <input type="text" class="form-control" name="quantity" value="${pData.quantity}">
      </div> <br/> <br/> <br/>
    </div>
    <div class="form-group">
      <label class="col-md-4 control-label" for="Product Price">Price:</label>
       <div class="col-md-4">
      <input type="text" class="form-control" name="price" value="${pData.price}">
      </div> <br/> <br/> <br/>
    </div>
    <div class="form-group">
      <label class="col-md-4 control-label" for="Manufacturing Date">Manufacturing Date:</label>
       <div class="col-md-4">
      <input type="text" class="form-control" name="mfg" value="${pData.mfg}">
      </div> <br/> <br/> <br/>
    </div>
    <div class="form-group">
      <label class="col-md-4 control-label" for="Product Name">Description:</label>
       <div class="col-md-4">
      <input type="text" class="form-control" name="description" value="${pData.description}">
      </div> <br/> <br/> <br/>
    </div>
    
    <div class="form-group">
      <label class="col-md-4 control-label" for="Product Image">Product Image</label>
       <div class="col-md-4">
      <input type="file" class="form-control" name="image" value="${pData.image}">
      </div> <br/> <br/> <br/>
    </div>
    
   <button type="submit" class="btn btn-success">  Edit Product  </button>
  </div>
  </form>
</form:form>
</c:otherwise>
</c:choose>

<br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/>
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
    </tr>
  </thead>
  <c:forEach items="${pro}" var="prol">
  <tr>
    <td><c:out value="${prol.id}"/></td>
    <td><c:out value="${prol.name}"/></td>
    <td><c:out value="${prol.quantity}"/></td>
    <td><c:out value="${prol.price}"/></td>
    <td><c:out value="${prol.mfg}"/></td>
    <td><c:out value="${prol.description}"/></td>
    <td><c:url var="src" value="/resources/${prol.id}.jpg"></c:url>
    <img src="${src}" width="50" height="50"/> </td>
    <td><a href="editProduct?proid=${prol.id}">edit</a></td>
    <td><a href="delpro?prid=${prol.id}">delete</a></td>
    
  </tr>
  </c:forEach>
</table>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>