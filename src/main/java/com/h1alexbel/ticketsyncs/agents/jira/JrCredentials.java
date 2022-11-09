package com.h1alexbel.ticketsyncs.agents.jira;

import com.h1alexbel.ticketsyncs.model.Credentials;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public final class JrCredentials implements Credentials {

  private String project;
  private String username;
  private String password;

  @Override
  public Credentials withProject(final String project) {
    this.project = project;
    return this;
  }

  @Override
  public Credentials withUsername(final String username) {
    this.username = username;
    return this;
  }

  @Override
  public Credentials withPassword(final String password) {
    this.password = password;
    return this;
  }

  @Override
  public String project() {
    return this.project;
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