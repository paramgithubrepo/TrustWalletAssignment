package tests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import utils.Constants;

public class CreateWalletSteps {

    ActionBarRootPage actionBarRootPage = new ActionBarRootPage();
    PasscodePage passcodePage = new PasscodePage();
    BiometricLoginPage biometricLoginPage = new BiometricLoginPage();
    EnableNotificationPage enableNotificationPage = new EnableNotificationPage();
    WalletReadyPage walletReadyPage = new WalletReadyPage();
    HomePage homePage = new HomePage();

    @Given("I access the Trust Wallet application")
    public void iAccessTheTrustWalletApplication() {
        Assert.assertTrue(actionBarRootPage.ifActionBarRootPageDisplayed(), "Action Bar Root Page NOT displayed");
        Assert.assertTrue(actionBarRootPage.iAlreadyhaveAWalletButton.isDisplayed(), "I already have a wallet button NOT displayed");
        Assert.assertTrue(actionBarRootPage.serviceTermsAndPrivacyPolicyText.isDisplayed(), "Terms and Privacy Policy NOT displayed");
        Assert.assertTrue(actionBarRootPage.verifyAdLinesDisplayedSuccessively(), "AD Lines Missing");
    }

    @When("I select {string}")
    public void iSelect(String walletCreationOption) {
        actionBarRootPage.selectCreateOrImportWallet(walletCreationOption);
    }

    @And("I enter a new passcode")
    public void iEnterANewPasscode() {
        Assert.assertTrue(passcodePage.ifCreatePasscodePageDisplayed(), "Create Passcode Page NOT displayed");
        Assert.assertTrue(passcodePage.createPasscodeView.isDisplayed(), "Create Passcode View NOT displayed");
        Assert.assertTrue(passcodePage.createPasscodeMessage.isDisplayed(), "Create Passcode Message NOT displayed");
        Assert.assertEquals(passcodePage.createPasscodeMessage.getText(), Constants.ENTER_PASSCODE_MESSAGE, "Create passcode message not valid");
        Assert.assertTrue(passcodePage.backButton.isDisplayed(), "Create Passcode Page Back Button NOT displayed");
        passcodePage.createNewPasscode();
        passcodePage.enterPasscode();
    }

    @And("I reenter and confirm the passcode")
    public void iReenterAndConfirmThePasscode() {
        Assert.assertTrue(passcodePage.ifConfirmPasscodePageDisplayed(), "Confirm Passcode Page NOT displayed");
        Assert.assertTrue(passcodePage.confirmPasscodeView.isDisplayed(), "Confirm Passcode View NOT displayed");
        Assert.assertTrue(passcodePage.confirmPasscodeMessage.isDisplayed(), "Confirm Passcode Message NOT displayed");
        Assert.assertEquals(passcodePage.confirmPasscodeMessage.getText(), Constants.CONFIRM_PASSCODE_MESSAGE, "Enter passcode message not valid");
        Assert.assertTrue(passcodePage.backButton.isDisplayed(), "Confirm Passcode Page Back Button NOT displayed");
        passcodePage.enterPasscode();
    }

    @And("I {string} the Biometric Login")
    public void iTheBiometricLogin(String biometricLoginOption) {
        Assert.assertTrue(biometricLoginPage.ifBiometricLoginPageDisplayed(), "Biometric Login Page NOT displayed");
        Assert.assertTrue(biometricLoginPage.biometricLoginMessage.isDisplayed(), "Biometric Login Message NOT displayed");
        Assert.assertEquals(biometricLoginPage.biometricLoginMessage.getText(), Constants.BIOMETRIC_LOGIN_MESSAGE, "Biometric Login message not valid");
        Assert.assertTrue(biometricLoginPage.biometricLoginDenyButton.isDisplayed(), "Biometric Deny Button NOT displayed");
        Assert.assertTrue(biometricLoginPage.biometricLoginConfirmButton.isDisplayed(), "Biometric Confirm Button NOT displayed");
        biometricLoginPage.selectBiometricLogin(biometricLoginOption);
    }

    @And("I {string} turn on notification")
    public void iTurnOnNotification(String enableNotificationOption) {
        Assert.assertTrue(enableNotificationPage.ifEnableNotificationPageDisplayed(), "Enable Notification Page NOT displayed");
        Assert.assertTrue(enableNotificationPage.enableNotificationMessage.isDisplayed(), "Enable Notification Message NOT displayed");
        Assert.assertEquals(enableNotificationPage.enableNotificationMessage.getText(), Constants.ENABLE_NOTIFICATION_MESSAGE, "Enable Notification message not valid");
        Assert.assertTrue(enableNotificationPage.enableNotificationButton.isDisplayed(), "Enable Notification Button NOT displayed");
        Assert.assertTrue(enableNotificationPage.skipButton.isDisplayed(), "Enable Notification Skip Button NOT displayed");
        enableNotificationPage.selectEnableNotification(enableNotificationOption);
    }

