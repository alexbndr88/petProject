package step_definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CreateTariff;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import utilities.Driver;
import pages.CreateTariff;
import java.time.Duration;
import java.util.Map;

public class CreateTariffSteps {

     WebDriver driver = Driver.getDriver();
CreateTariff createTariffPage = PageFactory.initElements(driver, CreateTariff.class);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(name = "email")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @Given("the user is located at {string}")
    public void the_user_is_located_at(String url) {
        driver.get(url);
    }

    @Given("the user logs in with {string} and {string}")

    public void the_user_logs_in_with(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @Given("the user is located at the Create Tariff page")
    public void the_user_is_located_at_the_create_tariff_page() {
        driver.get("https://supplysync.us/create-tariff");
    }

    @When("the user creates a new tariff with the following details")
    public void the_user_creates_a_new_tariff_with_the_following_details(Map<String, String> tariffDetails) {
        String branchName = tariffDetails.get("branchName");
        String tariffName = tariffDetails.get("tariffName");
        String deliveryTime = tariffDetails.get("deliveryTime");
        String typeOfDelivery = tariffDetails.get("typeOfDelivery");
        String deliveryCost = tariffDetails.get("deliveryCost");
        String region = tariffDetails.get("region");
        String coordinates = tariffDetails.get("coordinates");
        String additionalInfo = tariffDetails.get("additionalInfo");
        boolean isAvailable = Boolean.parseBoolean(tariffDetails.get("isAvailable"));

        createTariffPage.createTariff(branchName, tariffName, deliveryTime, typeOfDelivery, deliveryCost, region, coordinates, additionalInfo, isAvailable);
    }

    @Then("the tariff should be created successfully")
    public void the_tariff_should_be_created_successfully() {
        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Hawaii']")).isDisplayed());
    }
}