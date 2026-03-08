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
import com.eci.myproject.pages.RedirectorPage;

public class RedirectorSteps {

    private WebDriver driver;
    private RedirectorPage redirectorPage;

    @Before("@redirector")
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
        redirectorPage = new RedirectorPage(driver);
    }

    @Given("I am on the redirector page")
    public void i_am_on_the_redirector_page() {
        redirectorPage.navigate();
    }

    @When("I click the redirect link")
    public void i_click_the_redirect_link() {
        redirectorPage.clickRedirectLink();
    }

    @Then("I should be redirected to the status codes page")
    public void i_should_be_redirected_to_status_codes_page() {
        String currentUrl = redirectorPage.getCurrentUrl();
        assert currentUrl.contains("status_codes") :
            "Expected redirect to status_codes page but was on: " + currentUrl;
    }

    @After("@redirector")
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}