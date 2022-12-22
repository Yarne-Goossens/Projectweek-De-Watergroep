package ui.controller;

import domain.model.Employee;
import domain.model.EmployeeType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ThankPage extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (Utility.hasRole(request,new EmployeeType[]{EmployeeType.KCC})) {
            throw new NotAuthorizedException();
        }
        return "thankPage.jsp";
    }
}
