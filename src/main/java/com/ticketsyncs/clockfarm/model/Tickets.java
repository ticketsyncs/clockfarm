package com.ticketsyncs.clockfarm.model;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface Tickets<K> {

  Ticket ticket(K id);
}