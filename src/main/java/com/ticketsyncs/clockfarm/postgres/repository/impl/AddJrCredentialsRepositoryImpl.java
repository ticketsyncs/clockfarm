package com.ticketsyncs.clockfarm.postgres.repository.impl;

import com.ticketsyncs.clockfarm.postgres.PgJrCredentials;
import com.ticketsyncs.clockfarm.postgres.repository.AddJrCredentialsRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Repository
public class AddJrCredentialsRepositoryImpl implements AddJrCredentialsRepository {

  @Override
  public Mono<Void> add(PgJrCredentials creds) {
    throw new UnsupportedOperationException("#add()");
  }
}