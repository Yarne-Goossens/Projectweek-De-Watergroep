package ui.controller;

import domain.model.Employee;
import domain.model.EmployeeType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogIn extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Employee user =(Employee) request.getSession().getAttribute("user");
        if(user != null){
            throw new NotAuthorizedException();
        }
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            Employee employee = service.findEmployeeWithEmail(email);
            if (employee.isCorrectPassword(password)) {
                request.getSession().setAttribute("user", employee);
                return "index.jsp";
            }
        } catch (Exception e) {
            request.setAttribute("errors", "E-mail of paswoord is niet correct");
        }
        return "login.jsp";
    }
}