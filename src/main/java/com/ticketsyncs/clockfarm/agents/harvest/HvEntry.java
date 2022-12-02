package com.ticketsyncs.clockfarm.agents.harvest;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public class HvEntry {

  private final String description;
  private final Double hours;

  public HvEntry(final String description, final Double hours) {
    this.description = description;
    this.hours = hours;
  }
}
