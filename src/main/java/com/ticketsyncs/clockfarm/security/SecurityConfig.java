package com.ticketsyncs.clockfarm.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 */
@EnableWebFluxSecurity
@Configuration
//@EnableReactiveMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final ReactiveAuthenticationManager authenticationManager;

  @Bean
  public SecurityWebFilterChain filter(final ServerHttpSecurity http) {
    return http
//        .exceptionHandling()
//        .authenticationEntryPoint((swe, e) -> Mono.fromRunnable(() ->
//                swe.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED)
//            )
//        )
//        .accessDeniedHandler((swe, e) -> Mono.fromRunnable(
//                () -> swe.getResponse().setStatusCode(HttpStatus.FORBIDDEN)
//            )
//        ).and()
//        .and()
        .csrf().disable()
        .formLogin().disable()
        .httpBasic().disable()
        .authenticationManager(this.authenticationManager)
//        .securityContextRepository(this.repository)
        .authorizeExchange()
        .anyExchange()
        .permitAll()
//        .pathMatchers(HttpMethod.OPTIONS).permitAll()
//        .pathMatchers("/test").permitAll()
//        .pathMatchers("/login").permitAll()
//        .pathMatchers("/register").permitAll()
//        .anyExchange().authenticated()
//        .and()
        .and()
        .csrf().disable()
        .build();
  }
}