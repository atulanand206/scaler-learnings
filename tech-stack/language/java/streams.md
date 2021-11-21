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

## Errors

### 1.  Stream has already been operated upon or closed.

As streams follow the principles of immutability, stream pipeline can't be shared midway. Like in the following example, `forEach `is separately called after `count` which the Streams don't allow.

```java
Stream<Integer> stream = streamOfIntegers(n);
System.out.println(stream.count());
stream.forEach(System.out::println);
```

