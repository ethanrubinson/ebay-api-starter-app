package com.ebay.api.app.resource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;

import org.apache.commons.lang3.StringUtils;

public final class HttpRequestUtil {

  private static final String BEARER_AUTHENTICATION_SCHEME = "Bearer";

  public static String getOAuthToken(HttpServletRequest req) {
    final String authHeader = req.getHeader(HttpHeaders.AUTHORIZATION);
    final String token;
    if (StringUtils.isBlank(authHeader)
        || StringUtils.isBlank(token = authHeader.replaceFirst(BEARER_AUTHENTICATION_SCHEME + StringUtils.SPACE,
            StringUtils.EMPTY))) {
      return null;
    } else {
      return token;
    }
  }

}
