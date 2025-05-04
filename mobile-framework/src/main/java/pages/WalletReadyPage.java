package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitTimeOuts;

public class WalletReadyPage extends BasePage {

    @FindBy(xpath = "//*[@text='Brilliant, your wallet is ready!']")
    public WebElement walletReadyTitle;

    @FindBy(xpath = "//*[@text='Brilliant, your wallet is ready!']/following-sibling::android.widget.TextView")
    public WebElement walletReadyMessage;

    @FindBy(xpath = "//*[@text='Buy Crypto']/following-sibling::android.widget.Button")
    public WebElement buyCryptoButton;

    @FindBy(xpath = "//*[@text='Deposit Crypto']/following-sibling::android.widget.Button")
    public WebElement depositCryptoButton;

    @FindBy(xpath = "//*[contains(@text,'Skip')]")
    public WebElement skipButton;

    public WalletReadyPage() {
        super();
    }

    public boolean ifWalletReadyPageDisplayed() {
        return waitUntilElementIsDisplayed(walletReadyTitle, WaitTimeOuts.SHORT_WAIT_IN_SECONDS);
    }

    public void skipBuyDepositCrypto(String skipBuyDepositCryptoOption) {
        switch (skipBuyDepositCryptoOption) {
            case "Buy": {
                buyCryptoButton.click();
                break;
            }
            case "Deposit": {
                depositCryptoButton.click();
                break;
            }
            case "Skip": {
                skipButton.click();
                break;
            }
        }
    }

}
