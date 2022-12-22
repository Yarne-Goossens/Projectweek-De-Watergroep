package ui.controller;

import domain.model.AssignmentType;
import domain.model.Employee;
import domain.model.LeakReport;
import domain.model.ServiceAssignment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class HandleNewAssignment extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<String> errors = new ArrayList<>();
        ServiceAssignment newAssignment = new ServiceAssignment();
        int id = Integer.parseInt(request.getParameter("id"));

        setCity(newAssignment, request, errors);
        setPostal(newAssignment, request, errors);
        setStreet(newAssignment, request, errors);
        setHouseNumber(newAssignment, request, errors);
        setAssignmentType(newAssignment, request, errors);
        setComment(newAssignment, request, errors);
        newAssignment.setStartDate(LocalDate.now());
        newAssignment.setServiceOpdrachtID(id);
        Employee user = (Employee) request.getSession().getAttribute("user");
        if (errors.size() == 0) {
            try {
                service.addServiceAssignmentWithoutTechnician(newAssignment);
                return "Controller?command=OverviewServiceAssignments";

            } catch (Exception e) {
                errors.add(e.getMessage());
                request.setAttribute("errors", errors);
                return "Controller?command=NewAssignment";
            }
        }else {
            request.setAttribute("errors", errors);
            return "Controller?command=NewAssignment";
        }
    }


    private void setCity(ServiceAssignment serviceAssignment, HttpServletRequest request, ArrayList<String> errors) {
        String place = request.getParameter("city");
        try {
            serviceAssignment.setCity(place);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }

    private void setPostal(ServiceAssignment serviceAssignment, HttpServletRequest request, ArrayList<String> errors) {
        try {
            int p = Integer.parseInt(request.getParameter("postal"));
            serviceAssignment.setPostalCode(p);
        } catch (NumberFormatException e) {
            errors.add("Geen geldig postcode");
        }catch (IllegalArgumentException e ){
            errors.add(e.getMessage());
        }
    }

    private void setStreet(ServiceAssignment serviceAssignment, HttpServletRequest request, ArrayList<String> errors) {
        String street = request.getParameter("street");
        try {
            serviceAssignment.setStreet(street);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }

    private void setHouseNumber(ServiceAssignment serviceAssignment, HttpServletRequest request, ArrayList<String> errors) {
        String nr = request.getParameter("houseNumber");
        try {
            serviceAssignment.setHouseNumber(nr);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }

    private void setAssignmentType(ServiceAssignment serviceAssignment, HttpServletRequest request, ArrayList<String> errors) {
        String typeString = request.getParameter("type");
        try {
            AssignmentType type = AssignmentType.valueOf(typeString);
            serviceAssignment.setType(type);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    private void setComment(ServiceAssignment serviceAssignment, HttpServletRequest request, ArrayList<String> errors) {
        String comment = request.getParameter("comment");
        try {
            serviceAssignment.setComment(comment);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }



}
