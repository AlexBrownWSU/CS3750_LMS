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
    <title>Sign Up</title>
    <link rel="stylesheet" href="style_sign_up.css">
</head>
<body>
<br>
<br>
<div class="signUp">
    <h3>CREATE NEW USER</h3>
    <hr>

    <form action="${pageContext.request.contextPath}/signUp" method="post">

        <div class="text-input">
            <input type="text" required autocomplete="off" name="fName" placeholder="First Name"/>
        </div>

        <div class="text-input">
            <input type="text" required autocomplete="off" name="lName" placeholder="Last Name"/>
        </div>

        <div class="text-input">
            <input type="text" required autocomplete="off" name="bDate" placeholder="Birth Date"/>
        </div>

        <div class="text-input">
            <input type="text" required autocomplete="off" name="email" placeholder="Email"/>
        </div>

        <div class="text-input">
            <input type="password" required autocomplete="off" name="password" placeholder="Password"/>
        </div>

        <div class="check-box">
            <input type="checkbox" name="userType" value="1"> Teacher?<br>
        </div>

        <div class="button">
            <input type="Submit" value="Sign up"/>
        </div>

    </form>

    <p class="message">Go
        <a href="login.jsp">back</a></p>

</div>
</body>
</html>
