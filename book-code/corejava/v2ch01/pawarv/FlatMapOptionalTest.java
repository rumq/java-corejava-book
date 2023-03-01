package pawarv;

import java.util.Optional;

/*
 *  Demonstrates how to use flatMap() to avoid NullPointerExceptions
 * 
 */
public class FlatMapOptionalTest {
    public static void main(String[] args) {

        // Cupboard has a safe which has box which has gold earrings
        // 1. Without optionals
        // 1.a  Box is not empty
        Box box = new Box("Gold Earrings");
        Safe safe = new Safe(box);
        Cupboard cupboard = new Cupboard(safe);
        String name = cupboard.getSafe().getBox().getName();
        System.out.println(name.toUpperCase());

        // 1.b Box is empty
        Box box1 = new Box();
        Safe safe1 = new Safe(box1);
        Cupboard cupboard1 = new Cupboard(safe1);
        String name1 = cupboard1.getSafe().getBox().getName();
        // System.out.println(name1.toUpperCase()); // NullPointerException

        // 2. With optionals

        // 2.a Box is not empty
        Box box2 = new Box("Gold Earrings");
        Safe safe2 = new Safe(box2);
        Cupboard cupboard2 = new Cupboard(safe2);
        Optional<String> name2 = cupboard2.getSafeOptional()
                .flatMap(Safe::getBoxOptional)
                .flatMap(Box::getNameOptional);

        name2.ifPresent((String s) -> {
            System.out.println(s.toUpperCase());
        });

        // 2.b Box is empty
        Box box3 = new Box();
        Safe safe3 = new Safe();
        Cupboard cupboard3 = new Cupboard();
        Optional<String> name3 = cupboard3.getSafeOptional()
                .flatMap(Safe::getBoxOptional)
                .flatMap(Box::getNameOptional);

        // Can do this, it won't throw a NullPointerException
        name3.ifPresent(System.out::println);

        name3.ifPresentOrElse((String s) -> {
            System.out.println(s.toUpperCase());
        }, () -> {
            System.out.println("Box is empty");
        });

    }

}

class Cupboard {
    private Safe goldSafe;

    Cupboard() {
    }

    Cupboard(Safe goldSafe) {
        this.goldSafe = goldSafe;
    }

    Safe getSafe() {
        return goldSafe;
    }

    Optional<Safe> getSafeOptional() {
        return Optional.ofNullable(goldSafe);
    }

}

class Box {
    String name;

    Box() {
    }

    Box(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    Optional<String> getNameOptional() {
        return Optional.ofNullable(name);
    }

}

class Safe {

    Box jewelleryBox;

    Safe() {
    }

    Safe(Box jewelleryBox) {
        this.jewelleryBox = jewelleryBox;
    }

    Box getBox() {
        return jewelleryBox;
    }

    Optional<Box> getBoxOptional() {
        return Optional.ofNullable(jewelleryBox);
    }

}
