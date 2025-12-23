package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentLoginPage {
    private WebDriver driver;
    private By usernameField = By.id("txt-username");
    private By passwordField = By.id("txt-password");
    private By loginButton = By.id("btn-login");

    public AppointmentLoginPage(WebDriver driver){
        this.driver = driver;
    }

    //LOGIN TO MAKE APPOINTMENT
    public void setUserDetails(String username, String password){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }

    public MakeAppointmentPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new MakeAppointmentPage(driver);
    }
}
