package com.ticketsyncs.clockfarm.postgres;

import com.ticketsyncs.clockfarm.model.CredentialsStorage;
import com.ticketsyncs.clockfarm.postgres.repository.JrCredentialsRepository;
import com.ticketsyncs.clockfarm.route.AddJrRq;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PgJrCredentialsStorage
    implements CredentialsStorage<Long, PgJrCredentials, AddJrRq, ScReadPgJrCredentials> {

  private final JrCredentialsRepository repository;
  private final PasswordEncoder encoder;

  @Transactional
  @Override
  public Mono<Void> add(final AddJrRq creds) {
    final String encoded = this.encoder.encode(creds.getRaw());
    final PgJrCredentials credentials = PgJrCredentials.builder()
        .email(creds.getEmail())
        .domain(creds.getDomain())
        .token(encoded)
        .username(creds.getPrincipal())
        .build();
    return this.repository.add(credentials);
  }

  @Override
  public Flux<ScReadPgJrCredentials> all(String username) {
    throw new UnsupportedOperationException("#all()");
  }

  @Override
  public Mono<PgJrCredentials> credentials(final Long id) {
    return this.repository.findById(id);
  }
}