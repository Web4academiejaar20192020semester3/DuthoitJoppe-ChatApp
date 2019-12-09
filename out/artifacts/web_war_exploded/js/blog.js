var webSocket;
var messages;

function openSocket() {
    webSocket = new WebSocket("ws://localhost:8080/echo");
    webSocket.onmessage = function (event) {
        writeResponse(event.data);
    };
    webSocket.onclose = function (event) {
        // setTimeout(openSocket, 1000);
    };
}

function sendBlog(id) {
    var error = document.getElementById(id + "error");
    var bool = true;
    error.innerHTML = "";
    try {
        var username = document.getElementById(id + "blogUser").value;
        if (username.length === 0) throw "Username mag niet leeg zijn";
        var comment = document.getElementById(id + "blogComment").value;
        if (comment.length === 0) throw "Comment mag niet leeg zijn";
        var score = document.getElementById(id + "blogScore").value;
        if (score < 1 || score > 10) throw "Score moet tussen 1 en 10 liggen";
    } catch (err) {
        error.innerHTML = err;
        bool = false;
    }

    if (bool) {
        var fullComment = id + username + ": " + comment + " ==> " + score + "/10";
        messages = document.getElementById(id + "blog");
        webSocket.send(fullComment);
    }
}

function writeResponse(text) {
    var id = text.toString().charAt(0);
    text = text.substring(1);
    switch (id) {
        case "0":
            messages = document.getElementById("0blog");
            break;
        case "1":
            messages = document.getElementById("1blog");
            break;
        case "2":
            messages = document.getElementById("2blog");
            break;
        case "3":
            messages = document.getElementById("3blog");
            break;
        case "4":
            messages = document.getElementById("4blog");
            break;
    }
    messages.innerHTML += "<p/>" + text;
}
