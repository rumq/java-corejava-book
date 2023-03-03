package pawarv;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 *  Using Function.identity() as value mapper
 * 
 *  Returns a function that always returns its input argument
 */
public class CollectingIntoMapsIdentity {
    public static void main(String[] args) {

        var names = List.of(new NameAddress("Adam", "Pune"),
                new NameAddress("Bella", "Mumbai"),
                new NameAddress("Charlie", "Chennai"));

        var mapNamePerson = names.stream()
                .collect(
                        Collectors.toMap(
                                NameAddress::name, Function.identity()));

        System.out.println(mapNamePerson);

    }
}

// record NameAddress(String name, String address) {
// };
