package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FriendChat extends AsyncRequestHandler {

    boolean tmp = true;

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String chatMessage = request.getParameter("chatMessage");
        String name = request.getParameter("person");
        Person me = (Person) request.getSession().getAttribute("user");
        List<Person> friends = getPersonService().getPersons();
        chatMessage = me.getFirstName() + ": " + chatMessage;
        Person friend = null;
        for (Person tmp : friends) {
            String user = tmp.getFirstName() + " " + tmp.getLastName();
            if (user.equals(name)) {
                friend = tmp;
            }
        }
        me.setBoolean(true);
        friend.setBoolean(true);
        chatMessage = toJSON(chatMessage, name);
        friend.setMessage(chatMessage);
        me.setMessage(chatMessage);
        return "";
    }

    private String toJSON(String message, String name) {
        StringBuffer json = new StringBuffer();

        json.append("{ \"message\" : \"");
        json.append(message);
//        json.append("\", \"name\" : \"");
//        json.append(name);
        json.append("\" }");

        return json.toString();
    }
}
