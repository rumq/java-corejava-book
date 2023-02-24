>[Home](Home.md)

# Chapter 9: Collections

## Status : IN_PROGRESS


- [Chapter 9: Collections](#chapter-9-collections)
  - [Status : IN\_PROGRESS](#status--in_progress)
  - [9.1 The Java Collections Framework](#91-the-java-collections-framework)
    - [9.1.1 Separating Collection Interfaces and Implementation](#911-separating-collection-interfaces-and-implementation)
    - [9.1.2 The Collection Interface](#912-the-collection-interface)
    - [9.1.3 Iterators](#913-iterators)
    - [9.1.4 Generic Utility Methods](#914-generic-utility-methods)
  - [9.2 Interfaces in the Collections Framework](#92-interfaces-in-the-collections-framework)
  - [9.3 Concrete Collections](#93-concrete-collections)
    - [9.3.1 Linked Lists](#931-linked-lists)
    - [9.3.2 Array Lists](#932-array-lists)
    - [9.3.3 Hash Sets](#933-hash-sets)
    - [9.3.4 Tree Sets](#934-tree-sets)
    - [9.3.5 Queues and Deques](#935-queues-and-deques)
    - [9.3.6 Priority Queues](#936-priority-queues)
  - [9.4 Maps](#94-maps)
    - [9.4.1 Basic Map Operations](#941-basic-map-operations)
    - [9.4.2 Updating Map Entries](#942-updating-map-entries)
    - [9.4.3 Map Views](#943-map-views)
    - [9.4.4 Weak Hash Maps](#944-weak-hash-maps)
    - [9.4.5 Linked Hash Sets and Maps](#945-linked-hash-sets-and-maps)
    - [9.4.6 Enumeration Sets and Maps](#946-enumeration-sets-and-maps)
    - [9.4.7 Identity Hash Maps](#947-identity-hash-maps)
  - [9.5 Copies and Views](#95-copies-and-views)
    - [9.5.1 Small Collections](#951-small-collections)
    - [9.5.2 Unmodifiable Copies and Views](#952-unmodifiable-copies-and-views)
    - [9.5.3 Subranges](#953-subranges)
    - [9.5.4 Checked Views](#954-checked-views)
    - [9.5.5 Synchronized Views](#955-synchronized-views)
    - [9.5.6 A Note on Optional Operations](#956-a-note-on-optional-operations)
  - [9.6 Algorithms](#96-algorithms)
    - [9.6.1 Why Generic Algorithms?](#961-why-generic-algorithms)
    - [9.6.2 Sorting and Shuffling](#962-sorting-and-shuffling)
    - [9.6.3 Binary Search](#963-binary-search)
    - [9.6.4 Simple Algorithms](#964-simple-algorithms)
    - [9.6.5 Bulk Operations](#965-bulk-operations)
    - [9.6.6 Converting between Collections and Arrays](#966-converting-between-collections-and-arrays)
    - [9.6.7 Writing Your Own Algorithms](#967-writing-your-own-algorithms)
  - [9.7 Legacy Collections](#97-legacy-collections)
    - [9.7.1 The Hashtable Class](#971-the-hashtable-class)
    - [9.7.2 Enumerations](#972-enumerations)
    - [9.7.3 Property Maps](#973-property-maps)
    - [9.7.4 Stacks](#974-stacks)
    - [9.7.5 Bit Sets](#975-bit-sets)


## 9.1 The Java Collections Framework

### 9.1.1 Separating Collection Interfaces and Implementation

> As is common with modern data structure libraries, the Java collection library separates interfaces and implementations.

### 9.1.2 The Collection Interface

[Collection API doc](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Collection.html)

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

[Iterator API doc](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Iterator.html)

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


> The Collection and Iterator interfaces are generic, which means you can write utility methods that operate on any kind of collection.
>
> In fact, the Collection interface declares quite a few useful methods that all implementing classes must supply. Among them are 
> * int size() 
> * boolean isEmpty() 
> * boolean contains(Object obj) 
> * boolean containsAll(Collection<?> c) 
> * boolean equals(Object other) 
> * boolean addAll(Collection<? extends E> from) 
> * boolean remove(Object obj) 
> * boolean removeAll(Collection<?> c) 
> * void clear() 
> * boolean retainAll(Collection<?> c) Object[] toArray()


> To make life easier for implementors, the library supplies a class AbstractCollection that leaves the fundamental methods size and iterator abstract but implements the routine methods in terms of them. 
> This approach is a bit outdated. It would be nicer if the methods were default methods of the Collection interface.

The default method `removeIf` has been added to Collection. See [PredicateAndTest](../book-code/corejava/v1ch06/pawarv/PredicateAndTest.java)

[GenericUtilityMethodsTest](../book-code/corejava/v1ch09/pawarv/GenericUtilityMethodsTest.java)
## 9.2 Interfaces in the Collections Framework

![Collections Hierarchy - Book](2023-01-16-20-24-46.png)
[Collection Hierarchy](https://upload.wikimedia.org/wikipedia/commons/a/ab/Java.util.Collection_hierarchy.svg) 

[Collection Hierrachy Local file](../assets/diagrams/Java.util.Collection_hierarchy.svg)

[Map Hierarchy](https://upload.wikimedia.org/wikipedia/commons/7/7b/Java.util.Map_hierarchy.svg)
[Map Hierarchy Local](../assets/diagrams/Java.util.Map_hierarchy.svg)

> There are two fundamental interfaces for collections: Collection and Map .

Add into a list using `boolean add(E element)` and get values using `E get(int index)` or visit them using an iterator.

Add into a Map using `V put(K key, V value)`, and read values using `V get(K key)`.

A List is an ordered collection.

## 9.3 Concrete Collections

![Concrete Collections - Book](2023-01-16-20-25-54.png)
### 9.3.1 Linked Lists

[LinkedList Diagram](../assets/diagrams/LinkedList.excalidraw)

[LinkedListTest](../book-code/corejava/v1ch09/linkedList/LinkedListTest.java)

[ListIteratorTest](../book-code/corejava/v1ch09/pawarv/ListIteratorTest.java)

### 9.3.2 Array Lists

[ArrayListTest](../book-code/corejava/v1ch09/pawarv/ArrayListTest.java)

[UnmodifiableCollectionsTest](../book-code/corejava/v1ch09/pawarv/UnmodifiableCollectionsTest.java)


### 9.3.3 Hash Sets
>  If you don’t care about the ordering of the elements, there are data structures that let you find elements much faster.

> A well-known data structure for finding objects quickly is the hash table. A hash table computes an integer, called the hash code, for each object. A hash code is somehow derived from the instance fields of an object, preferably in such a way that objects with different data yield different codes.

>  A set is a collection of elements without duplicates.

[HashSetTest](../book-code/corejava/v1ch09/pawarv/HashSetTest.java)

[SetTest](../book-code/corejava/v1ch09/set/SetTest.java)

### 9.3.4 Tree Sets

 > A tree set is a sorted collection. You insert elements into the collection in any order. When you iterate through the collection, the values are automatically presented in sorted order.

 > In order to use a tree set, you must be able to compare the elements. The elements must implement the Comparable interface, or you must supply a Comparator when constructing the set

[TreeSetTest](../book-code/corejava/v1ch09/treeSet/TreeSetTest.java)

[TreeSet Test - read words from a book](../book-code/corejava/v1ch09/pawarv/TreeSetTest.java)

[TreeSetBasicTest](../book-code/corejava/v1ch09/pawarv/TreeSetBasicTest.java)


### 9.3.5 Queues and Deques

From [AbstractQueue API](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/AbstractQueue.html)
> public abstract class AbstractQueue<E> extends AbstractCollection<E> implements Queue<E>

> This class provides skeletal implementations of some Queue operations. The implementations in this class are appropriate when the base implementation does not allow null elements. Methods add, remove, and element are based on offer, poll, and peek, respectively, but throw exceptions instead of indicating failure via false or null returns.

> A Queue implementation that extends this class must minimally define a method Queue.offer(E) which does not permit insertion of null elements, along with methods Queue.peek(), Queue.poll(), Collection.size(), and Collection.iterator(). Typically, additional methods will be overridden as well. If these requirements cannot be met, consider instead subclassing AbstractCollection.

> This class is a member of the Java Collections Framework.

### 9.3.6 Priority Queues

> A priority queue retrieves elements in sorted order after they were inserted in arbitrary order.

> Just like a TreeSet, a priority queue can either hold elements of a class that implements the Comparable interface or a Comparator object you supply in the constructor.

[PriorityQueueTest](../book-code/corejava/v1ch09/priorityQueue/PriorityQueueTest.java)

## 9.4 Maps

A Map stores key value pairs. The keys are unique. The values can be duplicates. You can find a value by looking up its key.

A Map.Entry object represents a key-value pair. You can get a Set of all entries in a map by calling the entrySet method. You can iterate through the entries in a map using a for-each loop.

[BasicMapTest](../book-code/corejava/v1ch09/pawarv/BasicMapTest.java)
[MapTest](../book-code/corejava/v1ch09/map/MapTest.java)

### 9.4.1 Basic Map Operations

HashMap and TreeMap are general purpose implementations of the Map interface. They differ in how they store the elements.

A HashMap is a Map that uses a hash table to store its elements. The hash function is applied to the keys. It is very fast for finding elements, but it is not guaranteed to preserve the order of the elements.

A TreeMap is a Map that uses a tree to store its elements. It is slower for finding elements, but it is guaranteed to preserve the order of the elements.

A LinkedHashMap is a Map that uses a hash table to store its elements. It is very fast for finding elements, and it preserves the order of the elements.


### 9.4.2 Updating Map Entries

When updating a map, you can use the put method to add a new entry or to replace an existing entry. The put method returns the previous value associated with the key, or null if there was no previous value.

When updating, we need to be aware of a special case where when it's the first occurrence of the key, we need to add a new entry, and when it's not the first occurrence, we need to update the existing entry.

In such cases, we have some options as shown in the below example.

[UpdateMapTest](../book-code/corejava/v1ch09/pawarv/UpdateMapTest.java)


### 9.4.3 Map Views

A map view is a collection that is backed by a map. If you change the map, the collection changes, and vice versa.

The `keySet` method returns a Set view of the keys in the map. The `values` method returns a Collection view of the values in the map. The `entrySet` method returns a Set view of the entries in the map.

The `entrySet` method returns a Set view of the entries in the map. Each entry is a Map.Entry object. 

You can iterate through the entries in a map using a for-each loop.

If you remove a key from the key set, it will be removed from the map as well, as key set is a view of the map. Same with the entry set.


### 9.4.4 Weak Hash Maps

If the reference to a key is is no longer used, the value cannot be accessed, however, the Garbage Collector will not collect the key-value pair from the map. This is because the key is still referenced by the map.

If we want such key-value pairs to be removed from the map, we can use a WeakHashMap.

A weak hash map is a Map that uses weak references to store its keys. A weak reference is a reference that does not prevent the garbage collector from collecting the object to which it refers. If the garbage collector collects a key, the corresponding entry is removed from the map.


### 9.4.5 Linked Hash Sets and Maps
### 9.4.6 Enumeration Sets and Maps
### 9.4.7 Identity Hash Maps

## 9.5 Copies and Views
### 9.5.1 Small Collections

[SmallCollections](../book-code/corejava/v1ch09/pawarv/SmallCollections.java)

Since Java 9, you can use the static method  `of` method to create a small collection with a few elements.

```java
var friends = Set.of("Raphael", "Olivia", "Thibaut");
var friends = List.of("Raphael", "Olivia", "Thibaut");
var friends = Map.of("Raphael", 7, "Olivia", 5, "Thibaut", 10);
```

These methods are convenient, but they have some limitations. The objects produced are immutable. You cannot add or remove elements from the collection. You cannot change the elements. You cannot change the order of the elements.

Collections.nCopies method returns a list with n copies of the same object.

### 9.5.2 Unmodifiable Copies and Views

[UnmodifiableCopiesAndViews](../book-code/corejava/v1ch09/pawarv/UnmodifiableCopiesAndViews.java)

You can create copies or views of collections that cannot be modified. The main difference between a copy and a view is that a copy is a separate collection, whereas a view is a view of the original collection. Therefore, any changes to the original collection are reflected in the view but not in the copy.

Collections has several methods that return unmodifiable copies or views of collections. They all start with the word `unmodifiable`. 

For example, `unmodifiableList` returns an unmodifiable view of a list. `unmodifiableSet` returns an unmodifiable view of a set. `unmodifiableMap` returns an unmodifiable view of a map. `unmodifiableSortedSet` returns an unmodifiable view of a sorted set. `unmodifiableSortedMap` returns an unmodifiable view of a sorted map.

### 9.5.3 Subranges

[SubrangesTest](../book-code/corejava/v1ch09/pawarv/SubrangesTest.java)

The `subList` method returns a view of a portion of a list. The view is backed by the original list, so any changes to the original list are reflected in the view. The view is not a separate list. It is a view of the original list.

Subranges are useful for implementing algorithms that need to process only a portion of a list. For example, the `sort` method sorts a list in place. If you want to sort only a portion of a list, you can use a subrange view.

Sorted set views are also useful for implementing algorithms that need to process only a portion of a set. For example, the `subSet` method returns a view of a portion of a sorted set. The view is backed by the original set, so any changes to the original set are reflected in the view. The view is not a separate set. It is a view of the original set.

Sorted sets also have a `headSet` method that returns a view of the portion of the set that is less than a given element. The `tailSet` method returns a view of the portion of the set that is greater than or equal to a given element.

Sorted map views are also useful for implementing algorithms that need to process only a portion of a map. For example, the `subMap` method returns a view of a portion of a sorted map. The view is backed by the original map, so any changes to the original map are reflected in the view. The view is not a separate map. It is a view of the original map.

Similar to sorted sets, sorted maps also have a `headMap` method that returns a view of the portion of the map that is less than a given key. The `tailMap` method returns a view of the portion of the map that is greater than or equal to a given key.


### 9.5.4 Checked Views

[CheckedViewsTest](../book-code/corejava/v1ch09/pawarv/CheckedViewsTest.java)

Checked views are views of collections that check whether the elements that are added to the collection are of the correct type. If an element is not of the correct type, an exception is thrown.

Collections has several methods that return checked views of collections. They all start with the word `checked`.

The `checkedCollection` method returns a checked view of a collection. The `checkedList` method returns a checked view of a list. The `checkedSet` method returns a checked view of a set. The `checkedSortedSet` method returns a checked view of a sorted set. The `checkedMap` method returns a checked view of a map. The `checkedSortedMap` method returns a checked view of a sorted map.


### 9.5.5 Synchronized Views

Collections has several methods that return synchronized views of collections. They all start with the word `synchronized`. 

The `synchronizedCollection` method returns a synchronized view of a collection. The `synchronizedList` method returns a synchronized view of a list. The `synchronizedSet` method returns a synchronized view of a set. The `synchronizedSortedSet` method returns a synchronized view of a sorted set. The `synchronizedMap` method returns a synchronized view of a map. The `synchronizedSortedMap` method returns a synchronized view of a sorted map.

It is a way to make a collection thread-safe. You'll learn more about thread safety in Chapter 16.

### 9.5.6 A Note on Optional Operations

Generally it doesn't make sense to use an interface and have optional methods. However, you find that in the Collections library some operations are optional. This was mainly done to reduce the number of interfaces in the collections library, which has a lot of requirements including that it needs to be simple. 

This approach is not recommended in your own code.


## 9.6 Algorithms
### 9.6.1 Why Generic Algorithms?

Collections interfaces have generic methods for searching, sorting, and shuffling. These methods are implemented by the Collections class. The Collections class also has generic methods for copying, reversing, and filling collections.

The advantage of using generic algorithms is that you can use them with any collection. You don't have to write your own algorithms for searching, sorting, and shuffling for each collection type.

### 9.6.2 Sorting and Shuffling

[SortingAndShufflingTest](../book-code/corejava/v1ch09/pawarv/SortingAndShufflingTest.java)

[ShuffleTest](../book-code/corejava/v1ch09/shuffle/ShuffleTest.java)

The `sort` method sorts a list in place. The `shuffle` method shuffles a list in place.

These do basic sorting and shuffling. If you want to sort in a different way, you can use the sort method that takes a comparator which we have seen in the previous chapters.

### 9.6.3 Binary Search

[BinarySearchTest](../book-code/corejava/v1ch09/pawarv/BinarySearchTest.java)

Binary search is a fast way to search a sorted list that has a way to access the elements by index, that is a list that implements the `RandomAccess` interface.

Consider looking up a word in a dictionary. You can start at the beginning and look at each word until you find the word you are looking for. It can take as many as steps as there are words in the dictionary.

If you open the dictionary in half and determine if the word would be in the first half or the second half, you can ignore half of the book. You can repeat this process until you find the word. This way, you can find the word in fewer steps.

If a list has 1024 elements, it takes 10 steps to find the element using binary search, whereas it can take 1024 steps to confirm the list does not have the element using linear search.

To search a sorted list, use the `binarySearch` method. The `binarySearch` method returns the index of the search key, if it is contained in the list. Otherwise, it returns a negative number. 

You can subtract 1 from the absolute of the negative number to get the index where the searched item would be inserted. That is if you get the index -5, the item would be inserted at index 4.

With a linked list, you can't access the elements by index. So, you can't use binary search.

### 9.6.4 Simple Algorithms

[SimpleAlgorithmsTest](../book-code/corejava/v1ch09/pawarv/SimpleAlgorithmsTest.java)

### 9.6.5 Bulk Operations

[BulkOperationsTest](../book-code/corejava/v1ch09/pawarv/BulkOperationsTest.java)

### 9.6.6 Converting between Collections and Arrays

[CollectionToArrayTest](../book-code/corejava/v1ch09/pawarv/CollectionToArrayTest.java)

### 9.6.7 Writing Your Own Algorithms

When you write a method that processes a collection, you should always use the interface type for the parameter. This way, you can use your method with any collection.

Also use the most generic type that'll work, Iterable, for example, instead of List. This way, you can use your method with any collection that implements the Iterable interface.

## 9.7 Legacy Collections
### 9.7.1 The Hashtable Class
### 9.7.2 Enumerations
### 9.7.3 Property Maps
[PropertiesTest](../book-code/corejava/v1ch09/pawarv/PropertiesTest.java)

### 9.7.4 Stacks
### 9.7.5 Bit Sets

>[Home](HOME.md)
