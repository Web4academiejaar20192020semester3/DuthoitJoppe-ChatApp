package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class CreateAccount extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String destination = "index.jsp";
        List<String> errors = new ArrayList<String>();

        String firstName = request.getParameter("firstName");
        if (firstName == null || firstName.isEmpty()) {
            errors.add("No first name given");
        }

        String lastName = request.getParameter("lastName");
        if (lastName == null || lastName.isEmpty()) {
            errors.add("No last name given");
        }

        String geslacht = request.getParameter("geslacht");
        if (geslacht == null || geslacht.isEmpty()) {
            errors.add("No gender given");
        }

        String email = request.getParameter("cEmail");
        if (email == null || email.isEmpty()) {
            errors.add("No email given");
        }

        String password = request.getParameter("cPassword");
        String rpassword = request.getParameter("rPassword");
        if (password == null || password.isEmpty()) {
            errors.add("No password given");
        } else if (!password.equals(rpassword)) {
            errors.add("Password not the same");
        }

        String tmp = request.getParameter("age");
        int leeftijd = 0;
        if (tmp == null || tmp.isEmpty()) {
            errors.add("No email given");
        } else {
            leeftijd = Integer.parseInt(tmp);
        }

        if (errors.size() == 0) {
            PersonService personService = super.getPersonService();
            Person person = personService.getAuthenticatedUser(email, password);
            if (person == null) {
                Person user = new Person(firstName, lastName, email, geslacht, password, leeftijd);
                personService.addPerson(user);
            } else {
                errors.add("User already exists");
            }
        }

        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
        }

        return destination;
    }
}
