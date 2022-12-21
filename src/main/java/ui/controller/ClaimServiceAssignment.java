package ui.controller;

import domain.model.AssignmentType;
import domain.model.Employee;
import domain.model.EmployeeType;
import domain.model.ServiceAssignment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ClaimServiceAssignment extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Utility.checkRole(request, new EmployeeType[]{EmployeeType.TECHNICIAN});
        Employee employee = (Employee) request.getSession().getAttribute("user");
        ArrayList<String> errors = new ArrayList<>();
        if (employee != null) {
            int serviceId = Integer.parseInt(request.getParameter("claimId"));
            ServiceAssignment serviceAssignment = service.findServiceAssignmentWithId(serviceId);
            serviceAssignment.setTechnician(employee);
            service.updateServiceAssignment(serviceAssignment);
            response.sendRedirect("Controller?command=OverviewServiceAssignments");
        } else {
            errors.add("U moet ingelogd zijn om een Service Opdracht te kunnen opnemen!");
        }
        request.setAttribute("errors",errors);
        return "Controller?command=OverviewServiceAssignments";
    }
}
