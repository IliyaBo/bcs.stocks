package com.bcs.stocks.exception;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionUtil {

  private static final String STACK_TRACE_ERROR = "Unable to generate a stack trace";

  protected ExceptionUtil() {
    //no-opt
  }

  /**
   * Stack trace to string
   */
  public static String getStackTraceAsString(Throwable exception) {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos)) {

      exception.printStackTrace(ps);
      ps.flush();
      return new String(baos.toByteArray(), StandardCharsets.UTF_8);

    } catch (IOException e) {
      log.error(STACK_TRACE_ERROR);
      return STACK_TRACE_ERROR;
    }
  }

}
