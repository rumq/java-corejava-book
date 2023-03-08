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
  - [1.7 The Optional Type](#17-the-optional-type)
    - [1.7.1 Getting an Optional Value](#171-getting-an-optional-value)
    - [1.7.2 Consuming an Optional Value](#172-consuming-an-optional-value)
    - [1.7.3 Pipelining Optional Values](#173-pipelining-optional-values)
    - [1.7.4 How Not to Work with Optional Values](#174-how-not-to-work-with-optional-values)
    - [1.7.5 Creating Optional Values](#175-creating-optional-values)
    - [1.7.6 Composing Optional Value Functions with flatMap](#176-composing-optional-value-functions-with-flatmap)
    - [1.7.7 Turning an Optional into a Stream](#177-turning-an-optional-into-a-stream)
  - [1.8 Collecting Results](#18-collecting-results)
  - [1.9 Collecting into Maps](#19-collecting-into-maps)
  - [1.10 Grouping and Partitioning](#110-grouping-and-partitioning)
  - [1.11 Downstream Collectors](#111-downstream-collectors)
  - [1.12 Reduction Operations](#112-reduction-operations)
  - [1.13 Primitive Type Streams](#113-primitive-type-streams)
  - [1.14 Parallel Streams](#114-parallel-streams)

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

## 1.7 The Optional Type

Book examples
- [OptionalTest](../book-code/corejava/v2ch01/optional/OptionalTest.java)

The Optional type is a container object used to contain objects that could be  null. Optional objects are used to represent null with a non-null value. Optional is a final class and cannot be subclassed.

Optional has various utility methods to facilitate code to handle values as ‘available’ or ‘not available’ instead of checking null values. 

### 1.7.1 Getting an Optional Value

See 
- [CreatingOptionalsTest](../book-code/corejava/v2ch01/pawarv/CreatingOptionalsTest.java)
- [GettingOptionalTest](../book-code/corejava/v2ch01/pawarv/GettingOptionalTest.java)

If we want to use a default value if a value is not available, we can use `orElse`, `orElseGet`, `orElseThrow` methods of Optional class.

### 1.7.2 Consuming an Optional Value

See [ConsumeOptionalTest](../book-code/corejava/v2ch01/pawarv/ConsumeOptionalTest.java)

We can consume an Optional value using `ifPresent` , `ifPresentOrElse` methods. It takes a Consumer as an argument. It consumes the value if it is present.

### 1.7.3 Pipelining Optional Values

See [PipeliningOptionalsTest](../book-code/corejava/v2ch01/pawarv/PipeliningOptionalsTest.java)

We can use `map` method to transform an Optional value. It takes a Function as an argument. It returns an Optional object containing the transformed value, if any.

### 1.7.4 How Not to Work with Optional Values

If you still use `isPresent` and then use the `get` method, you get no benefit from using Optional.

See  
- [CreatingOptionalsTest](../book-code/corejava/v2ch01/pawarv/CreatingOptionalsTest.java)

### 1.7.5 Creating Optional Values

See 
- [CreatingOptionalsTest](../book-code/corejava/v2ch01/pawarv/CreatingOptionalsTest.java).

### 1.7.6 Composing Optional Value Functions with flatMap

See 
- [FlatMapOptionalTest](../book-code/corejava/v2ch01/pawarv/FlatMapOptionalTest.java)
- [OptionalFlatMap Diagram](../assets/diagrams/OptionalFlatMap.excalidraw)

The `flatMap` method works in a similar way to the `flatMap` method of Stream. It takes an optional that can explode into more optionals and flattens them. 

For example if the optional returns a type that has a method that returns an optional, you can use `flatMap` to get the optional value.

Supposing a cupboard may have a safe which may have a box which have have earrings. You can use `flatMap` to get the earrings without checking for nulls.



### 1.7.7 Turning an Optional into a Stream

See [OptionToStreamTest](../book-code/corejava/v2ch01/pawarv/OptionToStreamTest.java)


The `stream` method returns a stream consisting of the optional value, if present. Otherwise, it returns an empty stream.

The `stream` method is useful when you want to use a stream method on an optional value.

After it's turned into a stream, you can use `flatMap` to drop the empty optionals.

## 1.8 Collecting Results

See [CollectingResultsTest](../book-code/corejava/v2ch01/pawarv/CollectingResultsTest.java)

Book examples
- [CollectingResults](../book-code/corejava/v2ch01/collecting/CollectingResults.java)
After all the stream operations are done, we can collect the results into a collection or a map.

We can use `forEach` method to consume the elements of a stream. It takes a Consumer as an argument. It consumes the elements of the stream. We can use `forEachOrdered` method to consume the elements of a stream in encounter order. It takes a Consumer as an argument. 

The `toArray` method returns an array containing the elements of the stream. It takes a generator as an argument. It returns an array containing the elements of the stream.

The `collect` method returns a result of the reduction operation. It takes a Collector as an argument. It returns a result of the reduction operation.

The `collect` method can also take a supplier, an accumulator, and a combiner as arguments. It returns a result of the reduction operation.

Factory methods of the Collectors class can be used to create Collectors.

The `toList` method returns a Collector. It returns a Collector that accumulates the input elements into a new list.

The `toSet` method returns a Collector. It returns a Collector that accumulates the input elements into a new set.

The `toCollection` method returns Collector. It takes a supplier as an argument. It returns a Collector that accumulates the input elements into a new collection, as supplied by the supplier.

The `counting` method returns a Collector. It returns a Collector that counts the input elements.

The `summingInt` method returns a Collector. It takes an IntFunction as an argument. It returns a Collector that sums the input elements.

The `averagingInt` method returns a Collector. It takes an IntFunction as an argument. It returns a Collector that computes the arithmetic mean of the input elements.

The `summarizingInt` method returns a Collector. It takes an IntFunction as an argument. It returns a Collector that computes summary statistics for the input elements.

The `joining` method returns a Collector. It returns a Collector that concatenates the input elements, separated by the specified delimiter, in encounter order.

The `mapping` method returns a Collector. It takes a function and a downstream collector as arguments. It returns a Collector that applies a mapping function to the input elements before accumulating them.

The `reducing` method returns a Collector. It takes an identity, a function, and a combiner as arguments. It returns a Collector that applies a reduction function to the input elements.


## 1.9 Collecting into Maps

See
- [CollectingIntoMapsBasicTest](../book-code/corejava/v2ch01/pawarv/CollectingIntoMapsBasicTest.java)
- [CollectingIntoMapsIdentity](../book-code/corejava/v2ch01/pawarv/CollectingIntoMapsIdentity.java)
- [CollectingIntoMapsMergesTest](../book-code/corejava/v2ch01/pawarv/CollectingIntoMapsMergesTest.java)


Book examples
- [CollectingIntoMaps](../book-code/corejava/v2ch01/collecting/CollectingIntoMaps.java)


The `toMap` method on Collectors returns a map. 

It can take 2,3 or 4 arguments. It returns a map containing the elements of the stream.

It can take key mapper function and the value mapper function as arguments to return a HashMap containing the key and corresponding value generated from these functions.

It can take the third argument of a merge function that is used to merge the values if the keys are the same. In this case merge means any logic we do to derive the value from the two values. As it takes two inputs, it's a binary operator.

Finally, it can take a supplier as the fourth argument which supplier the type of map we need, by default it's a HashMap.

See this [diagram](../assets/diagrams/toMap.excalidraw).

## 1.10 Grouping and Partitioning

See
- [GroupingAndPartitioningTest](../book-code/corejava/v2ch01/pawarv/GroupingAndPartitioningTest.java)
- [GroupingAndPartitioning](../assets/diagrams/GroupingAndPartitioning.excalidraw)

The `groupingBy` method returns a Collector. It takes a classifier function as an argument. It returns a Collector that groups the input elements according to a classification function.

The `partitioningBy` method returns a Collector. It takes a predicate as an argument. It returns a Collector that partitions the input elements according to a predicate.

## 1.11 Downstream Collectors

See 
- [DownstreamCollectorsTest](../book-code/corejava/v2ch01/pawarv/DownstreamCollectorsTest.java)
- [DownstreamCollectorsTeeingTest](../book-code/corejava/v2ch01/pawarv/DownstreamCollectorsTeeingTest.java)


Book examples
- [DownstreamCollectors](../book-code/corejava/v2ch01/collecting/DownstreamCollectors.java)


After grouping or partitioning, we end up with a map that has lists as values. We can use downstream collectors to further process these lists. 

The methods we saw earlier `toSet`, `toList`, `counting`, `summingInt`, `averagingInt`, `maxBy`, `minBy`, `mapping` can all be used as downstream collectors.

The `collectingAndThen` method returns a Collector. It takes a downstream collector and a function as arguments. It returns a Collector that applies a finisher function to the result of a reduction.


## 1.12 Reduction Operations
See
- [BasicReduceTest](../book-code/corejava/v2ch01/pawarv/BasicReduceTest.java)
- [ReduceWithCombinerTest](../book-code/corejava/v2ch01/pawarv/ReduceWithCombinerTest.java)
- [DifferentWaysOfSumming](../book-code/corejava/v2ch01/pawarv/DifferentWaysOfSumming.java)
- [ReductionOperation](../assets/diagrams/ReductionOperation.excalidraw)
- [ReductionOperationWithCombiner](../assets/diagrams/ReductionOperationWithCombiner.excalidraw)

We'll always use collect, but it's good to know how reduce works.

The `reduce` method takes an element from the stream, applies the accumulator function which requires two arguments. The first one is the partial result and the second is the current element. 

The initial value of the accumulator is the **identity**.  
The result of a binary operation on an element with the identity is the element itself.
For example, 0 is an identity for addition, 1 is an identity for multiplication. So if 0 is added to any element, we get the element back, similarly if 1 is multiplied to any element, we get the element back.


If there are no elements in the stream, the identity is returned. 

The **accumulator function** is associative. It can be 
any function that takes two arguments and returns a value.

**Associative** means that the order of the operands does not matter. For example, addition is associative. So if we add 1 + 2 + 3, we get the same result as 3 + 2 + 1. Similarly, multiplication is associative. So if we multiply 1 * 2 * 3, we get the same result as 3 * 2 * 1. Subtraction is not associative. So if we subtract 1 - 2 - 3, we get a different result than 3 - 2 - 1.



From the method documentation:
> 
> 
> The `reduce` method performs a reduction on the elements of this stream, using the provided identity value and an associative accumulation function, and returns the reduced value. This is equivalent to:

>```java
>T result = identity;
>     for (T element : this stream)
>         result = accumulator.apply(result, element)
>     return result;
>but is not constrained to execute sequentially.
>```
>
>The identity value must be an identity for the accumulator function. This means that for all t, accumulator.apply(identity, t) is equal to t. The accumulator function must be an associative function.
>
>This is a terminal operation.



If we do not give an identity to the reduce method, then the first element of the stream is used as the identity. It also returns an Optional.

Here is the documentation for the overridden  `reduce` method that does not take an identity as an argument:

> Performs a reduction on the elements of this stream, using an associative accumulation function, and returns an Optional describing the reduced value, if any. This is equivalent to:

> ```java
> boolean foundAny = false;
>     T result = null;
>     for (T element : this stream) {
>         if (!foundAny) {
>             foundAny = true;
>             result = element;
>         }
>         else
>             result = accumulator.apply(result, element);
>     }
>     return foundAny ? Optional.of(result) : Optional.empty();
> }
> ```
>but is not constrained to execute sequentially.
>
>The accumulator function must be an associative function.
>
>This is a terminal operation.


The `collect` method can also be used to perform reduction operations. It is more generic. 
It takes a supplier, an accumulator, and a combiner as arguments. It returns a result of the reduction operation.

To make it practical to use it, Collectors class provides a lot of predefined collectors that can be used to perform reduction operations. This we have already seen in the previous section.

## 1.13 Primitive Type Streams

See 
- [PrimitiveTypeStreamsTest](../book-code/corejava/v2ch01/pawarv/PrimitiveTypeStreamsTest.java)

The `IntStream`, `LongStream`, and `DoubleStream` classes are specializations of the `Stream` class for the primitive types `int`, `long`, and `double`. They have the same methods as the `Stream` class, but they are specialized for the primitive types.

The `mapToInt`, `mapToLong`, and `mapToDouble` methods on streams return a stream of the corresponding primitive type. They take a function as an argument. They return a stream of the corresponding primitive type.

They have  `sum`, `average`, `min`, and `max` methods that are not present in the `Stream` class. They return the corresponding primitive type.

The `range` and `rangeClosed` methods on the `IntStream` class return a stream of integers. They take two arguments. They return a stream of integers between the two arguments.

The `range` method does not include the second argument in the stream. The `rangeClosed` method includes the second argument in the stream.

The `summaryStatistics` method on the `IntStream` class returns a summary of the stream. It returns an `IntSummaryStatistics` object. It has the following methods:

- `getCount` returns the number of elements in the stream.
- `getSum` returns the sum of the elements in the stream.
- `getMin` returns the minimum element in the stream.
- `getMax` returns the maximum element in the stream.
- `getAverage` returns the average of the elements in the stream.
   
## 1.14 Parallel Streams

See
- [ParallelStreamsTest](../book-code/corejava/v2ch01/pawarv/ParallelStreamsTest.java)


Streams makes it easy to process data in parallel.


The `parallel` method on the `Stream` class returns a parallel stream. It takes no arguments. It returns a parallel stream.

The `parallelStream` method on the `Collection` interface returns a parallel stream. It takes no arguments. It returns a parallel stream.

The `sequential` method on the `Stream` class returns a sequential stream. It takes no arguments. It returns a sequential stream.

The operations on a parallel stream are performed in parallel as opposed to a sequential stream where the operations are performed in sequence. 

The operations have to be **associative** (order should not matter) & **stateless** for the parallel stream to work. If the operations are not associative or stateless, then the result of the parallel stream will be different from the result of the sequential stream.

> 
> Keep these issues in mind:
> - There is a substantial overhead to parallelization that will only pay off for very large data sets.
> - Parallelizing a stream is only a win if the underlying data source can be effectively split into multiple parts.
> - The thread pool that is used by parallel streams can be starved by blocking operations such as file I/O or network access.
>
    

> [Home](HOME.md)
