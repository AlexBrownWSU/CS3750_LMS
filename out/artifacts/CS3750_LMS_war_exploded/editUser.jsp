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
    <a href="${pageContext.request.contextPath}/login?userId=${id}"><i class="fa fa-home"></i></a>
    <a class="active" href="${pageContext.request.contextPath}/editUser.jsp "><i class="fa fa-user"></i></a>
    <a href="${pageContext.request.contextPath}/login.jsp"><i class="fa fa-sign-out"></i></a>
    <a href="#"><i class="fa fa-globe"></i></a>
    <a href="#"><i class="fa fa-trash"></i></a>
</div>

<div class="edit-user-form">
    <form action="${pageContext.request.contextPath}/editUserPostInfo" method="post">
        <p class="heading">User Information</p>
        <hr>
        <div class="info">
            <table style="width:100%">
                <tr>
            <td>
                <div class="text-input">
                    <input type="hidden" id="userId" name="userId" value="${id}">
                    <label for="username">Username (email)</label>
                    <input type="text" name="username" width="30" placeholder="Email" value="${email}" id="username"/>
                </div>
            </td>
                    <td>
            <div class="text-input">
                <label for="password">Password</label>
                <input type="password" name="password" width="30" placeholder="Password" value="${password}" id="password" readonly/>
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
                            <label for="fName">First Name</label>
                            <input type="text" name="fName" width="30" placeholder="First Name" value="${fName}" id="fName"/>
                        </div>
                    </td>
                    <td>
                        <div class="text-input">
                            <label for="lName">Last Name</label>
                            <input type="text" name="lName" width="30" placeholder="Last Name" value="${lName}" id="lName"/>
                    </div>
                    </td>
                </tr>
                <tr>
                    <td align="center" colspan="2">
                        <div class="text-input">
                            <label for="bDate">Birthday</label>
                            <input type="date" name="bDate" width="30" placeholder="Birth Date" value="${bDate}" id="bDate"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td align="center" colspan="2">
                        <div class="text-input">
                            <label for="bio">Biography</label>
                            <textarea name="bio" cols="40" rows="5" placeholder="Bio" id="bio">${bio}</textarea>
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
                        <label for="address1">Line 1</label>
                        <input type="text" name="address1" width="30" placeholder="Line 1" value="${lineOne}" id="address1"/>
                    </div>
                </td>
                <td>
                    <div class="text-input">
                        <label for="address2">Line 2</label>
                        <input type="text" name="address2" width="30" placeholder="Line 2" value="${lineTwo}" id="address2"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="text-input">
                        <label for="address3">Line 3</label>
                        <input type="text" name="address3" width="30" placeholder="Line 3" value="${lineThree}" id="address3" />
                    </div>
                </td>
                <td>
                    <div class="text-input">
                        <label for="Zip">Zip</label>
                        <input type="number" name="zip" width="30" placeholder="Zip" value="${zip}" id="zip" />
                    </div>
                </td>
            </tr>
                <tr>
                    <td>
                        <div class="text-input">
                            <label for="city">City</label>
                            <input type="text" name="city" width="30" placeholder="City" value="${city}" id="city"/>
                        </div>
                    </td>
                    <td>
            <div class="text-input">
                <label for="phoneNumber">Phone Number</label>
                <input type="text" name="phoneNumber" width="30" placeholder="Phone Number" value="${phoneNumber}" id="phoneNumber"/>
            </div>
                    </td>
                </tr>
            <tr>
                <td>
            <div class="text-input">
                <label for="country">Country</label>
                <input type="text" name="country" width="30" placeholder="County" value="${country}" id="country"/>
            </div>
                </td>
                <td>
            <div class="text-input">
                <label for="state">State</label>
               <input type="text" name="state" width="30" placeholder="State" value="${state}" id="state"/>
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

