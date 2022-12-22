package ui.controller;

import domain.model.AssignmentStatus;
import domain.model.ServiceAssignment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CancelAssignment extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ServiceAssignment serviceAssignmentWithId = service.findServiceAssignmentWithId(id);
        service.updateAssignmentStatus(serviceAssignmentWithId.getId(), AssignmentStatus.GEANNULEERD);
        response.sendRedirect("Controller?command=OverviewServiceAssignments");
        return "Controller?command=OverviewServiceAssignments";
    }
}
