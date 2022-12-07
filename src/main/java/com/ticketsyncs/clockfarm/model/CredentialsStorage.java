package com.ticketsyncs.clockfarm.model;

import java.io.Serializable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface CredentialsStorage<K, T extends Credentials, R extends Serializable, S> {

  Mono<Void> add(R creds);

  Flux<S> all(String username);

  Mono<T> credentials(K id);
}