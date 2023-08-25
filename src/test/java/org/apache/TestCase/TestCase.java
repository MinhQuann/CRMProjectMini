package org.apache.TestCase;

import org.apache.DashBoard.DashBoardCRM;
import org.apache.POM.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase  {
    WebDriver driver;
    LoginPage loginPage;
    DashBoardCRM dashBoardCRM;


    @Before
    public void InitTest(){
        //PC nhà
        System.setProperty("webdriver.chrome.driver","D:\\Webdriver\\driver chrome\\chromedriver-win64\\chromedriver.exe");
        //Lap Công ty
        //System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        this.driver = new ChromeDriver();
        this.dashBoardCRM = new DashBoardCRM(this.driver);
        this.loginPage = new LoginPage(this.driver);



    }

    @Test
    public void Verify_Login_with_Email_Pwd_Correct(){
        this.loginPage.Open();
        this.loginPage.Login("quanbnm@gmail.com","12345678x@X");
        try {
                Thread.sleep(4000);
                Assert.assertEquals("Dashboard", this.dashBoardCRM.GetTitleDashBoard());
            }catch (Exception e){
                System.out.println("Err valid not correct" + e.getMessage());
            }
    }

    @Test
    public void Verify_Login_Fail_Case(){

        this.loginPage.Open();
        this.loginPage.Login("quanbnm12314@gmail.com", "1234125x@xW");
        try {
            Thread.sleep(4000);
            Assert.assertEquals("Username or password incorrect. Please check again",this.loginPage.ErrMsg());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void Verify_Login_With_field_Empty(){
        this.loginPage.Open();
        this.loginPage.Login("","12345678x@X");
        try {
            Thread.sleep(4000);
            Assert.assertEquals("Please input your username!",this.loginPage.ErrMsgInput());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.loginPage.Open();
        this.loginPage.Login("quanbnm@gmail.com","");
        try {
            Thread.sleep(4000);
            Assert.assertEquals("Please input your password!",this.loginPage.ErrMsgPwdInput());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @After
    public void End(){
        driver.quit();
    }
}
