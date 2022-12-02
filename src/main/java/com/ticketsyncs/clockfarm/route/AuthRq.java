package com.ticketsyncs.clockfarm.route;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRq implements Serializable {

  private static final long serialVersionUID = 8908025826085659092L;
  private String username;
  private String password;
}