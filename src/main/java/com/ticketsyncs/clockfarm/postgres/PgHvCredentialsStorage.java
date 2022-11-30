package com.ticketsyncs.clockfarm.postgres;

import com.ticketsyncs.clockfarm.model.CredentialsStorage;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public class PgHvCredentialsStorage implements CredentialsStorage<Long, PgHvCredentials> {

  @Override
  public Mono<Void> add(PgHvCredentials creds) {
    throw new UnsupportedOperationException("#add()");
  }

  @Override
  public Mono<PgHvCredentials> credentials(Long id) {
    throw new UnsupportedOperationException("#credentials()");
  }
}