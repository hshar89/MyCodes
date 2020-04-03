<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
  
  <head>
     <title>Student Registration Form</title>
  </head>
  
  <body>
    
    <form:form action="processForm" modelAttribute="student">
      FirstName: <form:input path="firstName"/>
      <br><br>
      LastName: <form:input path="lastName"/>
      <br><br>
      <form:select path="country" required="true">
      <form:options items="${student.countryOptions}" />
      </form:select>
      <br><br>
      <!--  
      Java <form:radiobutton path="favouriteLanguage" value="Java"/>
      C# <form:radiobutton path="favouriteLanguage" value="C#"/>
      Python <form:radiobutton path="favouriteLanguage" value="Python"/>
      Scala <form:radiobutton path="favouriteLanguage" value="Scala"/>
      -->
      <form:radiobuttons path="favouriteLanguage" items="${student.favoriteLanguages}"/>
      <br><br>
      Operating Systems:
      
      Linux: <form:checkbox path="operatingSystems" value="Linux"/>
      Windows: <form:checkbox path="operatingSystems" value="Windows"/>
      Mac: <form:checkbox path="operatingSystems" value="Mac"/>
      
      <br><br>
      <input type="submit" value="Submit"/>
    </form:form>
  </body>
  
</html>