package com.ticketsyncs.clockfarm.route;

import com.ticketsyncs.clockfarm.postgres.PgUser;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface UserService {

  Mono<PgUser> user(String username);
}