package com.ticketsyncs.clockfarm.postgres.repository.impl;

import com.ticketsyncs.clockfarm.postgres.PgGhCredentials;
import com.ticketsyncs.clockfarm.postgres.repository.FindAllByUsernameGhRepository;
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
public class FindAllByUsernameGhRepositoryImpl implements FindAllByUsernameGhRepository {

  private static final String SQL_FIND_CREDS_BY_USERNAME =
      "SELECT g.url AS url FROM ticket_syncs.github_creds g WHERE g.user_id = " +
          "(SELECT u.id FROM ticket_syncs.user_account u WHERE  u.username = :username)";
  private final DatabaseClient db;

  @Override
  public Flux<PgGhCredentials> all(final String username) {
    return this.db.sql(SQL_FIND_CREDS_BY_USERNAME)
        .bind("username", username)
        .fetch()
        .all()
        .map(rows -> PgGhCredentials.builder()
            .url((String) rows.get("url"))
            .build()
        );
  }
}