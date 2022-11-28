package com.ticketsyncs.clockfarm.repository;

import com.ticketsyncs.clockfarm.postgres.PgUser;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface UserRepository extends R2dbcRepository<PgUser, Long> {

  Mono<PgUser> findByUsername(String username);
}