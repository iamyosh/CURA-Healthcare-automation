package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setDriver(){
        driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        homePage = new HomePage(driver);


        //click make appointment button

    }


}
