package com.ebay.api.app.response;

import java.net.URI;

public class UserAuthorizationUrlResponse {

  private final URI url;

  public UserAuthorizationUrlResponse(URI url) {
    this.url = url;
  }

  public URI getUrl() {
    return url;
  }

}
