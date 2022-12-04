>[Common Home](../README.md)
 
# Chapter 9 Collections 
 
## Status : IN_PROGRESS
 
## Separating Interface from Implementation

> As is common with modern data structure libraries, the Java collection library separates interfaces and implementations.


## The Collection Interface


> The fundamental interface for collection classes in the Java library is the Collection interface. The interface has two fundamental methods:

```java
public interface Collection<E>
{
   boolean add(E element);  //returns true if the collection changed
   Iterator<E> iterator();  // returns an iterator for the collection
   . . . (other methods omitted)
}

```

## Iterators



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

>The remove method of the Iterator interface removes the element that was returned by the last call to next.
 




 

 
>[Common Home](../README.md)