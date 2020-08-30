package PageObjects;

import Utilities.Constant;
import Utilities.config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;

    public void beforeSuite() {
        if (config.Browser.browser.equalsIgnoreCase("ff")) {
            System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
            driver = new FirefoxDriver();
            //signIn("Dinesh_Test@test.com", "Jan@2019");
            driver.get(config.url.appurl);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } else if (config.Browser.browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
            driver = new ChromeDriver();
           // signIn("Dinesh_Test@test.com", "Jan@2019");
            driver.get(config.url.appurl);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }
    }

    public void signIn(String username, String Password) {
        driver.get(config.url.appurl);
        driver.findElement(By.cssSelector(".login")).click();
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(Password);
        driver.findElement(By.id("SubmitLogin")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //waittillElementLoad(10,By.cssSelector("#center_column > h1"));
    }

    public void afterSuite() {
        if (null != driver) {
            driver.quit();
        }
    }
}
