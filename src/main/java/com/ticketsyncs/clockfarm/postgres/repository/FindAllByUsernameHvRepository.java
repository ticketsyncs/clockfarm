package com.ticketsyncs.clockfarm.postgres.repository;

import com.ticketsyncs.clockfarm.postgres.PgHvCredentials;
import reactor.core.publisher.Flux;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface FindAllByUsernameHvRepository {

  Flux<PgHvCredentials> all(String username);
}