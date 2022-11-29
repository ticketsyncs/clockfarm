package com.ticketsyncs.clockfarm.security.spi.impl;

import com.ticketsyncs.clockfarm.repository.UserRepository;
import com.ticketsyncs.clockfarm.security.spi.AuthService;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final UserRepository repository;

  @Override
  public Mono<UserDetails> findByUsername(final String username) {
    return this.repository.findByUsername(username)
        .flatMap(pgUser -> Mono.just(
                new User(pgUser.username(),
                    pgUser.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority("USER")
                    )
                )
            )
        );
  }
}