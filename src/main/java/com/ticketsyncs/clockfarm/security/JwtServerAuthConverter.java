package com.ticketsyncs.clockfarm.security;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Component
public class JwtServerAuthConverter implements ServerAuthenticationConverter {

  @Override
  public Mono<Authentication> convert(final ServerWebExchange exchange) {
    return Mono.justOrEmpty(exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION))
        .filter(it -> it.startsWith("Bearer "))
        .map(it -> it.substring(7))
        .map(BearerToken::new);
  }
}