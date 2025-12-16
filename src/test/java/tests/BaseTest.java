package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.MakeAppointmentPage;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;
    protected MakeAppointmentPage makeAppointmentPage;

    @BeforeClass
    public void setDriver(){
        driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        homePage = new HomePage(driver);


        //click make appointment button
        makeAppointmentPage = homePage.clickAppointmentButton();
    }


}
