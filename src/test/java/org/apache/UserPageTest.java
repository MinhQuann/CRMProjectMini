package org.apache;

import org.apache.DashBoard.AccountSettings;
import org.apache.DashBoard.DashBoardCRM;
import org.apache.LoginPageCRM.LoginPage;
import org.junit.After;
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


    @Before
    public void InitTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get("https://lab.connect247.vn/ucrm-sso/users");
        this.accountSettings = new AccountSettings(this.driver);
        this.loginPage = new LoginPage(this.driver);


        // Login Before Test
        this.loginPage.clickBtnLoginOutSidePage.click();
        this.loginPage.EmailLgn.sendKeys("quanbnm@gmail.com");
        this.loginPage.Pwdlgn.sendKeys("12345678x@X");
        this.loginPage.ClickBtnLoginPage.click();
        Thread.sleep(3000);
    }

    @Test
    public void Create_new_user(){
        this.accountSettings.AddUser();
        this.accountSettings.FirstName.sendKeys("Minh");
        this.accountSettings.LastName.sendKeys("Quân");
        this.accountSettings.Email.sendKeys("quanbnm01@gmail.com");
        this.accountSettings.Password.sendKeys("12345678x@X");
        this.accountSettings.VerifyPass.sendKeys("12345678x@X");
        this.accountSettings.Role.sendKeys("LV2" + Keys.ENTER);
        this.accountSettings.ReportTo.sendKeys("Cây táo nở hoa" + Keys.ENTER);
        this.accountSettings.Save.click();
        //Assert

        try {
            this.accountSettings.CheckUser();
            System.out.println("new user display");
        }catch (Exception e){
            System.out.println("New user not display");
        }









    }

    @After
    public void End(){
        //driver.quit();
    }

}
