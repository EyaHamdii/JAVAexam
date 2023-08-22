<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <div class="container">
     <a href="/classes">🏠 Home </a>
    <button type="button" class="btn btn-danger"><a href="/logout">Logout</a></button>
   
   <hr />
   
   <form:form action="/classes/${course.id }/edit" method="post" modelAttribute="course">
   <input type="hidden" name="_method" value="put">
   <form:errors class="text-danger" path="*"/>
    <p class="form-group">
        <form:label path="title" for="usr">Name</form:label>
        <form:input path="title" class="<form-control></form-control>" id="usr"/>
    </p>
    <p class="form-group">
        <form:label path="weekday" for="usr">Day of week</form:label>
        <form:input path="weekday" class="form-control" id="usr"/>
    </p>
      <p class="form-group">
        <form:label path="prices" for="usr">Drop-in Price</form:label>
        <form:input type="number" path="prices" class="form-control" id="usr"/>
    </p>
      <p class="form-group">
        <form:label path="description" for="usr">Description</form:label>
        <form:input  path="description" class="form-control" id="usr"/>
    </p>
   	<button><a href="/classes">Cancel</a></button>
    <button class="btn btn-outline-primary">Submit</button>
    
</form:form>    
  
   	
   	<form action="/classes/${course.id}" method="post">
   	<input  type="hidden" name="_method" value="delete">
    <input type="submit" class="btn btn-outline-danger" value="Delete">
   	</form>

</body>
</html>