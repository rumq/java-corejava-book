package pawarv;

import java.util.stream.Stream;

public class SubstreamTest {
    public static void main(String[] args) {

        // limit
        var firstTen = Stream
                .iterate(1, n -> n + 1)
                .limit(10)
                .toList();

        System.out.println("First ten: " + firstTen);

        // skip
        var skipFirst10 = Stream
                .iterate(1, n -> n + 1)
                .skip(1000)
                .limit(10)  // required, otherwise it will print infinite stream
                .toList();
        System.out.println("Skip first 10: " + skipFirst10);

        // takeWhile
        var hundredRandomNumbers = Stream
                .generate(Math::random)
                .map(n -> (int) (n * 10))
                .limit(100)
                .toList();

        System.out.println(hundredRandomNumbers);
        var takeWhileList = hundredRandomNumbers.stream()
                .takeWhile(n -> n <= 8)
                .toList();
        System.out.println("Size of takeWhileList: " + takeWhileList.size());
        System.out.println("takeWhileList: " + takeWhileList);
        

        // dropWhile (does the opposite)
        var dropWhileList = hundredRandomNumbers
                .stream()
                .dropWhile(n -> n <=8)
                .toList();
        System.out.println("Size of dropWhileList: " + dropWhileList.size());
        System.out.println("dropWhileList:" + dropWhileList);

        // concat 
        var concatList = Stream.concat(
            hundredRandomNumbers.stream().takeWhile(n -> n <=8).limit(100),
            hundredRandomNumbers.stream().dropWhile(n -> n <=8)).toList();
        System.out.println("Size of concatList: " + concatList.size());
        System.out.println("concatLis: " + concatList);            

    }
}
