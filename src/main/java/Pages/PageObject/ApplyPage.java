package Pages.PageObject;

import Base.TestBase;
import Pages.Locators.ILabLocators;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ApplyPage extends TestBase {

    public ILabLocators iLabLocators;

    public ApplyPage() {

        this.iLabLocators = new ILabLocators();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 2);
        PageFactory.initElements(factory, this.iLabLocators);
    }

    public void apply(String name, String email, String phone_number, String error_message) {
        try {
            iLabLocators.careersButton.click();
            iLabLocators.southAfricaButton.click();
            iLabLocators.role.click();
            iLabLocators.applyOnlineButton.click();
            iLabLocators.name.sendKeys(name);
            iLabLocators.email.sendKeys(email);
            iLabLocators.phoneNumber.sendKeys(phone_number);
            iLabLocators.submitApplication.click();
            iLabLocators.verifyText.getText().contains(error_message);

        } catch (Exception e) {

            e.printStackTrace();
        }
        if(iLabLocators.getVerifyText.isDisplayed()){
            System.out.println("Application Successful");
        }
        else{
            throw new AssertionError("Application Failed");
        }

    }
}
