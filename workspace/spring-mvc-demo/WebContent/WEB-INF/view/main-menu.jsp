<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" 
		  href="${pageContext.request.contextPath}/Resources/css/my-test.css">

    <script src="${pageContext.request.contextPath}/Resources/javascript/simple-test.js"></script>
</head>
<body>
<h2>Spring MVC Demo - Home Page</h2>
  <hr>
  <a href="hello/showForm">Hello World Form</a>
  <br><br>
  
  <a href="student/showForm">Student Form</a>
  <br><br>
  <a href="customer/showForm">Customer Form</a>
  <br><br>
  <img src="${pageContext.request.contextPath}/Resources/images/Test1.png" height="40" width="40"/>
  <br><br>
  <input type="button" onclick="doSomething()" value="Click Me"/>
</body>
</html>