<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Make the Payment</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container" align="center">
  <h2><strong><u>Choose a Payment Mode:</u></strong></h2>
<form action="ThankYou">
<div class="form-group">
<div class="radio">
      <h3><strong><label><input type="radio" name="optradio" required="true"> Debit/Credit Card</label></strong></h3>
      <div class="form-group">
     <label class="col-md-4 control-label"> Card Number : </label>
     <div class="col-md-4">
      <input type="text" class="form-control" name="cardnumber" >
     </div></div><br/><br/>
     
     <div class="form-group">
     <label class="col-md-4 control-label"> CVV : </label>
     <div class="col-md-4">
      <input type="text" class="form-control" name="cvv" >
     </div></div>
      </div><br/><br/>
      
    <div class="radio">
      <h3><strong><label><input type="radio" name="optradio" required="true">Cash On Delivery[COD]</label></strong></h3>
    </div>
    <button type="submit" class="btn btn-success">Pay Now</button>
</div>
</form> 
</div>
<br/><br/><br/><br/>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>