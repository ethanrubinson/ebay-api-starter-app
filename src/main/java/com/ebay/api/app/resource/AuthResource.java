package com.ebay.api.app.resource;

import java.net.URI;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ebay.api.app.context.Scope;
import com.ebay.api.app.response.ExtendedOAuthResponse;
import com.ebay.api.app.response.Message;
import com.ebay.api.client.auth.oauth2.OAuth2Api;
import com.ebay.api.client.auth.oauth2.model.Environment;
import com.ebay.api.client.auth.oauth2.model.OAuthResponse;

@Path("/auth")
public class AuthResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(AuthResource.class);

  private static final OAuth2Api EBAY_AUTH_API = new OAuth2Api();

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/app_token")
  public Response token() {
    try {
      final OAuthResponse _res = EBAY_AUTH_API.getApplicationToken(Environment.PRODUCTION, Scope.PUBLIC_SCOPE_ONLY);
      final ExtendedOAuthResponse res = new ExtendedOAuthResponse(_res);
      if (res.getErrorMessage() == null) {
        return Response.ok().entity(res).build();
      } else {
        return Response.status(Status.EXPECTATION_FAILED).entity(res).build();
      }
    } catch (Exception unexpectedEx) {
      LOGGER.error("Failed to generate an application token.", unexpectedEx);
      final Message msg = new Message(unexpectedEx.getMessage());
      return Response.serverError().entity(msg).build();
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/user_authorization_url")
  public Response userAuthorizationUrl(@QueryParam("redirect") boolean redirect) {
    try {
      final URI userAuthUrl = new URI(EBAY_AUTH_API.generateUserAuthorizationUrl(Environment.PRODUCTION,
          Scope.ALL_SCOPES, Optional.empty()));

      if (redirect) {
        return Response.temporaryRedirect(userAuthUrl).build();
      } else {
        return Response.ok().entity(userAuthUrl).build();
      }

    } catch (Exception unexpectedEx) {
      LOGGER.error("Failed to generate eBay sign in URL.", unexpectedEx);
      final Message msg = new Message(unexpectedEx.getMessage());
      return Response.serverError().entity(msg).build();
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/user_token")
  public Response accept(@QueryParam("code") String code) {
    if (StringUtils.isBlank(code)) {
      return userAuthorizationUrl(true);
    } else {
      try {
        final OAuthResponse res = EBAY_AUTH_API.exchangeCodeForAccessToken(Environment.PRODUCTION, code);
        if (StringUtils.isBlank(res.getErrorMessage())) {
          return Response.ok().entity(res).build();
        } else {
          return Response.serverError().entity(res).build();
        }
      } catch (Exception unexpectedEx) {
        LOGGER.error("Failed to exchange code for access token.", unexpectedEx);
        final Message msg = new Message(unexpectedEx.getMessage());
        return Response.serverError().entity(msg).build();
      }
    }
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/user_authorization_failure")
  public Response reject() {
    final Message msg = new Message("Authorization failed.");
    return Response.status(Status.UNAUTHORIZED).entity(msg).build();
  }

}
