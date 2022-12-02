package com.ticketsyncs.clockfarm.postgres.repository;

import com.ticketsyncs.clockfarm.postgres.PgGhCredentials;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface GitHubCredentialsRepository
    extends R2dbcRepository<PgGhCredentials, Long>,
    AddGitHubCredentialsRepository {
}