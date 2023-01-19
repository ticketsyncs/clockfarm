package com.ticketsyncs.clockfarm.agents.jira;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
class HoursOfTest {

  @Test
  void spentTime() {
    final Double hours = new HoursOf(66).formatted();
    Assertions.assertThat(hours).isEqualTo(1.06);
  }

  @Test
  void spentLessThanHour() {
    final Double hours = new HoursOf(55).formatted();
    Assertions.assertThat(hours).isEqualTo(0.55);
  }
}