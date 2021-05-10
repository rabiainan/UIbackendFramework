package Utils;

import com.framework.Pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;

public class Utils extends Base {

    public static String getGlobalProperties(String key) throws IOException {
        File propFile = new File("src/test/resources/app.Properties");
        FileInputStream stream = new FileInputStream(propFile);
        Properties prop = new Properties();
        prop.load(stream);
        return prop.get(key).toString();
    }

    public WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


}
