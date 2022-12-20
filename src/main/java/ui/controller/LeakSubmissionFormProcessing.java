package ui.controller;

import domain.model.LeakReport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class LeakSubmissionFormProcessing extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();
        LeakReport newLeak = new LeakReport();

        newLeak.setFirstNameRequest(newLeak,request,errors);
        newLeak.setLastNameRequest(newLeak,request,errors);
        newLeak.setEmailRequest(newLeak,request,errors);
        newLeak.setCityRequest(newLeak,request,errors);
        newLeak.setPostalRequest(newLeak,request,errors);
        newLeak.setStreetRequest(newLeak,request,errors);
        newLeak.setHouseNumberRequest(newLeak,request,errors);
        newLeak.setCommentaryRequest(newLeak,request,errors);


        if (errors.size() == 0) {
            try {
                service.addLeakReport(newLeak);
                HttpSession session = request.getSession();
                session.setAttribute("lastAddedLeak", newLeak);
                return "Controller?command=Overview";
            }
            catch (IllegalArgumentException exc) {
                request.setAttribute("error", exc.getMessage());
                return "Controller?command=LeakSubmissionForm";
            }
        }
        else {
            request.setAttribute("errors", errors);
            return "Controller?command=LeakSubmissionForm";
        }
    }
}
