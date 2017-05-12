<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Single Product Info</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<c:url value="/resources/.jpg" var="url"></c:url>
<c:forEach items="${addProd}" var="prol">

 <h1><center><bold>Information of <c:out value="${prol.name}"/></bold></center></h1>
  
 <div><c:url var="src" value="/resources/${prol.id}.jpg"></c:url>
    <img src="${src}" width="50%" height="50%" style="float:left"/>
   
   <h3><p style="float:right">
    <br><c:out value="${prol.name}"/><br>
    
    <br><c:out value="${prol.price}"/><br>
    
    <br><c:out value="${prol.description}"/><br></p></h3></div>
<form action="AddtoCart">
<input type="hidden" name="prid" value="${prol.id}">
<br> <br> <br> <br>
Quantity <input type="text" name="q"/>
<input type="submit" value="Add to Cart"/>
</c:forEach>
</form>
 <br> <br> <br> <br> <br> <br> <br> <br> <br>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>