package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PersonService;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PersonService model = new PersonService();
    private ControllerFactory controllerFactory = new ControllerFactory();

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String destination = "index.jsp";
        RequestHandler handler = null;
        if (action != null) {
            try {
                handler = controllerFactory.getController(action, model);
                destination = handler.handleRequest(request, response);
            } catch (NotAuthorizedException exc) {
                List<String> errors = new ArrayList<String>();
                errors.add(exc.getMessage());
                request.setAttribute("errors", errors);
                destination = "index.jsp";
            }
//            RequestDispatcher view = request.getRequestDispatcher(destination);
//            view.forward(request, response);
        }
//        if (destination !=null) {
//			view.forward(request, response);
//		}
        if (handler instanceof AsyncRequestHandler) {
            response.setContentType("application/json");
            response.getWriter().write(destination);
        } else {
            RequestDispatcher view = request.getRequestDispatcher(destination);
            view.forward(request, response);
        }
    }

//    protected void doOptions(HttpServletRequest request,
//                             HttpServletResponse response) throws ServletException, IOException {
//
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT");
//        response.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
//        processRequest(request, response);
//    }
}
