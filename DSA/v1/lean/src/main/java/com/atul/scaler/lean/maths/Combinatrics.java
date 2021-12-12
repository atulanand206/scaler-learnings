package com.atul.scaler.lean.maths;

/**
 * Problem: Given three integers A, B and C, where A represents n, B represents r and C represents
 * m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
 *
 * <p>x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
 *
 * <p>Problem Constraints: 1 <= size of the array <= 1000000
 *
 * <p>Input: First argument is an array of digits.
 *
 * <p>Output: Return the array of digits after adding one.
 *
 * <p>Approach: 1. Using the pascal triangle generated in a bottom-up fashion.
 *
 * <p>Time Complexity: O(n * r)
 *
 * <p>2. Using the formula nCr % m = (n!/((n-r)!*r!))% m. when m is a prime using the inverse
 * modulo.
 *
 * <p>Time Complexity: O(n + log(m)) ~ O(n)
 *
 * @author atulanand
 */
public class Combinatrics {

  public int solve(int A, int B, int C) {
    int[][] pascal = new int[A + 1][B + 1];
    pascal[0][0] = 1;
    for (int i = 1; i <= A; i++)
      for (int j = 0; j <= B; j++)
        if (j == 0 || j == i) pascal[i][j] = 1;
        else pascal[i][j] = (pascal[i - 1][j - 1] + pascal[i - 1][j]) % C;
    return pascal[A][B];
  }

  public int solvePrime(int A, int B, int C) {
    return (int)
        ((factorial(A, C) * binaryExpo(factorial(B, C), C - 2, C) % C)
            * binaryExpo(factorial(A - B, C), C - 2, C)
            % C);
  }

  public long factorial(long A, long m) {
    long res = 1;
    for (int i = 1; i <= A; i++) res = (res * i) % m;
    return res;
  }

  public long binaryExpo(long A, long B, long C) {
    long res = 1;
    while (B > 0) {
      if ((B & 1) == 1) res = (res * A) % C;
      A = (A * A) % C;
      B >>= 1;
    }
    return res;
  }
}
