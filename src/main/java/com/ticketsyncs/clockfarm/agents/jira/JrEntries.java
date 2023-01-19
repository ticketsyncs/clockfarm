/*
 * Copyright (c) 2022 Aliaksei Bialiauski
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.ticketsyncs.clockfarm.agents.jira;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.ticketsyncs.clockfarm.model.Entries;
import com.ticketsyncs.clockfarm.model.Entry;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Jira entries or tickets.
 *
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 0.0.1
 */
@Component
@RequiredArgsConstructor
public final class JrEntries implements Entries {

  private final JiraRestClient jira;

  @Override
  public Entry entry(final String id) {
    final Issue issue = this.jira.getIssueClient().getIssue(id).claim();
    return new JrEntry(
      issue.getKey(),
      issue.getProject().getName(),
      issue.getSummary(),
      issue.getTimeTracking().getTimeSpentMinutes()
    );
  }

  @Override
  public Iterable<Entry> iterate() {
    final List<Entry> entries = new ArrayList<>();
    this.jira.getSearchClient().searchJql("")
      .claim().getIssues().forEach(issue -> entries.add(
          new JrEntry(
            issue.getKey(),
            issue.getProject().getName(),
            issue.getSummary(),
            issue.getTimeTracking().getTimeSpentMinutes()
          )
        )
      );
    return entries;
  }

  @Override
  public Iterable<Entry> iterate(final String project) {
    final List<Entry> entries = new ArrayList<>();
    this.jira.getSearchClient().searchJql(
        String.format("project=%s", project)
      )
      .claim().getIssues().forEach(issue -> entries.add(
          new JrEntry(
            issue.getKey(),
            issue.getProject().getName(),
            issue.getSummary(),
            issue.getTimeTracking().getTimeSpentMinutes()
          )
        )
      );
    return entries;
  }
}