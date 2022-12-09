package com.ticketsyncs.clockfarm.route;

import com.ticketsyncs.clockfarm.model.CredentialsStorage;
import com.ticketsyncs.clockfarm.model.Users;
import com.ticketsyncs.clockfarm.postgres.PgGhCredentials;
import com.ticketsyncs.clockfarm.postgres.PgHvCredentials;
import com.ticketsyncs.clockfarm.postgres.PgJrCredentials;
import com.ticketsyncs.clockfarm.postgres.PgUser;
import com.ticketsyncs.clockfarm.postgres.ScReadPgGhCredentials;
import com.ticketsyncs.clockfarm.postgres.ScReadPgHvCredentials;
import com.ticketsyncs.clockfarm.postgres.ScReadPgJrCredentials;
import com.ticketsyncs.clockfarm.security.spi.AuthService;
import java.util.function.Function;
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

  private static final String TOKEN_USER_INFO =
      "This is Yours JWT() token. Please include it into Authorization header to use the Ticketsyncs API";

  @Bean
  public RouterFunction<ServerResponse> auth(final AuthService auth) {
    return RouterFunctions.route()
        .POST("/login", request ->
            request.bodyToMono(AuthRq.class)
                .flatMap(req -> ServerResponse.ok()
                    .body(auth.findByUsername(req.getUsername())
                            .flatMap(user ->
                                Mono.just(new RsJwt(auth.token(user.getUsername()),
                                        TOKEN_USER_INFO
                                    )
                                )
                            ),
                        RsJwt.class
                    )
                )
        )
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> register(final Users<Long, PgUser, RgRq> users) {
    return RouterFunctions.route()
        .POST("/register",
            request ->
                request.bodyToMono(RgRq.class)
                    .flatMap(req ->
                        ServerResponse.ok()
                            .body(users.add(req), Void.class)
                    )
                    .switchIfEmpty(ServerResponse.badRequest().build())
        )
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> jiraSync() {
    return RouterFunctions.route()
        .POST("/harvest/jira/sync", req ->
            req.bodyToMono(JiraSyncRq.class)
                .flatMap(new Function<JiraSyncRq, Mono<? extends ServerResponse>>() {
                  @Override
                  public Mono<? extends ServerResponse> apply(JiraSyncRq jiraSyncRq) {
                    throw new UnsupportedOperationException("#apply()");
                  }
                }))
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> ghSync() {
    return RouterFunctions.route()
        .POST("/harvest/github/sync", null)
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> addGh(
      final CredentialsStorage<Long, PgGhCredentials, AddGhRq, ScReadPgGhCredentials> github) {
    return RouterFunctions.route()
        .POST("/add/github",
            request ->
                request.bodyToMono(AddGhRq.class)
                    .flatMap(rq ->
                        ServerResponse.ok()
                            .body(github.add(rq), Void.class)
                    )
                    .switchIfEmpty(ServerResponse.badRequest().build())
        )
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> addJira(
      final CredentialsStorage<Long, PgJrCredentials, AddJrRq, ScReadPgJrCredentials> jira) {
    return RouterFunctions.route()
        .POST("/add/jira",
            request ->
                request.bodyToMono(AddJrRq.class)
                    .flatMap(rq ->
                        ServerResponse.ok()
                            .body(jira.add(rq), Void.class)
                    )
                    .switchIfEmpty(ServerResponse.badRequest().build())
        )
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> addHarvest(
      final CredentialsStorage<Long, PgHvCredentials, AddHvRq, ScReadPgHvCredentials> harvest) {
    return RouterFunctions.route()
        .POST("/add/harvest",
            request ->
                request.bodyToMono(AddHvRq.class)
                    .flatMap(rq ->
                        ServerResponse.ok()
                            .body(harvest.add(rq), Void.class)
                    )
                    .switchIfEmpty(ServerResponse.badRequest().build())
        )
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> meGh(
      final CredentialsStorage<Long, PgGhCredentials, AddGhRq, ScReadPgGhCredentials> ghs) {
    return RouterFunctions.route()
        .GET("/me/github", request ->
            ServerResponse.ok().body(
                    ghs.all("test"),
                    ScReadPgGhCredentials.class
                )
                .switchIfEmpty(ServerResponse.notFound().build())
        )
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> meJira(
      final CredentialsStorage<Long, PgJrCredentials, AddJrRq, ScReadPgJrCredentials> jira) {
    return RouterFunctions.route()
        .GET("/me/jira", request ->
            ServerResponse.ok().body(
                    jira.all("test"),
                    ScReadPgJrCredentials.class
                )
                .switchIfEmpty(ServerResponse.notFound().build())
        )
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> meHarvest(
      final CredentialsStorage<Long, PgHvCredentials, AddHvRq, ScReadPgHvCredentials> harvest) {
    return RouterFunctions.route()
        .GET("/me/harvest", request ->
            ServerResponse.ok().body(
                    harvest.all("test"),
                    ScReadPgHvCredentials.class
                )
                .switchIfEmpty(ServerResponse.notFound().build())
        )
        .build();
  }
}