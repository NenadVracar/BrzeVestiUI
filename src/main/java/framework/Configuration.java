package framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    
    public static String chromeDriverPath;
    public static String validAdminUserEmail;
    public static String validAdminUserPassword;
    
    public static void intit() throws FileNotFoundException, IOException{
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("env.properties");
        properties.load(fis);
        chromeDriverPath = properties.getProperty("chromeDriverPath");
        validAdminUserEmail = properties.getProperty("validAdminUserEmail");
        validAdminUserPassword = properties.getProperty("validAdminUserPassword");
    }
    
}
