package com.h1alexbel.ticketsyncs.model;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface Credentials {

  Credentials withProject(String project);

  Credentials withUsername(String username);

  Credentials withPassword(String password);

  String project();

  String username();

  String password();
}