>[Home](Home.md)

# Volume 1 Chapter 12 Concurrency   

Status : DONE

- [Volume 1 Chapter 12 Concurrency](#volume-1-chapter-12-concurrency)
  - [12.1 What Are Threads?](#121-what-are-threads)
  - [12.2 Thread States](#122-thread-states)
    - [12.2.1 New](#1221-new)
    - [12.2.2 Runnable Threads](#1222-runnable-threads)
    - [12.2.3 Blocked and Waiting Threads](#1223-blocked-and-waiting-threads)
    - [12.2.4 Terminated Threads](#1224-terminated-threads)
  - [12.3 Thread Properties](#123-thread-properties)
    - [12.3.1 Interrupting Threads](#1231-interrupting-threads)
    - [12.3.2 Daemon Threads](#1232-daemon-threads)
    - [12.3.3 Thread Names](#1233-thread-names)
    - [12.3.4 Handlers for Uncaught Exceptions](#1234-handlers-for-uncaught-exceptions)
    - [12.3.5 Thread Priorities](#1235-thread-priorities)
  - [12.4 Synchronization](#124-synchronization)
    - [12.4.1 An Example of Race Condition](#1241-an-example-of-race-condition)
    - [12.4.2 Race Condition Explained](#1242-race-condition-explained)
    - [12.4.3 Lock Objects](#1243-lock-objects)
    - [12.4.4 Condition Objects](#1244-condition-objects)
    - [12.4.5 The synchronized Keyword](#1245-the-synchronized-keyword)
    - [12.4.6 Synchronized Blocks](#1246-synchronized-blocks)
    - [12.4.7 The Monitor Concept](#1247-the-monitor-concept)
    - [12.4.8 Volatile Fields](#1248-volatile-fields)
    - [12.4.9 Final Variables](#1249-final-variables)
    - [12.4.10 Atomics](#12410-atomics)
    - [12.4.11 Deadlocks](#12411-deadlocks)
    - [12.4.12 Why the stop and suspend Methods Are Deprecated](#12412-why-the-stop-and-suspend-methods-are-deprecated)
    - [12.4.13 On-Demand Initialization](#12413-on-demand-initialization)
    - [12.4.14 Thread-local Variables](#12414-thread-local-variables)
  - [12.5 Thread-Safe Collections](#125-thread-safe-collections)
    - [12.5.1 Blocking Queues](#1251-blocking-queues)
    - [12.5.2 Efficient Maps, Sets, and Queues](#1252-efficient-maps-sets-and-queues)
    - [12.5.3 Atomic update of Map Entries](#1253-atomic-update-of-map-entries)
    - [12.5.4 Bulk Operations on Concurrent Hash Maps](#1254-bulk-operations-on-concurrent-hash-maps)
    - [12.5.5 Concurrent Set Views](#1255-concurrent-set-views)
    - [12.5.6 Copy on Write arrays](#1256-copy-on-write-arrays)
    - [12.5.7 Parallel Array Algorithms](#1257-parallel-array-algorithms)
    - [12.5.8 Older Thread-Safe Collections](#1258-older-thread-safe-collections)
  - [12.6 Tasks and Thread Pools](#126-tasks-and-thread-pools)
    - [12.6.1 Callables and Futures](#1261-callables-and-futures)
    - [12.6.2 Executors](#1262-executors)
    - [12.6.3 Controlling Groups of Tasks](#1263-controlling-groups-of-tasks)
    - [12.6.4 The Fork-Join Framework](#1264-the-fork-join-framework)
  - [12.7 Asynchronous Computations](#127-asynchronous-computations)
    - [12.7.1 Completable Futures](#1271-completable-futures)
    - [12.7.2 Composing Completable Futures](#1272-composing-completable-futures)
    - [12.7.3 Long-Running Tasks in User Interface Callbacks](#1273-long-running-tasks-in-user-interface-callbacks)
  - [12.8 Processes](#128-processes)
    - [12.8.1 Building a Process](#1281-building-a-process)
    - [12.8.2 Running a Process](#1282-running-a-process)
    - [12.8.3 Process Handles](#1283-process-handles)


*Multitasking* is the ability of the operating system to run several programs each running in its own process at the same time. The operating system switches between the processes very quickly, so that it appears that they are running at the same time. The operating system gives each process a CPU time slice, which is the amount of time that the process can run before the operating system switches to another process.

*Multithreading* is the ability of a program to run several tasks at the same time. Each task is called a *thread*. Such a program is called a *multithreaded program*.

The thread is different from the process. A *process* is a program in execution. A thread is a task within a process. A process can have multiple threads. 

A process has its own *memory space*, i.e variables, whereas the threads share the memory space of their process.

Shared variables are variables that are accessible to multiple threads. If a thread modifies a shared variable, other threads may see the change. 

Threads are light weight. A process can have thousands of threads. Creating and destroying a thread is much faster and takes less overhead than creating and destroying a process.

Threads are useful for two reasons:
1. They can make a program run faster by running several tasks at the same time.
2. A program can be more responsive by doing a time-consuming task in a separate thread.

The Java platform supports multithreading. A Java program can run several threads at the same time. Each thread has its own call stack for executing methods.

Concurrent programming is hard and as an application programmer you only need to know a few basic concepts.


## 12.1 What Are Threads?

See [BasicThreadTest](../book-code/corejava/v1ch12/pawarv/BasicThreadTest.java)

Steps to create a thread:
1. Define a class that implements the `Runnable` interface.
2. Construct a `Thread` object from the `Runnable` object.
3. Start the thread by calling the `start` method.

```java
public class ThreadTest
{
   public static void main(String[] args)
   {
      Runnable r = () -> {
         for (int i = 1; i <= 1000; i++) System.out.println(i);
      };
      Thread t = new Thread(r);
      t.start();
      for (int i = 1001; i <= 2000; i++) System.out.println(i);
   }
}
```

The `Runnable` interface has a single method `run`. The `run` method is called when the thread is started.


## 12.2 Thread States

A thread can be in one of six states:
1. *New* - The thread has been created but not started.
2. *Runnable* - The thread is executing in the Java virtual machine.
3. *Blocked* - The thread is blocked waiting for a monitor lock.
4. *Waiting* - The thread is waiting indefinitely for another thread to perform a particular action.
5. *Timed waiting* - The thread is waiting for another thread to perform an action for up to a specified waiting time.
6. *Terminated* - The thread has exited.

You can use the `getState` method to get the state of a thread.

### 12.2.1 New

A thread is in the *new* state when it is created. The thread is not yet running. 

### 12.2.2 Runnable Threads

A thread is in the *runnable* state when it is executing in the Java virtual machine. It may be running or it may be waiting for the operating system to give it processor time.

You can use the `yield` method to give up the remainder of the current time slice and allow other threads to execute. 

### 12.2.3 Blocked and Waiting Threads

A thread is in the *blocked* state when it is waiting for a monitor lock. A monitor lock is a mechanism for controlling access to a shared resource.

A thread is in the *waiting* state when it is waiting indefinitely for another thread to perform a particular action.

A thread is in the *timed waiting* state when it is waiting for another thread to perform an action for up to a specified waiting time. A thread enters the timed waiting state using one of the following methods:
   - Thread.sleep
   - Object.wait
   - Thread.join
   - Lock.tryLock
   - Condition.await
  
The [Thread.State](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Thread.State.html) enum has these six states.

[Thread States](../assets/diagrams/ThreadStates.excalidraw) diagram.


### 12.2.4 Terminated Threads

A thread is in the *terminated* state when it has exited. It can no longer be scheduled for execution. It is terminated either by normal termination or by an uncaught exception.

## 12.3 Thread Properties


We'll discuss the following thread properties:

### 12.3.1 Interrupting Threads

See [InterruptTest](../book-code/corejava/v1ch12/pawarv/InterruptTest.java)
See [InterruptedTest](../book-code/corejava/v1ch12/pawarv/InterruptedTest.java)

A thread exits when its `run` method returns or when an uncaught exception is thrown.

If a thread has not exited, it can be interrupted.

The `interrupt` method interrupts the thread. It sets a flag that indicates that the thread should be interrupted. 

The `interrupted` method tests whether the current thread has been interrupted. It also clears the interrupted status.


The `isInterrupted` method tests whether the thread has been interrupted. 

The `sleep` method throws an `InterruptedException` if the thread is interrupted while sleeping.

A run method should check the `isInterrupted` flag frequently and exit if it is set.

### 12.3.2 Daemon Threads

A *daemon thread* is a thread that runs in the background to perform tasks such as garbage collection. When the only threads running are all daemon threads, the Java virtual machine exits.

The `setDaemon` method marks a thread as a daemon thread. It must be called before the thread is started.

### 12.3.3 Thread Names

The `setName` method sets the name of a thread. The `getName` method gets the name of a thread.

 
### 12.3.4 Handlers for Uncaught Exceptions

See later.

### 12.3.5 Thread Priorities

Don't have to use thread priorities. They are not reliable.

## 12.4 Synchronization

A *race condition* occurs when two or more threads access a shared variable and they interfere with each other, so that the result depends on the order of the operations.

### 12.4.1 An Example of Race Condition

See 
- [RaceConditionTest](../book-code/corejava/v1ch12/pawarv/RaceConditionTest.java)
- [UnsynchBankTest](../book-code/corejava/v1ch12/unsynch/UnsynchBankTest.java)

### 12.4.2 Race Condition Explained

In the above example two threads try to carry out the below operations on the same variable `counter`:

```java

value = value + 1;

```
This is not an atomic operation. 

If it was an atomic operation,  operations would be executed in the following order:

Suppose the value is 0.

1. Thread 1 reads `value` and gets 0, adds 1 to 0 and gets 1. It moves 1 to `value`.
2. Thread 2 reads `value` and gets 1, adds 1 to 1 and gets 2. It moves 2 to `value`.

The final value of `value` is 2. Which is correct.

It is actually three operations:

1. Read `value`
2. Add 1 to `value`
3. Move the result to `value`

If the two threads execute these operations in the following order:

1. Thread 1 reads `value` and gets 0.
2. Thread 2 reads `value` and gets 0.
3. Thread 1 adds 1 to 0 and gets 1.
4. Thead 2 adds 1 to 0 and gets 1.
5. Thread 1 moves 1 to `value`.
6. Thread 2 moves 1 to `value`.

The final value of `value` is 1. Which is incorrect.

### 12.4.3 Lock Objects

See 
- [RaceConditionReentrantLockTest](../book-code/corejava/v1ch12/pawarv/RaceConditionReentrantLockTest.java.java)
- [SynchBankTest](../book-code/corejava/v1ch12/synch/SynchBankTest.java)

One way to ensure only one thread at a time can execute a section of code is to use a *lock object*.

A *lock object* is an object that is used to control access to a shared resource.

We can use  `ReentrantLock` class to create a lock object. It has the method `lock` to lock the object and `unlock` to unlock the object. 

The `lock` is called at the beginning of the section of code that needs to be executed by only one thread at a time. 

The `unlock` is called at the end of the section of code. 

To ensure that the `unlock` is called even if an exception is thrown, we can use the `try-finally` construct. 

It is called *reentrant* because if the same thread tries to lock the same lock object twice, it will succeed. The thread must call `unlock` twice to release the lock.

### 12.4.4 Condition Objects

See 
- [RaceConditionReentrantLockConditionTest](../book-code/corejava/v1ch12/pawarv/RaceConditionReentrantLockConditionTest.java)
  

A *condition object* is an object that is associated with a lock object and is used to control access to a shared resource. 

If a particular condition has to be true for a thread to execute the critical section, that condition cannot be checked outside the critical section. So a thread has to acquire a lock. 

But if the thread acquires a lock and finds that the condition is not true, it can't do its work, and it also will be blocking other threads from doing their work.

To overcome this problem, after acquiring a lock, a thread can wait for a particular condition to be true by calling the `await` method of the condition object. 

After calling the `await` method, the thread releases the lock object and becomes suspended.  is different from a thread waiting to acquire a lock as the thread is now inside the critical section.

It becomes active again when the other threads acquire the lock and call the `signal` or `signalAll` method of the condition object. Then it competes for lock with other threads, and proceeds only when it acquires the lock. But of course, the condition must be true for the thread to execute the critical section. If the condition is not true, the thread will again call the `await` method and release the lock.

### 12.4.5 The synchronized Keyword

See 
- [RaceConditionSynchronizedTest](../book-code/corejava/v1ch12/pawarv/RaceConditionSynchronizedTest.java)
- [SynchBankTest2](../book-code/corejava/v1ch12/synch2/SynchBankTest2.java)

The `synchronized` keyword can be used to mark a method as a critical section. 

This simplifies the code in comparison to using a lock object & condition object.

Every object has an *internal lock* or *intrinsic lock* or *monitor lock*. 

When a thread invokes a synchronized method, it automatically acquires the lock of the object on which the method is called.

When the thread exits the critical section, it releases the lock.

Every object has the method `wait` to suspend the thread and `notify` or `notifyAll` to wake up the suspended thread. These methods must be called from a synchronized method. And they are analogous to the `await` and `signal` or `signalAll` methods of the condition object.


### 12.4.6 Synchronized Blocks

We can use the `synchronized` keyword to mark a block of code as a critical section.

syntax:

```java

synchronized (lockObject) {
    // critical section
}

```
Ensure that the lock object is the same for all threads that need to execute the critical section. And it is not a string literal.

The object can be any object, and it may have been created for this purpose.

If you are calling methods from an object that already use the object's intrinsic lock, and you use synchronized blocks for further synchronization,  you'd be locking the same object. This is client-side locking. We don't need to do this.

### 12.4.7 The Monitor Concept

Java's primitives for synchronization are based on the *monitor concept*, but not completely.

Monitor have the following properties:
- A monitor is a class that has only private fields
- Each object of a monitor class has an associated lock
- All methods are locked by the same lock
- The lock can have any number of conditions.
  

### 12.4.8 Volatile Fields

See [volatile](../assets/diagrams/volatile.excalidraw)

Issues
1. Processors may save the value of a variable in a register or in a cache, so that it does not have to be read from memory every time it is used. So the value of a variable may not be the same in different processors. If the threads are running on different processors, this can cause problems.
2. Compilers may reorder the execution of statements in a method without taking into consideration that the memory values may be changed by another thread.

The `volatile` keyword can be used to mark a field as *volatile*. Then the compiler will ensure that change done by one thread is visible to other threads.

> Brian Goetz coined the following “synchronization motto”: “If you write a
> variable which may next be read by another thread, or you read a variable
> which  may  have  last  been  written  by  another  thread,  you  must  use
> synchronization.”
>
> 
>  The  volatile  keyword  offers  a  lock-free  mechanism  for  synchronizing
> access  to  an  instance  field.  If  you  declare  a  field  as  volatile,  then  the
> compiler  and  the  virtual  machine  take  into  account  that  the  field  may  be
> concurrently updated by another thread

You can use it as below where you are not doing any operations on the variable, but just assigning or reading it.
   
```java
private volatile boolean done; 
public boolean isDone() { return done; } 
public void setDone() { done = true; }
```

However, volatile variables do not provide atomicity.
```java
private volatile boolean done; 
public void flipDone() { done = !done; } // not atomic

private volatile int count;
public increment() { count = count + 1; } // not atomic

```


### 12.4.9 Final Variables

If you know you won't change a variable after declaring it or assigning value to it once, you can declare it as `final`. This will also ensure that different threads see the same value.

For example, in the below code, all threads will see the accounts variable after the construction of the HashMap.

```java
final var accounts = new HashMap<String, Double>()
```


### 12.4.10 Atomics

See 
- [RaceConditionAtomicIntegerTest](../book-code/corejava/v1ch12/pawarv/RaceConditionAtomicIntegerTest.java)
- [AtomicIntegerTest](../book-code/corejava/v1ch12/pawarv/AtomicIntegerTest.java)
- [LongAccumulatorTest](../book-code/corejava/v1ch12/pawarv/LongAccumulatorTest.java)

The `java.util.concurrent.atomic` package contains classes that provide atomic operations on variables, so that you don't have to use synchronization.

For example, the `AtomicInteger` class provides atomic operations on an integer variable. Similarly, `AtomicLong` and `AtomicBoolean` provide atomic operations on long and boolean variables.

```java
var counter = new AtomicInteger();
counter.incrementAndGet();

var counter2 = new AtomicLong();
counter2.incrementAndGet();

```

> LongAccumulator - This class is usually preferable to AtomicLong when multiple threads update a common value that is used for purposes such as collecting statistics, not for fine-grained synchronization control. Under low update contention, the two classes have similar characteristics. But under high contention, expected throughput of this class is significantly higher, at the expense of higher space consumption.



### 12.4.11 Deadlocks

See 
- [RaceConditionDeadLockTest](../book-code/corejava/v1ch12/pawarv/RaceConditionDeadLockTest.java)
- [DeadlockedTransfersTest](../book-code/corejava/v1ch12/pawarv/DeadlockedTransfersTest.java)

A *deadlock* occurs when two or more threads are blocked forever, waiting for each other.

For example, in the below code, thread 1 is waiting for thread 2 to release the lock on the account object, and thread 2 is waiting for thread 1 to release the lock on the other account object.

```java
public void transfer(Account from, Account to, int amount) {
    synchronized (from) {
        synchronized (to) {
            if (from.getBalance() < amount) {
                throw new IllegalArgumentException();
            }
            else {
                from.debit(amount);
                to.credit(amount);
            }
        }
    }
}
```


### 12.4.12 Why the stop and suspend Methods Are Deprecated

The `stop` and `suspend` methods are deprecated because they can cause deadlocks. So, you should not use them.

### 12.4.13 On-Demand Initialization

See [OnDemandInitializationTest](../book-code/corejava/v1ch12/pawarv/OnDemandInitializationTest.java)

If we want to initialize a data structure only when it is needed, and that too only once, we can use the *on-demand initialization* idiom.

We can use the fact that the static initialization happens only once when the class is first used.

As JVM does this using a lock, we don't have to handle the synchronization.


### 12.4.14 Thread-local Variables

See 
- [ThreadLocalTest](../book-code/corejava/v1ch12/pawarv/ThreadLocalTest.java)
- [CountThreadLocalTest](../book-code/corejava/v1ch12/pawarv/CountThreadLocalTest.java)

A *thread-local variable* is a variable that is associated with a thread. Each thread has its own copy of a thread-local variable. Thread-local variables are typically private static fields in classes that wish to associate state with a thread (e.g., a user ID or transaction ID).

```java
private static ThreadLocal<LocalDate> date = ThreadLocal.withInitial(() -> LocalDate.now());
```


## 12.5 Thread-Safe Collections

If multiple threads modify a data structure, it is easy to damage it. In such cases, you need to use a *thread-safe* data structure.

### 12.5.1 Blocking Queues

See 
- [BasicBlockingQueueTest](../book-code/corejava/v1ch12/pawarv/BasicBlockingQueueTest.java)
- [BlockingQueueTest](../book-code/corejava/v1ch12/blockingQueue/BlockingQueueTest.java) 

A threading problem can sometimes be solved by using one or more queues.

A blocking queue can be used to transfer data between threads. For example, a thread can put data into a queue, and another thread can take data from the queue.

A *blocking queue* is a queue that blocks when you try to remove an element from it and the queue is empty, or if you try to add an element to it and the queue is full.

The `java.util.concurrent` package contains the `BlockingQueue` interface, which extends the `Queue` interface. The `BlockingQueue` interface defines methods that wait for the queue to become nonempty when retrieving an element, and wait for space to become available in the queue when storing an element.


### 12.5.2 Efficient Maps, Sets, and Queues

Later (Advanced)

The `java.util.concurrent` package contains several classes that implement the `Map`, `Set`, and `Queue` interfaces. These classes are thread-safe and efficient.

For example, the `ConcurrentHashMap` class implements the `Map` interface. It is a hash table that supports full concurrency of retrievals and high expected concurrency for updates. 


### 12.5.3 Atomic update of Map Entries
Later (Advanced)

see 
- [CHMDemo](../book-code/corejava/v1ch12/concurrentHashMap/CHMDemo.java)

A ConcurrentHashMap's internal data structure is not destroyed when the map is used by multiple threads unlike a HashMap. So, it is safe to use a ConcurrentHashMap in a multithreaded program.

However, a ConcurrentHashMap still needs to be used with care. For example, if you want to increment a counter in a map, you should use the `compute` method, which atomically updates the map entry.

```java
map.compute(key, (k, v) -> v == null ? 1 : v + 1);
```

Or even better, use the `merge` method, which is more concise.

```java
map.merge(key, 1, Integer::sum);
```

### 12.5.4 Bulk Operations on Concurrent Hash Maps
Later (Advanced)
### 12.5.5 Concurrent Set Views
Later (Advanced)

Can get a ConcurrentSet from a ConcurrentHashMap.

For example, the `keySet` method returns a `Set` view of the keys. This set is backed by the map, so changes to the map are reflected in the set, and vice-versa.

The `newKeySet` method returns a `ConcurrentHashMap.KeySetView` object, which is a `Set` view of the keys. This set is backed by the map, so changes to the map are reflected in the set, and vice-versa. 


### 12.5.6 Copy on Write arrays
Later (Advanced)
### 12.5.7 Parallel Array Algorithms
Later (Advanced)

### 12.5.8 Older Thread-Safe Collections
Later (Advanced)

## 12.6 Tasks and Thread Pools

Threads are expensive to create and destroy. So, it is better to reuse threads. This is the idea behind *thread pools*.


### 12.6.1 Callables and Futures

Later (Advanced) and all the below.

### 12.6.2 Executors

### 12.6.3 Controlling Groups of Tasks
### 12.6.4 The Fork-Join Framework

## 12.7 Asynchronous Computations
### 12.7.1 Completable Futures
### 12.7.2 Composing Completable Futures
### 12.7.3 Long-Running Tasks in User Interface Callbacks
## 12.8 Processes
### 12.8.1 Building a Process
### 12.8.2 Running a Process
### 12.8.3 Process Handles 

>[Home](HOME.md)
