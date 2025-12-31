package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AppointmentLoginPage;
import pages.MakeAppointmentPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class MakeAppointmentTest extends BaseTest{

    //hv to add the login details again bcz each test is independent
    @BeforeMethod
    public void loginTest(){
        AppointmentLoginPage loginPage = new AppointmentLoginPage(driver);
        loginPage.setUserDetails("John Doe", "ThisIsNotAPassword");
        loginPage.clickLoginButton();
    }


    @Test
    public void selectOptions(){
        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        makeAppointmentPage.selectFromDropdown("Seoul CURA Healthcare Center");

        makeAppointmentPage.selectDate("27");

        makeAppointmentPage.addComment("No comment");
        makeAppointmentPage.clickAppointmentButton();
    }

    @AfterMethod
    public void takeScreenshot(){       //camera is the variable name
        var camera = (TakesScreenshot) driver;  //'TakeScreenshot' is an interface tht hv ss support
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        System.out.println("Screenshot of booked appointment taken in path: " + screenshot.getAbsolutePath());

        //getScreenshotAs - Selenium method that captures the current browser screen

        try {   //IO exception block to handle errors
            Files.move(screenshot.toPath(), new File("resources/screenshots/appointment.png").toPath()); //moves ss to desired folder
        }catch (IOException exception){
            exception.printStackTrace();  //print full error details
        }
        //try{} - put code inside that might fail
        //catch{} - to catch the error (has the error msg)
    }

    @Test
    public void backHome(){
        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        makeAppointmentPage.backToHome();
    }
    
}
