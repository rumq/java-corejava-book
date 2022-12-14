package pawarv;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {
    
    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        Method square = ReflectionDemo.class.getMethod("square", double.class);

        System.out.println(square);
        
        var result = square.invoke(null, 6.0);

        System.out.println(result);
    }

    public static double square(double x) {
        return x * x;
    }
}
