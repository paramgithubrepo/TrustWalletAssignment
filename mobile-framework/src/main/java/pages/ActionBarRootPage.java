package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Constants;
import utils.WaitTimeOuts;

public class ActionBarRootPage extends BasePage {

    @FindBy(xpath = "//*[@resource-id='CreateNewWalletButton']/android.widget.Button")
    public WebElement createNewWalletBtn;

    @FindBy(xpath = "//*[@resource-id='ImportWalletButton']/android.widget.Button")
    public WebElement iAlreadyhaveAWalletButton;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'agree')]")
    public WebElement serviceTermsAndPrivacyPolicyText;


    public ActionBarRootPage() {
        super();
    }

    public boolean ifActionBarRootPageDisplayed() {
        return waitUntilElementIsDisplayed(createNewWalletBtn, WaitTimeOuts.MEDIUM_WAIT_IN_SECONDS);
    }

    public boolean verifyAdLinesDisplayedSuccessively() {
        boolean adLineDisplayed = true;
        for (String adLine: Constants.AD_LINES) {
            adLineDisplayed = adLineDisplayed && waitUntilElementIsDisplayed(By.xpath(
                    "//android.widget.TextView[@text='"
                            + adLine
                            + "']"
            ), WaitTimeOuts.LONG_WAIT_IN_SECONDS);
        }
        return adLineDisplayed;
    }

    public void selectCreateOrImportWallet(String walletCreationOption) {
        switch (walletCreationOption) {
            case "Create new wallet": {
                createNewWalletBtn.click();
                break;
            }
            case "I already have a wallet": {
                iAlreadyhaveAWalletButton.click();
                break;
            }
        }
    }

}
