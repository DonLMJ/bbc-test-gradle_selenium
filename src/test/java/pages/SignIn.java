package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class SignIn {
    WebDriver driver;

    public SignIn(WebDriver driver) {
        this.driver=driver;
    }

    //Locator for emailInput
    By EmailInput = By.id("user-identifier-input");

    //Method to fill email input
    public void fillEmail(String user) {
        driver.findElement(EmailInput).sendKeys(user);
    }

    By PwdInput = By.id("password-input");

    //Method to fill pwd input
    public void fillPwd(String pwd) {
        driver.findElement(PwdInput).sendKeys(pwd);
    }

    By SubmitButton = By.cssSelector("#submit-button");

    public void Submit() {
        driver.findElement(SubmitButton).click();
    }

}
