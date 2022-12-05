package com.ticketsyncs.clockfarm.route;

import com.ticketsyncs.clockfarm.model.CredentialsStorage;
import com.ticketsyncs.clockfarm.model.Users;
import com.ticketsyncs.clockfarm.postgres.PgGhCredentials;
import com.ticketsyncs.clockfarm.postgres.PgHvCredentials;
import com.ticketsyncs.clockfarm.postgres.PgJrCredentials;
import com.ticketsyncs.clockfarm.postgres.PgUser;
import com.ticketsyncs.clockfarm.security.spi.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Configuration
@RequiredArgsConstructor
public class Routes {

  @Bean
  public RouterFunction<ServerResponse> auth(final AuthService auth) {
    return RouterFunctions.route()
        .POST("/login", request -> request.bodyToMono(AuthRq.class)
            .flatMap(req -> ServerResponse.ok()
                .body(auth.findByUsername(req.getUsername())
                        .flatMap(
                            user -> Mono.just(new RsJwt(auth.token(user.getUsername()
                                ),
                                    "This is Yours JWT() token. Please include it into Authorization header to use the Ticketsyncs API"
                                )
                            )
                        ),
                    RsJwt.class
                )
            )
        )
        .build();
  }

//  @Bean
//  public RouterFunction<ServerResponse> me(
//      final CredentialsStorage<Long, PgHvCredentials, AddHvRq> harvest,
//      final CredentialsStorage<Long, PgJrCredentials, AddJrRq> jira,
//      final CredentialsStorage<Long, PgGhCredentials, AddGhRq, > github) {
//    return RouterFunctions.route()
//        .GET("/me", request -> ServerResponse.ok()
//            .body(new RsMe(
//                    harvest.all("@principal"),
//                    jira.all("@principal"),
//                    github.all("@principal")
//                ),
//                RsMe.class
//            )
//        )
//        .build();
//  }

  @Bean
  public RouterFunction<ServerResponse> register(final Users<Long, PgUser, RgRq> users) {
    return RouterFunctions.route()
        .POST("/register", request -> request.bodyToMono(RgRq.class)
            .flatMap(req -> ServerResponse.ok()
                .body(users.add(req), Void.class)
            )
        )
        .build();
  }
}






