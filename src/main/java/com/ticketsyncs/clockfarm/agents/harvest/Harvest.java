package com.ticketsyncs.clockfarm.agents.harvest;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface Harvest {

  void entry(HvEntry entry);

  void sync(String request);
}