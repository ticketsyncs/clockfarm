package com.ticketsyncs.clockfarm.postgres;

import com.ticketsyncs.clockfarm.model.CredentialsStorage;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public class PgGhCredentialsStorage implements CredentialsStorage<Long, PgGhCredentials> {

  @Override
  public Mono<Void> add(PgGhCredentials creds) {
    throw new UnsupportedOperationException("#add()");
  }

  @Override
  public Mono<PgGhCredentials> credentials(Long id) {
    throw new UnsupportedOperationException("#credentials()");
  }
}