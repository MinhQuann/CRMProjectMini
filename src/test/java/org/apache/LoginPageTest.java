package org.apache;

import org.apache.DashBoard.DashBoardCRM;
import org.apache.LoginPageCRM.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {

    WebDriver driver;
    LoginPage loginPage;
    DashBoardCRM dashBoardCRM;

    @Before
    public void InitTest(){

        //PC nhà
        //System.setProperty("webdriver.chrome.driver","D:\\Webdriver\\driver chrome\\chromedriver-win64\\chromedriver.exe");

        //Lap Công ty
        System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("https://lab.connect247.vn/ucrm-sso/dashboard");
        this.loginPage = new LoginPage(this.driver);
        this.dashBoardCRM = new DashBoardCRM(this.driver);
    }

    @Test
    public void Verify_Login_with_Email_Pwd_Correct(){
        this.loginPage.clickBtnLoginOutSidePage.click();
        this.loginPage.EmailLgn.sendKeys("quanbnm@basebs.com");
        this.loginPage.Pwdlgn.sendKeys("12345678x@X");
        this.loginPage.ClickBtnLoginPage.click();

        Assert.assertEquals("Dashboard",this.dashBoardCRM.DashTitle);

    }

//    @Test
//    public void Case2(){
//
//    }

//    @After
//    public void End(){
//        driver.quit();
//    }


}
