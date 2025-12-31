package tests;

import org.testng.annotations.Test;
import pages.BackHomePage;

public class BackHomeTest extends BaseTest{

    @Test
    public void backHome(){
        BackHomePage backHomePage = new BackHomePage(driver);
    }
}
