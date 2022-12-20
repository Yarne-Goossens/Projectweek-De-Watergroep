package domain.model;

public enum EmployeeType {
    KCC("Klant Contact Centrum"), TECHNICIAN("Technieker"), MONITOR("Leiding Monitor");

    private final String stringValue;

    EmployeeType(String stringValue){
        this.stringValue=stringValue;
    }

    public String getStringValue(){
        return this.stringValue;
    }
}
