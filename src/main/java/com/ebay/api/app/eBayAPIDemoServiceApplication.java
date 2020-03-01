package com.ebay.api.app;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ebay.api.client.auth.oauth2.CredentialUtil;

@SpringBootApplication
public class eBayAPIDemoServiceApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(eBayAPIDemoServiceApplication.class);

  private static final String EBAY_CONFIG = "ebay-config.yaml";

  public static void main(String[] args) {
    try (final InputStream fis = eBayAPIDemoServiceApplication.class.getClassLoader()
                                                                    .getResourceAsStream(EBAY_CONFIG);) {
      CredentialUtil.load(fis);
    } catch (Exception credFailureEx) {
      LOGGER.error("Failed to load eBay configuration.", credFailureEx);
      return;
    }

    SpringApplication.run(eBayAPIDemoServiceApplication.class);
  }

}
