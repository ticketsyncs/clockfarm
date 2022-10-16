package com.h1alexbel.software.harvestsync.jira;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * @author Aliaksei Bialiauski (abialiauski@sovld.com)
 * @since 1.0
 */
@RestController
@RequestMapping("/jira")
@RequiredArgsConstructor
public class JiraController {

  //  private final JiraRestClient restClient;
  @Value("${jira.domain}")
  private String domain;
  @Value("${jira.username}")
  private String username;

  @GetMapping("/{token}/spent/{id}")
  public Integer getSpentMinutesByIssueKey(@PathVariable String token, @PathVariable String id) {
//    return this.restClient
//        .getIssueClient()
//        .getIssue(id)
//        .claim()
//        .getTimeTracking()
//        .getTimeSpentMinutes();
    JiraRestClient restClient = new AsynchronousJiraRestClientFactory()
        .createWithBasicHttpAuthentication(URI.create(this.domain),
            this.username, token
        );
    return restClient.getIssueClient()
        .getIssue(id).claim().getTimeTracking().getTimeSpentMinutes();
  }

//  @Bean
//  public JiraRestClient restClient1(String token) {
//    return new AsynchronousJiraRestClientFactory()
//        .createWithBasicHttpAuthentication(URI.create(this.domain),
//            this.username, token
//        );
//  }
}