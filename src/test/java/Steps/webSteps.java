package Steps;

import Utils.Utils;
import com.framework.Pages.Base;
import com.framework.Pages.HomePage;
import com.framework.Pages.SignUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class webSteps extends Base {

    private static HomePage homePage = new HomePage();
    private static SignUpPage signUpPage;
    Utils utils= new Utils();
    String name;

    @Given("User landed to Github")
    public void userLandedToGithub() throws IOException {

        homePage.NavigateToHomePage();
    }

    @And("user click Sign up button")
    public void userClickSignUpButton() {

        signUpPage= homePage.clickSignUp();
    }

    @Given("user types {string} as user name")
    public void userTypesAsUserName(String nameValue) throws InterruptedException {

        signUpPage.typeUsername(nameValue);
        Thread.sleep(5000);
        utils.waitForVisibility(signUpPage.errormessage,3);
    }

    @Then("user should get user not available message")
    public void userShouldGetUserNotAvailableMessage() {

        Assert.assertTrue(signUpPage.errormessage.isDisplayed());

        System.out.println(signUpPage.getErrorMessage());

    }

    @And("UI shows correct availability of username")
    public void uiShowsCorrectAvailabilityOfUsername() {

        List<WebElement> listofUsername = driver.findElements(By.xpath("//div[@class='js-suggested-usernames-container ']/span"));

        for (WebElement link : listofUsername) {
            System.out.println(link.getText());
        }

        Assert.assertTrue(listofUsername.get(0).isDisplayed());
        Assert.assertTrue(listofUsername.get(1).isDisplayed());
        Assert.assertTrue(listofUsername.get(2).isDisplayed());

    }
}
