>[Common Home](../README.md)
 
# V1 Chapter 5 Inheritance
 
## Status : IN_PROGRESS 
 

## Contents


In this chapter
* 5.1 Classes, Superclasses, and Subclasses
* 5.2 Object: The Cosmic Superclass
* 5.3 Generic Array Lists
* 5.4 Object Wrappers and Autoboxing
* 5.5 Methods with a Variable Number of Parameters
* 5.6 Abstract Classes
* 5.7 Enumeration Classes
* 5.8 Sealed Classes
* 5.9 Reflection
* 5.10 Design Hints for Inheritance
 
## Inheritance & Polymorphism

>A simple rule can help you decide whether or not inheritance is the right design for your data. 
>The “is–a” rule states that every object of the subclass is an object of the superclass.

> Another way of formulating the “is–a” rule is the *substitution principle*. 
> That principle states that you can use a subclass object whenever the program expects a superclass object.

> In the Java programming language, object variables are polymorphic. A variable of type Employee can refer to an object of type Employee or to an object of any subclass of the Employee class (such as Manager, Executive, Secretary, and so on).

Cannot call the method that is not defined in the declared type of the object.

You can assign a subclass object to a superclass variable, but you cannot assign a superclass object to a subclass variable. That is a four legged animal is an animal, but an animal is not necessarily a four legged animal. All polygons are shapes, but not all shapes are polygons.


> In the Java programming language, object variables are polymorphic. A variable of type Employee can refer to an object of type Employee or to an object of any subclass of the Employee class (such as Manager, Executive, Secretary, and so on).

Final classes cannot be subclassed. Final methods cannot be overridden. Final variables cannot be changed.

> You can cast only within an inheritance hierarchy.
> Use instanceof to check before casting from a superclass to a subclass.
 
>In Java, only the values of primitive types (numbers, characters, and boolean values) are not objects.
>[Common Home](../README.md)