package com.ebay.api.app.context;

import java.util.Arrays;
import java.util.List;

public interface Scope {

  String PUBLIC = "https://api.ebay.com/oauth/api_scope";
  List<String> PUBLIC_SCOPE_ONLY = Arrays.asList(PUBLIC);

  String SELL_MARKETING_READONLY = "https://api.ebay.com/oauth/api_scope/sell.marketing.readonly";
  List<String> SELL_MARKETING_READONLY_SCOPE_ONLY = Arrays.asList(SELL_MARKETING_READONLY);

  String SELL_MARKETING = "https://api.ebay.com/oauth/api_scope/sell.marketing";
  List<String> SELL_MARKETING_SCOPE_ONLY = Arrays.asList(SELL_MARKETING);

  String SELL_INVENTORY_READONLY = "https://api.ebay.com/oauth/api_scope/sell.inventory.readonly";
  List<String> SELL_INVENTORY_READONLY_SCOPE_ONLY = Arrays.asList(SELL_INVENTORY_READONLY);

  String SELL_INVENTORY = "https://api.ebay.com/oauth/api_scope/sell.inventory";
  List<String> SELL_INVENTORY_SCOPE_ONLY = Arrays.asList(SELL_INVENTORY);

  String SELL_ACCOUNT_READONLY = "https://api.ebay.com/oauth/api_scope/sell.account.readonly";
  List<String> SELL_ACCOUNT_READONLY_SCOPE_ONLY = Arrays.asList(SELL_ACCOUNT_READONLY);

  String SELL_ACCOUNT = "https://api.ebay.com/oauth/api_scope/sell.account";
  List<String> SELL_ACCOUNT_SCOPE_ONLY = Arrays.asList(SELL_ACCOUNT);

  String SELL_FULFILLMENT_READONLY = "https://api.ebay.com/oauth/api_scope/sell.fulfillment.readonly";
  List<String> SELL_FULFILLMENT_READONLY_SCOPE_ONLY = Arrays.asList(SELL_FULFILLMENT_READONLY);

  String SELL_FULFILLMENT = "https://api.ebay.com/oauth/api_scope/sell.fulfillment";
  List<String> SELL_FULFILLMENT_SCOPE_ONLY = Arrays.asList(SELL_FULFILLMENT);

  String SELL_ANALYTICS_READONLY = "https://api.ebay.com/oauth/api_scope/sell.analytics.readonly";
  List<String> SELL_ANALYTICS_READONLY_SCOPE_ONLY = Arrays.asList(SELL_ANALYTICS_READONLY);

  String SELL_FINANCES = "https://api.ebay.com/oauth/api_scope/sell.finances";
  List<String> SELL_FINANCES_SCOPE_ONLY = Arrays.asList(SELL_FINANCES);

  String SELL_PAYMENT_DISPUTE = "https://api.ebay.com/oauth/api_scope/sell.payment.dispute";
  List<String> SELL_PAYMENT_DISPUTE_SCOPE_ONLY = Arrays.asList(SELL_PAYMENT_DISPUTE);

  String SELL_IDENTITY_READONLY = "https://api.ebay.com/oauth/api_scope/commerce.identity.readonly";
  List<String> SELL_IDENTITY_READONLY_SCOPE_ONLY = Arrays.asList(SELL_IDENTITY_READONLY);

  List<String> ALL_SCOPES = Arrays.asList(PUBLIC,
                                          SELL_MARKETING_READONLY,
                                          SELL_MARKETING,
                                          SELL_INVENTORY_READONLY,
                                          SELL_INVENTORY,
                                          SELL_ACCOUNT_READONLY,
                                          SELL_ACCOUNT,
                                          SELL_FULFILLMENT_READONLY,
                                          SELL_FULFILLMENT,
                                          SELL_ANALYTICS_READONLY,
                                          SELL_FINANCES,
                                          SELL_PAYMENT_DISPUTE,
                                          SELL_IDENTITY_READONLY);

}
