# Mobile Framework

## Features

- Executing automation scripts in Android Device
- Executes in Run / Debug Mode in any editors (Say Eclipse / IntelliJ)
- Executed from command prompt
- Can be integrated to pipeline scripts

## Requirements

- JDK 20
- Maven
- Android Studio / Platform Tools
- Appium
- Appium Inspector
- APK file in path: src/test/resources/apk/TrustWallet.apk

## Build and Run
#### Using Maven
#### Command
mvn clean test -Dcucumber.options="--tag {TAG}"
#### Example
mvn clean test -Dcucumber.options="--tag @CreateWallet"

#### Using Editors in Run / Debug Mode
#### Cucumber Run Configurations
glue: tests

### App package / APK File & Path / Appium Url
These can updated in the config file:
src/main/resources/config.properties

#### These properties can also be overridden at runtime from commandprompt
- -Dapp.package=com.wallet.crypto.trustapp
- -Dapk.path=/src/test/resources/apk/TrustWallet.apk
- -Dappium.url=http://localhost:4723

### Example
- mvn clean test -Dcucumber.options="--tag @CreateWallet" -Dapp.package=com.wallet.crypto.trustapp

### Cucumber reports with screenshots are generated in below path
mobile-framework\target
