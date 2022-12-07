package com.ticketsyncs.clockfarm.postgres;

import com.ticketsyncs.clockfarm.model.CredentialsStorage;
import com.ticketsyncs.clockfarm.postgres.repository.GitHubCredentialsRepository;
import com.ticketsyncs.clockfarm.route.AddGhRq;
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
public class PgGhCredentialsStorage
    implements CredentialsStorage<Long, PgGhCredentials, AddGhRq, ScReadPgGhCredentials> {

  private final GitHubCredentialsRepository repository;
  private final PasswordEncoder encoder;

  @Transactional
  @Override
  public Mono<Void> add(final AddGhRq creds) {
    final String encoded = this.encoder.encode(creds.getRaw());
    final PgGhCredentials credentials = PgGhCredentials.builder()
        .url(creds.getUrl())
        .token(encoded)
        .username(creds.getPrincipal())
        .build();
    return this.repository.add(credentials);
  }

  @Override
  public Flux<ScReadPgGhCredentials> all(final String username) {
    return this.repository
        .all(username)
        .flatMap(
            creds ->
                Flux.just(
                    new ScReadPgGhCredentials(creds.getUrl())
                )
        );
  }

  @Override
  public Mono<PgGhCredentials> credentials(final Long id) {
    return this.repository.findById(id);
  }
}