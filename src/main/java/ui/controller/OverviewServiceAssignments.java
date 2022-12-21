package ui.controller;

import domain.model.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OverviewServiceAssignments extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("serviceAssignments",service.getAllServiceAssignments());
        return "serviceAssignmentOverview.jsp";
    }
}
