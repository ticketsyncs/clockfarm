package com.ticketsyncs.clockfarm.postgres;

import com.ticketsyncs.clockfarm.model.Credentials;
import com.ticketsyncs.clockfarm.model.WithId;
import java.net.URI;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(schema = "ticket_syncs", value = "jira_creds")
public class PgJrCredentials implements Credentials, WithId<Long> {

  @Id
  private Long id;
  private String email;
  private String domain;
  private String token;
  @Column("user_id")
  private Long userId;

  @Override
  public URI uri() {
    return URI.create(this.domain);
  }

  @Override
  public String username() {
    return this.email;
  }

  @Override
  public String password() {
    return this.password();
  }

  @Override
  public Long id() {
    return this.id;
  }
}