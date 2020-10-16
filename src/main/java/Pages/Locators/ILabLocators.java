package Pages.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ILabLocators {

    @FindBy(xpath = "(//a[contains(.,'CAREERS')])[1]")
    public WebElement careersButton;

    @FindBy(xpath = "(//a[contains(.,'South Africa')])[1]")
    public WebElement southAfricaButton;

    @FindBy(xpath = "//a[contains(.,'Interns - BSC Computer Science, National Diploma: IT Development Graduates')]")
    public WebElement role;

    @FindBy(xpath = "//a[contains(.,'Apply Online')]")
    public WebElement applyOnlineButton;

    @FindBy(xpath = "//input[contains(@id,'name')]")
    public WebElement name;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//input[@id='wpjb_submit']")
    public WebElement submitApplication;

    @FindBy(xpath = "//li[contains(.,'You need to upload at least one file.')]")
    public WebElement verifyText;

    @FindBy(id = "li[contains(.,'You need to upload at least one file.')]")
    public WebElement getVerifyText;


}
