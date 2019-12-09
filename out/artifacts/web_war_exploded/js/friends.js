var xhr3 = new XMLHttpRequest();
var xhr4 = new XMLHttpRequest();

function getFriends() {
    xhr3.open("GET", "Controller?action=GetFriends", true);
    xhr3.onreadystatechange = getFriendsData;
    xhr3.send(null);
}

function addFriend() {
    var friendEmail = document.getElementById("inputFriend").value;
    var friend = "friend=" + encodeURIComponent(friendEmail);
    xhr4.open("POST", "Controller?action=AddFriend", true);
    xhr4.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr4.send(friend);
    getFriends();
}

function getFriendsData() {
    if (xhr3.readyState == 4) {
        if (xhr3.status == 200) {
            var mapData = JSON.parse(xhr3.responseText);
            var friendsDiv = document.getElementById("friendsDiv");
            while (friendsDiv.firstChild != null) {
                friendsDiv.removeChild(friendsDiv.firstChild);
            }
            var table = document.createElement("table");
            var trh = document.createElement("tr");
            var thName = document.createElement("th");
            var thStatus = document.createElement("th");
            thName.appendChild(document.createTextNode("Name"));

            thStatus.appendChild(document.createTextNode("Status"));
            trh.appendChild(thName);
            trh.appendChild(thStatus);
            table.appendChild(trh);
            friendsDiv.appendChild(table);

            var map = new Map(Object.entries(mapData));
            var counter = 0;
            var bool = true;
            map.forEach(function (value, key) {
                var obj = new Map(Object.entries(value));
                var tr = document.createElement("tr");
                table.appendChild(tr);
                obj.forEach(function (v, k) {
                    var name = document.createElement("td");
                    tr.appendChild(name);
                    name.appendChild(document.createTextNode(v));
                    if (counter % 2 == 0) {
                        name.addEventListener('click', function () {
                            openChatWindow(v, bool);
                        })
                        counter++;
                    }
                });
                counter = 0;
            });
            setTimeout(getFriends, 10000);
        }
    }
}

