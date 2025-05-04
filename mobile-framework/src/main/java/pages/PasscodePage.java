package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AppContext;
import utils.WaitTimeOuts;

public class PasscodePage extends BasePage {

    @FindBy(xpath = "//*[@text='Create passcode']")
    public WebElement createPasscodePageTitle;

    @FindBy(xpath = "//*[@text='Confirm passcode']")
    public WebElement confirmPasscodePageTitle;

    @FindBy(xpath = "//*[@text='Create passcode']/following-sibling::android.view.View[1]")
    public WebElement createPasscodeView;

    @FindBy(xpath = "//*[@text='Confirm passcode']/following-sibling::android.view.View[1]")
    public WebElement confirmPasscodeView;

    @FindBy(xpath = "//*[@text='Create passcode']/following-sibling::android.widget.TextView[1]")
    public WebElement createPasscodeMessage;

    @FindBy(xpath = "//*[@text='Confirm passcode']/following-sibling::android.widget.TextView[1]")
    public WebElement confirmPasscodeMessage;

    @FindBy(xpath = "//*[@content-desc='Back']")
    public WebElement backButton;

    public PasscodePage() {
        super();
    }

    public boolean ifCreatePasscodePageDisplayed() {
        return waitUntilElementIsDisplayed(createPasscodePageTitle, WaitTimeOuts.SHORT_WAIT_IN_SECONDS);
    }

    public boolean ifConfirmPasscodePageDisplayed() {
        return waitUntilElementIsDisplayed(confirmPasscodePageTitle, WaitTimeOuts.SHORT_WAIT_IN_SECONDS);
    }

    public void enterPasscode() {
        for (int passcodeDigit: AppContext.passcode) {
            super.driver.findElement(By.xpath(
                    "//android.widget.TextView[@text='"
                    + passcodeDigit
                    + "']")).click();
        }
    }

    public void createNewPasscode() {
        for (int ite = 0; ite < 6; ite++) {
            AppContext.passcode[ite] = new Faker().number().randomDigit();
        }
    }

}
