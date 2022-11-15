package com.h1alexbel.ticketsyncs.model;

import java.net.URI;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface Credentials {

  URI domainURI();

  String username();

  String password();
}