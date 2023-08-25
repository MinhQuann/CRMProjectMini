package org.apache;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    ChromeDriver driver;
    @Before
    public void Starting(){



        //System.out.println("Starting");

        //1. Khai bao duong dan chon webdrivers --> de script co the tuong tac

        //PC nhà
        //System.setProperty("webdriver.chrome.driver","D:\\Webdriver\\driver chrome\\chromedriver-win64\\chromedriver.exe");

        //Lap Công ty
        System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        //2. Khoi tao driver tuong ung voi trinh duyet muon test

        this.driver = new ChromeDriver();
        driver.manage().window().maximize();

        //3. Su dung phuong thuc webdriver de lam viec

        this.driver.get("https://lab.connect247.vn/ucrm-sso/settings");

        //WebDriverWait wait = new WebDriverWait(driver,43100);

        //Login
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.findElement(By.xpath("//button[@class = 'ant-btn ant-btn-primary']")).click();
        this.driver.findElement(By.id("basic_email")).sendKeys("quanbnm@gmail.com");
        this.driver.findElement(By.id("basic_pass")).sendKeys("12345678x@X");
        this.driver.findElement(By.xpath("//button[@class = 'ant-btn ant-btn-primary']")).click();

    }


    @Test
    public void StandarObject(){

        //Action
        this.driver.findElement(By.xpath("//div[@class = 'custom-cursor-on-hover']")).click();

        //Get Obj name

//        WebElement account = driver.findElement(By.cssSelector(".sc-dAbbOL.fVxUGi .sc-hzhJZQ.hqOiOl:nth-child(1) span.ant-typography"));
//        WebElement contact = driver.findElement(By.cssSelector(".sc-dAbbOL.fVxUGi .sc-hzhJZQ.hqOiOl:nth-child(2) span.ant-typography"));
//        WebElement lead = driver.findElement(By.cssSelector(".sc-dAbbOL.fVxUGi .sc-hzhJZQ.hqOiOl:nth-child(3) span.ant-typography"));
//        WebElement socialID = driver.findElement(By.cssSelector(".sc-dAbbOL.fVxUGi .sc-hzhJZQ.hqOiOl:nth-child(4) span.ant-typography"));
//        WebElement Ticket = driver.findElement(By.cssSelector(".sc-dAbbOL.fVxUGi .sc-hzhJZQ.hqOiOl:nth-child(5) span.ant-typography"));
//        WebElement CallInDetail = driver.findElement(By.cssSelector(".sc-fHjqPf.kKZgwc > span.ant-typography"));
//        WebElement EmailInDetail = driver.findElement(By.cssSelector(".sc-dAbbOL.fVxUGi .sc-hzhJZQ.hqOiOl:nth-child(5) span.ant-typography"));
//        WebElement ICINDetail = driver.findElement(By.cssSelector(".sc-dAbbOL.fVxUGi .sc-hzhJZQ.hqOiOl:nth-child(5) span.ant-typography"));
//        WebElement Interaction = driver.findElement(By.cssSelector(".sc-dAbbOL.fVxUGi .sc-hzhJZQ.hqOiOl:nth-child(5) span.ant-typography"));
//        WebElement Article = driver.findElement(By.cssSelector(".sc-dAbbOL.fVxUGi .sc-hzhJZQ.hqOiOl:nth-child(5) span.ant-typography"));
//        WebElement Category = driver.findElement(By.cssSelector(".sc-dAbbOL.fVxUGi .sc-hzhJZQ.hqOiOl:nth-child(5) span.ant-typography"));
//        WebElement Tag = driver.findElement(By.cssSelector(".sc-dAbbOL.fVxUGi .sc-hzhJZQ.hqOiOl:nth-child(5) span.ant-typography"));




//      account.getText();

        //Assert
//        assertEquals("Account",account.getText());
//        assertEquals("Contact", contact.getText());
//        assertEquals("Lead", lead.getText());
//        assertEquals("Social ID",socialID.getText());
//        assertEquals("Ticket", Ticket.getText());
//        assertEquals("Call Interaction Detail", CallInDetail.getText());
    }

