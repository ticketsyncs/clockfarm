package com.ticketsyncs.clockfarm.postgres.repository;

import com.ticketsyncs.clockfarm.postgres.PgUser;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface UserAddRepository {

  Mono<Void> add(PgUser user);
}