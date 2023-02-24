> [Home](Home.md)

# Volume 2 Chapter 1 Streams

## Status : IN_PROGRESS

- [Volume 2 Chapter 1 Streams](#volume-2-chapter-1-streams)
  - [Status : IN\_PROGRESS](#status--in_progress)
  - [1.1 From Iterating to Stream Operations](#11-from-iterating-to-stream-operations)
  - [1.2 Stream Creation](#12-stream-creation)
  - [1.3 The filter, map, and flatMap Methods](#13-the-filter-map-and-flatmap-methods)

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

Once we have a stream, we can apply operations on it.

A filter operation takes a predicate and returns a stream consisting of the elements that match the given predicate.

A map operation takes a function and returns a stream consisting of the results of applying the given function to the elements of this stream.

A flatMap operations returns a stream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element. Each mapped stream is closed after its contents have been placed into this stream. (If a mapped stream is null an empty stream is used, instead.).  In other words, it takes a stream of streams and returns a flattened stream.

A multiple map operation can be replaced by a single flatMap operation.

A mapMulti operation takes a function that returns a collection, and then returns a stream consisting of the results of replacing each element of this stream with the contents of a mapped collection produced by applying the provided mapping function to each element. In other words, it takes a stream of collections and returns a flattened stream.

A mapMulti operation a stream consisting of the results of replacing each element of this stream with multiple elements, specifically zero or more elements. Replacement is performed by applying the provided mapping function to each element in conjunction with a consumer argument that accepts replacement elements. The mapping function calls the consumer zero or more times to provide the replacement elements.

1.4 Extracting Substreams and Combining Streams

1.5 Other Stream Transformations

1.6 Simple Reductions

1.7 The Optional Type

1.8 Collecting Results

1.9 Collecting into Maps

1.10 Grouping and Partitioning

1.11 Downstream Collectors

1.12 Reduction Operations

1.13 Primitive Type Streams

1.14 Parallel Streams

> [Home](HOME.md)
