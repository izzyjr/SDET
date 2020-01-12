package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepsTwo {
    @Given("^user navigates to stackoverflow website two$")
    public void user_navigates_to_stackoverflow_website_two() throws Throwable {
        System.out.println("user_navigates_to_stackoverflow_website_two");
    }

    @Given("^user clicks on the login button on homepage two$")
    public void user_clicks_on_the_login_button_on_homepage_two() throws Throwable {
        System.out.println("user_clicks_on_the_login_button_on_homepage_two");
    }

    @Given("^user enters a valid username two$")
    public void user_enters_a_valid_username_two() throws Throwable {
        System.out.println("user_enters_a_valid_username_two");
    }

    @Given("^user enters a valid password two$")
    public void user_enters_a_valid_password_two() throws Throwable {
        System.out.println("user_enters_a_valid_password_two");
    }

    @When("^user clicks on the login button two$")
    public void user_clicks_on_the_login_button_two() throws Throwable {
        System.out.println("user_clicks_on_the_login_button_two");
    }

    @Then("^user should be taken to the successful login page two$")
    public void user_should_be_taken_to_the_successful_login_page_two() throws Throwable {
        System.out.println("user_should_be_taken_to_the_successful_login_page_two");
    }
}
