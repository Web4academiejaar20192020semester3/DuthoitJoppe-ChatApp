package controller;

import domain.Person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetUsersAngular extends AsyncRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        List<Person> persons = getPersonService().getPersons();
        String users = toJSON(persons);
        return users;
    }

    private String toJSON(List<Person> persons) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        for (Person p : persons) {
            json.append("{ \"voornaam\" : \"");
            json.append(p.getFirstName());
            json.append("\", \"naam\" : \"");
            json.append(p.getLastName());
            json.append("\", \"email\" : \"");
            json.append(p.getUserId());
            json.append("\", \"geslacht\" : \"");
            json.append(p.getGelacht());
            json.append("\", \"leeftijd\" : \"");
            json.append(p.getLeeftijd());
            json.append("\" }, ");
        }
        json.deleteCharAt(json.length() - 1);
        json.deleteCharAt(json.length() - 1);
        json.append("]");

        return json.toString();
    }
}
