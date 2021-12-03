# Streams

Backed by lazy evaluations, **STREAMS** provides an amazing toolkit for functional programming in Java.&#x20;

Some common examples.&#x20;

### 1. Create a stream of n consecutive elements starting at x.

Streams doesn't perform computations until it's the next step. As a consequence, Streams provide an infinite variant. It is unbounded in nature but can also be limited by setting a limit in the stream pipeline. As the following method returns a Stream, no computations will be performed in this method and it'll linger lazily in the memory until it's called externally to finish the job.&#x20;

```java
Stream<Integer> streamOfIntegers(int n, int x) {
  return Stream.iterate(x, e -> e + 1).limit(n);
}
```

Instead of using an Infinite Stream, we can also create an `IntStream` using the `range` method. This is the replacement of the for loop that we've been writing since forever.

```java
 // Omits the end value from the result.
 IntStream streamRange(int start, int end) {
   return IntStream.range(start, end);
 }
 
 // Includes the end value in the result.
 IntStream streamRangeClosed(int start, int end) {
  return IntStream.rangeClosed(start, end);
}
```

### 2. Create a stream from an array

Arrays provide an API to create an `IntStream` from an `int` array. Similar API is available for `long`, `double` & `object` as well.

```java
IntStream streamFromIntArray(int[] arr) {
  return Arrays.stream(arr);
}

LongStream streamFromLongArray(long[] arr) {
  return Arrays.stream(arr);
}
```

### 3. Create a stream from a list

Collection interface provides a `stream()` method to easily convert a list into a stream.

```java
 Stream<String> streamFromStringList(List<String> list) {
   return list.stream();
 }
```

### 4. Multiply all the numbers with a fixed number in a stream&#x20;

For applying an operation to all elements in a Stream, we leverage the map function provided by the Streams API.

Map function is a transformation function which takes in a value and a transformation lambda expression and return the transformed result.&#x20;

The type of input and output can be different.&#x20;

There will be equal no of elements in input and output.

```java
Stream<Integer> multiply(Stream<Integer> input, int factor) {
    return input.map(e -> e * factor);
}

```

### 5. Multiply all the numbers with one less than the number in a stream&#x20;

Streams API provides a `map()` method which is used to transform an element and store the result in the same order.

```java
Stream<Integer> multiplyWithOneLess(Stream<Integer> input) {
    return input.map(e -> e * (e - 1));
}
```

### 6.  Find the distinct integers of an array in sorted order

Streams API provides `sorted()` which is used to sort a stream. You can pass custom `Comparator` to sort according to requirement. `Comparator` provides some type inferred comparators which work on all types implementing the `Comparable` interface like `Comparator.reverseOrder()` which reverses a stream of integers or strings as it should without specifying the type as it is inferred from the stream.

Stream API provides `distinct()` method which only allows one instance of each value in the resultant stream.

```java
public int[] distinctSorted(int[] n) {
    return Arrays.stream(n)
        .sorted()
        .distinct()
        .toArray();
}
```

### 7. Find the largest difference between consecutive elements oof an array.

Assuming there are at least 2 elements in the array, the following method would&#x20;

```java
public int maxConsecutiveDistance(int[] points) {
    return IntStream.range(1, points.length)
        .boxed()
        .map(i -> points[i] - points[i-1])
        .sorted(Comparator.reverseOrder())
        .findFirst()
        .orElse(0);
}
```

## Errors

### 1.  Stream has already been operated upon or closed.

As streams follow the principles of immutability, stream pipeline can't be shared midway. Like in the following example, `forEach` is separately called after `count` which the Streams don't allow.

```java
Stream<Integer> stream = streamOfIntegers(n);
System.out.println(stream.count());
stream.forEach(System.out::println);
```

