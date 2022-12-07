package com.ticketsyncs.clockfarm.route;

import java.io.Serializable;
import lombok.Value;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Value
public class AddJrRq implements Serializable {

  String username;
  String url;
  String raw;
  String principal;
}