package com.ticketsyncs.clockfarm.model;

import java.io.Serializable;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 0.0.1
 */
public interface Users<K, T extends User<K>, R extends Serializable> {

  Mono<Void> add(R req);

  Mono<T> user(K id);

  Mono<T> user(String name);
}