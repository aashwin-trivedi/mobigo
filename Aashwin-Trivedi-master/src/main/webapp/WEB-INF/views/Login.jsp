<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Login </title>
<style type="text/css"> 
body {background-image: url("resources/29.jpg");} 
 </style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
    <center><h2> Login </h2></center>
        <form:form action="perform_login" method="post">
            <form>
     <div align="center">
     
      <div class="form-group">
     <label class="col-md-4 control-label"> User Name : </label>
     <div class="col-md-4">
      <input type="text" class="form-control" name="username">
      </div> <br/> <br/> <br/>
    </div>
    
    
    <div class="form-group">
      <label class="col-md-4 control-label"> Password: </label>
      <div class="col-md-4">
      <input type="password" class="form-control" name="password">
      </div> <br/> <br/> <br/>
    </div>
    
    
    
    
    
  <center> <button type="submit" class="btn btn-success"> Login </button>     <button type="button" class="btn btn-warning">Cancel</button></center>
  <br><br><br><br><input type="checkbox" checked="checked"> Remember me
  
<span class="psw">Forgot <a href="#">password?</a></span>
<br><br><br><br>
</div>
</form:form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>











    