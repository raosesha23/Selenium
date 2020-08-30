package Tests;

import PageObjects.AmazonPage;
import PageObjects.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AmazonTest extends BaseClass {
AmazonPage amazonpage;

    @BeforeMethod
    public void Login() throws IOException {
        beforeSuite();
        amazonpage = new AmazonPage();
    }

    @Test
    public void AmazonSearchTest() {

            amazonpage.SearchTextBox.click();
            amazonpage.SearchTextBox.sendKeys("IPhone6s");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            amazonpage.SearchSubmitButton.click();

            System.out.println("Selenium test is Pass");

    }

    @AfterMethod
    public void BrowserQuit() {
        afterSuite();
    }

}
