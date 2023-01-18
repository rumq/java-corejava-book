package pawarv;

import java.util.*;

/*
 *  A custom queue implementation
 *  
 *
 */
public class CustomQueue <T> extends AbstractQueue<T>{
    private LinkedList<T> elements;

    public CustomQueue() {
      this.elements = new LinkedList<T>();
    }


    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean offer(T t) {
        if (t == null)
            return false;
        elements.add(t);
        return true;
    }

    @Override
    public T poll() {
        Iterator<T> iter = elements.iterator();
        T t = iter.next();
        if (t != null) {
            iter.remove();
            return t;
        }
        return null;
    }

    @Override
    public T peek() {
        return elements.getFirst();
    } 
}
