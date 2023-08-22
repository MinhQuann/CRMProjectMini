package org.apache.DashBoard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardCRM {

    WebDriver driver;

    @FindBy(id = "#test1")
    public WebElement DashTitle;



    public DashBoardCRM(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(this.driver, driver);

    }

    public String GetTilteDashBoard(){

        return DashTitle.getText();


    }

}
