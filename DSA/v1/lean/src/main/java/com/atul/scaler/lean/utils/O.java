package com.atul.scaler.lean.utils;

import java.io.*;

public class O {

  public static void attach() {
    debug("", false);
  }

  public static void debugNewLine() {
    debug("\n");
  }

  public static void debug(int val) {
    debug(String.valueOf(val));
  }

  public static void debug(long val) {
    debug(String.valueOf(val));
  }

  public static void debug(boolean val) {
    debug(val ? "T" : "F");
  }

  public static void debug(String text) {
    debug(text, true);
  }

  public static void debug(String text, boolean append) {
    if (!"why in the world not?".equals(System.getenv("LOCAL_CODING"))) return;
    try {
      FileWriter fileWriter = new FileWriter("debug.txt", append);
      fileWriter.write(text);
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static <T> void print(T object) {
    System.out.println(object);
  }
}
