package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetMessage extends AsyncRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person person = (Person) request.getSession().getAttribute("user");
        String message = "";
        if (person.getBoolean()) {
            message = person.getMessage();
            person.setBoolean(false);
        }
        return message;
    }
}

