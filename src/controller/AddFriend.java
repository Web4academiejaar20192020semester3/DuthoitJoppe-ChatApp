package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddFriend extends AsyncRequestHandler {

    //tis af
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person person = (Person) request.getSession().getAttribute("user");
        String email = request.getParameter("friend");
        Person friend = getPersonService().getPerson(email);
        boolean t = true;
        for (Person tmp : person.getFriends()) {
            if (tmp.getUserId().equals(friend.getUserId())) {
                t = false;
            }
        }
        if (t) {
            person.addFriend(friend);
            friend.addFriend(person);
        }
        return "";
    }
}
