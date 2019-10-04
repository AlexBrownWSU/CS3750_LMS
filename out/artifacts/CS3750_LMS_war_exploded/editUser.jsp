<%--
  Created by IntelliJ IDEA.
  User: alexbrown
  Date: 9/25/19
  Time: 7:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
    <link rel="stylesheet" href="style_edit_user.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<div class="topnav">
    <p style="color:red">Edit User Profile: ${lName}, ${fName}, User ID: ${id} Address ID: ${addressId}</p>
    <hr>
</div>

<div class="icon-bar">
    <a href="/userLandingPage.jsp"><i class="fa fa-home"></i></a>
    <a class="active" href="/editUser.jsp "><i class="fa fa-user"></i></a>
    <a href="/login.jsp"><i class="fa fa-sign-out"></i></a>
    <a href="#"><i class="fa fa-globe"></i></a>
    <a href="#"><i class="fa fa-trash"></i></a>
</div>

<div class="edit-user-form">
    <form action="/editUserPostInfo" method="post">
        <p class="heading">User Information</p>
        <hr>
        <div class="info">
            <table style="width:100%">
                <tr>
            <td>
                <div class="text-input">
                    <input type="hidden" id="userId" name="userId" value="${id}">
                    <input type="text" name="username" width="30" placeholder="Email" value="${email}" />
                </div>
            </td>
                    <td>
            <div class="text-input">
                <input type="password" name="password" width="30" placeholder="Password" value="${password}" readonly/>
            </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div>
                            <button>Edit Password</button>
                        </div>
                    </td>
                </tr>
            </table>
        </div>

        <p class="heading">Personal Information</p>
        <hr>
        <div class="info">
            <table style="width:100%">
                <tr>
                    <td>
                        <div class="text-input">
                            <input type="text" name="fName" width="30" placeholder="First Name" value="${fName}"/>
                        </div>
                    </td>
                    <td>
                        <div class="text-input">
                            <input type="text" name="lName" width="30" placeholder="Last Name" value="${lName}"/>
                    </div>
                    </td>
                </tr>
                <tr>
                    <td align="center" colspan="2">
                        <div class="text-input">
                            <input type="date" name="bDate" width="30" placeholder="Birth Date" value="${bDate}"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td align="center" colspan="2">
                        <div class="text-input">
                            <textarea name="bio" cols="40" rows="5" placeholder="Bio"></textarea>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        <br>
        <p class="heading">Address Information</p>
        <hr>
        <div class="info">
            <table style="width:100%">
            <tr>
                <td>
                    <div class="text-input">
                        <input type="hidden" id="addressId" name="addressId" value="${addressId}">
                        <input type="text" name="address1" width="30" placeholder="Line 1" value="${lineOne}"/>
                    </div>
                </td>
                <td>
                    <div class="text-input">
                        <input type="text" name="address2" width="30" placeholder="Line 2" value="${lineTwo}"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="text-input">
                        <input type="text" name="address3" width="30" placeholder="Line 3" value="${lineThree}"/>
                    </div>
                </td>
                <td>
                    <div class="text-input">
                        <input type="number" name="zip" width="30" placeholder="Zip" value="${zip}"/>
                    </div>
                </td>
            </tr>
                <tr>
                    <td>
                        <div class="text-input">
                            <input type="text" name="city" width="30" placeholder="City" value="${city}"/>
                        </div>
                    </td>
                    <td>
            <div class="text-input">
                <input type="text" name="phone" width="30" placeholder="Phone Number" value="${phoneNumber}"/>
            </div>
                    </td>
                </tr>
            <tr>
                <td>
            <div class="text-input">
                <input type="text" name="country" width="30" placeholder="County" value="${country}"/>
            </div>
                </td>
                <td>
            <div class="text-input">
               <input type="text" name="state" width="30" placeholder="State" value="${state}"/>
            </div>
                </td>
            </tr>
            </table>
            <div class="button">
                <input type="submit" value="Edit"/>
            </div>
            </table>
        </div>
    </form>
</div>
</body>
</html>

