package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.AppointmentLoginPage;
import pages.MakeAppointmentPage;

public class AppointmentLoginTest extends BaseTest{

    @Test
    public void successfulLogin(){
        AppointmentLoginPage appointmentLoginPage = new AppointmentLoginPage(driver);
        appointmentLoginPage.setUserDetails("John Doe", "ThisIsNotAPassword");
        MakeAppointmentPage makeAppointmentPage = appointmentLoginPage.clickLoginButton();
    }
}

