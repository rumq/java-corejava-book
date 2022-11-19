package demo04;

import java.time.LocalDate;

public class LocalDateDemo {

    public static void main(String[] args) {
        
        
        // Using static factory method 'now'
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(date.plusDays(30));

        // Using 'of'
        System.out.println(LocalDate.of(1996, 1, 1));

    }
}
