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

    public WebElement Del;

    @FindBy(css = "img[alt = 'changePass']")
    public WebElement keychangPwd;



    public AccountSettings(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void AddUser(){
        this.driver.findElement(AddUser).click();
    }

    public WebElement CheckUser(){
        WebDriverWait newUserInListView = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        return newUserInListView.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='usersTable']//td[text()='quanbnm01@gmail.com']")));
    }







}
