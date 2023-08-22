package org.apache.LoginPageCRM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    WebDriver driver;
    @FindBy(xpath = "//button[@class = 'ant-btn ant-btn-primary'] ")
    public WebElement clickBtnLoginOutSidePage;

    @FindBy(id = "basic_email")
    public WebElement EmailLgn;

    @FindBy(id = "basic_pass")
    public WebElement Pwdlgn;

    @FindBy(css = "button[type = 'submit']")
    public WebElement ClickBtnLoginPage;

    By LockMsgWithIncorrectUserName_pwd = By.cssSelector("div.ant-notification-notice-description");

    By InputUserNoti = By.cssSelector("div.ant-form-item-explain-error");

    By InputPwdNoti = By.cssSelector("div.ant-form-item-explain-error");

    @FindBy(xpath = "//div[@class = 'forgot-password']")
    public WebElement ClickForgotPass;

    @FindBy(css = "input[type = 'email']")
    public  WebElement ForgotEmailPage;

    @FindBy(xpath = "//button[@class = 'ant-btn-default']")
    public  WebElement ClickRestorePwd;

    @FindBy(xpath = "//div[@class = 'backToLogin custom-cursor-on-hover']")
    public WebElement ClickBacktoLoginPage;


    public  LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String ErrMsg(){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LockMsgWithIncorrectUserName_pwd)).getText();

    }

    public String ErrMsgInput(){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InputUserNoti)).getText();

    }

    public String ErrMsgPwdInput(){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InputPwdNoti)).getText();
    }


//    public void WaitForPageLoaded(){
//        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                return ((JavascriptExecutor)driver).executeScript("Return document.readyState").toString().equals("complete");
//            }
//        };
//        try {
//            Thread.sleep(1000);
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//            wait.until(expectation);
//        } catch (Throwable error) {
//            Assert.fail("Timeout waiting for Page Load Request to complete");
//        }
//    }


}
