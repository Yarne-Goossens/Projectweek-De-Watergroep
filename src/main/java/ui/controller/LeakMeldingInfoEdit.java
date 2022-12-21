package ui.controller;

import domain.model.EmployeeType;
import domain.model.LeakReport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LeakMeldingInfoEdit extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Utility.checkRole(request, new EmployeeType[]{EmployeeType.KCC});
        int id = Integer.parseInt(request.getParameter("id"));
        LeakReport leak = service.getLeakFromId(id);
        request.setAttribute("editedLeak", leak);
        return "leakMeldingEdit.jsp";
    }
}
