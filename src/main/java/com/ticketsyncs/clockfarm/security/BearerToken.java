package com.ticketsyncs.clockfarm.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public class BearerToken extends AbstractAuthenticationToken {

  private String value;

  public BearerToken(String val) {
    super(AuthorityUtils.NO_AUTHORITIES);
    this.value = val;
  }

  @Override
  public Object getCredentials() {
    return this.value;
  }

  @Override
  public Object getPrincipal() {
    return this.value;
  }
}