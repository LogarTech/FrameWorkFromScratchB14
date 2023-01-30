package com.test.openmrs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "username")
    WebElement username;

    @FindBy(xpath = "//input[@id= 'password']")
    WebElement password;
    // DO NOT USE ANY INDEX LOCATOR EXCEPT TABLES
    @FindBy(xpath = "//ul[@id='sessionLocation']//li")
    List <WebElement> locations;

    @FindBy(css = "#loginButton")
    WebElement loginButton;

    @FindBy(css = "#error-message")
    WebElement errorMessage;

    public void login(String username, String password, String location){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        for(WebElement llocation : locations){
            if(BrowserUtils.getText(llocation).equals(location)){
                llocation.click();
                break;
            }
        }
        loginButton.click();
    }

    public String validateMessage(){
        return BrowserUtils.getText(errorMessage);
    }


}
