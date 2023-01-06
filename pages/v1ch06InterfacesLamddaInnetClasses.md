>[Home](Home.md)
 
# Chapter 6: Interfaces, Lambda Expressions, and Inner Classes
 
## Status : IN_PROGRESS 
 
## Contents
 
- 6.1 Interfaces
  - 6.1.1 The Interface Concept
  - 6.1.2 Properties of Interfaces
  - 6.1.3 Interfaces and Abstract Classes
  - 6.1.4 Static and Private Methods
  - 6.1.5 Default Methods
  - 6.1.6 Resolving Default Method Conflicts
  - 6.1.7 Interfaces and Callbacks
  - 6.1.8 The Comparator Interface
  - 6.1.9 Object Cloning
- 6.2 Lambda Expressions
  - 6.2.1 Why Lambdas?
  - 6.2.2 The Syntax of Lambda Expressions
  - 6.2.3 Functional Interfaces
  - 6.2.4 Method References
  - 6.2.5 Constructor References
  - 6.2.6 Variable Scope
  - 6.2.7 Processing Lambda Expressions
  - 6.2.8 More about Comparators
- 6.3 Inner Classes
  - 6.3.1 Use of an Inner Class to Access Object State
  - 6.3.2 Special Syntax Rules for Inner Classes
  - 6.3.3 Are Inner Classes Useful? Actually Necessary? Secure?
  - 6.3.4 Local Inner Classes
  - 6.3.5 Accessing Variables from Outer Methods
  - 6.3.6 Anonymous Inner Classes
  - 6.3.7 Static Inner Classes
- 6.4 Service Loaders
- 6.5 Proxies
  - 6.5.1 When to Use Proxies
  - 6.5.2 Creating Proxy Objects
  - 6.5.3 Properties of Proxy Classes
 
## Order of examples

- [EmployeeSortTest](../book-code/corejava/v1ch06/interfaces/EmployeeSortTest.java)
- [TimerTest](../book-code/corejava/v1ch06/timer/TimerTest.java)
- [CloneTest](../book-code/corejava/v1ch06/clone/CloneTest.java)
- [LambdaTest](../book-code/corejava/v1ch06/lambda/LambdaTest.java)
- [InnerClassTest](../book-code/corejava/v1ch06/innerClass/InnerClassTest.java)
- [AnonymousInnerClassTest](../book-code/corejava/v1ch06/anonymousInnerClass/AnonymousInnerClassTest.java)
- [StaticInnerClassTest](../book-code/corejava/v1ch06/staticInnerClass/StaticInnerClassTest.java)
- [ProxyTest](../book-code/corejava/v1ch06/proxy/ProxyTest.java)


## 6.1 Interfaces

### 6.1.1 The Interface Concept
> In the Java programming language, an interface is not a class but a set of requirements for the classes that want to conform to the interface.

> All methods of an interface are automatically public. For that reason, it is not necessary to supply the keyword public when declaring a method in an interface.

> Just as methods in an interface are automatically public, fields are always public static final.

> Interfaces never have instance fields.

> To declare that a class implements an interface, use the implements keyword:
> `class Employee implements Comparable`

Example of using `Comparable` interface [EmployeeSortTest](../book-code/corejava/v1ch06/interfaces/EmployeeSortTest.java)

Example of using `Clonable` interface [CloneTest](../book-code/corejava/v1ch06/clone/CloneTest.java)

### 6.1.2 Properties of Interfaces

- Can't be instantiated
- Can be used as a type
- `instanceof` operator can be used to test if an object implements an interface
- You can extend interfaces
- A class can implement multiple interfaces
- Records and Enums can implement interfaces
- Can have constants see [InterfaceTest](../book-code/corejava/v1ch06/pawarv/InterfacesTest.java)


### 6.1.3 Interfaces and Abstract Classes

To use abstract class, you must extend it, and a class can extend only one abstract class, but a class can implement multiple interfaces.

### 6.1.4 Static and Private Methods

Interfaces can have static and private methods. Static methods are not inherited by classes that implement the interface. Private methods are not visible to classes that implement the interface.

See Path interface. It has a static method `of`.

See [InterfacesTest](../book-code/corejava/v1ch06/pawarv/InterfacesTest.java)

