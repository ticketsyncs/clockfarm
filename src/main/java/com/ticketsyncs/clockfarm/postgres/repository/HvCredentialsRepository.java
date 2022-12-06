package com.ticketsyncs.clockfarm.postgres.repository;

import com.ticketsyncs.clockfarm.postgres.PgHvCredentials;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface HvCredentialsRepository
    extends R2dbcRepository<PgHvCredentials, Long>,
    AddHvCredentialsRepository,
    FindAllByUsernameHvRepository {
}