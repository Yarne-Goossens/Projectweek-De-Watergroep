package ui.controller;

import domain.model.AssignmentType;
import domain.model.Email;
import domain.model.LeakReport;
import domain.model.ServiceAssignment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CloseAssignment extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ServiceAssignment serviceAssignmentWithId = service.findServiceAssignmentWithId(id);
        service.closeAssignment(serviceAssignmentWithId);
        List<LeakReport> leakReportList = service.getAllLeaksWithServiceAssignmentId(id);
        if (serviceAssignmentWithId.getType().equals(AssignmentType.LEKHERSTEL)){
            for (LeakReport leakReport: leakReportList){
                String emailOfReporter = leakReport.getEmail();
                Email email = new Email();
                email.setRecipient(emailOfReporter);
                String message = "Bedankt!" + "\n\n" + leakReport.getFirstName() + ", dankzij jouw melding is er water bespaard. \n" + "Onze technieker is ter plaatse geweest en heeft het lek hersteld. \n" + "Jouw melding helpt in de strijd tegen waterschaarste. \n" + "Want elke druppel telt!";
                email.setMessage(message);
                email.setSubject("Lek is opgelost");
                service.sendEmail(email);
            }
        }
        response.sendRedirect("Controller?command=OverviewServiceAssignments");
        return "Controller?command=OverviewServiceAssignments";
    }
}
