package ui.controller;

import domain.model.Email;
import domain.model.EmployeeType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SendEmail extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Utility.checkRole(request, new EmployeeType[]{EmployeeType.TECHNICIAN});
        ArrayList<String> errors = new ArrayList<>();
        Email email = new Email();
        setRecipient(email, request, errors);
        setSubject(email, request, errors);
        setMessage(email,request, errors);

        if (errors.size() == 0) {
            try {
                service.sendEmail(email);
                request.setAttribute("email","true");
                response.sendRedirect("Controller?command=SendEmailForm&email=true");
                return "Controller?command=SendEmailForm";
            }
            catch (IllegalArgumentException  | IOException exc) {
                request.setAttribute("error", exc.getMessage());
                return "Controller?command=SendEmailForm";
            }
        }
        else {
            request.setAttribute("errors", errors);
            return "Controller?command=SendEmailForm";
        }
    }



    private void setRecipient(Email email, HttpServletRequest request, ArrayList<String> errors) {
        String recipient = request.getParameter("recipient");
        try {
            email.setRecipient(recipient);
            request.setAttribute("recipientPreviousValue", recipient);

        }
        catch (IllegalArgumentException exc) {
            request.setAttribute("recipientPreviousValue", recipient);

            errors.add(exc.getMessage());
        }
    }

    private void setSubject(Email email, HttpServletRequest request, ArrayList<String> errors) {
        String subject = request.getParameter("subject");
        try {
            email.setSubject(subject);
            request.setAttribute("subjectPreviousValue", subject);

        }
        catch (IllegalArgumentException exc) {
            request.setAttribute("subjectPreviousValue", subject);
            errors.add(exc.getMessage());
        }
    }

    private void setMessage(Email email, HttpServletRequest request, ArrayList<String> errors) {
        String message = request.getParameter("message");
        try {
            email.setMessage(message);
            request.setAttribute("messagePreviousValue", message);
        }
        catch (IllegalArgumentException exc) {
            request.setAttribute("messagePreviousValue", message);
            errors.add(exc.getMessage());
        }
    }


}
