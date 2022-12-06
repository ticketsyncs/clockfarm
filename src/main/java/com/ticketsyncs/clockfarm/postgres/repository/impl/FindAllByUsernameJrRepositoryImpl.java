package com.ticketsyncs.clockfarm.postgres.repository.impl;

import com.ticketsyncs.clockfarm.postgres.PgJrCredentials;
import com.ticketsyncs.clockfarm.postgres.repository.FindAllByUsernameJrRepository;
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
public class FindAllByUsernameJrRepositoryImpl implements FindAllByUsernameJrRepository {

  private static final String SQL_FIND_CREDS_BY_USERNAME =
      "SELECT j.email AS email, j.domain AS domain FROM ticket_syncs.jira_creds j WHERE j.user_id = " +
          "(SELECT u.id FROM ticket_syncs.user_account u WHERE  u.username = :username)";
  private final DatabaseClient db;

  @Override
  public Flux<PgJrCredentials> all(final String username) {
    return this.db.sql(SQL_FIND_CREDS_BY_USERNAME)
        .bind("username", username)
        .fetch()
        .all()
        .map(rows -> PgJrCredentials.builder()
            .domain("domain")
            .email("email")
            .build()
        );
  }
}