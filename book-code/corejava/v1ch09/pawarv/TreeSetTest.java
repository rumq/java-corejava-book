package pawarv;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * 
 * This program uses a tree set to print all unique words in System.in.
 * 1. cd book-code/corejava/v1ch09
 * 2. javac pawarv/TreeSetTest.java
 * 3. java pawarv.TreeSetTest  < ../other/CountOfMonteCristo.txt
 * 
 * 
 *  Results:
 *  java pawarv.TreeSetTest  < ../gutenberg/alice30.txt
 *       5909 distinct words. 38 milliseconds.
 *  java pawarv.TreeSetTest  < ../other/CountOfMonteCristo.txt
 *       40032 distinct words. 579 milliseconds. [ seen above 605]
 */

public class TreeSetTest {
    
    public static void main(String[] args) {
        var words = new TreeSet<String>();
        long totalTime = 0;

        try(var in = new Scanner(System.in)) {
            while(in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }
        

        Iterator<String> iter = words.iterator();
        for(int i = 1; i <= 20 && iter.hasNext(); i++) {
            System.out.println(iter.next());
        }

        System.out.println(". . .");
        System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");
    }
}
