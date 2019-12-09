package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ChangeStatus extends AsyncRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person person = (Person) request.getSession().getAttribute("user");
        String status = request.getParameter("status");
        person.setStatus(status);
        return "";
    }
}
