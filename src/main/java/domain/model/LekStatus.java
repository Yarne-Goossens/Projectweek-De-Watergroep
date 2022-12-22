package domain.model;

public enum LekStatus {
     OPEN("Open"),VERWERKT("Verwerkt"), GEANNULEERD("Geannuleerd");

     private final String stringValue;

     LekStatus(String stringValue){this.stringValue = stringValue;}

    public String getStringValue(){return stringValue;}
}
