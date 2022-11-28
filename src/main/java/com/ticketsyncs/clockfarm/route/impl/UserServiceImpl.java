package com.ticketsyncs.clockfarm.route.impl;

import com.ticketsyncs.clockfarm.postgres.PgUser;
import com.ticketsyncs.clockfarm.repository.UserRepository;
import com.ticketsyncs.clockfarm.route.UserService;
import lombok.RequiredArgsConstructor;
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
public class UserServiceImpl implements UserService {

  private final UserRepository repository;

  @Override
  public Mono<PgUser> user(final String username) {
    return this.repository.findByUsername(username);
  }
}