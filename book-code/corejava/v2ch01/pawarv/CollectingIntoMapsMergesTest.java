package pawarv;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CollectingIntoMapsMergesTest {
    public static void main(String[] args) {

        var nameAddresses = List.of(
                new NameAddress("Peter", "Pune"),
                new NameAddress("Paul", "Mumbai"),
                new NameAddress("Mary", "Pune"),
                new NameAddress("Peter", "Mumbai"),
                new NameAddress("Paul", "Pune"),
                new NameAddress("Mary", "Mumbai"),
                new NameAddress("Eve", "Pune"),
                new NameAddress("Eve", "Mumbai"),
                new NameAddress("Eve", "Hyderabad"));

        // a) key mapper, value mapper
        try {
            var nameToAddress = nameAddresses.stream()
                    .collect(Collectors.toMap(
                            nameAddress -> nameAddress.name(), // key mapper
                            nameAddress -> nameAddress.address())); // value mapper
            System.out.println(nameToAddress);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        // b) key mapper, value mapper, merge function
        // merge function simply returns the existing value
        var nameToAddress2 = nameAddresses.stream()
                .collect(Collectors.toMap(
                        NameAddress::name, // key mapper
                        NameAddress::address, // value mapper
                        (existingValue, newValue) -> existingValue)); // merge function
        System.out.println("nameAddress2 : " + nameToAddress2);

        // c) mapper concatenating the values
        var nameToAddress3 = nameAddresses.stream()
                .collect(Collectors.toMap(
                        NameAddress::name, // key mapper
                        NameAddress::address, // value mapper
                        (existingValue, newValue) -> existingValue + ", " + newValue)); // merge function
        // String::concat)); // merge function
        System.out.println("nameAddress3 : " + nameToAddress3);

        // d) mapper creating a union of addresses as values
        var nameToAddress4 = nameAddresses.stream()
                .collect(Collectors.toMap(
                        elem -> elem.name(), // key mapper
                        // singleton returns an immutable set containing only the specified object.
                        elem -> Collections.singleton(elem.address()), // value mapper, singleton set (immutable), 
                        (a, b) -> { // merge function
                            var union = new HashSet<String>(a);
                            union.addAll(b);
                            return union;
                        })); // merge function
        System.out.println("nameAddress4 : " + nameToAddress4);

        // e) mapper creating a union of NameAddress objects as values
        var nameToAddress5 = nameAddresses.stream()
                .collect(Collectors.toMap(
                        elem -> elem.name(), // key mapper
                        elem -> Collections.singleton(elem), // value mapper
                        (a, b) -> { // merge function
                            var union = new HashSet<NameAddress>(a);
                            union.addAll(b);
                            return union;
                        })); // merge function
        System.out.println("nameAddress5 : " + nameToAddress5);

    }

}
