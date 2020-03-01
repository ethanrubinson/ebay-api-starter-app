package com.ebay.api.app.response;

import java.util.Map;

import com.ebay.api.client.auth.oauth2.model.OAuthResponse;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtendedOAuthResponse extends OAuthResponse {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  private final Map<String, Object> errorMap;

  public ExtendedOAuthResponse(OAuthResponse res) {
    super(res.getErrorMessage());

    Map<String, Object> errorMap = null;
    if (super.getErrorMessage() == null) {
      super.setAccessToken(res.getAccessToken());
      super.setRefreshToken(res.getRefreshToken());
    } else {
      try {
        errorMap = OBJECT_MAPPER.readValue(super.getErrorMessage(), new TypeReference<Map<String, Object>>() {});
      } catch (Exception jsonEx) {
        // Do nothing; the error message just isn't valid JSON.
      }
    }
    this.errorMap = errorMap;
  }

  @JsonGetter("_errorMessage")
  public Map<String, Object> getErrorMessageAsMap() {
    return errorMap;
  }

}
