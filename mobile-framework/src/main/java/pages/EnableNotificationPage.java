package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitTimeOuts;

public class EnableNotificationPage extends BasePage {

    @FindBy(xpath = "//*[@text='Keep up with the market!']")
    public WebElement enableNotificationTitle;

    @FindBy(xpath = "//*[@text='Keep up with the market!']/following-sibling::android.widget.TextView")
    public WebElement enableNotificationMessage;

    @FindBy(xpath = "//*[@text='Enable Notifications']/following-sibling::android.widget.Button")
    public WebElement enableNotificationButton;

    @FindBy(xpath = "//*[@resource-id='secondaryAction']")
    public WebElement skipButton;

    public EnableNotificationPage() {
        super();
    }

    public boolean ifEnableNotificationPageDisplayed() {
        return waitUntilElementIsDisplayed(enableNotificationTitle, WaitTimeOuts.SHORT_WAIT_IN_SECONDS);
    }

    public void selectEnableNotification(String enableNotificationOption) {
        switch (enableNotificationOption) {
            case "Enable": {
                enableNotificationButton.click();
                break;
            }
            case "Skip": {
                skipButton.click();
                break;
            }
        }
    }

}
