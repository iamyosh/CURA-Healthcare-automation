package tests;

import org.testng.annotations.Test;
import pages.AppointmentLoginPage;
import pages.BackHomePage;
import pages.MakeAppointmentPage;

import static org.testng.Assert.assertTrue;

public class BackHomeTest extends BaseTest{

    @Test
    public void backHome(){
        //Step 1: login
        AppointmentLoginPage loginPage = new AppointmentLoginPage(driver);
        loginPage.setUserDetails("John Doe", "ThisIsNotAPassword");
        loginPage.clickLoginButton();

        //step 2: make appointment
        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        makeAppointmentPage.selectFromDropdown("Seoul CURA Healthcare Center");
        makeAppointmentPage.selectDate("27");
        makeAppointmentPage.addComment("No comment");
        makeAppointmentPage.clickAppointmentButton();

        //Step 3: click bck to home
        BackHomePage backHomePage = makeAppointmentPage.backHomeLink();

        // Step 4: Optional verification
        assertTrue(driver.getCurrentUrl().contains("katalon-demo-cura.herokuapp.com"),
                "Homepage did not load after clicking Back to Home");
    }
}
