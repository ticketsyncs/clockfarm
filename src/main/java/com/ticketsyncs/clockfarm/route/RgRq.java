package com.ticketsyncs.clockfarm.route;

import java.io.Serializable;
import lombok.Value;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Value
public class RgRq implements Serializable {

  private static final long serialVersionUID = -1284952378973194408L;
  String username;
  String password;
}