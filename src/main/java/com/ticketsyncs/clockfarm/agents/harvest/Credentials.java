package com.ticketsyncs.clockfarm.agents.harvest;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface Credentials {

  final class Simple implements Credentials {

    private final String login;
    private final String password;

    public Simple(final String login, final String password) {
      this.login = login;
      this.password = password;
    }
  }
}