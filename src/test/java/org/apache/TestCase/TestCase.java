package org.apache.TestCase;

import org.apache.DashBoard.DashBoardCRM;
import org.apache.POM.LoginPage;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@FixMethodOrder(MethodSorters.JVM)
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
    public void Verify_Login_with_Email_Pwd_Correct_1(){
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
    public void Verify_Login_Fail_Case_2(){

        this.loginPage.Open();
        this.loginPage.Login("quanbnm12314@gmail.com", "1234125x@xW");
        Assert.assertEquals("Username or password incorrect. Please check again",this.loginPage.ErrMsg());
    }

    @Test
    public void Verify_Login_With_field_Empty_3(){
        this.loginPage.Open();
        this.loginPage.Login("","12345678x@X");
        Assert.assertEquals("Please input your username!",this.loginPage.ErrMsgInput());

        this.loginPage.Open();
        this.loginPage.Login("quanbnm@gmail.com","");
        Assert.assertEquals("Please input your password!",this.loginPage.ErrMsgPwdInput());
    }

    @After
    public void End(){
        driver.quit();
    }
}
