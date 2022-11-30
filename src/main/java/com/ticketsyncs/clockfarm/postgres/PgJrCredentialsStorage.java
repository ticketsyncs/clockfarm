package com.ticketsyncs.clockfarm.postgres;

import com.ticketsyncs.clockfarm.model.CredentialsStorage;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public class PgJrCredentialsStorage implements CredentialsStorage<Long, PgJrCredentials> {

  @Override
  public Mono<Void> add(PgJrCredentials creds) {
    throw new UnsupportedOperationException("#add()");
  }

  @Override
  public Mono<PgJrCredentials> credentials(Long id) {
    throw new UnsupportedOperationException("#credentials()");
  }
}