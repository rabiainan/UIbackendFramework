package com.framework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage  extends Base{

    @FindBy(id = "user_login")
    private WebElement username;

    @FindBy(xpath= "(//div[contains(@class,'mb-1')])[2]")
    public WebElement errormessage;

    public void typeUsername (String nameValue){
        username.sendKeys(nameValue);

    }
    public String getErrorMessage (){
        return errormessage.getText();

    }

}
