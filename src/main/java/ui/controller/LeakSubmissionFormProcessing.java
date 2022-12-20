package ui.controller;

import domain.model.LeakReport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class LeakSubmissionFormProcessing extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();
        LeakReport newLeak = new LeakReport();

        setFirstNameRequest(newLeak,request,errors);
        setLastNameRequest(newLeak,request,errors);
        setEmailRequest(newLeak,request,errors);
        setCityRequest(newLeak,request,errors);
        setPostalRequest(newLeak,request,errors);
        setStreetRequest(newLeak,request,errors);
        setHouseNumberRequest(newLeak,request,errors);
        setCommentaryRequest(newLeak,request,errors);

        if (errors.size() == 0) {
            try {
                service.addLeakReport(newLeak);
                HttpSession session = request.getSession();
                session.setAttribute("lastAddedLeak", newLeak);

                response.sendRedirect("Controller?command=OverviewLeaks");
                return "Controller?command=OverviewLeaks";
            }
            catch (IllegalArgumentException | IOException exc) {
                request.setAttribute("error", exc.getMessage());
                return "Controller?command=LeakSubmissionForm";
            }
        }
        else {
            request.setAttribute("errors", errors);
            return "Controller?command=LeakSubmissionForm";
        }
    }

    //Setters with Request processing

    public void setFirstNameRequest(LeakReport leakReport, HttpServletRequest request, ArrayList<String> errors) {
        String name = request.getParameter("naam");
        try {
            leakReport.setFirstName(name);
            request.setAttribute("firstNamePreviousValue", name);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    public void setLastNameRequest(LeakReport leakReport, HttpServletRequest request, ArrayList<String> errors) {
        String type = request.getParameter("voornaam");
        try {
            leakReport.setLastName(type);
            request.setAttribute("lastNamePreviousValue", type);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }
    public void setEmailRequest(LeakReport leakReport, HttpServletRequest request, ArrayList<String> errors) {
        String type = request.getParameter("email");
        try {
            leakReport.setEmail(type);
            request.setAttribute("emailPreviousValue", type);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    public void setCityRequest(LeakReport leakReport, HttpServletRequest request, ArrayList<String> errors) {
        String type = request.getParameter("Plaats");
        try {
            leakReport.setCity(type);
            request.setAttribute("cityPreviousValue", type);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    public void setPostalRequest(LeakReport leakReport, HttpServletRequest request, ArrayList<String> errors) {
        String regex = "^[0-9]+";

        String stringPostcode =request.getParameter("Postcode");
        try {
            if(stringPostcode.isEmpty()){
                throw new IllegalArgumentException("Vul een postcode in.");
            }
            if(! stringPostcode.matches(regex)){
                throw new IllegalArgumentException("Vul een juiste postcode in.");
            }

            int postcode= Integer.parseInt(stringPostcode);
            leakReport.setPostalCode(postcode);
            request.setAttribute("postalPreviousValue", postcode);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    public void setStreetRequest(LeakReport leakReport, HttpServletRequest request, ArrayList<String> errors) {
        String type = request.getParameter("Straat");
        try {
            leakReport.setStreet(type);
            request.setAttribute("streetPreviousValue", type);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    public void setHouseNumberRequest(LeakReport leakReport, HttpServletRequest request, ArrayList<String> errors) {

        String houseNumber =request.getParameter("HuisNummer");
        try {
            if(houseNumber.isEmpty()){
                throw new IllegalArgumentException("Vul een huisnummer in.");
            }
            leakReport.setHouseNumber(houseNumber);
            request.setAttribute("houseNumberPreviousValue", houseNumber);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    public void setCommentaryRequest(LeakReport leakReport, HttpServletRequest request, ArrayList<String> errors) {
        String type = request.getParameter("Commentaar");
        try {
            leakReport.setComment(type);
            request.setAttribute("commentaryPreviousValue", type);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }
}
