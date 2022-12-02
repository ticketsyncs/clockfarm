package com.ticketsyncs.clockfarm.security.spi;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface AuthService extends ReactiveUserDetailsService {

  String token(String username);

  String username(String token);

  boolean isValid(String token, UserDetails user);
}