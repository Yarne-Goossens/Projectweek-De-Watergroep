package ui.controller;

import domain.model.LeakReport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class LeakMeldingInfoEditConfirmation extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();
        LeakReport leak = new LeakReport();


        setCityRequest(leak,request,errors);
        setPostalRequest(leak,request,errors);
        setStreetRequest(leak,request,errors);
        setHouseNumberRequest(leak,request,errors);
        setCommentaryRequest(leak,request,errors);


        if (errors.size() == 0) {
            try {
                service.updateLeak(leak);
                return "Controller?command=Overview";
            }
            catch (IllegalArgumentException exc) {
                request.setAttribute("error", exc.getMessage());
                return "Controller?command=LeakMeldingInfoEditConfirmation";
            }
        }
        else {
            request.setAttribute("errors", errors);
            return "Controller?command=LeakMeldingInfoEditConfirmation";
        }
    }

    private void setCityRequest(LeakReport leak, HttpServletRequest request, ArrayList<String> errors) {
        String city = request.getParameter("plaats");
        try {
            leak.setCity(city);
            request.setAttribute("cityPreviousValue", city);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setHouseNumberRequest(LeakReport leak, HttpServletRequest request, ArrayList<String> errors) {
        String huisNummer = request.getParameter("huisNummer");
        try {
            leak.setHouseNumber(huisNummer);
            request.setAttribute("houseNumberPreviousValue", huisNummer);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setCommentaryRequest(LeakReport leak, HttpServletRequest request, ArrayList<String> errors) {
        String comment = request.getParameter("commentaar");
        try {
            leak.setComment(comment);
            request.setAttribute("commentaryPreviousValue", comment);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }

    }

    private void setPostalRequest(LeakReport leak, HttpServletRequest request, ArrayList<String> errors) {
        String regex = "^[0-9]";

        String stringPostcode =request.getParameter("postcode");
        try {
            int postcode= Integer.parseInt(stringPostcode);
            leak.setPostalCode(postcode);
            request.setAttribute("postalPreviousValue", postcode);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setStreetRequest(LeakReport leak, HttpServletRequest request, ArrayList<String> errors) {
        String street = request.getParameter("straat");
        try {
            leak.setStreet(street);
            request.setAttribute("streetPreviousValue", street);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }




}
















