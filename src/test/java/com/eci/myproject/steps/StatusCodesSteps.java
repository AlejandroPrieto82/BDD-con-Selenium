package com.eci.myproject.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import com.eci.myproject.pages.StatusCodesPage;

public class StatusCodesSteps {

    private WebDriver driver;
    private StatusCodesPage statusCodesPage;

    @Before("@status_codes")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        statusCodesPage = new StatusCodesPage(driver);
    }

    @Given("I am on the status codes page")
    public void i_am_on_the_status_codes_page() {
        statusCodesPage.navigate();
    }

    @When("I click on status code {string}")
    public void i_click_on_status_code(String code) {
        statusCodesPage.clickStatusCode(code);
    }

    @Then("I should see the status code {string} in the page")
    public void i_should_see_status_code_in_page(String code) {
        assert statusCodesPage.isStatusCodeDisplayed(code) :
            "Expected status code " + code + " not found in page";
    }

    @After("@status_codes")
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
