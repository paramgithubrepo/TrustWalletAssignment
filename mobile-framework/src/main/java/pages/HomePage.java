package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WaitTimeOuts;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@resource-id='topBarHistoryIcon']")
    public WebElement topBarHistoryIcon;

    @FindBy(xpath = "//*[@resource-id='topBarQrIcon']")
    public WebElement topBarQrIcon;

    @FindBy(xpath = "//*[@resource-id='topBarSearchIcon']")
    public WebElement topBarSearchIcon;

    @FindBy(xpath = "//*[@resource-id='topBarWalletName']")
    public WebElement topBarWalletName;

    @FindBy(xpath = "//*[@resource-id='itemIcon']")
    public WebElement topBarWalletNameItemIcon;

    @FindBy(xpath = "//*[@resource-id='mainBalance']")
    public WebElement mainBalance;

    @FindBy(xpath = "//*[@resource-id='mainBalanceChange24h']")
    public WebElement mainBalanceChangePercentage;

    @FindBy(xpath = "//*[@resource-id='HomeSendButton']")
    public WebElement sendButton;

    @FindBy(xpath = "//*[@resource-id='HomeSendButton']/android.widget.TextView")
    public WebElement sendButtonText;

    @FindBy(xpath = "//*[@resource-id='HomeSendButton']")
    public WebElement receiveButton;

    @FindBy(xpath = "//*[@resource-id='HomeSendButton']/android.widget.TextView")
    public WebElement receiveButtonText;

    @FindBy(xpath = "//*[@resource-id='HomeSendButton']")
    public WebElement buyButton;

    @FindBy(xpath = "//*[@resource-id='HomeSendButton']/android.widget.TextView")
    public WebElement buyButtonText;

    @FindBy(xpath = "//*[@resource-id='HomeSendButton']")
    public WebElement sellButton;

    @FindBy(xpath = "//*[@resource-id='HomeSendButton']/android.widget.TextView")
    public WebElement sellButtonText;

    @FindBy(xpath = "//*[@resource-id='bannerSlide']")
    public WebElement homeBannerSlide;

    @FindBy(xpath = "//*[@resource-id='Crypto']")
    public WebElement cryptoTab;

    @FindBy(xpath = "//*[@resource-id='NFTs']")
    public WebElement nftTab;

    @FindBy(xpath = "//*[@resource-id='HomeNavigationButton']")
    public WebElement homeNavigationButton;

    @FindBy(xpath = "//*[@resource-id='TrendingTokenNavigationButton']")
    public WebElement trendingTokenNavigationButton;

    @FindBy(xpath = "//*[@resource-id='SwapNavigationButton']")
    public WebElement swapNavigationButton;

    @FindBy(xpath = "//*[@resource-id='EarnNavigationButton']")
    public WebElement earnNavigationButton;

    @FindBy(xpath = "//*[@resource-id='DiscoverNavigationButton']")
    public WebElement discoverNavigationButton;

    public HomePage() {
        super();
    }

    public boolean ifHomePageDisplayed() {
        return waitUntilElementIsDisplayed(homeBannerSlide, WaitTimeOuts.MEDIUM_WAIT_IN_SECONDS);
    }

}
