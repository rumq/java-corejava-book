> [Home](Home.md)

# Volume 2 Chapter 1 Streams

Status : IN_PROGRESS

- [Volume 2 Chapter 1 Streams](#volume-2-chapter-1-streams)
  - [1.1 From Iterating to Stream Operations](#11-from-iterating-to-stream-operations)
  - [1.2 Stream Creation](#12-stream-creation)
  - [1.3 The filter, map, and flatMap Methods](#13-the-filter-map-and-flatmap-methods)
  - [1.4 Extracting Substreams and Combining Streams](#14-extracting-substreams-and-combining-streams)
  - [1.5 Other Stream Transformations](#15-other-stream-transformations)
  - [1.6 Simple Reductions](#16-simple-reductions)

Streams were introduced in Java 8. They are a new abstraction that allows you to process data **declaratively**. It provides a way to process data in a functional style.

A stream is a sequence of objects that supports various methods which can be **pipelined** to produce the desired result. For example, filtering strings, sorting them, and printing them out. 

Streams are created on a source, e.g. a java.util.Collection like lists or sets (maps are not supported). 

Stream operations can either be **intermediate** or **terminal**. While terminal operations return a result of a certain type, intermediate operations return the stream itself so you can chain multiple method calls in a row. 

Intermediate operations are always **lazy**. For example, filtering a Stream obtained from a list will not actually filter any elements. The filtering will be performed when the terminal operation is executed. This allows for optimization because filtering operations can be skipped if no terminal operation is invoked on the stream.

You can specify what need to be done, not how.

## 1.1 From Iterating to Stream Operations

Differences between Iteration and Stream Operations

| Iteration                     | Stream Operations     |
| ----------------------------- | --------------------- |
| Explicit iteration            | Implicit iteration    |
| Imperative style              | Declarative style     |
| External iteration            | Internal iteration    |
| Stateful iteration            | Stateless iteration   |
| Iteration variable is updated | No iteration variable |

Operations are **stateless**, a stream operation does not modify the source data. It only produces a result. 
It does not **store** any elements. 

As the operations are stateless, they can be executed in **parallel**.

The operations are **lazy**, they are not executed until a terminal operation is invoked. So we can chain multiple operations without the overhead of processing the intermediate results. 

And we can have **infinite** streams.


## 1.2 Stream Creation

There are several ways to create a stream.

See [CreatingStreamsTest](../book-code/corejava/v2ch01/pawarv/CreatingStreamsTest.java)

Do not modify the collection that's being used to create a stream. The outcome is undefined. 

## 1.3 The filter, map, and flatMap Methods

See the following examples
- [FilterOperationTest](../book-code/corejava/v2ch01/pawarv/FilterOperationTest.java)
- [MapOperationTest](../book-code/corejava/v2ch01/pawarv/MapOperationTest.java)
- [FlatMapOperationSimpleTest](../book-code/corejava/v2ch01/pawarv/FlatMapOperationSimpleTest.java.java)
- [FlatMapOperationComplexTest](../book-code/corejava/v2ch01/pawarv/FlatMapOperationComplexTest.java)
- [MapMultiOperationTest](../book-code/corejava/v2ch01/pawarv/MapMultiOperationTest.java)
  

Once we have a stream, we can apply operations on it.

A filter operation takes a predicate and returns a stream consisting of the elements that match the given predicate.

A map operation takes a function and returns a stream consisting of the results of applying the given function to the elements of this stream.

> A flatMap operations returns a stream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element. Each mapped stream is closed after its contents have been placed into this stream. (If a mapped stream is null an empty stream is used, instead.). 

That is a bit confusing. Let's break it down. 
A flatMap operation like a map operation, works on a stream to return another steam. Suppose the mapping function returns not a single value, but a stream? You'll end up with a stream of streams. In this case, if you use a flatMap instead of a map, the result will be just a single stream containing all the elements of the streams returned by the mapping function.

In other words, it takes a stream of streams and returns a flattened stream.

> A mapMulti operation returns a stream consisting of the results of replacing each element of this stream with multiple elements, specifically zero or more elements. Replacement is performed by applying the provided mapping function to each element in conjunction with a consumer argument that accepts replacement elements. The mapping function calls the consumer zero or more times to provide the replacement elements.

It's a bit like a flatMap operation, but the mapping function can produce zero or more elements rather than a stream.

## 1.4 Extracting Substreams and Combining Streams

See the following example [SubstreamTest](../book-code/corejava/v2ch01/pawarv/SubstreamTest.java)

The `limit` and `skip` methods can be used to extract a substream. 

The `limit` method returns a stream consisting of the elements of this stream, truncated to be no longer than `maxSize` in length. 

The `skip` method returns a stream consisting of the remaining elements of this stream after discarding the first `n` elements of the stream. If this stream contains fewer than `n` elements then an empty stream will be returned.

The `takeWhile` and `dropWhile` methods can be used to extract a substream.

The `takeWhile` method returns a stream consisting of the elements of the stream until a particular element that matches the given predicate. Note that if the first element itself matches the predicate, then nothing will be included in the resulting stream.

The `dropWhile` method does the exact opposite. It returns a stream consisting of the remaining elements of this stream after discarding all the elements until the first element that matches the given predicate is found. Note that if the first element itself matches the predicate, then the entire stream will be returned.

The `concat` method can be used to combine two streams. It returns a stream consisting of the elements of the first stream followed by the elements of the second stream. So, if you combine the elements of the lists resulting from the takeWhile and dropWhile operations, you get the original list back. You can see this in the example.

## 1.5 Other Stream Transformations

See example [OtherStreamTransformationsTest](../book-code/corejava/v2ch01/pawarv/OtherStreamOperationsTest.java)

The `distinct` method returns a stream consisting of the distinct elements of this stream.

The `sorted` method returns a stream consisting of the elements of this stream, sorted according to natural order.

The `sorted` method can also take a comparator as an argument. It returns a stream consisting of the elements of this stream, sorted according to the provided comparator.

The `peek` method returns a stream consisting of the elements of this stream, additionally performing the provided action on each element as elements are consumed from the resulting stream.

The `unordered` method returns a stream with the same elements as this stream, but may not preserve any encounter order.

## 1.6 Simple Reductions

See example [SimpleReductionsTest](../book-code/corejava/v2ch01/pawarv/SimpleReductionsTest.java)


Reduction operations are terminal operations. They return a single value.

The `count` method returns the number of elements a stream.

The `min` and `max` methods return the minimum and maximum element of a stream. These methods assume that the elements of the stream are comparable. The result is an Optional object containing the minimum or maximum element, if any. 

The `min` and `max` methods can also take a comparator as an argument. They return the minimum and maximum element of a stream according to the provided comparator.

The `findAny` and `findFirst` methods return an Optional object. They return an arbitrary element of the stream or the first element of the stream, respectively.

The `anyMatch`, `allMatch`, and `noneMatch` methods return a boolean value. They return true if any, all, or none of the elements of the stream match the provided predicate, respectively.

The `reduce` method returns an Optional object. It returns the result of reducing the elements of the stream with the provided binary operator. The binary operator takes two arguments and returns one. The result is an Optional object containing the reduced value, if any.

The `reduce` method can also take an identity value and a binary operator as arguments. It returns the result of reducing the elements of the stream with the provided identity value and binary operator. The binary operator takes two arguments and returns one. The result is an Optional object containing the reduced value, if any.

1.7 The Optional Type

See example [OptionalTest](../book-code/corejava/v2ch01/pawarv/OptionalTest.java)

The Optional type is a container object used to contain not-null objects. Optional objects are used to represent null with a non-null value. Optional is a final class and cannot be subclassed.

Optional has various utility methods to facilitate code to handle values as ‘available’ or ‘not available’ instead of checking null values. 

If we want to use a default value if a value is not available, we can use `orElse` method of Optional class.


1.8 Collecting Results

1.9 Collecting into Maps

1.10 Grouping and Partitioning

1.11 Downstream Collectors

1.12 Reduction Operations

1.13 Primitive Type Streams

1.14 Parallel Streams

> [Home](HOME.md)
