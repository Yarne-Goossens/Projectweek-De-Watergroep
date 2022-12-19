package util;

import java.util.Properties;

public class Secret extends Credentials {

    public static void setPass(Properties dbProperties) {
        dbProperties.setProperty("user", "hakkaton_02");
        dbProperties.setProperty("password", "Oveechaeto&tfM8o");
    }
}
