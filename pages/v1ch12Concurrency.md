>[Home](Home.md)

# Volume 1 Chapter 12 Concurrency   

Status : 

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

A thread exits when its `run` method returns or when an uncaught exception is thrown.

If a thread has not exited, it can be interrupted.

The `interrupt` method interrupts the thread. It sets a flag that indicates that the thread should be interrupted. 

The `interrupted` method tests whether the current thread has been interrupted. It also clears the interrupted status.


The `isInterrupted` method tests whether the thread has been interrupted. 

The `sleep` method throws an `InterruptedException` if the thread is interrupted while sleeping.

A run method should check the `isInterrupted` flag frequently and exit if it is set.



### 12.3.2 Daemon Threads
### 12.3.3 Thread Names
### 12.3.4 Handlers for Uncaught Exceptions
### 12.3.5 Thread Priorities


## 12.4 Synchronization
## 12.5 Thread-Safe Collections
## 12.6 Tasks and Thread Pools
## 12.7 Asynchronous Computations
## 12.8 Processe

>[Home](HOME.md)
