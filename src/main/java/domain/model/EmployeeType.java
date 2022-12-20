package domain.model;

public enum EmployeeType {
    KCC("Klant Contactcentrum"), TECHNICIAN("Technieker");

    private final String stringValue;

    EmployeeType(String stringValue){
        this.stringValue=stringValue;
    }

    public String getStringValue(){
        return this.stringValue;
    }
}
