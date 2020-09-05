package base;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import framework.Configuration;
import java.io.IOException;


public class BaseTest {
    protected static WebDriver driver;   
   
    @BeforeClass
    public static void setUpClass() throws IOException {
        Configuration.intit();
        System.setProperty("webdriver.chrome.driver", Configuration.chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://bvtest.school.cubes.rs/login");
    }
    
    @AfterClass
    public static void tearDownClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    
}