### 6.1.5 Default Methods

> You can supply a default implementation for any interface method. You must tag such a method with the default modifier.

Example in `Iterator` interface. It has a default methods `remove` and  `forEachRemaining`.

> An important use for default methods is interface evolution.

>  Adding a nondefault method to an interface is not source-compatible but is binary-compatible.

If a new method is added to an interface, all classes that implement the interface must be updated to provide an implementation for the new method, otherwise they will not compile. If they are not updated, the old jars can be used without any recompilation, but the new method will not be available.

If the new method is a default method, then the class does not have to be updated. If the old jars are used, the new method will be available, but it will use the default implementation.

See [InterfacesTest](../book-code/corejava/v1ch06/pawarv/InterfacesTest.java)

### 6.1.6 Resolving Default Method Conflicts

> What happens if the exact same method is defined as a default method in one interface and then again as a method of a superclass or another interface?
>
> 1. Superclasses win. If a superclass provides a concrete method, default methods with the same name and parameter types are simply ignored.
> 2. Interfaces clash. If an interface provides a default method, and another interface contains a method with the same name and parameter types (default or not), then you must resolve the conflict by overriding that method.

### 6.1.7 Interfaces and Callbacks

>A common pattern in programming is the callback pattern. In this pattern, you specify the action that should occur whenever a particular event happens. For example, you may want a particular action to occur when a button is clicked or a menu item is selected.

### 6.1.8 The Comparator Interface

The Comparator interface is a generic interface that defines a single method, `int compare(T first, T second)`, that compares its two arguments for order. The method returns a negative integer if the first argument is less than the second, zero if they are equal, and a positive integer if the first argument is greater than the second.

The Comparator interface is a functional interface, so you can use a lambda expression to specify a comparator.

Example of using `Comparator` interface [EmployeeSortTest](../book-code/corejava/v1ch06/interfaces/EmployeeSortTest.java)

### 6.1.9 Object Cloning

[Clone Test](../book-code/corejava/v1ch06/clone/CloneTest.java)

### 6.2 Lambda Expressions

Looks at the [TimerTest](../book-code/corejava/v1ch06/timer/TimerTest.java) and [ComparatorTest](../book-code/corejava/v1ch06/pawarv/ComparatorTest.java) examples to see how blocks of code were passed around. Doing this was quite verbose. Lambda expressions are a way to pass around blocks of code in a more concise way.

### 6.2.1 Why Lambdas?

>A lambda expression is a block of code that you can pass around so it can be executed later, once or multiple times.

The key point is that you can pass around code without executing it.

### 6.2.2 The Syntax of Lambda Expressions

Lambda (λ) was used by Alonzo Church to represent functions in his lambda calculus. Lambda expressions are a way to represent functions in Java.

Syntax is `parameters -> body`

The parameter types are optional. If there is only one parameter, the parentheses are optional. If the body is a single expression, the braces and return statement are optional.

> You never specify the result type of a lambda expression. It is always inferred from context. 

See example in [LambdaTest](../book-code/corejava/v1ch06/pawarv/LambdaSyntaxTest.java)

### 6.2.3 Functional Interfaces

>You can supply a lambda expression whenever an object of an interface with a single abstract method is expected. Such an interface is called a functional interface.

> In fact, conversion to a functional interface is the only thing that you can do with a lambda expression in Java.

### 6.2.4 Method References
### 6.2.5 Constructor References
### 6.2.6 Variable Scope
### 6.2.7 Processing Lambda Expressions
### 6.2.8 More about Comparators
### 6.3 Inner Classes
### 6.3.1 Use of an Inner Class to Access Object State
### 6.3.2 Special Syntax Rules for Inner Classes
### 6.3.3 Are Inner Classes Useful? Actually Necessary? Secure?
### 6.3.4 Local Inner Classes
### 6.3.5 Accessing Variables from Outer Methods
### 6.3.6 Anonymous Inner Classes
### 6.3.7 Static Inner Classes
### 6.4 Service Loaders
### 6.5 Proxies
### 6.5.1 When to Use Proxies
### 6.5.2 Creating Proxy Objects
### 6.5.3 Properties of Proxy Classes

 
>[Home](HOME.md)