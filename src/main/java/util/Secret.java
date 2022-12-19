package util;

import java.util.Properties;

public class Secret extends Credentials {

    public static void setPass(Properties dbProperties) {
        dbProperties.setProperty("user", "hakkaton_00");
        dbProperties.setProperty("password", "yourverysecretpasswordhere");
    }
}
