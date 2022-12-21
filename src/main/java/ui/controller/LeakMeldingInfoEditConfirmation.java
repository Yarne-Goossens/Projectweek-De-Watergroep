package ui.controller;

import domain.model.LeakReport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class LeakMeldingInfoEditConfirmation extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();
        int id = Integer.parseInt(request.getParameter("id"));
        LeakReport leak = service.getLeakFromId(id);


        setCityRequest(leak,request,errors);
        setPostalRequest(leak,request,errors);
        setStreetRequest(leak,request,errors);
        setHouseNumberRequest(leak,request,errors);
        setCommentaryRequest(leak,request,errors);


        if (errors.size() == 0) {
            try {
                service.updateLeak(leak);
                response.sendRedirect("Controller?command=OverviewLeaks");
                return "Controller?command=OverviewLeaks";
            }
            catch (IllegalArgumentException | IOException exc) {
                request.setAttribute("error", exc.getMessage());
                request.setAttribute("editedLeak", leak);
                return "Controller?command=LeakMeldingInfoEditForm";
            }
        }
        else {
            request.setAttribute("errors", errors);
            request.setAttribute("editedLeak", leak);
            return "Controller?command=LeakMeldingInfoEditForm";
        }
    }

    private void setCityRequest(LeakReport leak, HttpServletRequest request, ArrayList<String> errors) {
        String city = request.getParameter("city");
        try {
            leak.setCity(city);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setHouseNumberRequest(LeakReport leak, HttpServletRequest request, ArrayList<String> errors) {
        String huisNummer = request.getParameter("houseNumber");
        try {
            leak.setHouseNumber(huisNummer);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setCommentaryRequest(LeakReport leak, HttpServletRequest request, ArrayList<String> errors) {
        String comment = request.getParameter("comment");
        try {
            leak.setComment(comment);
            request.setAttribute("commentaryPreviousValue", comment);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }

    }

    private void setPostalRequest(LeakReport leak, HttpServletRequest request, ArrayList<String> errors) {

        String stringPostcode = request.getParameter("postalCode");
        try {
            int postcode= Integer.parseInt(stringPostcode);
            leak.setPostalCode(postcode);
        }catch(NumberFormatException exc)  {
            errors.add("Post code is niet geldig");
        }
        catch (IllegalArgumentException  exc) {
            errors.add(exc.getMessage());
        }
    }

    private void setStreetRequest(LeakReport leak, HttpServletRequest request, ArrayList<String> errors) {
        String street = request.getParameter("street");
        try {
            leak.setStreet(street);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
        }
    }




}
















