package domain.model;

public enum LeakStatus {
     OPEN("Open"),VERWERKT("Verwerkt"), GEANNULEERD("Geannuleerd");

     private final String stringValue;

     LeakStatus(String stringValue){this.stringValue = stringValue;}

    public String getStringValue(){return stringValue;}
}
