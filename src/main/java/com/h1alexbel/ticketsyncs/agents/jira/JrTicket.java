package com.h1alexbel.ticketsyncs.agents.jira;

import com.atlassian.jira.rest.client.api.domain.Issue;
import com.h1alexbel.ticketsyncs.model.Ticket;
import java.util.Objects;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public final class JrTicket implements Ticket {

  private final String id;
  private final Double spent;
  private final Issue issue;

  public JrTicket(final Issue issue) {
    this.issue = issue;
    this.id = issue.getKey();
    this.spent = this.hours(Objects.requireNonNull(issue.getTimeTracking())
        .getTimeSpentMinutes()
    );
  }

  private Double hours(final Integer tracked) {
    final double hours = tracked / 60.0;
    final double left = tracked % 60.0;
    final double minutes = left / 100.0;
    return hours + minutes;
  }

  @Override
  public Double spentHours() {
    return this.spent;
  }
}