package collecting;

import static java.util.stream.Collectors.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

/**
 * @version 1.01 2021-09-06
 * @author Cay Horstmann
 */
public class DownstreamCollectors
{
   private static final String CITIES_TXT = "book-code/corejava/v2ch01/cities.txt";

   public record City(String name, String state, int population) {}

   public static Stream<City> readCities(String filename) throws IOException
   {
      return Files.lines(Path.of(filename))
         .map(l -> l.split(", "))
         .map(a -> new City(a[0], a[1], Integer.parseInt(a[2])));
   }

   public static void main(String[] args) throws IOException
   {
      Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
      Map<String, Set<Locale>> countryToLocaleSet = locales.collect(groupingBy(
         Locale::getCountry, toSet()));
      System.out.println("countryToLocaleSet: " + countryToLocaleSet);

      locales = Stream.of(Locale.getAvailableLocales());
      Map<String, Long> countryToLocaleCounts = locales.collect(groupingBy(
         Locale::getCountry, counting()));
      System.out.println("countryToLocaleCounts: " + countryToLocaleCounts);

      Stream<City> cities = readCities(CITIES_TXT);
      Map<String, Integer> stateToCityPopulation = cities.collect(groupingBy(
         City::state, summingInt(City::population)));
      System.out.println("stateToCityPopulation: " + stateToCityPopulation);

      cities = readCities(CITIES_TXT);
      Map<String, Optional<String>> stateToLongestCityName = cities
         .collect(groupingBy(City::state,
            mapping(City::name, maxBy(Comparator.comparing(String::length)))));
      System.out.println("stateToLongestCityName: " + stateToLongestCityName);

      locales = Stream.of(Locale.getAvailableLocales());
      Map<String, Set<String>> countryToLanguages = locales.collect(groupingBy(
         Locale::getDisplayCountry, mapping(Locale::getDisplayLanguage, toSet())));
      System.out.println("countryToLanguages: " + countryToLanguages);

      cities = readCities(CITIES_TXT);
      Map<String, IntSummaryStatistics> stateToCityPopulationSummary = cities
         .collect(groupingBy(City::state, summarizingInt(City::population)));
      System.out.println(stateToCityPopulationSummary.get("NY"));

      cities = readCities(CITIES_TXT);
      Map<String, String> stateToCityNames = cities.collect(groupingBy(
         City::state,
         reducing("", City::name, (s, t) -> s.length() == 0 ? t : s + ", " + t)));

      cities = readCities(CITIES_TXT);
      stateToCityNames = cities.collect(groupingBy(City::state,
         mapping(City::name, joining(", "))));
      System.out.println("stateToCityNames: " + stateToCityNames);

      cities = readCities(CITIES_TXT);
      record Pair<S, T>(S first, T second) {}
      Pair<List<String>, Double> result = cities.filter(c -> c.state().equals("NV"))
         .collect(teeing(
            mapping(City::name, toList()),
            averagingDouble(City::population),
            (names, avg) -> new Pair<>(names, avg)));
      System.out.println(result);
   }
}
