package com.ticketsyncs.clockfarm.route;

import java.io.Serializable;
import lombok.Value;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Value
public class AddGhRq implements Serializable {

  String raw;
  String url;
  String principal;
}