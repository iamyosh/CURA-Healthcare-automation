package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MakeAppointmentPage {

    private WebDriver driver;
    private By dropdown = By.id("combo_facility" );
    private By dateInput = By.id("txt_visit_date");
    private By comment = By.id("txt_comment");
    private By appointmentButton = By.id("btn-book-appointment");
    private By backToHomeButton = By.className("btn btn-default");

    public MakeAppointmentPage(WebDriver driver){
        this.driver = driver;
    }

    //Dropdown list - to select the facility
    public void selectFromDropdown(String option){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));   //explicit wait
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown));

        Select select = new Select(element);    //use 'Select' for a dropdown
        select.selectByVisibleText(option);
    }

    //Calendar - to select appointment date
    public void selectDate(String day){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //open the calendar
        wait.until(ExpectedConditions.elementToBeClickable(dateInput)).click();

        //select the day
        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class='day' and text()='" + day + "']")));
        date.click();
    }

    //add comment
    public void addComment(String text){
        driver.findElement(comment).sendKeys(text);
    }

    public void clickAppointmentButton(){
        driver.findElement(appointmentButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void backToHome(){
        driver.findElement(backToHomeButton).click();
    }


}
