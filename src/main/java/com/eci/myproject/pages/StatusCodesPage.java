package com.eci.myproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class StatusCodesPage {

    private WebDriver driver;

    @FindBy(css = "div.example ul li a")
    private List<WebElement> statusCodeLinks;

    public StatusCodesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigate() {
        driver.get("https://the-internet.herokuapp.com/status_codes");
    }

    public void clickStatusCode(String code) {
        for (WebElement link : statusCodeLinks) {
            if (link.getText().trim().equals(code)) {
                link.click();
                return;
            }
        }
        throw new RuntimeException("Status code link not found: " + code);
    }

    public boolean isStatusCodeDisplayed(String code) {
        return driver.getCurrentUrl().contains(code) ||
               driver.getPageSource().contains(code);
    }
}