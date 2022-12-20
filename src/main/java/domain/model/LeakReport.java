package domain.model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class LeakReport {
    private int id,postalCode,houseNumber;
    private String firstName,lastName,email,city,street,comment;

    public LeakReport(int id, int postalCode, int houseNumber, String firstName, String lastName, String email, String city, String street) {
        this.id = id;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.street = street;
    }

    public LeakReport() {
    }

    public int getId() {
        return id;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    //Setters with Request processing

    private void setName(Animal animal, HttpServletRequest request, ArrayList<String> errors) {
        String name = request.getParameter("name");
        try {
            animal.setName(name);
            request.setAttribute("nameClass", "has-success");
            request.setAttribute("namePreviousValue", name);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("nameClass", "has-error");
        }
    }

    private void setType(Animal animal, HttpServletRequest request, ArrayList<String> errors) {
        String type = request.getParameter("type");
        try {
            animal.setType(type);
            request.setAttribute("typeClass", "has-success");
            request.setAttribute("typePreviousValue", type);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("typeClass", "has-error");
        }
    }

    private void setFood(Animal animal, HttpServletRequest request, ArrayList<String> errors) {
        int food;
        if(request.getParameter("food").isBlank()) {
            food = -1;
        } else {
            food = Integer.parseInt(request.getParameter("food"));
        }
        try {
            animal.setFood(food);
            request.setAttribute("foodClass", "has-success");
            request.setAttribute("foodPreviousValue", food);
        }
        catch (IllegalArgumentException exc) {
            errors.add(exc.getMessage());
            request.setAttribute("foodClass", "has-error");
        }
    }
}
