<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
   <title>Welcome to luv2code company</title>
</head>

<body>
 <h2>luv2code company home page</h2>
 <hr>
 <p>
  Welcome to luv2code
  </p>
 <!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
</body>
</html>