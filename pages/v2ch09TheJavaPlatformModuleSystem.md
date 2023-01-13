>[Common Home](../README.md)
 
# The Java Platform Module System
 
## Status : IN_PROGRESS 
 
## Links
 
[Oreilly book Core Java II Edition 12 Chapter 9 link](https://learning.oreilly.com/library/view/core-java-vol/9780137870899/ch09.xhtml)


## Book highlights (form Oreilly)

[Book highlights](https://github.com/vikrampawar/book-highlights/blob/main/pages/core-java--volume-ii--advanced-features.md)

>A module can make classes and packages selectively available so that its evolution can be controlled. (link) 

>Automatic modules can read the unnamed module, so their dependencies can go onto the class path. (link)

>Any class that is not on the module path is part of an unnamed module. Technically, there may be more than one unnamed module, but all of them together act as if they are a single module which is called the unnamed module. As with automatic modules, the unnamed module can access all other modules, and all of its packages are exported and opened. (link)

>Recall from Chapter 5 of Volume I that JAR files can contain, in addition to class files and a manifest, file resources which can be loaded with the method Class.getResourceAsStream, and now also with Module.getResourceAsStream (link)

>Open modules combine the compile-time safety of the module system with the classic permissive runtime behavior. (link)

>Using the opens keyword, a module can open a package, which enables reflective access to all instances of classes in the given package. (link)

>If you want to load a module into JShell, include the JAR on the module path and use the --add-modules option: (link)

>Instead, a module can be deployed by placing all its classes in a JAR file, with a module-info.class in the root. Such a JAR file is called a modular JAR. (link)

>Module names are only used in module declarations (link)

## Introduction

Introduced in Java 9.

>A module can make classes and packages selectively available so that its evolution can be controlled. (link) 

## 9.1 The Module Concept

The new system is called the Java Platform Module System.
It was used  to modularize the Java Platform, Standard Edition, starting with Java 9.

>A Java platform module consists of
> * A collection of packages
> * Optionally, resource files and other files such as native libraries
> * A list of the accessible packages in the module
> * A list of all modules on which this module depends 

## 9.2 Naming modules

The module name is a string that is used to identify the module.
It can be the same as the package name, but it does not have to be.

> Also, just as with path names, there is no hierarchical relationship between modules.
> If you had a module com.horstmann and another module com.horstmann.corejava, they would be unrelated, as far as the module system is concerned.

>The easiest approach is to name a module after the top-level package that the module provides. For example, the SLF4J logging façade has a module `org.slf4j `with packages `org.slf4j`, `org.slf4j.spi`, `org.slf4j.event`, and `org.slf4j.helpers`.


>Module names are only used in module declarations. In the source files for your Java classes, you never refer to module names; instead, use package names the way they have always been used.

>[Common Home](../README.md)