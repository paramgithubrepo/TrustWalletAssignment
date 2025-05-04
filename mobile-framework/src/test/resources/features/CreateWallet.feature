@CreateWallet
Feature: Create Wallet
  As a new user
  I access Trust Wallet application
  To create a new wallet account

  Background:
    Given I access the Trust Wallet application

  Scenario: Create new wallet successfully
    When I select "Create new wallet"
    And I enter a new passcode
    And I reenter and confirm the passcode
    And I "Deny" the Biometric Login
    And I "Skip" turn on notification
    Then A new wallet is created successfully
    When I "Skip" crypto on wallet creation
    Then Home page is displayed successfully