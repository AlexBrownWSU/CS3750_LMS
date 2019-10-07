<%--
  Created by IntelliJ IDEA.
  User: alexbrown
  Date: 9/25/19
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="style_login.css">
</head>
<body>
<br>
<br>
<div class="center">
    <h3>LOGIN TO YOUR ACCOUNT</h3>
    <hr>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="text-input">
            <input type="text" name="username" width="30" placeholder="Email"/>
        </div>
        <div class="text-input">
            <input type="password" name="password" width="30" placeholder="Password"/>
        </div>
        <div class="button">
            <input type="submit" value="Login"/>
        </div>
    </form>

    <p class="message">Not registered?
        <a href="signUp.jsp">Create an account</a></p>

    <p class="error" style="color:red">${errorMessage}</p>

</div>

</body>
</html>

