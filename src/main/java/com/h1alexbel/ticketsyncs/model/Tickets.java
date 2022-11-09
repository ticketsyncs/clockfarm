package com.h1alexbel.ticketsyncs.model;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface Tickets<K> {

  Ticket ticket(K id);
}