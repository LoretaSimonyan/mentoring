package utils;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@Getter
public class PropertiesReader  {
    FileReader reader ;
    private String userEmail;
    private String userPassword;
    private String otherUserEmail;

    Properties properties;

    public PropertiesReader()  {
        readUserProperties();
    }

    @SneakyThrows
    private void readUserProperties() {
        reader = new FileReader("src/main/resources/user.properities");
        properties = new Properties();
        properties.load(reader);
        userEmail= properties.getProperty("USER_EMAIL");
        userPassword= properties.getProperty("USER_PASSWORD");
        otherUserEmail = properties.getProperty("OTHER_USER_EMAIL");
    }
}
