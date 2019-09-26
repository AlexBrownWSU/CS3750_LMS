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
    <p style="color:red">Edit User Profile: ${lName}, ${fName}</p>
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
    <form action="/editUser" method="post">

        <p class="heading">User Information</p>
        <hr>
        <div class="info">
            <table style="width:100%">
                <tr>
            <td>
                <div class="text-input">
                <input type="text" name="username" width="30" placeholder="Email" value="${email}" readonly/>
            </div>
            </td>
                    <td>
            <div class="text-input">
                <input type="password" name="password" width="30" placeholder="Password" value="${password}"/>
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
                        <input type="text" name="address1" width="30" placeholder="Line 1"/>
                    </div>
                </td>
                <td>
                    <div class="text-input">
                        <input type="text" name="address2" width="30" placeholder="Line 2"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="text-input">
                        <input type="text" name="address3" width="30" placeholder="Line 3"/>
                    </div>
                </td>
                <td>
                    <div class="text-input">
                        <input type="text" name="zip" width="30" placeholder="Zip"/>
                    </div>
                </td>
            </tr>
                <tr>
                    <td>
                        <div class="text-input">
                            <input type="text" name="City" width="30" placeholder="City"/>
                        </div>
                    </td>
                    <td>
            <div class="text-input">
                <input type="text" name="phone" width="30" placeholder="Phone Number"/>
            </div>
                    </td>
                </tr>
            <tr>
                <td>
            <div class="text-input">
                <input type="text" name="City" width="30" placeholder="City"/>
            </div>
                </td>
                <td>
            <div class="select">
                <select>
                <option value="AL">Alabama</option>
                <option value="AK">Alaska</option>
                <option value="AZ">Arizona</option>
                <option value="AR">Arkansas</option>
                <option value="CA">California</option>
                <option value="CO">Colorado</option>
                <option value="CT">Connecticut</option>
                <option value="DE">Delaware</option>
                <option value="DC">District Of Columbia</option>
                <option value="FL">Florida</option>
                <option value="GA">Georgia</option>
                <option value="HI">Hawaii</option>
                <option value="ID">Idaho</option>
                <option value="IL">Illinois</option>
                <option value="IN">Indiana</option>
                <option value="IA">Iowa</option>
                <option value="KS">Kansas</option>
                <option value="KY">Kentucky</option>
                <option value="LA">Louisiana</option>
                <option value="ME">Maine</option>
                <option value="MD">Maryland</option>
                <option value="MA">Massachusetts</option>
                <option value="MI">Michigan</option>
                <option value="MN">Minnesota</option>
                <option value="MS">Mississippi</option>
                <option value="MO">Missouri</option>
                <option value="MT">Montana</option>
                <option value="NE">Nebraska</option>
                <option value="NV">Nevada</option>
                <option value="NH">New Hampshire</option>
                <option value="NJ">New Jersey</option>
                <option value="NM">New Mexico</option>
                <option value="NY">New York</option>
                <option value="NC">North Carolina</option>
                <option value="ND">North Dakota</option>
                <option value="OH">Ohio</option>
                <option value="OK">Oklahoma</option>
                <option value="OR">Oregon</option>
                <option value="PA">Pennsylvania</option>
                <option value="RI">Rhode Island</option>
                <option value="SC">South Carolina</option>
                <option value="SD">South Dakota</option>
                <option value="TN">Tennessee</option>
                <option value="TX">Texas</option>
                <option value="UT">Utah</option>
                <option value="VT">Vermont</option>
                <option value="VA">Virginia</option>
                <option value="WA">Washington</option>
                <option value="WV">West Virginia</option>
                <option value="WI">Wisconsin</option>
                <option value="WY">Wyoming</option>
                </select>
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

