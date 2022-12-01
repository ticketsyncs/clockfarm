package com.ticketsyncs.clockfarm.model;

import java.io.Serializable;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface CredentialsStorage<K, T extends Credentials, R extends Serializable> {

  Mono<Void> add(R creds);

  Mono<T> credentials(K id);
}