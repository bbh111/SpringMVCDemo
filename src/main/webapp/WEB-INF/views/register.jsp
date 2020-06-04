<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: hieu
  Date: 27/05/2020
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

    <script>
        function cfPass(field) {
            var mess = document.getElementById("mess");
            var pw = document.getElementById("exampleInputPassword1").value;
            var cfpw = document.getElementById("cfPass").value;
            alert(pw);
            field.focus();
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md">
            <div class="mt-5">
                <form action="/register" method="post" modelAttribute="newAccount">
                    <div class="form-group">
                        <form:label path="username" >Username</form:label>
                        <form:input path="username" class="form-control" id="exampleInputEmail1"
                                               aria-describedby="emailHelp" placeholder="Enter your email" require="" />
                        <small id="emailHelp" class="form-text text-muted">Please input an email</small>
                    </div>
                    <div class="form-group">
<%--                        <form:label path="password">Password</form:label>--%>
<%--                        <form:input path="password" type="password" name="password" class="form-control" id="exampleInputPassword1"--%>
<%--                                    placeholder="Password" pattern="{a-z0-9}(6-30)" required=""/>--%>
                        <small id="passwordHelp" class="form-text text-muted">Password must more than 6 character</small>
                    </div>
                    <div class="form-group">
<%--                        <label for="cfPass">Re-Enter your Password</label>--%>
<%--                        <input type="password" name="cfpassword" class="form-control" id="cfPass"--%>
<%--                               placeholder="Re-Enter Password" onmouseout="cfPass()" onfocus="this.select()" onblur="cfPass(this)" required>--%>
<%--                        <small id="mess"></small>--%>
                    </div>
                    <div class="form-group">
<%--                        <form:label path="accountInformation.fullName">Your Name</form:label>--%>
<%--                        <form:input path="accountInformation.fullName" type="text" name="cusName" class="form-control" id="fullName"--%>
<%--                                    placeholder="Your Name" required="true"/>--%>
                    </div>
                    <div class="form-group">
                        <label for="gender">Gender</label>
                        <div class="radio" id="gender">
                            <label><input type="radio" name="gender" value="1" checked>Male</label>
                            <label><input type="radio" name="gender" value="2" >Female</label>
                            <label><input type="radio" name="gender" value="0" >Other</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="phone">Your Phone</label>
                        <input type="number" name="phone" class="form-control" id="phone"
                               placeholder="Your Phone" >
                    </div>
                    <div class="form-group">
                        <label for="address">Your Address</label>
                        <input type="text" name="address" class="form-control" id="address"
                               placeholder="Your Address" >
                    </div>
                    <div class="form-group">
                        <label for="introduction">Your Introduction</label>
                        <input type="text" name="intro" class="form-control" id="introduction"
                               placeholder="Your Introduction" >
                    </div>
                    <button type="submit" class="btn btn-primary">Đăng ký ngay</button>
                </form>
                <c:if test="${not empty errMess}">
                    ${errMess}
                </c:if>
                <c:if test="${not empty json}">
                    ${json}
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
</html>
