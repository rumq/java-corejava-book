>[Common Home](../README.md)
 
# V1 Chapter 4 : Objects and Classes
 
## Status : IN_PROGRESS 
 
## Contents

In this chapter
• 4.1 Introduction to Object-Oriented Programming
• 4.2 Using Predefined Classes
• 4.3 Defining Your Own Classes
• 4.4 Static Fields and Methods
• 4.5 Method Parameters
• 4.6 Object Construction
• 4.7 Records
• 4.8 Packages
• 4.9 JAR Files
• 4.10 Documentation Comments
• 4.11 Class Design Hints

 
## Objects 

> The most common relationships between classes are
> * Dependence (“uses–a”)
> * Aggregation (“has–a”)
> * Inheritance (“is–a”)

![UMLNotationForClassRelationships](UMLNotationForClassRelationships.png)

> Constructors always have the same name as the class name. Thus, the constructor for the `Date` class is called `Date`.
 
Object variable is different to Object.

Two variables can point to the same object.

![Object Variables](../assets/diagrams/ObjectVariable.png)
 
 `Date` class refers to a particular point in time

 `LocalDate` class refers to a particular calendar notation. Instances of this are created using `static factory methods`.


> The library designers decided to separate the concerns of keeping time and attaching names to points in time. Therefore, the standard Java library contains two separate classes: the Date class, which represents a point in time, and the LocalDate class, which expresses days in the familiar calendar notation. Java 8 introduced quite a few other classes for manipulating various aspects of date and time—see Chapter 6 of Volume II.

> You do not use a constructor to construct objects of the `LocalDate` class. Instead, use static factory methods that call constructors on your behalf. 
> The expression `LocalDate.now()` constructs a new object that represents the date at which the object was constructed. 
> You can construct an object for a specific date by supplying year, month, and day:
`LocalDate.of(1999, 12, 31)`

Try `getYear(), getMonth(), getDayOfMonth()` on `LocalDate` object.

Try `plusDays()` on `LocalDate` object.


The `NullPointerException` is a runtime exception that is thrown when you try to use a variable that does not refer to an object. Show `NullPointerException` 


>[Common Home](../README.md)