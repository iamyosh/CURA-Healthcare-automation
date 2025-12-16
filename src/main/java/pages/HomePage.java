package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By appointmentLink = By.id("btn-make-appointment");

    public HomePage(WebDriver driver){
        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public MakeAppointmentPage clickAppointmentButton(){
        wait.until(ExpectedConditions.elementToBeClickable(appointmentLink)).click();
        return new MakeAppointmentPage(driver);
    }
}
