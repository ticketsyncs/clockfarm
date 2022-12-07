package com.ticketsyncs.clockfarm.postgres.repository;

import com.ticketsyncs.clockfarm.postgres.PgJrCredentials;
import reactor.core.publisher.Flux;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface FindAllByUsernameJrRepository {

  Flux<PgJrCredentials> all(String username);
}