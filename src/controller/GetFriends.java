package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetFriends extends AsyncRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person person = (Person) request.getSession().getAttribute("user");
        List<Person> friends = person.getFriends();
        String friendsJSON = toJSON(friends);
        return friendsJSON;
    }

    private String toJSON(List<Person> friends) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        for (Person p : friends) {
            json.append("{ \"name\" : \"");
            json.append(p.getFirstName());
            json.append(" ");
            json.append(p.getLastName());
            json.append("\", \"status\" : \"");
            json.append(p.getStatus());
            json.append("\" }, ");
        }
        json.deleteCharAt(json.length() - 1);
        json.deleteCharAt(json.length() - 1);
        json.append("]");

        return json.toString();
    }
}

