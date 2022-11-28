package com.ticketsyncs.clockfarm.agents.harvest;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public final class HvApp implements Harvest {

  private final Credentials.Simple creds;

  public HvApp(final Credentials.Simple creds) {
    this.creds = creds;
  }

  @Override
  public void entry(HvEntry entry) {
    throw new UnsupportedOperationException("#entry()");
  }

  @Override
  public void sync(String request) {
    throw new UnsupportedOperationException("#sync()");
  }
}