package org.opencart.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.opencart.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDef {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        driver=new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Given("I am on the OpenCart login page")
    public void i_am_on_the_open_cart_login_page() {
       driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       driver.manage().window().maximize();
       loginPage=new LoginPage(driver);
    }
    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPage.enterEmail("bikoushik557@gmail.com");
        loginPage.enterPassword("Test123");
    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickOnSignOnButton();
    }
    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertEquals(loginPage.checkLogoutLink(),true);

    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String userName, String Password) {
        loginPage.enterEmail(userName);
        loginPage.enterPassword(Password);
    }

    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String errorMsg) {
        Assert.assertEquals(loginPage.getInvalidCredErrorMsg().contains(errorMsg),true);
    }

    @When("I click on the {string} Link")
    public void i_click_on_the_link(String string) {
        loginPage.clickOnForgottenPasswordLink();
    }
    @Then("I should be redirected to password reset page")
    public void i_should_be_redirected_to_password_reset_page() {
       Assert.assertEquals(loginPage.getForgotPwdPageURL(),"https://naveenautomationlabs.com/opencart/index.php?route=account/forgotten");
    }
}
