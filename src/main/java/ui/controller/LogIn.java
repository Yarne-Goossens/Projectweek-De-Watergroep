package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogIn extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            if (service.findUserWithEmail(email).isCorrectPassword(password)) {
                request.getSession().setAttribute("user", service.findUserWithEmail(email));
                return "index.jsp";
            }
        } catch (Exception e) {
            request.setAttribute("errors", "E-mail of paswoord is niet correct");
        }
        return "login.jsp";
    }
}