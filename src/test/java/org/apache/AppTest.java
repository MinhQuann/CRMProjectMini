package org.apache;

import static org.junit.Assert.assertTrue;

import org.junit.After;
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
        System.setProperty("webdriver.chrome.driver","D:\\Webdriver\\chromedriver.exe");

        //Lap Công ty
        //System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");


        //2. Khoi tao driver tuong ung voi trinh duyet muon test

        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);


        //3. Su dung phuong thuc webdriver de lam viec

        this.driver.get("https://lab.connect247.vn/ucrm-sso/login");

        //WebDriverWait wait = new WebDriverWait(driver,43100);

        //Login
        WebElement click = this.driver.findElement(By.xpath("//button[@class = 'ant-btn ant-btn-primary']"));
        click.click();
        WebElement id = this.driver.findElement(By.id("basic_email"));
        WebElement pwd = this.driver.findElement(By.id("basic_pass"));
        id.sendKeys("quanbnm@basebs.com");
        pwd.sendKeys("12345678x@X");
        WebElement clickLogin = this.driver.findElement(By.xpath("//button[@class = 'ant-btn ant-btn-primary']"));
        clickLogin.click();

        this.driver.get("https://lab.connect247.vn/ucrm-sso/report#my_folders");
    }


    @Test
    public void WFInCreaseOTFS(){


    }
    @After
    public void Quit(){

    }
}
