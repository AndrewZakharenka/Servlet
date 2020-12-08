<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>

    <meta charset="UTF-8">
    <title>My profile</title>
</head>
<body>

<c:if test="${authorized == 'True'}">
    <script>$.get("http://localhost:8080/profile");</script>
    <jsp:include page="navbar.jsp"></jsp:include>
    <ul class="list-group">
        <li class="list-group-item">Id: <c:out value="${User.id}"></c:out></li>
        <li class="list-group-item">Name: <c:out value="${User.name}"></c:out></li>
        <li class="list-group-item">Surname: <c:out value="${User.surname}"></c:out></li>
        <li class="list-group-item">Email: <c:out value="${User.email}"></c:out></li>
    </ul>
</c:if>
<c:if test="${authorized != 'True'}">
    <jsp:include page="login.jsp"></jsp:include>
</c:if>

</body>
</html>