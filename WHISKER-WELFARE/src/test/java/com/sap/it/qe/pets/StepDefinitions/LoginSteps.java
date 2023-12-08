package com.sap.it.qe.pets.StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert; // If using JUnit for assertions
// Additional specific imports based on your requirements
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

// Import necessary libraries

public class LoginSteps {
    WebDriver driver; // Initialize WebDriver

    @Given("user is on login page")
    public void user_is_on_login_page() {
        // Code to navigate to the login page
        driver.get("URL_of_Login_Page");
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        // Code to enter username and password into respective fields
        driver.findElement(By.id("username")).sendKeys("your_username");
        driver.findElement(By.id("password")).sendKeys("your_password");
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {
        // Code to click on the login button
        driver.findElement(By.id("loginButton")).click();
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        // Code to verify navigation to the home page after successful login
        String currentURL = driver.getCurrentUrl();
        // Perform assertions to verify the URL or elements present on the home page
        Assert.assertTrue(currentURL.contains("home"));
    }
}
