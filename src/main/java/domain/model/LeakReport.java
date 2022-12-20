package domain.model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Override
    public String toString() {
        return "LeakReport{" +
                "id=" + id +
                ", postalCode=" + postalCode +
                ", houseNumber=" + houseNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", comment='" + comment + '\'' +
                '}';
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
        if(String.valueOf(postalCode).length()!=4){
            throw new IllegalArgumentException("Postcode is niet geldig");
        }
        this.postalCode = postalCode;
    }

    public void setHouseNumber(int houseNumber) {
        if(houseNumber<=0){
            throw new IllegalArgumentException("Vul een juist huisnummer in.");
        }
        this.houseNumber = houseNumber;
    }

    public void setFirstName(String firstName) {
        if(firstName.isEmpty()){
            throw new IllegalArgumentException("Vul een voornaam in.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(lastName.isEmpty()){
            throw new IllegalArgumentException("Vul een achternaam in.");
        }
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        if (email.isEmpty()) {
            throw new IllegalArgumentException("No email given");
        }
        String USERID_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern p = Pattern.compile(USERID_PATTERN);
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            throw new IllegalArgumentException("Geef een geldige email in.");
        }
        this.email = email;
    }

    public void setCity(String city) {
        if(city.isEmpty()){
            throw new IllegalArgumentException("Vul een juiste plaats in.");
        }
        this.city = city;
    }

    public void setStreet(String street) {
        if(street.isEmpty()){
            throw new IllegalArgumentException("Vul een juiste straat in.");
        }
        this.street = street;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

        String regex = "^[0-9]";

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

        String stringPostcode =request.getParameter("HuisNummer");
        String regex = "^[0-9]";
        try {
            if(stringPostcode.isEmpty()){
                throw new IllegalArgumentException("Vul een huisnummer in.");
            }
            if(! stringPostcode.matches(regex)){
                throw new IllegalArgumentException("Vul een juist huisnummer in.");
            }
            int houseNumber= Integer.parseInt(stringPostcode);
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