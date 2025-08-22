package ui.stepDefinitions;

import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import ui.pages.MainPage;
import utils.Driver;


public class SignUpSteps {

    WebDriver driver = Driver.getDriver();
    MainPage mainPage = new MainPage(driver);
    private static final Logger logger = LogManager.getLogger(SignUpSteps.class);


    @Given("user is on {string}")
    public void user_is_on(String url) {
        logger.info("Opening the url: " + url);
        driver.get(url);
        logger.info("Successfully loaded new page: " + url);
    }

    @When("user clicks on sign up button")
    public void user_clicks_on_sign_up_button() {
        mainPage.signUpButton.click();
        logger.info("user clicked on sign up button");
    }

    @When("user provides email {string}, password {string}, confirm password {string}")
    public void user_provides_email_password_confirm_password(String email, String password, String confirmPassword) {
        mainPage.email.sendKeys(email);
        logger.info("user entered email: " + email);

        mainPage.password.sendKeys(password);
        logger.info("user entered password: " + password);

        mainPage.confirmPassword.sendKeys(confirmPassword);
        logger.info("user entered confirmation password: " + confirmPassword);
    }

    @When("user clicks on continue")
    public void user_clicks_on_continue() {

    }
    @Then("verify sign up form appeared")
    public void verify_sign_up_form_appeared() {

    }
    @Then("user provides first name {string}, last name {string}, name of business {string}, area of business {string}, currency {string}")
    public void user_provides_first_name_last_name_name_of_business_area_of_business_currency(String fName, String lName, String nameOfBusiness, String areaOfBusiness, String currency) {

    }
    @Then("user clicks on final green sign up button")
    public void user_clicks_on_final_green_sign_up_button() {

    }
    @Then("verify user is signed in")
    public void verify_user_is_signed_in() {

    }
}
