package com.ticketsyncs.clockfarm.postgres;

import com.ticketsyncs.clockfarm.model.User;
import com.ticketsyncs.clockfarm.model.Users;
import org.springframework.r2dbc.core.DatabaseClient;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public class PgUsers implements Users.Rc<Long> {

  private final DatabaseClient db;

  public PgUsers(final DatabaseClient db) {
    this.db = db;
  }

  @Override
  public User<Long> user(Long id) {
    throw new UnsupportedOperationException("#user()");
  }

  @Override
  public User<Long> user(String name) {
    throw new UnsupportedOperationException("#user()");
  }

  @Override
  public void add(User<Long> user) {
    throw new UnsupportedOperationException("#add()");
  }
}