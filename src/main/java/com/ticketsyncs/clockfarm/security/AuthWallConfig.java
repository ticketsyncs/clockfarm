package com.ticketsyncs.clockfarm.security;

import com.ticketsyncs.clockfarm.route.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Configuration
@RequiredArgsConstructor
public class AuthWallConfig {

  private final AuthService auth;

  @Bean
  public ReactiveAuthenticationManager authenticationManager(PasswordEncoder passwordEncoder) {
    final UserDetailsRepositoryReactiveAuthenticationManager
        authenticationManager =
        new UserDetailsRepositoryReactiveAuthenticationManager(this.auth);
    authenticationManager.setPasswordEncoder(passwordEncoder);
    return authenticationManager;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(12);
  }
}