//    public class LoginPageTest{
//
//        ChromeDriver driver;
//        LoginPage loginPage;
//        DashBoardCRM dashBoardCRM;
//
//        @Before
//        public void InitTest(){
//
//            //PC nhà
//            //System.setProperty("webdriver.chrome.driver","D:\\Webdriver\\driver chrome\\chromedriver-win64\\chromedriver.exe");
//            //Lap Công ty
//            System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
//
//            this.driver = new ChromeDriver();
//            this.dashBoardCRM = new DashBoardCRM(this.driver);
//            this.loginPage = new LoginPage(this.driver);
//        }
//
//        @Test
//        public void Verify_Login_with_Email_Pwd_Correct(){
//            this.loginPage.Open();
//            this.loginPage.Login("quanbnm@gmail.com","12345678x@X");
//            try {
//                Thread.sleep(4000);
//                Assert.assertEquals("Dashboard", this.dashBoardCRM.GetTitleDashBoard());
//            }catch (Exception e){
//                System.out.println("Err valid not correct" + e.getMessage());
//            }
//        }
//
////    @Test
////    public void Verify_Login_With_Email_InCr_and_PWd_Cr(){
////            this.loginPage.clickBtnLoginOutSidePage.click();
////            this.loginPage.EmailLgn.sendKeys("quanbnm876@gmail.com");
////            this.loginPage.Pwdlgn.sendKeys("12345678x@X");
////            this.loginPage.ClickBtnLoginPage.click();
////
////            Assert.assertEquals("Username or password incorrect. Please check again",this.loginPage.ErrMsg());
////    }
////    @Test
////    public void Verify_Login_With_Email_Cr_and_Pwd_InC(){
////        this.loginPage.clickBtnLoginOutSidePage.click();
////        this.loginPage.EmailLgn.sendKeys("quanbnm@gmail.com");
////        this.loginPage.Pwdlgn.sendKeys("123456782x@X");
////        this.loginPage.ClickBtnLoginPage.click();
////        Assert.assertEquals("Username or password incorrect. Please check again",this.loginPage.ErrMsg());
////    }
////
////    @Test
////    public void Verify_Login_With_Email_InCr_and_Pwd_InCr(){
////        this.loginPage.clickBtnLoginOutSidePage.click();
////        this.loginPage.EmailLgn.sendKeys("quanbnm12312@gmail.com");
////        this.loginPage.Pwdlgn.sendKeys("123456782x@X");
////        this.loginPage.ClickBtnLoginPage.click();
////        Assert.assertEquals("Username or password incorrect. Please check again",this.loginPage.ErrMsg());
////
////    }
////    @Test
////    public void Verify_Login_With_Email_Empty_and_Pwd(){
////        this.loginPage.clickBtnLoginOutSidePage.click();
////        this.loginPage.EmailLgn.sendKeys("");
////        this.loginPage.Pwdlgn.sendKeys("123456782x@X");
////        this.loginPage.ClickBtnLoginPage.click();
////
////        Assert.assertEquals("Please input your username!", this.loginPage.ErrMsgInput());
////    }
////
////    @Test
////    public void Verify_Login_With_Email_and_Pwd_Empty(){
////        this.loginPage.clickBtnLoginOutSidePage.click();
////        this.loginPage.EmailLgn.sendKeys("quanbnm@gmail.com");
////        this.loginPage.Pwdlgn.sendKeys("");
////        this.loginPage.ClickBtnLoginPage.click();
////
////        Assert.assertEquals("Please input your password!", this.loginPage.ErrMsgPwdInput());
////    }
//
//
//        @After
//        public void End() throws InterruptedException {
//            Thread.sleep(3000);
//            driver.quit();
//        }
//
//
//    }



    @After
    public void Quit(){

    }
}
