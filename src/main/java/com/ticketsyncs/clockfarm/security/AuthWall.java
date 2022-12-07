package com.ticketsyncs.clockfarm.security;

import com.ticketsyncs.clockfarm.security.spi.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Component
@RequiredArgsConstructor
public class AuthWall implements ReactiveAuthenticationManager {

  private final AuthService auth;

  @Override
  public Mono<Authentication> authenticate(final Authentication authentication) {
    return Mono.justOrEmpty(authentication)
        .cast(String.class)
        .flatMap(this::validate)
        .onErrorMap(error -> new InvalidJwtTokenException(error.getMessage(), error));
  }

  private Mono<Authentication> validate(final String jwt) {
    final String username = this.auth.username(jwt);
    return this.auth.findByUsername(username)
        .flatMap(user -> {
          if (this.auth.isValid(jwt, user)) {
            return Mono.just(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(),
                    user.getAuthorities()
                )
            );
          }
          return Mono.error(new IllegalArgumentException("Token is not valid"));
        });
  }
}