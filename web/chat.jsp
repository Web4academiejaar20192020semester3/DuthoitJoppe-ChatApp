<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Chat"/>
</jsp:include>
<body onload="getStatus(); getFriends();">
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Chat"/>
</jsp:include>
<main>
    <p>Chat</p>
    <label for="statusDiv">Status : </label>
    <div id="statusDiv"></div>
    <input type="text" id="statusSubmit"
           onkeydown="if (event.keyCode == 13) document.getElementById('statusButton').click()"/>
    <input type="button" id="statusButton" value="Change" onclick="changeStatus()"/>
    <br>
    <div id="chatWindow"></div>
    <div id="chatWindow2"></div>
    <div>
        <label for="inputFriend">Add friend</label>
        <input type="text" id="inputFriend"
               onkeydown="if (event.keyCode == 13) document.getElementById('addFriendButton').click()"/>
        <input type="button" id="addFriendButton" value="Add" onclick="addFriend()">
    </div>
    <br>
    <div id="friendsDiv"></div>
    <script src="js/status.js"></script>
    <script src="js/friends.js"></script>
    <script src="js/friends_chat.js"></script>
    <script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
</body>
</html>