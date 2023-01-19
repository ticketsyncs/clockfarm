package com.ticketsyncs.clockfarm.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
class SimpleCredentialsTest {

  @Test
  void username() {
    final String username = "abialiauski.dev@gmail.com";
    final Credentials creds =
      new Credentials.Simple(username, "123456");
    Assertions.assertThat(creds.username()).isEqualTo(username);
  }

  @Test
  void password() {
    final String password = "apkowiyhnwiun@gkniojsJI";
    final Credentials creds = new Credentials.Simple("john123", password);
    Assertions.assertThat(creds.password()).isEqualTo(password);
  }
}