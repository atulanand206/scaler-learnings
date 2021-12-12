package com.atul.scaler.lean.utils;

import java.util.*;

public class S {

  public static <T> String string(T val) {
    return val + "\n";
  }

  public static String string(int[] array) {
    StringBuilder sb = new StringBuilder();
    openingBracket(sb);
    for (int in : array) sb.append(in).append(", ");
    if (array.length != 0) deleteLastComma(sb);
    closingBracket(sb);
    return sb.toString();
  }

  public static String string(long[] array) {
    StringBuilder sb = new StringBuilder();
    openingBracket(sb);
    for (long in : array) sb.append(in).append(", ");
    if (array.length != 0) deleteLastComma(sb);
    closingBracket(sb);
    return sb.toString();
  }

  public static String string(double[] array) {
    StringBuilder sb = new StringBuilder();
    openingBracket(sb);
    for (double in : array) sb.append(in).append(", ");
    if (array.length != 0) deleteLastComma(sb);
    closingBracket(sb);
    return sb.toString();
  }

  public static String string(boolean[] array) {
    StringBuilder sb = new StringBuilder();
    openingBracket(sb);
    for (boolean in : array) sb.append(in ? "T" : "F").append(", ");
    if (array.length != 0) deleteLastComma(sb);
    closingBracket(sb);
    return sb.toString();
  }

  public static String string(char[] array) {
    StringBuilder sb = new StringBuilder();
    openingBracket(sb);
    for (char in : array) sb.append(in).append(", ");
    if (array.length != 0) deleteLastComma(sb);
    closingBracket(sb);
    return sb.toString();
  }

  public static String string(String[] array) {
    StringBuilder sb = new StringBuilder();
    openingBracket(sb);
    for (String in : array) sb.append(in).append(", ");
    if (array.length != 0) deleteLastComma(sb);
    closingBracket(sb);
    return sb.toString();
  }

  public static String string(int[][] array) {
    StringBuilder sb = new StringBuilder();
    openingBracketWithNewLine(sb);
    for (int[] in : array) sb.append("  ").append(string(in));
    closingBracket(sb);
    return sb.toString();
  }

  public static String string(long[][] array) {
    StringBuilder sb = new StringBuilder();
    openingBracketWithNewLine(sb);
    for (long[] in : array) sb.append("  ").append(string(in));
    closingBracket(sb);
    return sb.toString();
  }

  public static String string(double[][] array) {
    StringBuilder sb = new StringBuilder();
    openingBracketWithNewLine(sb);
    for (double[] in : array) sb.append("  ").append(string(in));
    closingBracket(sb);
    return sb.toString();
  }

  public static <T> String string(boolean[][] array) {
    StringBuilder sb = new StringBuilder();
    openingBracketWithNewLine(sb);
    for (boolean[] in : array) sb.append("  ").append(string(in));
    closingBracket(sb);
    return sb.toString();
  }

  public static String string(char[][] array) {
    StringBuilder sb = new StringBuilder();
    openingBracketWithNewLine(sb);
    for (char[] in : array) sb.append("  ").append(string(in));
    closingBracket(sb);
    return sb.toString();
  }

  public static String string(String[][] array) {
    StringBuilder sb = new StringBuilder();
    openingBracketWithNewLine(sb);
    for (String[] in : array) sb.append("  ").append(string(in));
    closingBracket(sb);
    return sb.toString();
  }

  public static <T> String stringi(List<T> list) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < list.size(); i++)
      sb.append(i).append(": ").append(list.get(i)).append("\n");
    return sb.toString();
  }

  public static <T> String string(Collection<T> collection) {
    StringBuilder sb = new StringBuilder();
    openingBracket(sb);
    for (T t : collection) sb.append(t).append(", ");
    if (!collection.isEmpty()) deleteLastComma(sb);
    closingBracket(sb);
    return sb.toString();
  }

  public static <T> String string2D(Collection<Collection<T>> collection) {
    StringBuilder sb = new StringBuilder();
    openingBracketWithNewLine(sb);
    for (Collection<T> t : collection) sb.append("  ").append(string(t));
    closingBracket(sb);
    return sb.toString();
  }

  public static <T> String string2Di(List<Collection<T>> list) {
    StringBuilder sb = new StringBuilder();
    openingBracketWithNewLine(sb);
    for (int i = 0; i < list.size(); i++)
      sb.append("  ").append(i).append(": ").append(string(list.get(i)));
    closingBracket(sb);
    return sb.toString();
  }

  public static <E, V> String string(Map<E, V> map) {
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<E, V> entry : map.entrySet())
      sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
    sb.append("\n");
    return sb.toString();
  }

  private static void openingBracket(StringBuilder sb) {
    sb.append("[");
  }

  private static void openingBracketWithNewLine(StringBuilder sb) {
    sb.append("[\n");
  }

  private static void closingBracket(StringBuilder sb) {
    sb.append("]\n");
  }

  private static void deleteLastComma(StringBuilder sb) {
    sb.delete(sb.length() - 2, sb.length());
  }
}
