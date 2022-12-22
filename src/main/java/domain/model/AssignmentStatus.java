package domain.model;

public enum AssignmentStatus {
    NIETOPGENOMEN("Niet Opgenomen"), OPGENOMEN("Opgenomen"), WORDTHERSTELD("Wordt Hersteld"), AFGEROND("Is Afgerond") ,GEANNULEERD("Geannuleerd");

    private final String stringValue;

    AssignmentStatus(String stringValue){this.stringValue=stringValue;}

    public String getStringValue() {return stringValue;}
}
