package com.ticketsyncs.clockfarm.postgres;

import com.ticketsyncs.clockfarm.model.Users;
import com.ticketsyncs.clockfarm.postgres.repository.UserRepository;
import com.ticketsyncs.clockfarm.route.RgRq;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class PgUsers implements Users<Long, PgUser, RgRq> {

  private final UserRepository repository;
  private final PasswordEncoder encoder;

  @Transactional
  @Override
  public Mono<Void> add(final RgRq req) {
    final String encoded = this.encoder.encode(req.getPassword());
    final PgUser user = PgUser.builder()
        .username(req.getUsername())
        .password(encoded)
        .build();
    return this.repository.add(user);
  }

  @Override
  public Mono<PgUser> user(final Long id) {
    return this.repository.findById(id);
  }

  @Override
  public Mono<PgUser> user(final String name) {
    return this.repository.findByUsername(name);
  }
}