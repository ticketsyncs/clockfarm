package com.ticketsyncs.clockfarm.postgres.repository.impl;

import com.ticketsyncs.clockfarm.postgres.PgHvCredentials;
import com.ticketsyncs.clockfarm.postgres.repository.AddHvCredentialsRepository;
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
public class AddHvCredentialsRepositoryImpl implements AddHvCredentialsRepository {

  private static final String SQL_SAVE_CREDENTIALS =
      "INSERT INTO ticket_syncs.harvest_creds(url, login, password, user_id) VALUES (:url, :login, :password," +
          " (SELECT u.id FROM ticket_syncs.user_account u WHERE u.username = :username))";
  private final DatabaseClient db;

  @Override
  public Mono<Void> add(final PgHvCredentials creds) {
    return this.db.sql(SQL_SAVE_CREDENTIALS)
        .bind("url", creds.getUrl())
        .bind("login", creds.getLogin())
        .bind("password", creds.getPassword())
        .bind("username", creds.getUsername())
        .fetch()
        .first()
        .then();
  }
}