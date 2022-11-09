package com.h1alexbel.ticketsyncs.agents.jira;

import com.h1alexbel.ticketsyncs.model.SpentTimeInHours;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public final class JrSpentTimeInHours implements SpentTimeInHours {

  private final Double value;

  public JrSpentTimeInHours(final Integer tracked) {
    this.value = this.fromMinutes(tracked);
//    final double hours = tracked / 60;
//    final double left = tracked % 60;
//    final double minutes = left / 100;
//    this.value = hours + minutes;
  }
}