package set;

import java.util.*;

/**
 * Procedure to run this program:
 * 1. Go to chapter v1ch09 ( Note, the based directory should match yours
 *    and use `\` instead of `/` on Windows)
 *    cd /home/vikram/git/java-corejava-book/book-code/corejava/v1ch09
 * 2. javac set/SetTest.java
 * 
 * 3. ( Note, the based directory should match yours
 *    and use `\` instead of `/` on Windows)
 *    And you are not on PowerShell. 
 * 
 * Results :
 * 
 *    java set.SetTest < '/home/vikram/git/java-corejava-book/book-code/corejava/gutenberg/alice30.txt'
 *        5909 distinct words. 45 milliseconds.               
 *    java set.SetTest < ../other/CountOfMonteCristo.txt 
 *        40032 distinct words. 532 milliseconds.* 
 * This program uses a set to print all unique words in System.in.
 * @version 1.12 2015-06-21
 * @author Cay Horstmann
 */
public class SetTest
{
   public static void main(String[] args)
   {
      var words = new HashSet<String>(); 
      long totalTime = 0;

      try (var in = new Scanner(System.in))      
      {
         while (in.hasNext())
         {
            String word = in.next();
            long callTime = System.currentTimeMillis();
            words.add(word);
            callTime = System.currentTimeMillis() - callTime;
            totalTime += callTime;
         }
      }

      Iterator<String> iter = words.iterator();
      for (int i = 1; i <= 20 && iter.hasNext(); i++)
         System.out.println(iter.next());
      System.out.println(". . .");
      System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");
   }
}
