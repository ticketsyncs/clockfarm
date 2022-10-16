package com.h1alexbel.software.harvestsync.jira.config;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

/**
 * @author Aliaksei Bialiauski (abialiauski@sovld.com)
 * @since 1.0
 */
@Configuration
public class JiraConfiguration {

  @Value("${jira.domain}")
  private String domain;
  @Value("${jira.username}")
  private String username;
  @Value("${jira.token}")
  private String token;

  @Bean
  public JiraRestClient restClient() {
    System.out.println(token);
    return new AsynchronousJiraRestClientFactory()
        .createWithBasicHttpAuthentication(URI.create(this.domain),
            this.username, this.token
        );
  }
}