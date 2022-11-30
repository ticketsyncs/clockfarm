package com.ticketsyncs.clockfarm.model;

import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface CredentialsStorage<K, T extends Credentials<K>> {

  Mono<Void> add(T creds);

  Mono<T> credentials(K id);
}