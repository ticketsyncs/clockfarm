package com.h1alexbel.ticketsyncs.agents.jira;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.h1alexbel.ticketsyncs.model.Credentials;
import com.h1alexbel.ticketsyncs.model.Ticket;
import com.h1alexbel.ticketsyncs.model.Tickets;
import java.util.concurrent.ExecutionException;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public final class JrTickets implements Tickets<String> {

  private final JiraRestClient client;

  public JrTickets(final Credentials creds) {
    this.client = new AsynchronousJiraRestClientFactory()
        .createWithBasicHttpAuthentication(creds.domainURI(), creds.username(),
            creds.password()
        );
  }

  @Override
  public Ticket ticket(final String id) {
    try {
      return new JrTicket(this.client.getIssueClient().getIssue(id).get());
    } catch (final InterruptedException | ExecutionException e) {
      throw new IllegalStateException(e);
    }
  }
}