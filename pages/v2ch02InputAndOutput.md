>[Home](Home.md)


# Volume 2 Chapter 2: Input and Output

Status : IN_PROGRESS 

We'll look into
- Read and write data to files
- Access files and directories
- Read binary and text formatted files
- Object serialization
- Regular expressions

## 2.1 Input/Output Streams

Input streams read data from a source, and output streams write data to a destination. 

Please note that these streams are not the same as the Streams that are in the package java.util.stream which are used for functional programming. Unfortunately, the Java API uses the same name for both.

The source and destination can be a file, an array, a device, or a network connection. The Java I/O API defines a large number of stream classes, and it is easy to get lost in the jungle of classes. The following table lists the most important stream classes.

| Stream Class | Description |
|--------------|-------------|
| InputStream | Abstract superclass for all input streams |
| OutputStream | Abstract superclass for all output streams |
| Reader | Abstract superclass for all character-based input streams |
| Writer | Abstract superclass for all character-based output streams |
| FileInputStream | Reads raw bytes from a file |
| FileOutputStream | Writes raw bytes to a file |
| FileReader | Reads characters from a file |
| FileWriter | Writes characters to a file |
| ByteArrayInputStream | Reads raw bytes from an array |
| ByteArrayOutputStream | Writes raw bytes to an array |
| CharArrayReader | Reads characters from an array |
| CharArrayWriter | Writes characters to an array |
| StringReader | Reads characters from a string |
| StringWriter | Writes characters to a string |
| PipedInputStream | Reads raw bytes from a pipe |
| PipedOutputStream | Writes raw bytes to a pipe |
| PipedReader | Reads characters from a pipe |
| PipedWriter | Writes characters to a pipe |
| ObjectInputStream | Reads objects from a stream |
| ObjectOutputStream | Writes objects to a stream |
| DataInputStream | Reads primitive data types from a stream |
| DataOutputStream | Writes primitive data types to a stream |
| BufferedInputStream | Adds buffering to an input stream |
| BufferedOutputStream | Adds buffering to an output stream |
| BufferedReader | Adds buffering and line-oriented reading to a character-based input stream |
| BufferedWriter | Adds buffering and line-oriented writing to a character-based output stream |
| PrintStream | Writes formatted data to an output stream |
| PrintWriter | Writes formatted data to a character-based output stream |

### 2.1.1 Reading and Writing Bytes

The InputStream and OutputStream classes are abstract classes that define the basic input and output operations. The InputStream class defines the following methods:

| Method | Description |
|--------|-------------|
| int read() | Reads a single byte. Returns -1 if the end of the stream has been reached. |
| int read(byte[] b) | Reads a sequence of bytes into an array. Returns the number of bytes read or -1 if the end of the stream has been reached. |
| void close() | Closes the stream. |

The OutputStream class defines the following methods:

| Method | Description |
|--------|-------------|
| void write(int b) | Writes a single byte. |
| void write(byte[] b) | Writes a sequence of bytes from an array. |
| void close() | Closes the stream. |

### 2.1.2 The Complete Stream Zoo

**Input and output stream hierarchy**
![](2023-03-15-09-36-13.png)

#### Character stream hierarchy
![](2023-03-15-09-37-01.png)

### 2.1.3 Combining Input/Output Stream Filters


### 2.1.4 Text Input and Output

See 
- [TextWriteTest](../book-code/corejava/v2ch02/IdeaProjects/IO/src/main/java/net/rumq/TextWriteTest.java)
- [TextWriteAutoFlushTrueTest](../book-code/corejava/v2ch02/IdeaProjects/IO/src/main/java/net/rumq/TextWriteAutoFlushTrueTest.java)

We can use PrintWriter to write text to a file. The PrintWriter class is a character-based output stream that adds buffering and formatting capabilities to an output stream. The PrintWriter class defines the following methods:

| Method | Description |
|--------|-------------|
| void print(String s) | Writes a string. |
| void println(String s) | Writes a string and a line separator. |
| void printf(String format, Object... args) | Writes a formatted string. |

The Scanner class is a character-based input stream that adds buffering and tokenization capabilities to an input stream. The Scanner class defines the following methods:

| Method | Description |
|--------|-------------|
| boolean hasNext() | Returns true if there is another token. |
| String next() | Returns the next token. |
| String nextLine() | Returns the next line. |
| int nextInt() | Returns the next integer. |
| double nextDouble() | Returns the next double. |
| boolean nextBoolean() | Returns the next boolean. |





2.1.5 How to Write Text Output

2.1.6 How to Read Text Input

2.1.7 Saving Objects in Text Format

2.1.8 Character Encodings

2.2 Reading and Writing Binary Data

2.2.1 The DataInput and DataOutput Interfaces

2.2.2 Random-Access Files

2.2.3 ZIP Archives

2.3 Object Input/Output Streams and Serialization

2.3.1 Saving and Loading Serializable Objects

2.3.2 Understanding the Object Serialization File Format

2.3.3 Modifying the Default Serialization Mechanism

2.3.4 The readResolve and writeReplace Methods

2.3.5 Versioning

2.3.6 Using Serialization for Cloning

2.3.7 Deserialization and Security

2.4 Working with Files

2.4.1 Paths

2.4.2 Reading and Writing Files

2.4.3 Creating Files and Directories

2.4.4 Copying, Moving, and Deleting Files

2.4.5 Getting File Information

2.4.6 Visiting Directory Entries

2.4.7 Using Directory Streams

2.4.8 ZIP File Systems

2.5 Memory-Mapped Files

2.5.1 Memory-Mapped File Performance

2.5.2 The Buffer Data Structure

2.6 File Locking

2.7 Regular Expressions

2.7.1 The Regular Expression Syntax

2.7.2 Matching an Entire String

2.7.3 Finding All Matches in a String

2.7.4 Groups

2.7.5 Splitting along Delimiters

2.7.6 Replacing Matches

2.7.7 Flags
>[Home](HOME.md)
