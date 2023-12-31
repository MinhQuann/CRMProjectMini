package org.apache.DashBoard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardCRM {

    WebDriver driver;

    @FindBy(css = "div##test1.title")
    public WebElement DashTitle;



    public DashBoardCRM(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(this.driver, driver);

    }

    public String GetTitleDashBoard(){
        return driver.getTitle();

    }

}
