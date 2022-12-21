package ui.controller;

import domain.model.ServiceAssignment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CloseService extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ServiceAssignment serviceAssignmentWithId = service.findServiceAssignmentWithId(id);
        service.closeAssignment(serviceAssignmentWithId);

        request.setAttribute("serviceAssignments",service.getAllServiceAssignments());
        response.sendRedirect("serviceAssignmentOverview.jsp");
        return "serviceAssignmentOverview.jsp";
    }
}
