package com.ticketsyncs.clockfarm.model;

import java.net.URI;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface Credentials {

  URI uri();

  String username();

  String password();
}