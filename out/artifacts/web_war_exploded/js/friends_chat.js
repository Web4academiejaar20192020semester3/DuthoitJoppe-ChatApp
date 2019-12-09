var chatName = "";
var boolean = true;
var falseB = false;

function openChatWindow(name, bool) {
    chatName = name;
    var chatWindow = $('#chatWindow');
    var chatWindow2 = $('#chatWindow2');
    if (bool) {
        boolean = false;
        chatWindow.empty();
        chatWindow.css("visibility", "hidden");
        chatWindow2.empty();
        chatWindow2.css("visibility", "hidden");
        chatWindow.css("visibility", "visible");
        chatWindow.append("<h2 id='chatName' onclick='minimizeChatWindow(chatName)'>" + name + "</h2>");
        chatWindow.append("<p id='chatX' onclick='closeChatWindow()'>X</p>");
        chatWindow.append("<div id='berichten'></div>");
        chatWindow.append("<input id='chatInput' type='text'>");
        chatWindow.append("<input id='chatButton' type='button' value='Send'>");
        $('#chatButton').click(function () {
            addChatMessage();
        })
        chatWindow.hide(0);
        chatWindow.show(500);
        getChatMessage();
    } else {
        chatWindow.css("visibility", "visible");
        chatWindow2.css("visibility", "hidden");
    }
}

function closeChatWindow() {
    var chatWindow = $('#chatWindow');
    var chatWindow2 = $('#chatWindow2');
    chatWindow.empty();
    chatWindow.css("visibility", "hidden");
    chatWindow2.empty();
    chatWindow2.css("visibility", "hidden");
}

function minimizeChatWindow(name) {
    var chatWindow = $('#chatWindow');
    var chatWindow2 = $('#chatWindow2');
    chatWindow.css("visibility", "hidden");
    chatWindow2.css("visibility", "visible");
    chatWindow2.append("<h2 id='chatName' onclick='openChatWindow(chatName, falseB)'>" + name + "</h2>");
    chatWindow2.append("<p id='chatX' onclick='closeChatWindow()'>X</p>");
    chatWindow2.hide(0);
    chatWindow2.show(500)
}

function addChatMessage() {
    $chatMessage = $('#chatInput').val();
    $.post("Controller?action=FriendChat", {chatMessage: $chatMessage, person: chatName});
}

function getChatMessage() {
    $.get("Controller?action=GetMessage", function (message) {
        var text = message["message"];
        // var name = message["name"];
        var tmp = $('#berichten').append("<p class='textMessage'></p>");
        // console.log(name);
        // console.log(chatName);
        // if (name === chatName) {
            tmp.append(text);
        // }
    });
    setTimeout(getChatMessage, 1000);
}
