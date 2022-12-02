package com.ticketsyncs.clockfarm.postgres.repository;

import com.ticketsyncs.clockfarm.postgres.PgJrCredentials;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface JrCredentialsRepository
    extends R2dbcRepository<PgJrCredentials, Long>,
    AddJrCredentialsRepository {
}