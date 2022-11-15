package com.h1alexbel.ticketsyncs.agents.jira;

import com.h1alexbel.ticketsyncs.model.Credentials;
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
  public URI domainURI() {
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
}