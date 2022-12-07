package com.ticketsyncs.clockfarm.postgres;

import com.ticketsyncs.clockfarm.model.Credentials;
import com.ticketsyncs.clockfarm.model.WithId;
import java.net.URI;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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
@Table(schema = "ticket_syncs", value = "github_creds")
public class PgGhCredentials implements Credentials, WithId<Long> {

  @Id
  private Long id;
  private String url;
  private String token;
  @Column("user_id")
  private Long userId;
  @Transient
  private String username;

  @Override
  public URI uri() {
    return URI.create(this.url);
  }

  @Override
  public String username() {
    return this.url;
  }

  @Override
  public String password() {
    return this.token;
  }

  @Override
  public Long id() {
    return this.id;
  }
}