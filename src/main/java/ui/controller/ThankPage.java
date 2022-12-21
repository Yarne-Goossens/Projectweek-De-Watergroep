package ui.controller;

import domain.model.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ThankPage extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Employee user =(Employee) request.getSession().getAttribute("user");
        if(user != null){
            throw new NotAuthorizedException();
        }
        return "thankPage.jsp";
    }
}
