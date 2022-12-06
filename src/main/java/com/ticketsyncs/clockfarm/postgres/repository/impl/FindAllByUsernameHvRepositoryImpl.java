package com.ticketsyncs.clockfarm.postgres.repository.impl;

import com.ticketsyncs.clockfarm.postgres.PgHvCredentials;
import com.ticketsyncs.clockfarm.postgres.repository.FindAllByUsernameHvRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Repository
@RequiredArgsConstructor
public class FindAllByUsernameHvRepositoryImpl implements FindAllByUsernameHvRepository {

  private static final String SQL_FIND_CREDS_BY_USERNAME =
      "SELECT h.login AS login, h.url AS url FROM ticket_syncs.harvest_creds h WHERE h.user_id = " +
          "(SELECT u.id FROM ticket_syncs.user_account u WHERE  u.username = :username)";
  private final DatabaseClient db;

  @Override
  public Flux<PgHvCredentials> all(final String username) {
    return this.db.sql(SQL_FIND_CREDS_BY_USERNAME)
        .bind("username", username)
        .fetch()
        .all()
        .map(rows -> PgHvCredentials.builder()
            .login((String) rows.get("login"))
            .url((String) rows.get("url"))
            .build()
        );
  }
}