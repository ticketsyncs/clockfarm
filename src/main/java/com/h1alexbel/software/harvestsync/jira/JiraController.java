package com.h1alexbel.software.harvestsync.jira;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aliaksei Bialiauski (abialiauski@sovld.com)
 * @since 1.0
 */
@RestController
@RequestMapping("/jira")
@RequiredArgsConstructor
public class JiraController {

  private final JiraRestClient restClient;

  @GetMapping("/spent/{id}")
  public Integer getSpentMinutesByIssueKey(@PathVariable String id) {
    return this.restClient
        .getIssueClient()
        .getIssue(id)
        .claim()
        .getTimeTracking()
        .getTimeSpentMinutes();
  }
}