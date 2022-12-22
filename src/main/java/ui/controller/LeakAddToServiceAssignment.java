package ui.controller;

import domain.model.EmployeeType;
import domain.model.LeakReport;
import domain.model.ServiceAssignment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LeakAddToServiceAssignment extends RequestHandler{
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Utility.checkRole(request, new EmployeeType[]{EmployeeType.KCC,EmployeeType.TECHNICIAN});
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));
        int leakId = Integer.parseInt(request.getParameter("leakId"));
        LeakReport leak = service.getLeakFromId(leakId);
        leak.setAssignmentId(serviceId);
        service.updateLeak(leak);

        return "Controller?command=OverviewServiceAssignments";
    }
}
