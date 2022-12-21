package ui.controller;

import com.beust.ah.A;
import domain.model.AssignmentType;
import domain.model.ServiceAssignment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class CreateServiceAssignment extends RequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<String> errors = new ArrayList<>();
        ServiceAssignment newAssignment = new ServiceAssignment();
        String idString = request.getParameter("id");
        setPlace(newAssignment, request, errors);
        setPostal(newAssignment, request, errors);
        setStreet(newAssignment, request, errors);
        setHuisnr(newAssignment, request, errors);
        setAssignmentType(newAssignment, request, errors);
        setComment(newAssignment, request, errors);
        setStartDate(newAssignment, request, errors);
        if (errors.size() == 0) {
            try {
                service.addServiceAssignment(newAssignment);
                return "Controller?command=OverviewServiceAssignments";
            } catch (Exception e) {
                errors.add(e.getMessage());
            }
        }
        request.setAttribute("errors", errors);
        return "Controller?command=CreateServiceAssignmentForm&id="+idString;
    }


    public void setPlace(ServiceAssignment serviceAssignment, HttpServletRequest request, ArrayList<String> errors){
        String place = request.getParameter("plaats");
        try{
            serviceAssignment.setCity(place);
            request.setAttribute("placePrevious", place);
        }
        catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
    }

    public void setPostal(ServiceAssignment serviceAssignment, HttpServletRequest request, ArrayList<String> errors){
        String postalString = request.getParameter("postcode");
        try{
            int postal=Integer.parseInt(postalString);
            serviceAssignment.setPostalCode(postal);
            request.setAttribute("postalPrevious", postal);
        }
        catch (Exception e){
            errors.add(e.getMessage());
        }
    }

    public void setStreet(ServiceAssignment serviceAssignment, HttpServletRequest request, ArrayList<String> errors){
        String street = request.getParameter("straat");
        try{
            serviceAssignment.setStreet(street);
            request.setAttribute("streetPrevious", street);
        }
        catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
    }

    public void setHuisnr(ServiceAssignment serviceAssignment, HttpServletRequest request, ArrayList<String> errors){
        String nr = request.getParameter("huisnr");
        try{
            serviceAssignment.setHouseNumber(nr);
            request.setAttribute("nrPrevious", nr);
        }
        catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
    }

    public void setAssignmentType(ServiceAssignment serviceAssignment, HttpServletRequest request, ArrayList<String> errors){
        String typeString = request.getParameter("type");
        try{
            AssignmentType type = AssignmentType.valueOf(typeString);
            serviceAssignment.setType(type);
            request.setAttribute("typePrevious", typeString);
        }
        catch (Exception e){
            errors.add(e.getMessage());
        }
    }

    public void setComment(ServiceAssignment serviceAssignment, HttpServletRequest request, ArrayList<String> errors){
        String comment = request.getParameter("comment");
        try{
            serviceAssignment.setComment(comment);
            request.setAttribute("commentPrevious", comment);
        }
        catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
    }

    public void setStartDate(ServiceAssignment serviceAssignment, HttpServletRequest request, ArrayList<String> errors){
        LocalDate startDate = LocalDate.now();
        try{
            serviceAssignment.setStartDate(startDate);
        }
        catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }
    }
}
