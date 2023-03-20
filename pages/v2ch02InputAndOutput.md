> [Home](Home.md)

# Volume 2 Chapter 2: Input and Output

- [Volume 2 Chapter 2: Input and Output](#volume-2-chapter-2-input-and-output)
  - [2.1 Input/Output Streams](#21-inputoutput-streams)
    - [Introduction](#introduction)
    - [2.1.1 Reading and Writing Bytes](#211-reading-and-writing-bytes)
    - [2.1.2 The Complete Stream Zoo](#212-the-complete-stream-zoo)
    - [2.1.3 Combining Input/Output Stream Filters](#213-combining-inputoutput-stream-filters)
    - [2.1.4 Text Input and Output](#214-text-input-and-output)
    - [2.1.5 How to Write Text Output](#215-how-to-write-text-output)
    - [2.1.6 How to Read Text Input](#216-how-to-read-text-input)
    - [2.1.7 Saving Objects in Text Format](#217-saving-objects-in-text-format)
    - [2.1.8 Character Encodings](#218-character-encodings)
  - [2.2 Reading and Writing Binary Data](#22-reading-and-writing-binary-data)
    - [2.2.1 The DataInput and DataOutput Interfaces](#221-the-datainput-and-dataoutput-interfaces)
    - [2.2.2 Random-Access Files](#222-random-access-files)
    - [2.2.3 ZIP Archives](#223-zip-archives)
  - [2.3 Object Input/Output Streams and Serialization](#23-object-inputoutput-streams-and-serialization)
    - [2.3.1 Saving and Loading Serializable Objects (later)](#231-saving-and-loading-serializable-objects-later)
    - [2.3.2 Understanding the Object Serialization File Format (later)](#232-understanding-the-object-serialization-file-format-later)
    - [2.3.3 Modifying the Default Serialization Mechanism (later)](#233-modifying-the-default-serialization-mechanism-later)
    - [2.3.4 The readResolve and writeReplace Methods (later)](#234-the-readresolve-and-writereplace-methods-later)
    - [2.3.5 Versioning (later)](#235-versioning-later)
    - [2.3.6 Using Serialization for Cloning (later)](#236-using-serialization-for-cloning-later)
    - [2.3.7 Deserialization and Security (later)](#237-deserialization-and-security-later)
  - [2.4 Working with Files](#24-working-with-files)
    - [2.4.1 Paths](#241-paths)
    - [2.4.2 Reading and Writing Files](#242-reading-and-writing-files)
    - [2.4.3 Creating Files and Directories](#243-creating-files-and-directories)
    - [2.4.4 Copying, Moving, and Deleting Files](#244-copying-moving-and-deleting-files)
    - [2.4.5 Getting File Information](#245-getting-file-information)
    - [2.4.6 Visiting Directory Entries](#246-visiting-directory-entries)
    - [2.4.7 Using Directory Streams](#247-using-directory-streams)
    - [2.4.8 ZIP File Systems](#248-zip-file-systems)
  - [2.7 Regular Expressions](#27-regular-expressions)
    - [2.7.1 The Regular Expression Syntax](#271-the-regular-expression-syntax)
    - [2.7.2 Matching an Entire String](#272-matching-an-entire-string)
    - [2.7.3 Finding All Matches in a String](#273-finding-all-matches-in-a-string)
    - [2.7.4 Groups](#274-groups)
    - [2.7.5 Splitting along Delimiters](#275-splitting-along-delimiters)
    - [2.7.6 Replacing Matches](#276-replacing-matches)
    - [2.7.7 Flags](#277-flags)

Status : IN_PROGRESS

We'll look into

- Read and write data to files
- Access files and directories
- Read binary and text formatted files
- Object serialization
- Regular expressions

## 2.1 Input/Output Streams

### Introduction

In Java I/O, a stream is a sequence of bytes. Note that these streams are not the same as the Streams that are in the package java.util.stream which are used for functional programming. Unfortunately, the Java API uses the same name for both.

Input streams read data from a source, and output streams write data to a destination.

To read and write text data (Unicode), we can use the `Reader` and `Writer` classes. These classes are abstract classes that define the basic input and output operations.

The source and destination can be a file, an array, a device, or a network connection. The Java I/O API defines a large number of stream classes, and it is easy to get lost in the jungle of classes. The following table lists the most important stream classes.


### 2.1.1 Reading and Writing Bytes

- [InputStreamAndOutputStreamTest](../book-code/corejava/v2ch02/pawarv/InputStreamAndOutputStreamTest.java)

The InputStream and OutputStream classes are abstract classes that define the basic input and output operations. 

The InputStream class defines the following methods:

| Method             | Description                                                                     |
| ------------------ | ------------------------------------------------------------------------------- |
| int read()         | Reads a single byte. Returns -1 if the end of the stream has been reached.      |
| int read(byte[] b) | Reads a sequence of bytes into an array. Returns the number of bytes read or -1 |
| void close()       | Closes the stream.                                                              |

The OutputStream class defines the following methods:

| Method               | Description                               |
| -------------------- | ----------------------------------------- |
| void write(int b)    | Writes a single byte.                     |
| void write(byte[] b) | Writes a sequence of bytes from an array. |
| void close()         | Closes the stream.                        |

### 2.1.2 The Complete Stream Zoo

Bytes class hierarchy is different from character class hierarchy.

**Input and output stream hierarchy**
![](2023-03-15-09-36-13.png)

**Character stream hierarchy**
![](2023-03-15-09-37-01.png)

**Input and Ouput classes**

| Class                 | Description                                                                 |
| --------------------- | --------------------------------------------------------------------------- |
| InputStream           | Abstract superclass for all input streams                                   |
| OutputStream          | Abstract superclass for all output streams                                  |
| Reader                | Abstract superclass for all character-based input streams                   |
| Writer                | Abstract superclass for all character-based output streams                  |
| FileInputStream       | Reads raw bytes from a file                                                 |
| FileOutputStream      | Writes raw bytes to a file                                                  |
| FileReader            | Reads characters from a file                                                |
| FileWriter            | Writes characters to a file                                                 |
| ByteArrayInputStream  | Reads raw bytes from an array                                               |
| ByteArrayOutputStream | Writes raw bytes to an array                                                |
| CharArrayReader       | Reads characters from an array                                              |
| CharArrayWriter       | Writes characters to an array                                               |
| StringReader          | Reads characters from a string                                              |
| StringWriter          | Writes characters to a string                                               |
| PipedInputStream      | Reads raw bytes from a pipe                                                 |
| PipedOutputStream     | Writes raw bytes to a pipe                                                  |
| PipedReader           | Reads characters from a pipe                                                |
| PipedWriter           | Writes characters to a pipe                                                 |
| ObjectInputStream     | Reads objects from a stream                                                 |
| ObjectOutputStream    | Writes objects to a stream                                                  |
| DataInputStream       | Reads primitive data types from a stream                                    |
| DataOutputStream      | Writes primitive data types to a stream                                     |
| BufferedInputStream   | Adds buffering to an input stream                                           |
| BufferedOutputStream  | Adds buffering to an output stream                                          |
| BufferedReader        | Adds buffering and line-oriented reading to a character-based input stream  |
| BufferedWriter        | Adds buffering and line-oriented writing to a character-based output stream |
| PrintStream           | Writes formatted data to an output stream                                   |
| PrintWriter           | Writes formatted data to a character-based output stream                    |

### 2.1.3 Combining Input/Output Stream Filters


See
- [CombiningFiltersTest](../book-code/corejava/v2ch02/pawarv/CombiningFiltersTest.java)

The subclasses of FilterInputStream and FilterOutputStream are called stream filters. They are used to modify the behaviour of the underlying stream.

This is done by chaining the filters together.

For example, the BufferedInputStream class adds buffering to an input stream. The DataInputStream class adds methods for reading Java primitive types. These classes which are subclasses of FilterInputStream can be chained together to add both buffering and data reading to an input stream.

The following diagram shows the class hierarchy of the input stream classes.

```mermaid

classDiagram
    InputStream <|-- FileInputStream
    InputStream <|-- FilterInputStream
    FilterInputStream <|-- BufferedInputStream
    FilterInputStream <|-- DataInputStream
    FilterInputStream <|-- ObjectInputStream
    FilterInputStream <|-- ZipInputStream

```

You can add those capabilities to an existing stream by wrapping it in a filter stream. For example, the following code adds buffering to a FileInputStream.

```java

var stream = new BufferedInputStream(
                new FileInputStream("myfile.txt"));

```

This following code adds buffering and data reading to a FileInputStream.

```java

var stream = new DataInputStream (
                new BufferedInputStream(
                    new FileInputStream("myfile.txt")));

```

This following code combines Zip and File input streams.

```java

var stream = new ZipInputStream (
                new FileInputStream("myfile.zip"));

```

The following combines DataInputStream, ZipInputStream, and FileInputStream.

```java

var stream = new DataInputStream (
                new ZipInputStream (
                    new FileInputStream("myfile.zip")));

```

The following diagram shows a sequence diagram of how the `read` method is called on the DataInputStream.

```mermaid

sequenceDiagram
    participant Client
    participant DataInputStream
    participant ZipInputStream
    participant FileInputStream

    Client->>DataInputStream: read()
    DataInputStream->>ZipInputStream: read()
    ZipInputStream->>FileInputStream: read()
    FileInputStream-->>ZipInputStream: read()
    ZipInputStream-->>DataInputStream: read()
    DataInputStream-->>Client: read()

```

### 2.1.4 Text Input and Output

See
- [ReaderAndWriterTest](../book-code/corejava/v2ch02/pawarv/ReaderAndWriterTest.java)

When saving data, there are two options: save the data in binary format or save the data in text format. Binary format is more compact, but it is not human-readable.

The `InputStreamReader` class converts bytes to characters. The `OutputStreamWriter` class converts characters to bytes. This is a bridge between byte streams and character streams. When saving text data, we have to consider the character encoding.

Both of these take Charset as an argument. By default, the Charset is UTF-8. However you can specify other character sets. Java internally uses UTF-16 for character encoding. Therefore, when you cast a character to an integer, you get the UTF-16 code point.

### 2.1.5 How to Write Text Output

- [PrintWriterTest](../book-code/corejava/v2ch02/pawarv/PrintWriterTest.java)
- [PrintWriterFlushTest](../book-code/corejava/v2ch02/pawarv/PrintWriterFlushTest.java)
 
We can use PrintWriter to write text. The PrintWriter class is a character-based output stream that adds buffering and formatting capabilities to an output stream. The PrintWriter class defines the following methods:

| Method                                     | Description                           |
| ------------------------------------------ | ------------------------------------- |
| void print(String s)                       | Writes a string.                      |
| void println(String s)                     | Writes a string and a line separator. |
| void printf(String format, Object... args) | Writes a formatted string.            |

We can use `PrintWriter` as below. The `out` object has the same methods as `System.out`.

```java
    PrintWriter out = new PrintWriter("myfile.txt", "UTF-8");
    out.println("Hello, World!");
```

We do not have to buffer the output. The `PrintWriter` class does it for us.
By default `autoflush` is disabled for `PrintWriter`. We can enable it by passing `true` as the second argument to the constructor.

### 2.1.6 How to Read Text Input

See
- [BufferedReaderTest](../book-code/corejava/v2ch02/pawarv/BufferedReaderTest.java)
- [FilesReadingAndWritingTest](../book-code/corejava/v2ch02/pawarv/FilesReadingAndWritingTest.java)
- [ScannerTest](../book-code/corejava/v2ch02/pawarv/ScannerTest.java)

In the early versions of Java, the BufferedReader class was the standard way to read text from a file. 

We can use the methods on `Files` to read text from a file. See

But it's better to use `Scanner` as it has more options to read text, like reading a line, reading an integer, reading a double, etc.

The Scanner class is a character-based input stream that adds buffering and tokenization capabilities to an input stream. The Scanner class defines the following methods:

| Method                | Description                             |
| --------------------- | --------------------------------------- |
| boolean hasNext()     | Returns true if there is another token. |
| String next()         | Returns the next token.                 |
| String nextLine()     | Returns the next line.                  |
| int nextInt()         | Returns the next integer.               |
| double nextDouble()   | Returns the next double.                |
| boolean nextBoolean() | Returns the next boolean.               |

### 2.1.7 Saving Objects in Text Format

See book example [TextFileTest](../book-code/corejava/v2ch02/textFile/TextFileTest.java)

### 2.1.8 Character Encodings

Character encodings are used to convert between characters and bytes. They are a way to represent characters in a computer using a fixed number of bits. For example, the ASCII character encoding uses 7 bits to represent each character. The Unicode character encoding uses 16 bits to represent each character. The UTF-8 character encoding uses 8 bits to represent each character. The UTF-16 character encoding uses 16 bits to represent each character.

The Java platform uses UTF-16 as the default character encoding. However, UTF-8 is more compact and is used more often.

See
- [UTF16AndUTF8DifferenceTest](../book-code/corejava/v2ch02/pawarv/UTF16AndUTF8DifferenceTest.java)

See also the examples from previous sections.
- [InputStreamAndOutputStreamTest](../book-code/corejava/v2ch02/pawarv/InputStreamAndOutputStreamTest.java)]
- [ReaderAndWriterTest](../book-code/corejava/v2ch02/pawarv/ReaderAndWriterTest.java)


**Character to byte conversion table**

This ascii table shows the byte values of the characters.

This is a table of the some characters from the first 128 characters in the Unicode character set. The first 32 characters are control characters that are not printable. The next 96 characters are printable ASCII characters. The last 32 characters are control characters that are not printable.

| Character | Decimal | Hexadecimal | 
| --------- | ------- | ----------- | 
| NUL       | 0       | 0x00        | 
| space     | 32      | 0x20        | 
| LF        | 10      | 0x0A        | 
| CR        | 13      | 0x0D        | 
| A         | 56      | 0x41        | 
| a         | 97      | 0x61        | 
| #         | 35      | 0x23        | 
| $         | 36      | 0x24        | 
| 1         | 49      | 0x31        | 

This is a table of Unicode characters that are not in the first 128 characters.

| Character | Decimal | Hexadecimal | 
| --------- | ------- | ----------- | 
| €         | 8364    | 0x20AC      | 
| £         | 163     | 0x00A3      | 
| ¥         | 165     | 0x00A5      | 
| ₹         | 8377    | 0x20B9      | 
| ₩         | 8361    | 0x20A9      | 

**Unicode, UTF-8 and UTF-16 Table**

This is a table of Unicode characters.
Unicode is a code point, which is a number that identifies a character.
UTF-8 is a variable-length encoding of Unicode characters.
UTF-16 is a fixed-length encoding of Unicode characters.
UTF-8 decimal is the decimal representation of the UTF-8 bytes.
UTF-16 decimal is the decimal representation of the UTF-16 bytes.

| Character | Unicode | UTF-8          | UTF-16 | UTF-8 decimal | UTF-16 decimal |
| --------- | ------- | -------------- | ------ | ------------- | -------------- |
| NUL       | U+0000  | 0x00           | 0x0000 | 0             | 0              |
| space     | U+0020  | 0x20           | 0x0020 | 32            | 32             |
| LF        | U+000A  | 0x0A           | 0x000A | 10            | 10             |
| CR        | U+000D  | 0x0D           | 0x000D | 13            | 13             |
| $         | U+0024  | 0x24           | 0x0024 | 36            | 36             |
| A         | U+0041  | 0x41           | 0x0041 | 65            | 65             |
| ¥         | U+00A5  | 0xC2 0xA5      | 0x00A5 | 194 165       | 165            |
| €         | U+20AC  | 0xE2 0x82 0xAC | 0x20AC | 226 130 172   | 8364           |
| ₹         | U+20B9  | 0xE2 0x82 0xB9 | 0x20B9 | 226 130 185   | 8377           |
| ₩         | U+20A9  | 0xE2 0x82 0xA9 | 0x20A9 | 226 130 169   | 8361           |

the UTF-8 of $ is 0x24, which is 36 in decimal and the UTF-16 of $ is 0x0024, which is 36 in decimal.

## 2.2 Reading and Writing Binary Data

See book examples (this came later)

- [DataIO](../book-code/corejava/v2ch02/randomAccess/DataIO.java)
- [RandomAccessTest](../book-code/corejava/v2ch02/randomAccess/RandomAccessTest.java)

### 2.2.1 The DataInput and DataOutput Interfaces

Use to read and write binary data.

The DataInput interface provides for reading bytes from a binary stream and reconstructing from them data in any of the Java primitive types

The DataOutput interface provides for converting data from any of the Java primitive types to a series of bytes and writing these bytes to a binary stream. The can be read by a DataInput.

See Book examples
- [DataIO](../book-code/corejava/v2ch02/randomAccess/DataIO.java)


### 2.2.2 Random-Access Files

Use to access a file at random locations.

See book example [RandomAccessTest](../book-code/corejava/v2ch02/randomAccess/RandomAccessTest.java)

### 2.2.3 ZIP Archives

Use to work with ZIP archives.

See book example [ZipTest](../book-code/corejava/v2ch02/zip/ZipTest.java)

## 2.3 Object Input/Output Streams and Serialization

Use to read and write objects.

See book example [ObjectInputStreamTest](../book-code/corejava/v2ch02/serial/ObjectStreamTest.java)

### 2.3.1 Saving and Loading Serializable Objects (later)

### 2.3.2 Understanding the Object Serialization File Format (later)

### 2.3.3 Modifying the Default Serialization Mechanism (later)

### 2.3.4 The readResolve and writeReplace Methods (later)

### 2.3.5 Versioning (later)

### 2.3.6 Using Serialization for Cloning (later)

### 2.3.7 Deserialization and Security (later)

## 2.4 Working with Files

You use `Path` and `Files` class to work with files. Do not use `File` which was used in the early versions of Java.

### 2.4.1 Paths

Path is an interface that represents a path to a file. It is a sequence of directory names and a file name. The `Paths` class defines the following methods:

| Method                                 | Description                                                             |
| -------------------------------------- | ----------------------------------------------------------------------- |
| Path get(String first, String... more) | Returns a path that is a concatenation of the given strings.            |
| Path get(URI uri)                      | Returns a path that is a URI.                                           |
| Path resolve(Path other)               | Returns a path that is a concatenation of this path and the given path. |

If it starts with a slash, it is an absolute path. If it starts with a drive letter, it is an absolute path. Otherwise, it is a relative path.

### 2.4.2 Reading and Writing Files

See [FilesReadingAndWritingTest](../book-code/corejava/v2ch02/pawarv/FilesReadingAndWritingTest.java)

Files provides the following methods:

| Method                                                                                                              | Description                                            |
| ------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------ |
| byte[] readAllBytes(Path path) throws IOException                                                                   | Returns the contents of the file as a byte array.      |
| List\<String\> readAllLines(Path path) throws IOException                                                           | Returns the contents of the file as a list of strings. |
| List\<String\> readAllLines(Path path, Charset cs) throws IOException                                               | Returns the contents of the file as a list of strings. |
| Stream\<String\> lines(Path path) throws IOException                                                                | Returns a stream of strings.                           |
| String readString(Path path) throws IOException                                                                     | Returns the contents of the file as a string.          |
| String readString(Path path, Charset cs) throws IOException                                                         | Returns the contents of the file as a string.          |
| Path write(Path path, byte[] bytes, OpenOption... options) throws IOException                                       | Writes a byte array to a file.                         |
| Path write(Path path, Iterable<? extends CharSequence> lines, Charset cs, OpenOption... options) throws IOException | Writes a list of strings to a file.                    |
| Path write(Path path, Iterable<? extends CharSequence> lines, OpenOption... options) throws IOException             | Writes a list of strings to a file.                    |
| Path writeString(Path path, CharSequence csq, OpenOption... options) throws IOException                             | Writes a string to a file.                             |

This saves you from having to create a `FileOutputStream` or `FileInputStream` or `FileReader` or `FileWriter`.

### 2.4.3 Creating Files and Directories

See [FilesHandlingTest](../book-code/corejava/v2ch02/pawarv/FilesHandlingTest.java)

We can use `Files` class to create files and directories.

| Method                                                                                        | Description                                                   |
| --------------------------------------------------------------------------------------------- | ------------------------------------------------------------- |
| boolean exists(Path path, LinkOption... options)                                              | Returns true if the file exists.                              |
| boolean notExists(Path path, LinkOption... options)                                           | Returns true if the file does not exist.                      |
| boolean isDirectory(Path path, LinkOption... options)                                         | Returns true if the file is a directory.                      |
| boolean isRegularFile(Path path, LinkOption... options)                                       | Returns true if the file is a regular file.                   |
| boolean isSymbolicLink(Path path)                                                             | Returns true if the file is a symbolic link.                  |
| boolean isHidden(Path path)                                                                   | Returns true if the file is hidden.                           |
| boolean isReadable(Path path)                                                                 | Returns true if the file is readable.                         |
| boolean isWritable(Path path)                                                                 | Returns true if the file is writable.                         |
| boolean isExecutable(Path path)                                                               | Returns true if the file is executable.                       |
| Path createFile(Path path, FileAttribute<?>... attrs) throws IOException                      | Creates a new file.                                           |
| Path createDirectory(Path path, FileAttribute<?>... attrs) throws IOException                 | Creates a new directory.                                      |
| Path createDirectories(Path path, FileAttribute<?>... attrs) throws IOException               | Creates a new directory and all necessary parent directories. |
| Path createSymbolicLink(Path link, Path target, FileAttribute<?>... attrs) throws IOException | Creates a new symbolic link.                                  |
| Path createLink(Path link, Path existing) throws IOException                                  | Creates a new hard link.                                      |
| Path delete(Path path) throws IOException                                                     | Deletes a file.                                               |
| Path deleteIfExists(Path path) throws IOException                                             | Deletes a file if it exists.                                  |
| Path copy(Path source, Path target, CopyOption... options) throws IOException                 | Copies a file.                                                |
| Path move(Path source, Path target, CopyOption... options) throws IOException                 | Moves a file.                                                 |

### 2.4.4 Copying, Moving, and Deleting Files

See [FilesHandlingTest](../book-code/corejava/v2ch02/pawarv/FilesHandlingTest.java)

### 2.4.5 Getting File Information

See [FilesHandlingTest](../book-code/corejava/v2ch02/pawarv/FilesHandlingTest.java)

### 2.4.6 Visiting Directory Entries

See [FilesDirectoryVisitorTest](../book-code/corejava/v2ch02/pawarv/FilesDirectoryVisitorTest.java)

### 2.4.7 Using Directory Streams

See [FilesDirectoryVisitorTest](../book-code/corejava/v2ch02/pawarv/FilesDirectoryVisitorTest.java)

### 2.4.8 ZIP File Systems

See 
- [ZipInputStream](../book-code/corejava/v2ch02/zip/ZipTest.java)
- [SimpleZipOutput](../book-code/corejava/v2ch02/pawarv/SimpleZipOutput.java)
- [ZipFolder](../book-code/corejava/v2ch02/pawarv/ZipFolder.java)
- [ZipIndividually](../book-code/corejava/v2ch02/pawarv/ZipIndividually.java)


Rest, later.

2.5 Memory-Mapped Files

2.5.1 Memory-Mapped File Performance

2.5.2 The Buffer Data Structure

2.6 File Locking

## 2.7 Regular Expressions

Regular expressions are a powerful language for describing text patterns. They are used in many applications, including search and replace operations, pattern matching in text editors, and parsing and validating data.

The Java regular expression API is in the `java.util.regex` package.

The pattern class is `java.util.regex.Pattern`. The [Pattern JDK documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/regex/Pattern.html)  has a nice summary of the syntax.

The Java tutorial on [Regular Expressions](https://docs.oracle.com/javase/tutorial/essential/regex/) is also a good resource.

A good book to read is [Mastering Regular Expressions](https://www.amazon.com/Mastering-Regular-Expressions-Jeffrey-Friedl/dp/0596528124).

A good website to test regular expressions is [regex101](https://regex101.com/).


### 2.7.1 The Regular Expression Syntax

Try out the examples in [RegexTest](../book-code/corejava/v2ch02/pawarv/RegexTest.java).

A character means the same thing as itself. For example, the regular expression `a` matches the string `a`. But the the following reserved characters have special meanings: 

`. * + ? { | ( ) [ \ ^ $`

To match a reserved character, you have to escape it with a backslash. For example, the regular expression `\.` matches the string `.`.

The following characters have special meanings:

| Character | Meaning |
| --------- | ------- |
| `.` | Matches any character. |
| `^` | Matches the beginning of a line. |
| `$` | Matches the end of a line. |
| `*` | Matches zero or more occurrences of the preceding character. |
| `+` | Matches one or more occurrences of the preceding character. |
| `?` | Matches zero or one occurrence of the preceding character. |
| `\` | Escapes the following character. |
| `[]` | Matches any character in the brackets. |
| `[^]` | Matches any character not in the brackets. |
| `()` | Groups characters. |
| `{}` | Specifies the number of occurrences of the preceding character. |
| `\|` | Separates alternatives. |
| `\d` | Matches a digit. |
| `\D` | Matches a non-digit. |
| `\s` | Matches a whitespace character. |
| `\S` | Matches a non-whitespace character. |
| `\w` | Matches a word character. |
| `\W` | Matches a non-word character. |


There is a lot to learn about, see the reference.

### 2.7.2 Matching an Entire String

See
- [RegexMatchingEntireString](../book-code/corejava/v2ch02/pawarv/RegexMatchingEntireString.java)

There are two cases

1. The regular expression matches the entire string.
2. The regular expression matches a substring of the string, so you want to know how many times the pattern occurs in the string.


For the first case, we can just use the `matches` method of the `String` class or the `matches` method of the `Pattern` class for the first case. 

The `matches` method checks whether the entire string matches the regular expression. 

If we need to use the same regular expression many times, it is more efficient to compile it into a `Pattern` object. The `Pattern` class has a `compile` method that takes a regular expression and returns a `Pattern` object.

```java
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(input);

if(matcher.matches()) {
    // do something
}
;
```

The pattern can be turned in a predicate.

```java
Predicate<String> predicate = Pattern.compile(regex).asMatchPredicate(); //  for Entire string (case )
Predicate<String> predicate = Pattern.compile(regex).asPredicate(); // for substring (case 2)

Stream<String> stream = Stream.of("a", "b", "c");
// 
stream.filter(predicate).forEach(System.out::println);

```

### 2.7.3 Finding All Matches in a String

See 

- [RegexMatchingSubstring](../book-code/corejava/v2ch02/pawarv/RegexMatchingSubstring.java)
- [HrefMatch](../book-code/corejava/v2ch02/match/HrefMatch.java) - Book example

For the second case, we can use the `find` method of the `Pattern` class.
The `find` method checks whether a substring of the string matches the regular expression.

```java
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(input);
while (matcher.find())
{
    String match = matcher.group();
    int start = matcher.start();
    int end = matcher.end();

    // do something
}
```


### 2.7.4 Groups

See
- [RegexGroupTest](../book-code/corejava/v2ch02/pawarv/RegexGroupTest.java)
- [RegexTest](../book-code/corejava/v2ch02/regex/RegexTest.java) Book example

### 2.7.5 Splitting along Delimiters

See
- [RegexSplitTest](../book-code/corejava/v2ch02/pawarv/RegexSplitTest.java)
  

### 2.7.6 Replacing Matches

See
- [RegexReplaceTest](../book-code/corejava/v2ch02/pawarv/RegexReplaceTest.java)
 

### 2.7.7 Flags

Can change the behaviour of the regular expression using flags.

> [Home](HOME.md)
