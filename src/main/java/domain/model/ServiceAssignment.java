package domain.model;

import java.time.LocalDate;

public class ServiceAssignment {

    private int id;
    private String city;
    private int postalCode;
    private String street;
    private String houseNumber;
    private AssignmentType type;
    private LocalDate startDate;
    private LocalDate endDate;
    private String comment;

    private Employee technician;
    private AssignmentStatus status;

    public ServiceAssignment(int id, String city, int postalCode, String street, String houseNumber, AssignmentType type, LocalDate startDate, LocalDate endDate, String comment, Employee technician) {
        setId(id);
        setCity(city);
        setPostalCode(postalCode);
        setStreet(street);
        setHouseNumber(houseNumber);
        setType(type);
        setStartDate(startDate);
        setEndDate(endDate);
        setComment(comment);
        setTechnician(technician);
    }

    public ServiceAssignment(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public AssignmentType getType() {
        return type;
    }

    public void setType(AssignmentType type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Employee getTechnician() {
        return technician;
    }

    public void setTechnician(Employee technician) {
        this.technician = technician;
    }

    public AssignmentStatus getStatus() {
        return status;
    }

    public void setStatus(AssignmentStatus status) {
        this.status = status;
    }
}
