package com.ticketsyncs.clockfarm.model;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface CredentialsStorage<K> {

  void add(Credentials<K> creds);

  Credentials<K> credentials(K id);
}