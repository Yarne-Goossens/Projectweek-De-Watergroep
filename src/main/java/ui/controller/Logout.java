package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        try {
            HttpSession session = request.getSession();
            session.setAttribute("user", null);
            response.sendRedirect("Controller?command=Home");
            return "Controller?command=Home";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
