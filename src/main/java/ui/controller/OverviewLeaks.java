package ui.controller;

import domain.model.EmployeeType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OverviewLeaks extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Utility.checkRole(request, new EmployeeType[]{EmployeeType.KCC});
        request.setAttribute("leaks",service.getAllLeaks());
        return "overviewLeaks.jsp";
    }
}
