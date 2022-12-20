package domain.model;

public enum AssignmentType {
    LEKHERSTEL("Lek Herstel"), EVALUATIE("Evaluatie Ter Plaatse");

    private final String stringValue;

    AssignmentType(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue(){
        return stringValue;
    }
}
