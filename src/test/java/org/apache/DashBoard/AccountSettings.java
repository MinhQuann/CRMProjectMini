package org.apache.DashBoard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountSettings {

    WebDriver driver;

    By AddUser = By.cssSelector("button[type = button].users__AddButton-sc-10v6jm4-3");

    By User = By.xpath("//*[@id=\"root\"]/section/section/main/div/div[2]/div/div/div/div/div/div/table/tbody/tr[2]/td[2]/div");

    By UserExist = By.cssSelector("div.ant-notification-notice-description");

    @FindBy(xpath = "//button[@type = 'submit']")
    public WebElement BtnTrans;

    @FindBy(css = "span.ant-switch-inner")
    public WebElement OffUser;

    By DelUserbtn = By.cssSelector("img[alt = 'delete']");

    @FindBy(xpath = "button[class = 'ant-btn ant-btn-primary'] ")
    public WebElement SaveDel;

    @FindBy(css= "input#transfer")
    public  WebElement TransData;
    @FindBy(id = "first_name")
    public WebElement FirstName;

    @FindBy(id = "last_name")
    public WebElement LastName;

    @FindBy(id = "email")
    public WebElement Email;

    @FindBy(id = "password")
    public WebElement Password;

    @FindBy(id = "verify_password")
    public WebElement VerifyPass;

    @FindBy(id = "roles")
    public WebElement Role;

    @FindBy(id = "report_to")
    public WebElement ReportTo;

    @FindBy(css = "button[type ='submit']")
    public WebElement Save;

    public WebElement Excel;

    @FindBy(css = "img[alt = 'edit']")
    public WebElement Edit;

    @FindBy(css = "img[alt = 'changePass']")
    public WebElement keychangPwd;



    public AccountSettings(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void AddUser(){
        this.driver.findElement(AddUser).click();
    }

    public String CheckUserOnDisplay(){
        WebDriverWait newUserInListView = new WebDriverWait(this.driver, Duration.ofSeconds(50));
        return newUserInListView.until(ExpectedConditions.visibilityOfElementLocated(User)).getText();
    }

    public String CheckNotiUserAlreadyExist(){
        WebDriverWait CheckNoti = new WebDriverWait(this.driver, Duration.ofSeconds(50));
        return  CheckNoti.until(ExpectedConditions.visibilityOfElementLocated(UserExist)).getText();
    }

    public void DelUserbtn(){
        try {
            Thread.sleep(2000);
            this.driver.findElement(DelUserbtn).click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



    }







}
