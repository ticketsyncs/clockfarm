package com.ticketsyncs.clockfarm.security;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public class InvalidJwtTokenException extends AuthenticationException {

  public InvalidJwtTokenException(String msg, Throwable cause) {
    super(msg, cause);
  }
}