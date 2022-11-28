package com.ticketsyncs.clockfarm.model;

import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 0.0.1
 */
public interface Users<K> {

  User<K> user(K id);

  User<K> user(String name);

  void add(User<K> user);

  interface Rc<K> extends Users<K> {

    default Mono<User<K>> rcUser(K id) {
      return Mono.just(user(id));
    }

    default Mono<User<K>> rcUser(String name) {
      return Mono.just(user(name));
    }

    default Mono<Void> rcAdd(User<K> user) {
      add(user);
      return Mono.just(user).then();
    }
  }
}