package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AmazonPage extends BaseClass {
    public @FindBy(id = "twotabsearchtextbox")
    WebElement SearchTextBox;
    public @FindBy(xpath = "//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")
    WebElement SearchSubmitButton;

    public AmazonPage() throws IOException {
        PageFactory.initElements(driver, this);
    }
}
