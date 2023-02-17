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
    <title>Travels</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <div class="container">
        <H1>Edit Expense</H1>
        <form:form action="/editing/${travel.id}" method="post" modelAttribute="travel">
            <input type="hidden"  name="_method" value="put">
            <div class="form-control">
                <form:label path="expenseName" for="expenseName">Expense Name</form:label>
                <form:errors path="expenseName"/>
                <form:input path="expenseName" type="text" id="expenseName" name="expenseName"/>
            </div>
            <div class="form-control">
                <form:label path="vendor" for="vendor">Vendor</form:label>
                <form:errors path="vendor"/>
                <form:input path="vendor" type="text" id="vendor" name="vendor"/>
            </div>
            <div class="form-control">
                <form:label path="ammount" for="ammount">Amount</form:label>
                <form:errors path="ammount"/>
                <form:input path="ammount" type="text" id="ammount" name="ammount"/>
            </div>
            <div class="form-control">
                <form:label path="description" for="description">Description</form:label>
                <form:errors path="description"/>
                <form:textarea path="description" type="text" id="description" name="description"/>
            </div>
            <input type="submit" value="submit">
        </form:form>
    </div>
</body>
</html>


