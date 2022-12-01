package com.ticketsyncs.clockfarm.postgres.repository.impl;

import com.ticketsyncs.clockfarm.postgres.PgHvCredentials;
import com.ticketsyncs.clockfarm.postgres.repository.AddHvCredentialsRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Repository
public class AddHvCredentialsRepositoryImpl implements AddHvCredentialsRepository {

  @Override
  public Mono<Void> add(PgHvCredentials creds) {
    throw new UnsupportedOperationException("#add()");
  }
}