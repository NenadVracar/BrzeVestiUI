import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import framework.Helper;

public class FirstJUnitTest {
        private static WebDriver driver;
        public FirstJUnitTest() {
    }
    @BeforeClass
    public static void setUpClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://bvtest.school.cubes.rs/login");
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("qa@cubes.rs");
        
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("cubesqa");
        
        WebElement loginButton = driver.findElement(By.className("btn-primary"));
        loginButton.click();
    }
        @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }
        @Before
    public void setUp() {
    }
        @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {}
    
    @Test
    public void testLogin (){
        
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();
        
        assertEquals("Url's doesn't match. ", expectedUrl, actualUrl);
    }
    @Test
    public void testAddNewCategory () {
                        
        WebElement categoriesLink = driver.findElement(By.linkText("Categories"));
        categoriesLink.click();
        
        WebElement addCategoryLink = driver.findElement(By.className("pull-right"));
        addCategoryLink.click();
        
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.sendKeys(Helper.getRandomText());
         
        WebElement saveButton = driver.findElement(By.id("save-category-button"));
        saveButton.click();
        
        WebElement alertMessage = driver.findElement(By.className("alert-success"));
        System.out.println("alert message is: " + alertMessage.getText());
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        
        assertEquals("Url's doesn't match",expectedUrl, actualUrl);
        
        String expectedMessageSnippet = "Nenad-";
        WebElement alertMessageElement = driver.findElement(By.className("alert-success"));
        String alertMessageText = alertMessageElement.getText();
        
        assertTrue("Test failed. Alert message doesn't contain expected string.",alertMessage.getText().contains(expectedMessageSnippet));
        
        
        
    }
}
