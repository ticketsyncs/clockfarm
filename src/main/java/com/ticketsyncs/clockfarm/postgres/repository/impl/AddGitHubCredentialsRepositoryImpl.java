package com.ticketsyncs.clockfarm.postgres.repository.impl;

import com.ticketsyncs.clockfarm.postgres.PgGhCredentials;
import com.ticketsyncs.clockfarm.postgres.repository.AddGitHubCredentialsRepository;
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
public class AddGitHubCredentialsRepositoryImpl implements AddGitHubCredentialsRepository {

  private static final String SQL_SAVE_CREDENTIALS =
      "INSERT INTO ticket_syncs.github_creds(url, token, user_id)" +
          " VALUES (:url, :token, (SELECT u.id FROM ticket_syncs.user_account u WHERE u.username = :username))";
  private final DatabaseClient db;

  @Override
  public Mono<Void> add(final PgGhCredentials creds) {
    return this.db.sql(SQL_SAVE_CREDENTIALS)
        .bind("url", creds.getUrl())
        .bind("token", creds.getToken())
        .bind("username", creds.getUsername())
        .fetch()
        .first()
        .then();
  }
}