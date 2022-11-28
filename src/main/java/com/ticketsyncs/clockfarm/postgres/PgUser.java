package com.ticketsyncs.clockfarm.postgres;

import com.ticketsyncs.clockfarm.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "user_account", schema = "ticket_syncs")
public class PgUser implements User<Long> {

  private String username;
  private String password;

  @Override
  public Long id() {
    throw new UnsupportedOperationException("#id()");
  }

  @Override
  public String username() {
    return this.username;
  }
}