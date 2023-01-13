>[Home](Home.md)

# Chapter 9: Collections

## Status : IN_PROGRESS

## Contents

- 9.1 The Java Collections Framework
  - 9.1.1 Separating Collection Interfaces and Implementation
  - 9.1.2 The Collection Interface
  - 9.1.3 Iterators
  - 9.1.4 Generic Utility Methods
- 9.2 Interfaces in the Collections Framework
- 9.3 Concrete Collections
  - 9.3.1 Linked Lists
  - 9.3.2 Array Lists
  - 9.3.3 Hash Sets
  - 9.3.4 Tree Sets
  - 9.3.5 Queues and Deques
  - 9.3.6 Priority Queues
- 9.4 Maps
  - 9.4.1 Basic Map Operations
  - 9.4.2 Updating Map Entries
  - 9.4.3 Map Views
  - 9.4.4 Weak Hash Maps
  - 9.4.5 Linked Hash Sets and Maps
  - 9.4.6 Enumeration Sets and Maps
  - 9.4.7 Identity Hash Maps
- 9.5 Copies and Views
  - 9.5.1 Small Collections
  - 9.5.2 Unmodifiable Copies and Views
  - 9.5.3 Subranges
  - 9.5.4 Checked Views
  - 9.5.5 Synchronized Views
  - 9.5.6 A Note on Optional Operations
- 9.6 Algorithms
  - 9.6.1 Why Generic Algorithms?
  - 9.6.2 Sorting and Shuffling
  - 9.6.3 Binary Search
  - 9.6.4 Simple Algorithms
  - 9.6.5 Bulk Operations
  - 9.6.6 Converting between Collections and Arrays
  - 9.6.7 Writing Your Own Algorithms
- 9.7 Legacy Collections
  - 9.7.1 The Hashtable Class
  - 9.7.2 Enumerations
  - 9.7.3 Property Maps
  - 9.7.4 Stacks
  - 9.7.5 Bit Sets


## 9.1 The Java Collections Framework

### 9.1.1 Separating Collection Interfaces and Implementation

> As is common with modern data structure libraries, the Java collection library separates interfaces and implementations.

### 9.1.2 The Collection Interface


> The fundamental interface for collection classes in the Java library is the Collection interface. The interface has two fundamental methods: (there are others as well)

```java
public interface Collection<E>
{
   boolean add(E element);  //returns true if the collection changed
   Iterator<E> iterator();  // returns an iterator for the collection
   . . . (other methods omitted)
}

```

### 9.1.3 Iterators

Are used to visit all elements of a collection.


> The Iterator interface has four methods:

```java
public interface Iterator<E>
{   E next();
   boolean hasNext();  // call this before calling next()
   void remove();
   default void forEachRemaining(Consumer<? super E> action);
}
```

Using an iterator

```java
Collection<String> c = . . . ;
Iterator<String> iter = c.iterator();
// this check is necessary 
// as calling next() can throw NoSuchElementException

while (iter.hasNext())
{  String s = iter.next();
       . . . do something with s
}
```
Can also use a for-each loop

```java
for (String s : c)
       . . . do something with s
```

It can be used on any collection as Collection implements Iterable interface.

```java
public interface Iterable<T>
{
  Iterator<T> iterator();
}
```

You can think of iterators being in between elements.

> think of Java iterators as being between elements. When you call next, the iterator jumps over the next element, and it returns a reference to the element

[AdvancingAnIterator](../assets/diagrams/AdvancingAnIterator.excalidraw)
[AdvancingAnIterator PNG](../assets/diagrams/AdvancingAnIterator.png)

[IteratorTest](../book-code/corejava/v1ch09/pawarv/IteratorTest.java)

>The remove method of the Iterator interface removes the element that was returned by the last call to next.


### 9.1.4 Generic Utility Methods
## 9.2 Interfaces in the Collections Framework
## 9.3 Concrete Collections
### 9.3.1 Linked Lists

[LinkedListTest](../book-code/corejava/v1ch09/linkedList/LinkedListTest.java)

### 9.3.2 Array Lists
### 9.3.3 Hash Sets
### 9.3.4 Tree Sets
### 9.3.5 Queues and Deques
### 9.3.6 Priority Queues
## 9.4 Maps
### 9.4.1 Basic Map Operations
### 9.4.2 Updating Map Entries
### 9.4.3 Map Views
### 9.4.4 Weak Hash Maps
### 9.4.5 Linked Hash Sets and Maps
### 9.4.6 Enumeration Sets and Maps
### 9.4.7 Identity Hash Maps
## 9.5 Copies and Views
### 9.5.1 Small Collections
### 9.5.2 Unmodifiable Copies and Views
### 9.5.3 Subranges
### 9.5.4 Checked Views
### 9.5.5 Synchronized Views
### 9.5.6 A Note on Optional Operations
## 9.6 Algorithms
### 9.6.1 Why Generic Algorithms?
### 9.6.2 Sorting and Shuffling
### 9.6.3 Binary Search
### 9.6.4 Simple Algorithms
### 9.6.5 Bulk Operations
### 9.6.6 Converting between Collections and Arrays
### 9.6.7 Writing Your Own Algorithms
## 9.7 Legacy Collections
### 9.7.1 The Hashtable Class
### 9.7.2 Enumerations
### 9.7.3 Property Maps
### 9.7.4 Stacks
### 9.7.5 Bit Sets

>[Home](HOME.md)