    @Then("A new wallet is created successfully")
    public void aNewWalletIsCreatedSuccessfully() {
        Assert.assertTrue(walletReadyPage.ifWalletReadyPageDisplayed(), "Wallet Ready Page NOT displayed");
        Assert.assertTrue(walletReadyPage.walletReadyMessage.isDisplayed(), "Wallet Ready Message NOT displayed");
        Assert.assertEquals(walletReadyPage.walletReadyMessage.getText(), Constants.WALLET_READY_MESSAGE, "Wallet Ready message not valid");
        Assert.assertTrue(walletReadyPage.buyCryptoButton.isDisplayed(), "Buy Crypto Button NOT displayed");
        Assert.assertTrue(walletReadyPage.depositCryptoButton.isDisplayed(), "Deposit Crypto Button NOT displayed");
        Assert.assertTrue(walletReadyPage.skipButton.isDisplayed(), "Skip Crypto Button NOT displayed");
    }

    @When("I {string} crypto on wallet creation")
    public void iCryptoOnWalletCreation(String skipBuyDepositCryptoOption) {
        walletReadyPage.skipBuyDepositCrypto(skipBuyDepositCryptoOption);
    }

    @Then("Home page is displayed successfully")
    public void homePageIsDisplayedSuccessfully() {
        Assert.assertTrue(homePage.ifHomePageDisplayed(), "Home Page NOT displayed");
        Assert.assertTrue(homePage.topBarHistoryIcon.isDisplayed(), "TopBarHistoryIcon NOT displayed");
        Assert.assertTrue(homePage.topBarQrIcon.isDisplayed(), "TopBarQrIcon NOT displayed");
        Assert.assertTrue(homePage.topBarSearchIcon.isDisplayed(), "TopBarSearchIcon NOT displayed");
        Assert.assertTrue(homePage.topBarWalletName.isDisplayed(), "TopBarWalletName NOT displayed");
        Assert.assertTrue(homePage.topBarWalletNameItemIcon.isDisplayed(), "TopBarWalletNameItemIcon NOT displayed");
        Assert.assertTrue(homePage.mainBalance.isDisplayed(), "MainBalance NOT displayed");
        Assert.assertTrue(homePage.mainBalanceChangePercentage.isDisplayed(), "MainBalanceChangePercentage NOT displayed");
        Assert.assertTrue(homePage.sendButton.isDisplayed(), "SendButton NOT displayed");
        Assert.assertTrue(homePage.sendButtonText.isDisplayed(), "SendButtonText NOT displayed");
        Assert.assertTrue(homePage.receiveButton.isDisplayed(), "ReceiveButton NOT displayed");
        Assert.assertTrue(homePage.receiveButtonText.isDisplayed(), "ReceiveButtonText NOT displayed");
        Assert.assertTrue(homePage.buyButton.isDisplayed(), "BuyButton NOT displayed");
        Assert.assertTrue(homePage.buyButtonText.isDisplayed(), "BuyButtonText NOT displayed");
        Assert.assertTrue(homePage.sellButton.isDisplayed(), "SellButton NOT displayed");
        Assert.assertTrue(homePage.sellButtonText.isDisplayed(), "SellButtonText NOT displayed");
        Assert.assertTrue(homePage.homeBannerSlide.isDisplayed(), "HomeBannerSlide NOT displayed");
        Assert.assertTrue(homePage.cryptoTab.isDisplayed(), "CryptoTab NOT displayed");
        Assert.assertTrue(homePage.nftTab.isDisplayed(), "NftTab NOT displayed");
        Assert.assertTrue(homePage.homeNavigationButton.isDisplayed(), "HomeNavigationButton NOT displayed");
        Assert.assertTrue(homePage.trendingTokenNavigationButton.isDisplayed(), "trendingTokenNavigationButton NOT displayed");
        Assert.assertTrue(homePage.swapNavigationButton.isDisplayed(), "SwapNavigationButton NOT displayed");
        Assert.assertTrue(homePage.earnNavigationButton.isDisplayed(), "EarnNavigationButton NOT displayed");
        Assert.assertTrue(homePage.discoverNavigationButton.isDisplayed(), "DiscoverNavigationButton NOT displayed");
    }

}
