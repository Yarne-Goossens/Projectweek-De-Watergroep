package ui.controller;

import domain.model.EmployeeType;
import domain.model.LeakReport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateServiceAssignmentForm extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        Utility.checkRole(request, new EmployeeType[]{EmployeeType.KCC,EmployeeType.TECHNICIAN});
        int id = Integer.parseInt(request.getParameter("id"));
        LeakReport leak = service.getLeakFromId(id);
        if (request.getAttribute("editedLeak") == null || request.getAttribute("editedLeak").equals("")){
            request.setAttribute("editedLeak", leak);
            request.setAttribute("plaatsPrevious",leak.getCity());
            request.setAttribute("postcodePrevious",leak.getPostalCode());
            request.setAttribute("straatPrevious",leak.getStreet());
            request.setAttribute("huisnrPrevious",leak.getHouseNumber());
            request.setAttribute("commentPrevious",leak.getComment());

        }
        request.setAttribute("serviceAssignments",service.getAllServiceAssignments());
        return "serviceAssignmentForm.jsp";

//        return "leakMeldingEdit.jsp";
    }
}
