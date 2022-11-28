package com.ticketsyncs.clockfarm.route;

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
public class AuthRequest {

  private String username;
  private String password;
}