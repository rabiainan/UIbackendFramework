package com.framework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;


public class HomePage extends Base {

    @FindBy(xpath = "(//a[contains(text(),'Sign up')])[1]")
    private WebElement signUpButton;

    public void NavigateToHomePage() throws IOException {
        driver.get(ReadFromGlobalProperties("WebBaseURL"));

    }

    public SignUpPage clickSignUp() {
        signUpButton.click();
        return new SignUpPage();
    }

}
