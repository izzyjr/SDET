package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginSteps {

    WebDriver driver;

    @Before()
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/israelmesa/Desktop/ChromeDriver/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

    }

    @Given("^user navigates to stackoverflow website$")
    public void user_navigates_to_stackoverflow_website() throws Throwable {
        System.out.println("user_navigates_to_stackoverflow_website");
    }

    @Given("^user clicks on the login button on homepage$")
    public void user_clicks_on_the_login_button_on_homepage() throws Throwable {
        System.out.println("user_clicks_on_the_login_button_on_homepage");
    }

    @Given("^user enters a valid username$")
    public void user_enters_a_valid_username() throws Throwable {
        System.out.println("user_clicks_on_the_login_button_on_homepage");
    }

    @Given("^user enters a valid password$")
    public void user_enters_a_valid_password() throws Throwable {
        System.out.println("user_enters_a_valid_password");
    }

    @When("^user clicks on the login button$")
    public void user_clicks_on_the_login_button() throws Throwable {
        System.out.println("user_clicks_on_the_login_button");
    }

    @Then("^user should be taken to the successful login page$")
    public void user_should_be_taken_to_the_successful_login_page() throws Throwable {
        System.out.println("user_should_be_taken_to_the_successful_login_page");
    }
}
