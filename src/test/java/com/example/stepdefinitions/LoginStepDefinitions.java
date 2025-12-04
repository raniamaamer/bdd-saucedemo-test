package com.example.stepdefinitions;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinitions {

    private WebDriver driver;

    @Given("user on login page")
    public void user_on_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
    }

    @When("Clicks on login Button")
    public void clicks_on_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user is navigated to home page")
    public void user_is_navigated_to_home_page() {
        // Vérifie que la page contient le titre "Products"
        String title = driver.findElement(By.className("title")).getText();
        assertTrue("Navigation failed: expected 'Products'", title.equals("Products"));

        // 🔍 DÉLAI TEMPORAIRE (3 secondes) POUR VOIR LA PAGE
        // ⚠️ À supprimer dans la version finale
        try {
            Thread.sleep(10000); // 10000 ms = 10secondes
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Then("Close the browser")
    public void close_the_browser() {
        if (driver != null) {
            driver.quit();
        }
    }
}