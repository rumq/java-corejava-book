> [Home](Home.md)

# Chapter 8: Generic Programming

Status : IN_PROGRESS

Generic programming is a style of programming in which algorithms are written in terms of types to-be-specified-later that are then instantiated when needed for specific types provided as parameters. This approach enables programmers to implement generic algorithms that work on collections of different types, can be customized, and are type safe and easier to read.

## 8.1 Why Generic Programming?

So we don't have to write the same code over and over again.
For example, we can write a generic method to sort an array of any type.

### 8.1.1 The Advantage of Type Parameters

Before Generics was introduced, we had to write a separate method for each type we wanted to sort.

Collections are a good example of where generics are useful. The Collection interface is parameterized with the type of the elements it contains. This allows us to write a single implementation of the Collection interface that can be used to store any type of object.

Before Generics, ArrayList would work with any type of object, but it would not be type safe. For example, if we wanted to store a list of Strings, we could add an Integer to the list. This would not be detected until runtime, when we would get a ClassCastException. With Generics, we can specify the type of the elements in the list, and the compiler will check that we only add elements of the correct type to the list.

Another advantage of generics is that they make the code easier to read. For example, the following code is much easier to read than the equivalent code that uses raw types.

```java
List<String> strings = new ArrayList<>();
strings.add("tweet");
String s = strings.get(0); // No cast
```

vs

```java
List strings = new ArrayList();
strings.add("tweet");
String s = (String) strings.get(0);
```

### 8.1.2 Who Wants to Be a Generic Programmer?

Three levels

- Basic level: use generic classes and methods
- Application level: to refactor existing code to use generics
- JDK developer level: to write new generic classes and methods

### 8.2 Defining a Simple Generic Class

See

- [PairTest1](../book-code/corejava/v1ch08/pair1/PairTest1.java)

Generic class acts like a template for a family of classes. The type parameter is a placeholder for a real type, which is specified when the class is instantiated.

```java

public class Pair<T> {
    private T first;
    private T second;

    public Pair() { first = null; second = null; }
    public Pair(T first, T second) { this.first = first; this.second = second; }

    public T getFirst() { return first; }
    public T getSecond() { return second; }

    public void setFirst(T newValue) { first = newValue; }
    public void setSecond(T newValue) { second = newValue; }
}
```

> It is common practice to use uppercase letters for type variables, and to keep them short. The Java library uses the variable E for the element type of a collection, K and V for key and value types of a table, and T (and the neighboring letters U and S, if necessary) for“any type at all."

## 8.3 Generic Methods

It is possible to define generic methods. A generic method is a method that declares one or more type parameters between the modifiers and the return type.

```java
public static <T> boolean hasNulls(Pair<T> p) {
    return p.getFirst() == null || p.getSecond() == null;
}
```

8.4 Bounds for Type Variables

8.5 Generic Code and the Virtual Machine

8.5.1 Type Erasure

8.5.2 Translating Generic Expressions

8.5.3 Translating Generic Methods

8.5.4 Calling Legacy Code

8.6 Restrictions and Limitations

8.6.1 Type Parameters Cannot Be Instantiated with Primitive

8.6.2 Runtime Type Inquiry Only Works with Raw Types

8.6.3 You Cannot Create Arrays of Parameterized Types

8.6.4 Varargs Warnings

8.6.5 You Cannot Instantiate Type Variables

8.6.6 You Cannot Construct a Generic Array

8.6.7 Type Variables Are Not Valid in Static Contexts of Generic Classes

8.6.8 You Cannot Throw or Catch Instances of a Generic Class

8.6.9 You Can Defeat Checked Exception Checking

8.6.10 Beware of Clashes after Erasure

8.7 Inheritance Rules for Generic Types

8.8 Wildcard Types

8.8.1 The Wildcard Concept

8.8.2 Supertype Bounds for Wildcards

8.8.3 Unbounded Wildcards

8.8.4 Wildcard Capture

8.9 Reflection and Generics

8.9.1 The Generic Class Class

8.9.2 Using Class<T> Parameters for Type Matching

8.9.3 Generic Type Information in the Virtual Machine

8.9.4 Type Literals

> [Home](HOME.md)
