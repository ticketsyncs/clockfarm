package com.ticketsyncs.clockfarm.agents.jira;

import com.ticketsyncs.clockfarm.model.Credentials;
import java.net.URI;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public final class JrCredentials implements Credentials {

  private final String project;
  private final String username;
  private final String password;

  public JrCredentials(final String project, final String username, final String password) {
    this.project = project;
    this.username = username;
    this.password = password;
  }

  @Override
  public URI uri() {
    return URI.create(this.project);
  }

  @Override
  public String username() {
    return this.username;
  }

  @Override
  public String password() {
    return this.password;
  }

  @Override
  public Object id() {
    throw new UnsupportedOperationException("#id()");
  }
}