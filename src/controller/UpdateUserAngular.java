package controller;

import domain.Person;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserAngular extends AsyncRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String geslacht= request.getParameter("geslacht");
        int leeftijd = Integer.parseInt(request.getParameter("leeftijd"));

        List<Person> persons = getPersonService().getPersons();
        for (Person tmp : persons) {
            if (tmp.getUserId().equals(email)) {
                tmp.setFirstName(firstName);
                tmp.setLastName(lastName);
                tmp.setUserId(email);
                tmp.setGelacht(geslacht);
                tmp.setLeeftijd(leeftijd);
            }
        }
        return null;
    }
}
