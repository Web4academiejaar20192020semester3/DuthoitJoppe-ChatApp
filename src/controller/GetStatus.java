package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetStatus extends AsyncRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person person = (Person) request.getSession().getAttribute("user");
        String status = person.getStatus();
        String statusJSON = this.toJSON(status);
        return statusJSON;
    }

    private String toJSON(String status) {
        StringBuffer json = new StringBuffer();

        json.append("{ \"status\" : \"");
        json.append(status);
        json.append("\"}");

        return json.toString();
    }
}
