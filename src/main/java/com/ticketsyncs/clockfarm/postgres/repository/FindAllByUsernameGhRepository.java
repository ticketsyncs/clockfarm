package com.ticketsyncs.clockfarm.postgres.repository;

import com.ticketsyncs.clockfarm.postgres.PgGhCredentials;
import reactor.core.publisher.Flux;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface FindAllByUsernameGhRepository {

  Flux<PgGhCredentials> all(String username);
}