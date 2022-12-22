package ui.controller;

import domain.model.ServiceAssignment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewAssignment extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ServiceAssignment serviceAssignment = service.findServiceAssignmentWithId(id);
        request.setAttribute("newAssignment",serviceAssignment);
        return "newServiceAssigment.jsp";
    }
}
