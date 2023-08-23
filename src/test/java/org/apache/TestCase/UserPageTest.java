package org.apache.TestCase;

import org.apache.DashBoard.AccountSettings;
import org.apache.DashBoard.DashBoardCRM;
import org.apache.LoginPageCRM.LoginPage;
import org.apache.SettingPageLocator.SettingPage;
import org.apache.hc.core5.reactor.Command;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.security.Key;

public class UserPageTest {

    ChromeDriver driver;

    LoginPage loginPage;

    AccountSettings accountSettings;

    SettingPage settingPage;


    @Before
    public void InitTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\Webdriver\\driver chrome\\chromedriver-win64\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("https://lab.connect247.vn/ucrm-sso/settings");
        this.accountSettings = new AccountSettings(this.driver);
        this.loginPage = new LoginPage(this.driver);
        this.settingPage = new SettingPage(this.driver);



        // Login Before Test
        this.loginPage.clickBtnLoginOutSidePage.click();
        this.loginPage.EmailLgn.sendKeys("quanbnm@gmail.com");
        this.loginPage.Pwdlgn.sendKeys("12345678x@X");
        this.loginPage.ClickBtnLoginPage.click();
        Thread.sleep(3000);
        this.settingPage.User.click();
        Thread.sleep(3000);


    }

    @Test
    public void Create_new_user() throws InterruptedException {
        this.accountSettings.AddUser();
        this.accountSettings.FirstName.sendKeys("Minh");
        this.accountSettings.LastName.sendKeys("Quân");
        this.accountSettings.Email.sendKeys("quanbnm01@gmail.com");
        this.accountSettings.Password.sendKeys("12345678x@X");
        this.accountSettings.VerifyPass.sendKeys("12345678x@X");
        this.accountSettings.Role.sendKeys("LV2" + Keys.ENTER);
        Thread.sleep(3000);
        this.accountSettings.ReportTo.sendKeys("Cây táo nở hoa" + Keys.ENTER);
        this.accountSettings.Save.click();
        //Assert
        try {
            if (this.accountSettings.CheckNotiUserAlreadyExist()){
                System.out.println("This email is already Register");
            }else {
                Thread.sleep(4000);
                Assert.assertEquals(this.accountSettings.CheckUserOnDisplay(),"Quân Minh" );
                System.out.println("New User Display on Screen");
            }
        }catch (Exception e){
            System.out.println("New user don't display on Screen");
        }
    }

    @Test
    public void Delete_User() throws InterruptedException {
        this.accountSettings.CheckOnOffUser();
        this.accountSettings.BtnTrans.click();
        try {
            Thread.sleep(2000);
            this.accountSettings.DelUserbtn();
        }catch (Exception e){
            System.out.println("Check time");
        }
        Thread.sleep(2000);
        this.accountSettings.TransData.sendKeys("Cây táo nở hoa" +  Keys.ENTER);
        Thread.sleep(2000);
        this.accountSettings.SaveDel.click();
        this.accountSettings.ConfirmDelButton.click();

        try {
            Thread.sleep(4000);
            Assert.assertEquals(this.accountSettings.CheckUserOnDisplay(),!this.accountSettings.CheckUserOnDisplay());

        }catch (Exception e){
            System.out.println("Error");
        }


    }

    @After
    public void End() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

}
