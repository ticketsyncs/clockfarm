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

import com.ticketsyncs.clockfarm.model.Entry;
import lombok.RequiredArgsConstructor;

/**
 * Jira entry or ticket.
 *
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 0.0.1
 */
@RequiredArgsConstructor
public final class JrEntry implements Entry {

  private final String id;
  private final String project;
  private final String body;
  private final Integer minutes;

  @Override
  public Double spentTime() {
    return new HoursOf(this.minutes)
      .formatted();
  }

  @Override
  public String project() {
    return this.project;
  }

  @Override
  public String toString() {
    return String.format("id: %s, text: %s", this.id, this.body);
  }
}