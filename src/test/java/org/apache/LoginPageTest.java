package org.apache;


import org.apache.DashBoard.DashBoardCRM;
import org.apache.LoginPageCRM.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LoginPageTest {

    ChromeDriver driver;
    LoginPage loginPage;
    DashBoardCRM dashBoardCRM;

    @Before
    public void InitTest(){

        //PC nhà
        //System.setProperty("webdriver.chrome.driver","D:\\Webdriver\\driver chrome\\chromedriver-win64\\chromedriver.exe");

        //Lap Công ty
        System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("https://lab.connect247.vn/ucrm-sso/dashboard");
        this.loginPage = new LoginPage(this.driver);
        this.dashBoardCRM = new DashBoardCRM(this.driver);
    }

    @Test
    public void Verify_Login_with_Email_Pwd_Correct(){
        this.loginPage.clickBtnLoginOutSidePage.click();
        this.loginPage.EmailLgn.sendKeys("quanbnm@gmail.com");
        this.loginPage.Pwdlgn.sendKeys("12345678x@X");
        this.loginPage.ClickBtnLoginPage.click();
        try {
            Thread.sleep(4000);
            Assert.assertEquals("Dashboard", this.dashBoardCRM.GetTitleDashBoard());
        }catch (Exception e){
            System.out.println("Err valid not correct" + e.getMessage());
        }
    }

    @Test
    public void Verify_Login_With_Email_InCr_and_PWd_Cr(){
            this.loginPage.clickBtnLoginOutSidePage.click();
            this.loginPage.EmailLgn.sendKeys("quanbnm876@gmail.com");
            this.loginPage.Pwdlgn.sendKeys("12345678x@X");
            this.loginPage.ClickBtnLoginPage.click();

            Assert.assertEquals("Username or password incorrect. Please check again",this.loginPage.ErrMsg());
    }
    @Test
    public void Verify_Login_With_Email_Cr_and_Pwd_InC(){
        this.loginPage.clickBtnLoginOutSidePage.click();
        this.loginPage.EmailLgn.sendKeys("quanbnm@gmail.com");
        this.loginPage.Pwdlgn.sendKeys("123456782x@X");
        this.loginPage.ClickBtnLoginPage.click();
        Assert.assertEquals("Username or password incorrect. Please check again",this.loginPage.ErrMsg());
    }

    @Test
    public void Verify_Login_With_Email_InCr_and_Pwd_InCr(){
        this.loginPage.clickBtnLoginOutSidePage.click();
        this.loginPage.EmailLgn.sendKeys("quanbnm12312@gmail.com");
        this.loginPage.Pwdlgn.sendKeys("123456782x@X");
        this.loginPage.ClickBtnLoginPage.click();
        Assert.assertEquals("Username or password incorrect. Please check again",this.loginPage.ErrMsg());

    }
    @Test
    public void Verify_Login_With_Email_Empty_and_Pwd(){
        this.loginPage.clickBtnLoginOutSidePage.click();
        this.loginPage.EmailLgn.sendKeys("");
        this.loginPage.Pwdlgn.sendKeys("123456782x@X");
        this.loginPage.ClickBtnLoginPage.click();

        Assert.assertEquals("Please input your username!", this.loginPage.ErrMsgInput());
    }

    @Test
    public void Verify_Login_With_Email_and_Pwd_Empty(){
        this.loginPage.clickBtnLoginOutSidePage.click();
        this.loginPage.EmailLgn.sendKeys("quanbnm@gmail.com");
        this.loginPage.Pwdlgn.sendKeys("");
        this.loginPage.ClickBtnLoginPage.click();

        Assert.assertEquals("Please input your password!", this.loginPage.ErrMsgPwdInput());
    }


    @After
    public void End() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
