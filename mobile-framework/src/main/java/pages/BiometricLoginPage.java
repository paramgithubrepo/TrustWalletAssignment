package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitTimeOuts;

public class BiometricLoginPage extends BasePage {

    @FindBy(xpath = "//*[@text='Biometric Login']")
    public WebElement biometricLoginTitle;

    @FindBy(xpath = "//*[@text='Biometric Login']/following-sibling::android.widget.TextView")
    public WebElement biometricLoginMessage;

    @FindBy(xpath = "//*[@text='Deny']")
    public WebElement biometricLoginDenyButton;

    @FindBy(xpath = "//*[@text='Confirm']")
    public WebElement biometricLoginConfirmButton;

    public BiometricLoginPage() {
        super();
    }

    public boolean ifBiometricLoginPageDisplayed() {
        return waitUntilElementIsDisplayed(biometricLoginTitle, WaitTimeOuts.SHORT_WAIT_IN_SECONDS);
    }

    public void selectBiometricLogin(String biometricLoginOption) {
        switch (biometricLoginOption) {
            case "Deny": {
                biometricLoginDenyButton.click();
                break;
            }
            case "Confirm": {
                biometricLoginConfirmButton.click();
                break;
            }
        }
    }

}
