# ebay-api-demo

A sample Sprint Boot service integration with eBay APIs.

## Setup

### Install Java 8

Install Java 8 if you don't already have it installed. You should see something similar to the following output when running `java -version` in your console.

```bash
java version "1.8.0_121"
Java(TM) SE Runtime Environment (build 1.8.0_121-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.121-b13, mixed mode)
```

### Install the eBay Java SDK

Follow the instructions here: https://github.com/ethanrubinson/ebay-java-sdk


### Clone this repository

```bash
git clone https://github.com/ethanrubinson/ebay-api-demo
cd ebay-api-demo
```

### Create an SSL keypair

Make sure the keypair is located in `src/main/resources/keystore.p12`. Use `changeit` for the password. You can leave the other settings as default. If you change the filename or password, make sure to update the configuraiton in `application.properties`

```bash
cd src/main/resources
keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 3650
```

### Configure your eBay Developer Credentials

Create a file called `ebay-config.yaml` in `src/main/resources/ebay-config.yaml` with the following content:

```yaml
name: ebay-config

# UPDATE the appid, certid, and devid from https://developer.ebay.com/my/keys
# UPDATE the redirecturi with the value from `Your branded eBay Sandbox Sign In (OAuth)`
# https://developer.ebay.com/my/auth?env=sandbox&index=0 ( ....&redirect_uri=<USE_THIS_VALUE>&scope=...)
api.sandbox.ebay.com:
    appid: <appid-from-developer-portal>
    certid: <certid-from-developer-portal>
    devid: <devid-from-developer-portal>
    redirecturi: <redirect_uri-from-developer-portal>

# UPDATE the appid, certid, and devid from https://developer.ebay.com/my/keys
# UPDATE the redirecturi with the value from `Your branded eBay Production Sign In (OAuth)`
# https://developer.ebay.com/my/auth?env=production&index=0 ( ....&redirect_uri=<USE_THIS_VALUE>&scope=...)
api.ebay.com:
    appid: <appid-from-developer-portal>
    certid: <certid-from-developer-portal>
    devid: <devid-from-developer-portal>
    redirecturi: <redirect_uri-from-developer-portal>
```

### Build the eBay API Demo Application

Use Maven, or the Maven Wrapper to build and install the SDK. Make sure you run this from the project root `ebay-api-demo/`.

```bash
# Use an existing Maven installation
mvn clean install

# Use the Maven Wrapper on Unix
./mvnw clean install

# Use the Maven Wrapper for Batch
./mvnw.cmd clean install
```

## Running the eBay API Demo Sample

After you've built the sample, you can run it with the following command:

```bash
java -jar target/ebay-api-demo-0.0.1-SNAPSHOT.jar
```

You'll need to allow Chrome to accept self-signed SSL certificates for localhost. Enter the following in your navbar and flip the setting to "Enabled".

```
chrome://flags/#allow-insecure-localhost
```

### Get an Application Token

https://localhost:11443/v1/auth/app_token

### Get a User Authorization URL

https://localhost:11443/v1/auth/user_authorization_url

### Get a User Token

https://localhost:11443/v1/auth/user_token

