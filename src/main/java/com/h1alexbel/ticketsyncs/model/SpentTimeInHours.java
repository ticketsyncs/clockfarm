package com.h1alexbel.ticketsyncs.model;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface SpentTimeInHours {

  default Double fromMinutes(final Integer minutes) {
    return 0.0;
  }
}