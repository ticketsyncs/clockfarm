package com.h1alexbel.ticketsyncs.model;

import java.io.Serializable;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 0.0.1
 */
public interface Users<K extends Serializable> {

  User user(K id);

  void add(User user);
}