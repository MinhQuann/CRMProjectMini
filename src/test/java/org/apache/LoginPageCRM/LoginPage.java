package org.apache.LoginPageCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    @FindBy(xpath = "//button[@class = 'ant-btn-primary'] ")
    public WebElement clickBtnLoginOutSidePage;

    @FindBy(id = "basic_email")
    public WebElement EmailLgn;

    @FindBy(id = "basic_pass")
    public WebElement Pwdlgn;

    @FindBy(css = "button[type = 'submit']")
    public WebElement ClickBtnLoginPage;

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






}
