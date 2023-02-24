> [Home](Home.md)

# Streams

## Status : IN_PROGRESS

- [Streams](#streams)
  - [Status : IN\_PROGRESS](#status--in_progress)
  - [1.1 From Iterating to Stream Operations](#11-from-iterating-to-stream-operations)
  - [1.2 Stream Creation](#12-stream-creation)

Streams were introduced in Java 8. They are a new abstraction that allows you to process data declaratively. A stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result. For example, filtering strings, sorting them, and printing them out. Streams are created on a source, e.g. a java.util.Collection like lists or sets (maps are not supported). Stream operations can either be intermediate or terminal. While terminal operations return a result of a certain type, intermediate operations return the stream itself so you can chain multiple method calls in a row. Intermediate operations are always lazy. For example, filtering a Stream obtained from a list will not actually filter any elements. The filtering will be performed when the terminal operation is executed. This allows for optimization because filtering operations can be skipped if no terminal operation is invoked on the stream.

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

- From a collection
- 

1.3 The filter, map, and flatMap Methods

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
