package com.ticketsyncs.clockfarm.postgres;

import com.ticketsyncs.clockfarm.model.Credentials;
import java.net.URI;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public class PgGhCredentials implements Credentials<Long> {

  @Override
  public URI uri() {
    throw new UnsupportedOperationException("#uri()");
  }

  @Override
  public String username() {
    throw new UnsupportedOperationException("#username()");
  }

  @Override
  public String password() {
    throw new UnsupportedOperationException("#password()");
  }

  @Override
  public Long id() {
    throw new UnsupportedOperationException("#id()");
  }
}
