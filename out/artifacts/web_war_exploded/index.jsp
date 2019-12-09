<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<body onload="openSocket();">
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<main>
    <c:if test="${errors.size()>0 }">
        <div class="danger">
            <ul>
                <c:forEach var="error" items="${errors}">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <c:if test="${user!=null}">
        <p>Welcome ${user.getFirstName()}!</p>
        <form method="post" action="Controller?action=LogOut">
            <p>
                <input type="submit" id="logoutbutton" value="Log Out">
            </p>
        </form>
    </c:if>
    <c:if test="${user==null}">
        <form method="post" action="Controller?action=LogIn">
            <p>
                <label for="email">Your email </label>
                <input type="text" id="email" name="email" value="jan@ucll.be">
            </p>
            <p>
                <label for="password">Your password</label>
                <input type="password" id="password" name="password" value="t">
            </p>
            <p>
                <input type="submit" id="loginbutton" value="Log in">
            </p>
        </form>
    </c:if>
    <p>Create Account</p>
    <form method="post" action="Controller?action=CreateAccount">
        <p>
            <label for="firstName">Your first name</label>
            <input type="text" id="firstName" name="firstName">
        </p>
        <p>
            <label for="lastName">Your last name</label>
            <input type="text" id="lastName" name="lastName">
        </p>
        <p>
            <label for="emailC">Your email </label>
            <input type="text" id="emailC" name="cEmail">
        </p>
        <p>
            <label for="geslacht">Your gender</label>
            <select id="geslacht" name="geslacht">
                <option value="M">Male</option>
                <option value="V">Female</option>
            </select>
        </p>
        <p>
            <label for="passwordC">Your password</label>
            <input type="password" id="passwordC" name="cPassword">
        </p>
        <p>
            <label for="passwordCrepeat">Repeat password</label>
            <input type="password" id="passwordCrepeat" name="rPassword">
        </p>
        <p>
            <label for="age">Your age</label>
            <input type="number" id="age" name="age" min="1" max="99">
        </p>
        <p>
            <input type="submit" id="createAccountbutton" value="Create Account">
        </p>
    </form>
    <div>
        <p>Was het een interessante projectweek?</p>
        <p id="0error"></p>
        <p>
            <label for="0blogUser">Username</label>
            <input type="text" id="0blogUser"
                   onkeydown="if (event.keyCode == 13) document.getElementById('0blogButton').click()">
        </p>
        <p>
            <label for="0blogComment">Comment</label>
            <input type="text" id="0blogComment"
                   onkeydown="if (event.keyCode == 13) document.getElementById('0blogButton').click()"/>
        </p>
        <p>
            <label for="0blogScore">Score</label>
            <input type="number" id="0blogScore" min="1" max="10"
                   onkeydown="if (event.keyCode == 13) document.getElementById('0blogButton').click()">
        </p>
        <p>
            <input type="button" id="0blogButton" value="Comment" onclick="sendBlog(0)"/>
        </p>

        <p id="0blog"></p>
    </div>
    <div>
        <p>Wat ben je van plan om te doen vandaag?</p>
        <p id="1error"></p>
        <p>
            <label for="1blogUser">Username</label>
            <input type="text" id="1blogUser"
                   onkeydown="if (event.keyCode == 13) document.getElementById('1blogButton').click()">
        </p>
        <p>
            <label for="1blogComment">Comment</label>
            <input type="text" id="1blogComment"
                   onkeydown="if (event.keyCode == 13) document.getElementById('1blogButton').click()"/>
        </p>
        <p>
            <label for="1blogScore">Score</label>
            <input type="number" id="1blogScore" min="1" max="10"
                   onkeydown="if (event.keyCode == 13) document.getElementById('1blogButton').click()">
        </p>
        <p>
            <input type="button" id="1blogButton" value="Comment" onclick="sendBlog(1)"/>
        </p>
        <p id="1blog"></p>
    </div>
    <div>
        <p>Naar welke muziek ben je momenteel aan het luisteren?</p>
        <p id="2error"></p>
        <p>
            <label for="2blogUser">Username</label>
            <input type="text" id="2blogUser"
                   onkeydown="if (event.keyCode == 13) document.getElementById('2blogButton').click()">
        </p>
        <p>
            <label for="2blogComment">Comment</label>
            <input type="text" id="2blogComment"
                   onkeydown="if (event.keyCode == 13) document.getElementById('2blogButton').click()"/>
        </p>
        <p>
            <label for="2blogScore">Score</label>
            <input type="number" id="2blogScore" min="1" max="10"
                   onkeydown="if (event.keyCode == 13) document.getElementById('2blogButton').click()">
        </p>
        <p>
            <input type="button" id="2blogButton" value="Comment" onclick="sendBlog(2)"/>
        </p>
        <p id="2blog"></p>
    </div>
    <div>
        <p>Hoe leuk is javascript?</p>
        <p id="3error"></p>
        <p>
            <label for="3blogUser">Username</label>
            <input type="text" id="3blogUser"
                   onkeydown="if (event.keyCode == 13) document.getElementById('3blogButton').click()">
        </p>
        <p>
            <label for="3blogComment">Comment</label>
            <input type="text" id="3blogComment"
                   onkeydown="if (event.keyCode == 13) document.getElementById('3blogButton').click()"/>
        </p>
        <p>
            <label for="3blogScore">Score</label>
            <input type="number" id="3blogScore" min="1" max="10"
                   onkeydown="if (event.keyCode == 13) document.getElementById('3blogButton').click()">
        </p>
        <p>
            <input type="button" id="3blogButton" value="Comment" onclick="sendBlog(3)"/>
        </p>
        <p id="3blog"></p>
    </div>
    <div>
        <p>Wat zijn de examenvragen voor het vak Web4?</p>
        <p id="4error"></p>
        <p>
            <label for="4blogUser">Username</label>
            <input type="text" id="4blogUser"
                   onkeydown="if (event.keyCode == 13) document.getElementById('4blogButton').click()">
        </p>
        <p>
            <label for="4blogComment">Comment</label>
            <input type="text" id="4blogComment"
                   onkeydown="if (event.keyCode == 13) document.getElementById('4blogButton').click()"/>
        </p>
        <p>
            <label for="4blogScore">Score</label>
            <input type="number" id="4blogScore" min="1" max="10"
                   onkeydown="if (event.keyCode == 13) document.getElementById('4blogButton').click()">
        </p>
        <p>
            <input type="button" id="4blogButton" value="Comment" onclick="sendBlog(4)"/>
        </p>
        <p id="4blog"></p>
    </div>
    <script src="js/blog.js"></script>
</main>

<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
</body>
</html>
