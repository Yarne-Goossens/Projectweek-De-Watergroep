package ui.controller;

import domain.model.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInPage extends RequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Employee user =(Employee) request.getSession().getAttribute("user");
        if(user != null){
            throw new NotAuthorizedException();
        }
        return "login.jsp";
    }
}
