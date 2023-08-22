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
    <title>JAVA</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<style>
.cont{
display: flex;
}
</style>
<div class="container">

   <button type="button" class="btn btn-danger"><a href="/logout">Logout</a></button>
   <hr />
   <h1>Namaste ,${user.userName}</h1>
   <h2>course schedule</h2>
   <table class="table">
   <thead>
   <tr>
   <th>class Name</th>
   <th>Instructor</th>
   <th>weekday</th>
   <th>Price</th>
   <th>Time</th>
   </tr>
   </thead>
   <tbody>
   <c:forEach items="${booksList }" var="oneBook" >
   <tr>
   <td><a href="/classes/${oneBook.id }">${oneBook.title} </a> <c:if test= "${user_id == oneBook.author.id}"><button class="btn btn-outline-success"><a href="/classes/${oneBook.id }/edit">Edit</a></button></c:if></td>
   <td>${oneBook.author.userName}</td>
   <td>${oneBook.weekday}</td>
   <td>${oneBook.prices}</td>
   </tr>
   </c:forEach>
   </tbody>
   </table>
</div>   <button  type="button" class="btn btn-outline-warning"><a href="/classes/new">+ new course🧘‍♀️🧘‍♂️</a></button> 
</body>
</html>