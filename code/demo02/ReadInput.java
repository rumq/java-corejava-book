package demo02;

import java.util.Scanner;

public class ReadInput {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = in.nextLine();

        System.out.println("What is your favorite color?");
        String favoriteColor = in.nextLine();

        System.out.println("What is your age?");
        int age = in.nextInt();


        System.out.println("Hello " + name + " is " + age + " years old and " + favoriteColor + " is your favorite color!");

    }
}
