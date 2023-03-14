>[Home](Home.md)

# Chapter 6: Interfaces, Lambda Expressions, and Inner Classes

## Status : DONE

- [Chapter 6: Interfaces, Lambda Expressions, and Inner Classes](#chapter-6-interfaces-lambda-expressions-and-inner-classes)
  - [Status : DONE](#status--done)
  - [Order of examples](#order-of-examples)
  - [6.1 Interfaces](#61-interfaces)
    - [6.1.1 The Interface Concept](#611-the-interface-concept)
    - [6.1.2 Properties of Interfaces](#612-properties-of-interfaces)
    - [6.1.3 Interfaces and Abstract Classes](#613-interfaces-and-abstract-classes)
    - [6.1.4 Static and Private Methods](#614-static-and-private-methods)
    - [6.1.5 Default Methods](#615-default-methods)
    - [6.1.6 Resolving Default Method Conflicts](#616-resolving-default-method-conflicts)
    - [6.1.7 Interfaces and Callbacks](#617-interfaces-and-callbacks)
    - [6.1.8 The Comparator Interface](#618-the-comparator-interface)
    - [6.1.9 Object Cloning](#619-object-cloning)
    - [6.2 Lambda Expressions](#62-lambda-expressions)
    - [6.2.1 Why Lambdas?](#621-why-lambdas)
    - [6.2.2 The Syntax of Lambda Expressions](#622-the-syntax-of-lambda-expressions)
    - [6.2.3 Functional Interfaces](#623-functional-interfaces)
    - [6.2.4 Method References](#624-method-references)
    - [6.2.5 Constructor References](#625-constructor-references)
    - [6.2.6 Variable Scope](#626-variable-scope)
    - [6.2.7 Processing Lambda Expressions](#627-processing-lambda-expressions)
    - [6.2.8 More about Comparators](#628-more-about-comparators)
    - [6.3 Inner Classes](#63-inner-classes)
    - [6.3.1 Use of an Inner Class to Access Object State](#631-use-of-an-inner-class-to-access-object-state)
    - [6.3.2 Special Syntax Rules for Inner Classes](#632-special-syntax-rules-for-inner-classes)
    - [6.3.3 Are Inner Classes Useful? Actually Necessary? Secure?](#633-are-inner-classes-useful-actually-necessary-secure)
    - [6.3.4 Local Inner Classes](#634-local-inner-classes)
    - [6.3.5 Accessing Variables from Outer Methods](#635-accessing-variables-from-outer-methods)
    - [6.3.6 Anonymous Inner Classes](#636-anonymous-inner-classes)
    - [6.3.7 Static Inner Classes](#637-static-inner-classes)
    - [6.4 Service Loaders](#64-service-loaders)
    - [6.5 Proxies](#65-proxies)
    - [6.5.1 When to Use Proxies](#651-when-to-use-proxies)
    - [6.5.2 Creating Proxy Objects](#652-creating-proxy-objects)
    - [6.5.3 Properties of Proxy Classes](#653-properties-of-proxy-classes)

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

Arrays.sort method takes a Comparator as a parameter. Comparator is a functional interface. So you can pass a lambda expression to sort an array.

Timer class takes an ActionListener as a parameter. ActionListener is a functional interface. So you can pass a lambda expression to the constructor.

See example in [LambdaTest](../book-code/corejava/v1ch06/pawarv/LambdaSyntaxTest.java)

The JAVA API has many functional interfaces. See [Functional Interfaces](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html)

The Predicate interface is a functional interface that takes an object and returns a boolean. It has a default method `and` that takes another Predicate and returns a new Predicate that is true if both Predicates are true.

See the examples in [PredicateTest](../book-code/corejava/v1ch06/pawarv/PredicateTest.java)
and [PredicateAndTest](../book-code/corejava/v1ch06/pawarv/PredicateAndTest.java)

The Supplier interface is a functional interface that takes no parameters and returns an object. 

>A Supplier has no arguments and yields a value of type T when it is called. Suppliers are used for lazy evaluation, (where the value is not computed until it is needed.)

See the examples in [SupplierTest](../book-code/corejava/v1ch06/pawarv/SupplierTest.java).

### 6.2.4 Method References

[MRStaticReferenceTest](../book-code/corejava/v1ch06/pawarv/MRStaticReferenceTest.java)

[MRStaticReferenceToInstanceMethodTest](../book-code/corejava/v1ch06/pawarv/MRStaticReferenceToInstanceMethodTest.java)

[MRObjectInstanceTest](../book-code/corejava/v1ch06/pawarv/MRObjectInstanceTest.java)

[MRStaticReferenceNoLambdaTest](../book-code/corejava/v1ch06/pawarv/MRStaticReferenceNoLambdaTest.java)

### 6.2.5 Constructor References

[ConstructorRefTest](../book-code/corejava/v1ch06/pawarv/ConstructorRefTest.java)

### 6.2.6 Variable Scope

A lambda expression can access local variables of the enclosing block that are final or effectively final.
These variables are called `captured variables` or `free variables`.

A block of code that contains free variables is called a `closure`, so a lambda expression is a closure.

[VariableScopeTest](../book-code/corejava/v1ch06/pawarv/VariableScopeTest.java)

### 6.2.7 Processing Lambda Expressions

> The point of using lambdas is deferred execution.
> 
> **Reasons for deferred execution:**
>  * Running the code in a separate thread
>  * Running the code multiple times
>  * Running the code at the right point in an algorithm (for example, the comparison operation in sorting)
>  * Running the code when something happens (a button was clicked, data has arrived, and so on)
>  * Running the code only when necessary

[ProcessingLambdasTest](../book-code/corejava/v1ch06/pawarv/ProcessingLambdasTest.java)

[ConsumerTest](../book-code/corejava/v1ch06/pawarv/ConsumerTest.java)

[BiConsumerTest](../book-code/corejava/v1ch06/pawarv/BiConsumerTest.java)

[MethodChaining](../book-code/corejava/v1ch06/pawarv/MethodChaining.java)

### 6.2.8 More about Comparators

[AdvancedComparatorsTest](../book-code/corejava/v1ch06/pawarv/AdvancedComparatorsTest.java)

### 6.3 Inner Classes

> Reasons
> * Inner classes can be hidden from other classes in the same package.
> * Inner class methods can access the data from the scope in which they are defined—including the data that would otherwise be private.

### 6.3.1 Use of an Inner Class to Access Object State

[InnerClassTest](../book-code/corejava/v1ch06/innerClass/InnerClassTest.java)

### 6.3.2 Special Syntax Rules for Inner Classes

See above example.

### 6.3.3 Are Inner Classes Useful? Actually Necessary? Secure?

Later

### 6.3.4 Local Inner Classes

[LocalInnerClassTest](../book-code/corejava/v1ch06/localInnerClass/LocalInnerClassTest.java)

### 6.3.5 Accessing Variables from Outer Methods

Later

### 6.3.6 Anonymous Inner Classes

[AnonymousInnerClassTest](../book-code/corejava/v1ch06/anonymousInnerClass/AnonymousInnerClassTest.java)

- Are used when you need to define a class that is used only once.
- Are local inner classes without a name.
- Cannot have a constructor, but can have an initializer block.
- Now a days, you can use lambda expressions instead of anonymous inner classes.


### 6.3.7 Static Inner Classes

Even called nested classes.

 > A static inner class is exactly like any other inner class, except that an object of a static inner class does not have a reference to the outer class object that generated it.

- Only one instance of a static inner class is ever created.
- Only inner classes can be static.

[StaticInnerClassTest](../book-code/corejava/v1ch06/staticInnerClass/StaticInnerClassTest.java)

### 6.4 Service Loaders

Later

### 6.5 Proxies

Later

### 6.5.1 When to Use Proxies

Later

### 6.5.2 Creating Proxy Objects

Later

### 6.5.3 Properties of Proxy Classes

Later

>[Home](HOME.md)