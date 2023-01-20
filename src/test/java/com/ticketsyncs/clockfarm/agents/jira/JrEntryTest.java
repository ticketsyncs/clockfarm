package com.ticketsyncs.clockfarm.agents.jira;

import com.ticketsyncs.clockfarm.model.Entry;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
class JrEntryTest {

  @Test
  void spentTime() {
    final Entry entry = new JrEntry(
      "CL-01",
      "Ticketsyncs.com",
      "Migrate PostgreSQL to DynamoDB",
      350
    );
    Assertions.assertThat(entry.spentTime()).isEqualTo(5.50);
  }

  @Test
  void project() {
    final String project = "Farm.io";
    final Entry entry = new JrEntry(
      "F-199",
      project,
      "Generate UML diagrams",
      30
    );
    Assertions.assertThat(entry.project()).isEqualTo(project);
  }

  @Test
  void body() {
    final String id = "K-1999";
    final String body = "Test page cache";
    final Entry entry = new JrEntry(
      id,
      "Apache Kafka",
      body,
      90
    );
    Assertions.assertThat(entry.toString())
      .isEqualTo(String.format("ticket: %s, text: %s", id, body));
  }
}