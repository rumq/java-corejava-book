package pawarv;

import static streams.CreatingStreams.show;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class CreatingStreamsTest {
    public static void main(String[] args) {

        // Empty stream
        var stream = Stream.empty();
        show("Empty stream", stream);
        
        // From a collection
        var list = List.of("a", "b", "c");
        var listStream = list.stream();        
        show("From a Collection", listStream);

        // From an array
        var array = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        var arrayStream = Stream.of(array);
        show("From an Array", arrayStream);

        // From a part of an array
        // var arrayStream2 = Stream.of(array, 1, 2);
        var arrayStream2 = Arrays.stream(array, 1, 10);
        show("From a part of an Array", arrayStream2);

        // Infinite streams [Method on Stream]
        var randomStream = Stream.generate(Math::random); // takes a Supplier
        show("Infinite streams", randomStream);

        // Infinite streams, constant [Method on Stream]
        var constantStream = Stream.generate(() -> "a"); // takes a Supplier
        show("Infinite streams, constant", constantStream);

        // Infinite streams, counting [Method on Stream]
        var countingStream = Stream.iterate(1, n -> n + 1); 
        show("Infinite streams, counting", countingStream);
        
        // Limit the size of an infinite stream, one way
        var countingStream2 = Stream.iterate(1, n -> n + 1).limit(5);
        show("Limit the size of an infinite stream", countingStream2);

        // Limit the size of an infinite stream, another way, 
        // using a Predicate, stream ends when the predicate returns false
        var countingStream3 = Stream.iterate(1,n -> n <= 5 ,n -> n + 1);
        show("Limit the size of an infinite stream, another way: ", countingStream3);

    }
}
