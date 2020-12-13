<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    <title>Registration</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-sm">
            </div>
            <div class="col-sm">
                <form action="${pageContext.request.contextPath}/register" method="post">
                    <div class="form-group">
                        <label for="Name">Name</label>
                        <input type="text" class="form-control" id="Name" name="Name">
                    </div>
                    <div class="form-group">
                        <label for="Surname">Surname</label>
                        <input type="text" class="form-control" id="Surname" name="Surname">
                    </div>
                    <div class="form-group">
                        <label for="Email">Email</label>
                        <input type="email" class="form-control" id="Email" name="Email" aria-describedby="emailHelp">
                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                    </div>
                    <div class="form-group">
                        <label for="Password1">Password</label>
                        <input type="password" class="form-control" id="Password1" name="Password1">
                    </div>
                    <div class="form-group">
                        <label for="Password2">Double check Password</label>
                        <input type="password" class="form-control" id="Password2" name="Password2">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>


                    <c:if test="${ErrorFlag == 'True'}">
                        <p><c:out value="${Error}"></c:out></p>
                    </c:if>
                </form>
            </div>
            <div class="col-sm">
            </div>
        </div>
    </div>

</body>
</html>