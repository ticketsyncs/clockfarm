package com.ticketsyncs.clockfarm.route;

import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Value
@AllArgsConstructor
public class RsJwt {

  String token;
  String msg;
}