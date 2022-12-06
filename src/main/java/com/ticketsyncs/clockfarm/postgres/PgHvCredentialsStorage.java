package com.ticketsyncs.clockfarm.postgres;

import com.ticketsyncs.clockfarm.model.CredentialsStorage;
import com.ticketsyncs.clockfarm.postgres.repository.HvCredentialsRepository;
import com.ticketsyncs.clockfarm.route.AddHvRq;
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
public class PgHvCredentialsStorage
    implements CredentialsStorage<Long, PgHvCredentials, AddHvRq, ScReadPgHvCredentials> {

  private final HvCredentialsRepository repository;
  private final PasswordEncoder encoder;

  @Transactional
  @Override
  public Mono<Void> add(final AddHvRq creds) {
    final String encoded = this.encoder.encode(creds.getRaw());
    final PgHvCredentials credentials = PgHvCredentials.builder()
        .login(creds.getLogin())
        .url(creds.getUrl())
        .password(encoded)
        .username(creds.getPrincipal())
        .build();
    return this.repository.add(credentials);
  }

  @Override
  public Flux<ScReadPgHvCredentials> all(final String username) {
    return this.repository
        .all(username)
        .flatMap(
            creds ->
                Flux.just(
                    new ScReadPgHvCredentials(creds.getLogin(), creds.getUrl())
                )
        );
  }

  @Override
  public Mono<PgHvCredentials> credentials(final Long id) {
    return this.repository.findById(id);
  }
}