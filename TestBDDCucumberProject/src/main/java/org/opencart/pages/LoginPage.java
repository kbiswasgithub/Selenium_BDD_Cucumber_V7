package org.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    //Locators
    private By emailInputLocator = By.name("email");
    private By passwordInputLocator= By.name("password");
    private By loginButtonLocator= By.xpath("//input[@type='submit']");
    private By forgotPasswordLinkLocator= By.linkText("Forgotten Password");
    private By logoutLinkLocator= By.linkText("Logout");
    private By errorMsgLocator= By.xpath("//div[contains(text(),'No match')]");

    //Constructor
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    //page methods/actions
    public void enterEmail(String email){
        WebElement emailInput=driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password){
        WebElement emailInput=driver.findElement(passwordInputLocator);
        emailInput.sendKeys(password);
    }

    public void clickOnSignOnButton(){
        WebElement loginButton=driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public void clickOnForgottenPasswordLink(){
        WebElement forgotPasswordLink=driver.findElement(forgotPasswordLinkLocator);
        forgotPasswordLink.click();
    }

    public void clickOnLogoutButton(){
        WebElement logoutButton=driver.findElement(logoutLinkLocator);
        logoutButton.click();
    }

    public void loginToOpenCart(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickOnSignOnButton();

    }

    public String getForgotPwdPageURL(){
        String forgotPwdPageURL=driver.getCurrentUrl();
        return forgotPwdPageURL;
    }

    public String getInvalidCredErrorMsg(){
        String errorMsg=driver.findElement(errorMsgLocator).getText().trim();
        return errorMsg;
    }

    public boolean checkLogoutLink(){
        return(driver.findElement(logoutLinkLocator).isDisplayed());

    }


}
