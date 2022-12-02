package com.ticketsyncs.clockfarm.postgres;

import com.ticketsyncs.clockfarm.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(schema = "ticket_syncs", value = "user_account")
public class PgUser implements User<Long> {

  @Id
  private Long id;
  private String username;
  private String password;

  @Override
  public Long id() {
    return this.id;
  }

  @Override
  public String username() {
    return this.username;
  }
}