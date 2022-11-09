package com.h1alexbel.ticketsyncs.agents.jira;

import com.atlassian.jira.rest.client.api.domain.Issue;
import com.h1alexbel.ticketsyncs.model.SpentTimeInHours;
import com.h1alexbel.ticketsyncs.model.Ticket;
import java.util.Objects;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public final class JrTicket implements Ticket {

  private final String id;
  private final Integer tracked;
  private final Issue issue;

  public JrTicket(final Issue issue) {
    this.issue = issue;
    this.id = issue.getKey();
    this.tracked =
        Objects.requireNonNull(issue.getTimeTracking())
            .getTimeSpentMinutes();
  }

  @Override
  public SpentTimeInHours spentHours() {
    return new JrSpentTimeInHours(this.tracked);
  }
}