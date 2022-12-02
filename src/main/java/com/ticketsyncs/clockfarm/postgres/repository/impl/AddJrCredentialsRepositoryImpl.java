package com.ticketsyncs.clockfarm.postgres.repository.impl;

import com.ticketsyncs.clockfarm.postgres.PgJrCredentials;
import com.ticketsyncs.clockfarm.postgres.repository.AddJrCredentialsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Repository
@RequiredArgsConstructor
public class AddJrCredentialsRepositoryImpl implements AddJrCredentialsRepository {

  private static final String SQL_SAVE_CREDENTAILS =
      "INSERT INTO ticket_syncs.jira_creds(email, domain, token, user_id)" +
          " VALUES (:email, :domain, :token, (SELECT u.id FROM ticket_syncs.user_account u WHERE u.username = :username))";
  private final DatabaseClient db;

  @Override
  public Mono<Void> add(final PgJrCredentials creds) {
    return this.db.sql(SQL_SAVE_CREDENTAILS)
        .bind("email", creds.getEmail())
        .bind("domain", creds.getDomain())
        .bind("token", creds.getToken())
        .bind("username", creds.getUsername())
        .fetch()
        .first()
        .then();
  }
}