package pawarv;

import java.lang.StackWalker.StackFrame;
import java.util.Optional;

public class SimpleStackTraceTest {
    public static void main(String[] args) {

        var walker = StackWalker.getInstance();

        System.out.println("Stack trace:");
        System.out.println("***Main method***");
        walker.forEach(System.out::println);
        method1(walker);
        method2(walker);

        Optional<StackFrame> opt = walker.walk(sf -> sf.findFirst());

        StackFrame first = opt.get();

        System.out.println("First element: " + first);

        System.out.println("Classname : " + first.getClassName());
        System.out.println("Methodname : " + first.getMethodName());
        System.out.println("Line number : " + first.getLineNumber());
        System.out.println("File name : " + first.getFileName());
        
    }

    private static void method1(StackWalker walker) {

        System.out.println("***Method1***");
        walker.forEach(System.out::println);
    }

    private static void method2(StackWalker walker) {
        System.out.println("***Method2***");
        method1(walker);
    }

}
