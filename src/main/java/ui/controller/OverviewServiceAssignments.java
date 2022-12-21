package ui.controller;

import domain.model.Employee;
import domain.model.EmployeeType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OverviewServiceAssignments extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Utility.checkRole(request, new EmployeeType[]{EmployeeType.KCC,EmployeeType.TECHNICIAN});
        request.setAttribute("serviceAssignments",service.getAllServiceAssignments());
        return "serviceAssignmentOverview.jsp";
    }
}
