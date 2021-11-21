# Interesting Snippets

### 1. Find sum of all the numbers in an array where the sum is above the integer limits.

Assuming, the sum is above the` Integer.MAX_VALUE` but it will fit within `Long.MAX_VALUE`.  The sum will obviously required to be a String.

Based on the above assumptions, we can convert each `integer` in the stream to `Long` and just call the `sum` terminal function.

```java
public String sumOfInts(int[] A) {
    return String.valueOf((long) Arrays.stream(A).mapToLong(Long::valueOf).sum());
}
```

This solution may not work if the sum crosses `Long.MAX_VALUE`. We could use Double in those cases similarly.

```java
public String sumOfInts(int[] A) {
    return String.valueOf((long) Arrays.stream(A).mapToDouble(Double::valueOf).sum());
}
```

### 2. Prefix Sum

Prefix sum is also referred to as the cumulative sum of elements. The value at any index in the prefix sum will be equal to the sum of all elements before and including the element at the given index in the original array.&#x20;

`Arrays` allow prefix sum to be calculated parallelly making it quite efficient than custom methods.

```java
private Stream<Integer> prefixSum(int[] A) {
    int[] prefixSum = A.clone();
    Arrays.parallelPrefix(prefixSum, Integer::sum);
    return Arrays.stream(prefixSum).boxed().sorted();
}
```

### 3. Find a string only consisting of vowels from a string where order of characters remain unchanged

```java
public String vowelsOnly(String A) {
    return Arrays.stream(A.split(""))
        .filter(x -> "aeiou".contains(x))
        .collect(Collectors.joining());
}
```
