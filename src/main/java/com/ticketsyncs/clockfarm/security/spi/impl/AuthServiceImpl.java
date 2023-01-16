//package com.ticketsyncs.clockfarm.security.spi.impl;
//
//import com.ticketsyncs.clockfarm.postgres.repository.UserRepository;
//import com.ticketsyncs.clockfarm.security.spi.AuthService;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtParser;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import java.security.Key;
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.Collections;
//import java.util.Date;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import reactor.core.publisher.Mono;
//
///**
// * @author Aliaksei Bialiauski (abialiauski@solvd.com)
// * @since 1.0
// */
//@Service
//@RequiredArgsConstructor
//public class AuthServiceImpl implements AuthService {
//
//  private final UserRepository repository;
//  private final Key key =
//      Keys.hmacShaKeyFor("@realo_aokoprqwjrioqjkokOK{WRq[peqp[elwq[pqq'q'weq".getBytes());
//  private final JwtParser parser = Jwts.parser();
//
//  @Transactional(readOnly = true)
//  @Override
//  public Mono<UserDetails> findByUsername(final String username) {
//    return this.repository.findByUsername(username)
//        .flatMap(pgUser -> Mono.just(
//                new User(pgUser.username(),
//                    pgUser.getPassword(),
//                    Collections.singletonList(new SimpleGrantedAuthority("USER")
//                    )
//                )
//            )
//        );
//  }
//
//  @Override
//  public String token(final String username) {
//    return Jwts.builder()
//        .setSubject(username)
//        .setIssuedAt(Date.from(Instant.now()))
//        .setExpiration(Date.from(Instant.now().plus(50L, ChronoUnit.DAYS)))
//        .signWith(this.key)
//        .compact();
//  }
//
//  @Override
//  public String username(final String token) {
//    return this.parser.parseClaimsJws(token).getBody().getSubject();
//  }
//
//  @Override
//  public boolean isValid(final String token, final UserDetails user) {
//    final Claims claims = this.parser.parseClaimsJwt(token).getBody();
//    final boolean unexpired = claims.getExpiration().after(Date.from(Instant.now()));
//    return unexpired && claims.getSubject().equals(user.getUsername());
//  }
//}