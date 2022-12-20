package domain.model;

public class Leak {
    private String firstname ,lastname,email, city, houseNumber , street ,comment;
    private int id, postal;


    public Leak(int id, String firstname, String lastname, String email, String city, String houseNumber, String street, String comment, int postal) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.city = city;
        this.houseNumber = houseNumber;
        this.street = street;
        this.comment = comment;
        this.postal = postal;
    }


    public Leak(){

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        if(this.firstname != null) {
            throw new IllegalArgumentException("Voornaam mag niet veranderd worden");
        }
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        if(this.lastname != null){
            throw new IllegalArgumentException("Achternaam  mag niet veranderd worden");
        }
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(this.email != null){
            throw new IllegalArgumentException("Email mag niet veranderd worden");
        }
        this.email = email;

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if(city.isBlank()){
            throw new IllegalArgumentException("Stad mag niet leeg zijn");
        }
        this.city = city;
    }

    public String getHouseNumber() {

        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        if(houseNumber.isBlank()){
            throw new IllegalArgumentException("Huis nummer mag niet leeg zijn");
        }
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPostal() {
        return postal;
    }

    public void setPostal(int postal) {
        if(postal < 1000 || postal > 9999){
            throw new IllegalArgumentException("Post code moet tussen 1000 en 9999");
        }
        this.postal = postal;
    }


    public String tostring(){
        return "Naam " + lastname + " " + firstname + "/n" + "Address" + street + " " + houseNumber +", " +city +" " + postal ;
    }
}

