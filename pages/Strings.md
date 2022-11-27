>[Common Home](../README.md)
 
# Strings
 
## Source 
Chapter 3.6

## String Literals

String literals are enclosed in double quotes. They are immutable.

```java
String greeting = "Hello World";
```


## Substring
String is not a predefined type. It is a class. It is a sequence of characters.

String is immutable. It cannot be changed.

substring method returns a new string that is a substring of this string.

`substring(int beginIndex, int endIndex)`

`beginIndex` is the beginning index, inclusive.

`endIndex` is the ending index, exclusive.

```java
String name = "PawarV";
String subName = name.substring(0, 3);
System.out.println(subName);

```

>There is one advantage to the way substring works: Computing the length of the substring is easy. The string s.substring(a, b) always has length b – a. For example, the substring "Hel" has length 3 – 0 = 3.

## Concatenation

The + operator can be used to concatenate strings.

```java

String firstName = "Pawar";
String lastName = "V";
String fullName = firstName + " " + lastName;
System.out.println(fullName);

```

Converts the other operand to a string and concatenates it to the string on the left.

```java
String s = "Hello, World!";
s = s + 2020;
System.out.println(s);

```

### join method

The join method is a static method of the String class.

```java
String s = String.join("/", "S", "M", "L", "XL");
System.out.println(s);

```
### repeat method

The repeat method is a static method of the String class.

```java
String s = "Hello".repeat(3);
System.out.println(s);

```
## String are immutable

String objects are immutable. That means that once a string is created, it cannot be changed.

```java
String greeting = "Hello";
greeting = "J" + greeting.substring(1);
System.out.println(greeting);

```

## An exercise in string manipulation

```java
String s = "Hello, World!";
int n = s.length();
System.out.println(n);

```
## String comparison

The equals method compares two strings to see if they contain the same characters.

```java
String s1 = "Hello";
String s2 = "Hello";
System.out.println(s1.equals(s2));

```

The compareTo method compares two strings lexicographically.

```java
String s1 = "Hello";
String s2 = "Hello";
System.out.println(s1.compareTo(s2));

```

The compareToIgnoreCase method compares two strings lexicographically, ignoring case differences.

```java
String s1 = "Hello";
String s2 = "hello";
System.out.println(s1.compareToIgnoreCase(s2));

```

The `==` operator compares the references of two strings.

```java
String firstName = "Deepika";
String surname = "Padukone";
String fullName = firstName + " " + surname;
System.out.println(fullName == "Deepika Padukone");
System.out.println(fullName.equals("Deepika Padukone"));
System.out.println(fullName.compareTo("Deepika Padukone"));
System.out.println(firstName == "Deepika");

```

## String formatting

The printf method of the PrintStream class can be used to format strings.

```java
String name = "Pawar";
int age = 30;
System.out.printf("Hello, %s. Next year, you'll be %d.\n", name, age);

```

## Empty strings & Null strings

An empty string is a string that contains no characters.

```java
String s = "";
System.out.println(s.length());

```

A null string is a string that has no value.

```java
String s = null;
System.out.println(s.length());

```

## String builder

The StringBuilder class is used to create a mutable sequence of characters.

```java
StringBuilder builder = new StringBuilder();
builder.append("Hello");
builder.append(" ");
builder.append("World");
String message = builder.toString();
System.out.println(message);

```


## String builder

The StringBuilder class is used to create a mutable sequence of characters.

```java
StringBuilder builder = new StringBuilder();
builder.append("Hello");
builder.append(" ");
builder.append("World");
builder.append("!");
String message = builder.toString();
System.out.println(message);

```


>[Common Home](../README.md)