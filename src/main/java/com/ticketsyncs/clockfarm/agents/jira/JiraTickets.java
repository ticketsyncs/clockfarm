package com.ticketsyncs.clockfarm.agents.jira;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.ticketsyncs.clockfarm.model.Credentials;
import com.ticketsyncs.clockfarm.model.Ticket;
import com.ticketsyncs.clockfarm.model.Tickets;
import java.util.concurrent.ExecutionException;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public final class JiraTickets implements Tickets<String> {

  private final JiraRestClient client;

  public JiraTickets(final Credentials creds) {
    this.client = new AsynchronousJiraRestClientFactory()
        .createWithBasicHttpAuthentication(creds.uri(), creds.username(),
            creds.password()
        );
  }

  @Override
  public Ticket ticket(final String id) {
    try {
      return new JiraTicket(this.client.getIssueClient().getIssue(id).get());
    } catch (final InterruptedException | ExecutionException e) {
      throw new IllegalStateException(e);
    }
  }
}