package org.apache;

import static org.junit.Assert.assertEquals;
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
        //System.setProperty("webdriver.chrome.driver","D:\\Webdriver\\chromedriver.exe");

        //Lap Công ty
        System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");


        //2. Khoi tao driver tuong ung voi trinh duyet muon test

        this.driver = new ChromeDriver();
        driver.manage().window().maximize();

        //3. Su dung phuong thuc webdriver de lam viec

        this.driver.get("https://lab.connect247.vn/ucrm-sso/login");

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
        this.driver.findElement(By.xpath("//ul[@class = 'react-multi-carousel-track ']")).click();
        WebElement account = driver.findElement(By.xpath("//span[@class = 'ant-typography']"));
        WebElement contact = driver.findElement(By.xpath("//div[@class = 'sc-hzhJZQ hqOiOl']"));
        WebElement lead = driver.findElement(By.xpath("//span[@class = 'ant-typography']"));
        WebElement socialID = driver.findElement(By.xpath("//span[@class = 'ant-typography']"));
        WebElement Ticket = driver.findElement(By.xpath("//span[@class = 'ant-typography']"));

//      account.getText();
        assertEquals(account.getText(),"Account");
        assertEquals(contact.getText(),"Contact");
        assertEquals(lead.getText(),"Lead");
        assertEquals(socialID.getText(),"Social ID");
        assertEquals(Ticket.getText(),"Ticket");








    }
    @After
    public void Quit(){

    }
}
