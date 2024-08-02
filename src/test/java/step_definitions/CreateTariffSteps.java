package step_definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

    public CreateTariffSteps(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
}




    @FindBy(name = "email")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

//    @Given("the user is located at {string}")
//    public void the_user_is_located_at(String url) {
//        driver.get(url);
//    }

//    @Given("the user logs in with {string} and {string}")
//
//    public void the_user_logs_in_with(String username, String password) {
//        usernameField.sendKeys(username);
//        passwordField.sendKeys(password);
//        loginButton.click();
//    }

    @Given("the user is located at the Create Tariff page")
    public void the_user_is_located_at_the_create_tariff_page() {
       driver.findElement(By.xpath("(//span[@class='sc-egiyK GEXAw MuiTypography-root MuiTypography-body1 MuiListItemText-primary'])[4]")).click();
//       driver.findElement(By.xpath("//button[@class='sc-jJoQJp ieRzNh MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root sc-eGRUor dTmEKg sc-gIDmLj fpapDT sc-gDGHff fkfylB']")).click();
//
    }

    @Given("user click create tariff")
    public void user_click_create_tariff() {
      driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    }
    @Given("user selecting branch")
    public void user_selecting_branch() {

        WebElement dropdownButton = driver.findElement(By.xpath("(//div[@class='sc-jeraig cyGdiz MuiFormControl-root sc-hmjpVf hGEnFv'])[1]"));
        dropdownButton.click();

        WebElement dropdownOption = driver.findElement(By.xpath("(//li[@class='sc-jJoQJp ieRzNh MuiMenuItem-root MuiMenuItem-gutters MuiButtonBase-root sc-jOxtWs iooOuN sc-bTfYFJ yMMnq'])[6]"));
        dropdownOption.click();
    }
    @Given("user eneters tarifname {string}")
    public void user_eneters_tarifname(String name) {
      driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
    }
    @Given("user selects time {string}")
    public void user_selects_time(String time) {
        driver.findElement(By.xpath("//input[@name='time']")).sendKeys(time);
    }
    @Given("user select type")
    public void user_select_type() {
        WebElement dropdownButton = driver.findElement(By.xpath("(//div[@class='sc-jeraig cyGdiz MuiFormControl-root sc-hmjpVf hGEnFv'])[2]"));
        dropdownButton.click();

        WebElement dropdownOption = driver.findElement(By.xpath("(//li[@class='sc-jJoQJp ieRzNh MuiMenuItem-root MuiMenuItem-gutters MuiButtonBase-root sc-jOxtWs iooOuN sc-bTfYFJ yMMnq'])[3]"));
        dropdownOption.click();
    }
    @Given("user enter cost {string}")
    public void user_enter_cost(String price) {
        driver.findElement(By.xpath("//input[@name='price']")).sendKeys(price);
    }

    @Given("user select region")
    public void user_select_region() {
        WebElement dropdownButton = driver.findElement(By.xpath("(//div[@class='sc-jeraig cyGdiz MuiFormControl-root sc-hmjpVf hGEnFv'])[3]"));
        dropdownButton.click();

        WebElement dropdownOption = driver.findElement(By.xpath("(//li[@class='sc-jJoQJp ieRzNh MuiMenuItem-root MuiMenuItem-gutters MuiButtonBase-root sc-jOxtWs iooOuN sc-bTfYFJ yMMnq'])[6]"));
        dropdownOption.click();
    }
    @Given("user select availability")
    public void user_select_availability() {
      driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
    }
    @Given("user enters graphic coordinates {string}")
    public void user_enters_graphic_coordinates(String string) {
       driver.findElement(By.xpath("//textarea[@id='mui-5']")).sendKeys(string);
    }
    @Given("user enters add {string}")
    public void user_enters_add(String string) {
        driver.findElement(By.xpath("//textarea[@id='mui-6']")).sendKeys(string);
    }
    @Then("user verifies that tariff was created")
    public void user_verifies_that_tariff_was_created() {
     driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("the tariff should be created successfully")
    public void the_tariff_should_be_created_successfully() {
        Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Hawaii']")).isDisplayed());
    }
}