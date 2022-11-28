package com.ticketsyncs.clockfarm.route;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Configuration
@RequiredArgsConstructor
public class Routes {

  @Bean
  public RouterFunction<ServerResponse> auth2(final AuthService auth) {
    return RouterFunctions.route()
        .POST("/login", request -> request.bodyToMono(AuthRequest.class)
            .flatMap(req -> ServerResponse.ok()
                .body(auth.findByUsername(req.getUsername()), UserDetails.class)
            )
        )
        .build();
  }
}