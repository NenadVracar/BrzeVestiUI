
package pages;

import framework.Configuration;
import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    private WebDriver driver;
    private final By emailFieldLocator = By.name("email");
    private final By passwordFieldLocator = By.name("password");
    private final By rememberMeCheckboxLocator = By.name("remember");
    private final By loginButtonLocator = By.className("btn-primary");
    private final By emailMessageLocator = By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/div[1]/div/span/strong");
    private final By passwordMessageLocator = By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/div[2]/div/span/strong");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
       
    public void enterEmailOfValidUser() {
        driver.findElement(emailFieldLocator).sendKeys(Configuration.validAdminUserEmail);
    }
    public void enterEmailOfNonexistingUser(){
        driver.findElement(emailFieldLocator).sendKeys(Helper.getRandomEmail());
    }
    public void enterEmail (String email) {
        driver.findElement(emailFieldLocator).sendKeys(email);
    }
    public void enterPasswordOfValidUser() {
        driver.findElement(passwordFieldLocator).sendKeys(Configuration.validAdminUserPassword);
    }
    
    public void enterPasswordOfNonexistingUser() {
        driver.findElement(passwordFieldLocator).sendKeys(Helper.getRandomText());
    }
    public void enterPassword (String password){
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }
    public void clickOnRememberMe(){
        driver.findElement(rememberMeCheckboxLocator).click();
    }
    public void clickLoginButton () {
        driver.findElement(loginButtonLocator).click();
    }
    
    public String getEmailMessageText(){
        return driver.findElement(emailMessageLocator).getText();
    }
    public String getPasswordMessageText(){
        return driver.findElement(passwordMessageLocator).getText();
    }
}
