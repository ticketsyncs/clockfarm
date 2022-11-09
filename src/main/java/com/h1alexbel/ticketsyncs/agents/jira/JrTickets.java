package com.h1alexbel.ticketsyncs.agents.jira;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.h1alexbel.ticketsyncs.model.Credentials;
import com.h1alexbel.ticketsyncs.model.Ticket;
import com.h1alexbel.ticketsyncs.model.Tickets;
import java.net.URI;
import java.util.concurrent.ExecutionException;
import org.springframework.stereotype.Component;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Component
public final class JrTickets implements Tickets<String> {

  private final JiraRestClient client;

  public JrTickets(final Credentials creds) {
    this.client = new AsynchronousJiraRestClientFactory()
        .createWithBasicHttpAuthentication(URI.create(creds.password()), creds.username(),
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