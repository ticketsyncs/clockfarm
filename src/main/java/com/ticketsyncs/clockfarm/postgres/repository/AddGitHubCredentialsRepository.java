package com.ticketsyncs.clockfarm.postgres.repository;

import com.ticketsyncs.clockfarm.postgres.PgGhCredentials;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface AddGitHubCredentialsRepository {

  Mono<Void> add(PgGhCredentials creds);
}