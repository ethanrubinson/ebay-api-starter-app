package com.ebay.api.app.context;

import com.ebay.api.client.auth.oauth2.model.Environment;
import com.ebay.sdk.ApiContext;

public class OAuthApiContext extends ApiContext {

  private static final String PRODUCTION_SOAP_API_URL = "https://api.ebay.com/wsapi";

  private static final String SANDBOX_SOAP_API_URL = "https://api.sandbox.ebay.com/wsapi";

  public OAuthApiContext(Environment environment, String userToken) {

    if (environment == Environment.PRODUCTION) {
      super.setApiServerUrl(PRODUCTION_SOAP_API_URL);
    } else if (environment == Environment.SANDBOX) {
      super.setApiServerUrl(SANDBOX_SOAP_API_URL);
    } else {
      throw new IllegalArgumentException("Unrecognized eBay environment.");
    }

    super.getApiCredential().setOAuthToken(userToken);
  }

}
