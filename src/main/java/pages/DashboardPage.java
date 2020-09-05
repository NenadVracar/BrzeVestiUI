package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;
    private final By optionsDropdownLocator = By.className("dropdown-toggle");
    private final By logoutButtonLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[2]/li/ul/li/a");
    private final By dashboardLinkLocator = By.xpath("//*[@id=\"app-navbar-collapse\"]/ul[1]/li[1]/a");
    private final By signaturesLinkLocator = By.linkText("Signatures");
    private final By categoriesLinkLocator = By.linkText("Categories");
    private final By panelHeadingLocator = By.className("panel-heading");
    
    public DashboardPage(WebDriver driver){
        this.driver=driver;
    }
    
    private void clickOnOptionsDropdown () {
        driver.findElement(optionsDropdownLocator).click();
    }
    private void clickOnDropdowndButtonFromDropdown () {
        driver.findElement(logoutButtonLocator).click();
    }
    public void logout (){
       clickOnOptionsDropdown();
       clickOnDropdowndButtonFromDropdown ();
    }
    public void clickOnDashboardNavLink(){
        driver.findElement(dashboardLinkLocator).click();
    }
    public void clickOnSignaturesNavLink(){
        driver.findElement(signaturesLinkLocator).click();
    }
    public void clickOnCategoriesNavLink(){
        driver.findElement(categoriesLinkLocator).click();
    }
    public String getPanelHeadingText(){
        return driver.findElement(panelHeadingLocator).getText();
    }
}
