package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignaturesPage {
    private WebDriver driver;
    private By panelHeadingLocator = By.className("panel-heading");
    public SignaturesPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getPanelHeadingText(){
        return driver.findElement(panelHeadingLocator).getText();
    }
    
}
