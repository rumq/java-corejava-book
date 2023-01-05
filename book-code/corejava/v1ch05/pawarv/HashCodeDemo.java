package pawarv;

public class HashCodeDemo {
    
    public static void main(String[] args) {
        // HashCode is used to store objects in hash table
        // HashCode is used to compare objects

        System.out.println("Hello".hashCode());
        System.out.println("Hello".hashCode());

        
        var s = "Ok";
        var sb = new StringBuilder(s);
        System.out.println(s.hashCode() + " " + sb.hashCode());
        var t = new String("Ok");
        var tb = new StringBuilder(t);
        System.out.println(t.hashCode() + " " + tb.hashCode());

    }
}
