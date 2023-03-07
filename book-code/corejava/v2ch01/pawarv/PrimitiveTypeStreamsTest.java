package pawarv;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveTypeStreamsTest {
    public static void main(String[] args) {

        var numbers = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        // IntStream ~~> Stream<int> (primitive type)
        IntStream numbersIntStream = numbers.stream()
                .mapToInt(Integer::parseInt);
        show("numbersIntStream", numbersIntStream);

        // Stream<Integer>
        Stream<Integer> numbersStream = numbers.stream()
                .map(Integer::parseInt);
        show("numbersStream", numbersStream);

        // Get Stream<Integer> from IntStream
        Stream<Integer> numbersStreamBoxed = numbers.stream()
                .mapToInt(Integer::parseInt)
                .boxed();
        show("numbersStreamBoxed", numbersStreamBoxed);

        // Stream<Integer> numbersStreamBoxed = numbersIntStream.boxed();
        // show("numbersStreamBoxed", numbersStreamBoxed.mapToInt(Integer::intValue));

        // generate
        IntStream is1 = IntStream.generate(() -> (int) (Math.random() * 100));
        show("is1", is1);

        // range
        IntStream is2 = IntStream.range(5, 10);
        show("is2", is2);

        // rangeClosed

        IntStream is3 = IntStream.rangeClosed(5, 10);
        show("is3", is3);

        var rand = new Random();

        IntStream randInts = rand.ints()
                .limit(10);
        show("randInts", randInts);

        LongStream randLongs = rand.longs()
                .limit(10);
        System.out.println("randLongs: ");
        randLongs.forEach(System.out::println);

        // array
        int[] arr = numbers.stream().mapToInt(Integer::parseInt).toArray();
        for (int i : arr) {
            System.out.print(i + " ");
        }

        // sum
        int sum = numbers.stream().mapToInt(Integer::parseInt).sum();
        System.out.println("sum: " + sum);

        // sum of empty IntStream
        int emptySum = numbers.stream().mapToInt(Integer::parseInt).filter(i -> i > 10).sum();
        System.out.println("emptySum: " + emptySum);

        // average
        double avg = numbers.stream().mapToInt(Integer::parseInt).average().getAsDouble();
        System.out.println("avg: " + avg);

        // min
        int min = numbers.stream().mapToInt(Integer::parseInt).min().getAsInt();
        System.out.println("min: " + min);

        // max

        int max = numbers.stream().mapToInt(Integer::parseInt).max().getAsInt();
        System.out.println("max: " + max);

        // count
        long count = numbers.stream().mapToInt(Integer::parseInt).count();
        System.out.println("count: " + count);

        // summaryStatistics
        IntSummaryStatistics stats = numbers.stream()
                .mapToInt(Integer::parseInt)
                .summaryStatistics();
        System.out.println("stats: " + stats);
        System.out.println(stats.getSum());
        System.out.println(stats.getAverage());
        System.out.println(stats.getMax());
        System.out.println(stats.getMin());

        // distinct
        IntStream is4 = IntStream.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        show("is4", is4.distinct());

        // filter
        IntStream is5 = IntStream.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        show("is5", is5.filter(x -> x % 2 == 0));

        // map
        IntStream is6 = IntStream.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        show("is6", is6.map(x -> x * x));

        // DoubleStream
        DoubleStream ds1 = DoubleStream.generate(() -> Math.random());
        ds1.limit(10).forEach(System.out::println);

        // LongStream
        LongStream ls1 = LongStream.generate(() -> (long) (Math.random() * 100));
        ls1.limit(10).forEach(System.out::println);

        // Stream<Long>
        Stream<Long> ls2 = LongStream.generate(() -> (long) (Math.random() * 100)).boxed();
        ls2.limit(10).forEach(System.out::println);

        // Stream<Double>
        Stream<Double> ds2 = DoubleStream.generate(() -> Math.random()).boxed();
        ds2.limit(10).forEach(System.out::println);

        // Boolean (No primitive type stream for Boolean)
        Stream<Boolean> bs1 = Stream.generate(() -> Math.random() > 0.5);
        bs1.limit(10).forEach(System.out::println);

    }

    public static void show(String title, IntStream stream) {
        final int SIZE = 10;
        int[] firstElements = stream.limit(SIZE + 1).toArray();
        System.out.print(title + ": ");
        for (int i = 0; i < firstElements.length; i++) {
            if (i > 0)
                System.out.print(", ");
            if (i < SIZE)
                System.out.print(firstElements[i]);
            else
                System.out.print("...");
        }
        System.out.println();
    }

    public static <T> void show(String title, Stream<T> stream) {
        final int SIZE = 10;
        List<T> firstElements = stream
                .limit(SIZE + 1)
                .toList();
        System.out.print(title + ": ");
        for (int i = 0; i < firstElements.size(); i++) {
            if (i > 0)
                System.out.print(", ");
            if (i < SIZE)
                System.out.print(firstElements.get(i));
            else
                System.out.print("...");
        }
        System.out.println();
    }
}
