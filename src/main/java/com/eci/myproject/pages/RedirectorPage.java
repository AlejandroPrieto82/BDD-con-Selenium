package com.eci.myproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedirectorPage {

    private WebDriver driver;

    @FindBy(id = "redirect")
    private WebElement redirectLink;

    public RedirectorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigate() {
        driver.get("https://the-internet.herokuapp.com/redirector");
    }

    public void clickRedirectLink() {
        redirectLink.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}