
package login;

import org.junit.Test;
import base.BaseTest;
import junit.framework.Assert;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import pages.DashboardPage;
import pages.LoginPage;

public class loginTests extends BaseTest {
    
     @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }   
    
    @Test
    public void testValidLogin (){
        LoginPage loginPage = new LoginPage (driver);
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();
        
        assertEquals("Url's doesn't match. ", expectedUrl, actualUrl);
        DashboardPage dashboardPage = new DashboardPage(driver);
        String expectedPanelHeadingText = "Dashboard";
        String actualPanelHeadingText = dashboardPage.getPanelHeadingText();
        assertTrue("Panel heading texts doesn't match.", expectedPanelHeadingText.equals(actualPanelHeadingText));
        
        dashboardPage.logout();
        driver.get("http://bvtest.school.cubes.rs/login");
    }
    
    @Test 
    public void testEmptyFieldsLogin () {
        LoginPage loginPage = new LoginPage (driver);
        loginPage.clickLoginButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match. ", expectedUrl, actualUrl);
        
        String expectedEmailMessage = "The email field is required.";
        String actualEmailMessage = loginPage.getEmailMessageText();
        Assert.assertTrue("Email message's doesn't match",expectedEmailMessage.equals(actualEmailMessage));
    }
    
    @Test
    public void testInvalidEmailInvalidPasswordLogin() {
        LoginPage loginPage = new LoginPage (driver);
        loginPage.enterEmailOfNonexistingUser();
        loginPage.enterPasswordOfNonexistingUser();
        loginPage.clickLoginButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match. ", expectedUrl, actualUrl);
        
        String expectedEmailMessage = "These credentials do not match our records.";
        String actualEmailMessage = loginPage.getEmailMessageText();
        Assert.assertTrue("Email message's doesn't match",expectedEmailMessage.equals(actualEmailMessage));
    }
    @Test
    public void testValidEmailInvalidPassword (){
        LoginPage loginPage = new LoginPage (driver);
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfNonexistingUser();
        loginPage.clickLoginButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match. ", expectedUrl, actualUrl);
        
        String expectedEmailMessage = "These credentials do not match our records.";
        String actualEmailMessage = loginPage.getEmailMessageText();
        Assert.assertTrue("Email message's doesn't match",expectedEmailMessage.equals(actualEmailMessage));
    }
    
    @Test
    public void testInvalidEmailValidPassword () {
        LoginPage loginPage = new LoginPage (driver);
        loginPage.enterEmailOfNonexistingUser();
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match. ", expectedUrl, actualUrl);
        
        String expectedEmailMessage = "These credentials do not match our records.";
        String actualEmailMessage = loginPage.getEmailMessageText();
        Assert.assertTrue("Email message's doesn't match",expectedEmailMessage.equals(actualEmailMessage));
    }
    @Test
    public void testCustomDataLogin(){
        LoginPage loginPage = new LoginPage (driver);
        loginPage.enterEmail("hello@nenad.rs");
        loginPage.enterPassword("123456");
        loginPage.clickLoginButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();
        assertEquals("Url's doesn't match. ", expectedUrl, actualUrl);
    }
    @Test
    public void testValidEmailEmptyPassword (){
        LoginPage loginPage = new LoginPage (driver);
        loginPage.enterEmailOfValidUser();
        loginPage.clickLoginButton();
        
        String expectedPasswordMessage = "The password field is required.";
        String actualPasswordMessage = loginPage.getPasswordMessageText();
        Assert.assertTrue("Password message's doesn't match" , expectedPasswordMessage.equals(actualPasswordMessage));
    }
}
