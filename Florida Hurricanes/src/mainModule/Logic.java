package mainModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Logic {

  public static final String FILEPATH = "NamedFloridaHurricanes.txt";
  protected static List<Hurricane> listOfHurricanes;
  protected static String lastSort;
  protected static String sortOrder;

  public static void readInInputFile() throws IOException {
    // path to the inputFile
    Scanner scanner = new Scanner(new File(FILEPATH));
    listOfHurricanes = new ArrayList<Hurricane>();

    // Declare components outside of the for loop for performance boost
    String[] row, rowComponents;
    String stormName, rawCategory, rawMonth, rawDay, rawYear;
    int category, month, day, year;

    while (scanner.hasNextLine()) {
      // Deserialize <NAME>,<CATEGORY>:<MM>/<DD>/<YYYY> into a Hurricane class

      row = scanner.nextLine().split(","); // read in next line from input file (1st line on 1st iteration)
      stormName = row[0]; // holds the name of storm
      rowComponents = row[1].split(":"); // splits rest of storm data into category and date
      rawCategory = rowComponents[0]; // holds the category of storm
      rowComponents = rowComponents[1].split("/"); // splits the date into month, day, and year
      rawMonth = rowComponents[0]; // holds the category of storm
      rawDay = rowComponents[1]; // holds the category of storm
      rawYear = rowComponents[2]; // holds the category of storm

      category = Integer.parseInt(rawCategory);
      month = Integer.parseInt(rawMonth);
      day = Integer.parseInt(rawDay);
      year = Integer.parseInt(rawYear);

      listOfHurricanes.add(new Hurricane(stormName, category, month, day, year));
    }
    scanner.close();
  }

  public static void sortHurricanesBy(String attributeCode) {
    sortHurricanesBy(attributeCode, true);
  }

  public static void sortHurricanesBy(String attributeCode, boolean ascendingOrder) {
    Collections.sort(listOfHurricanes, new Hurricane.HurricaneComparator(attributeCode));
    lastSort = attributeCode;

    if (!ascendingOrder) {
      Collections.reverse(listOfHurricanes);
      sortOrder = "Descending";
    } else {
      sortOrder = "Ascending";
    }
  }

  public static List<String> serializeHurricanes() {
    List<String> serializedText = new ArrayList<String>();

    serializedText.add("Florida Major Hurricanes 1950 - 2020");
    serializedText.add("\n\n");
    serializedText.add(String.format("Sort by %s in %s Order %n %n", lastSort, sortOrder));

    for (Hurricane hurricane : listOfHurricanes) {
      serializedText.add(
        String.format(
        		"%s %s %d-%d-%d %n",
        		hurricane.getStormName(), hurricane.getCategory(),
        		hurricane.getMonth(), hurricane.getDay(), hurricane.getYear()
        		)
      ); 
    }
    //"|%10d|", 101;  // Specifying length of integer  

    return serializedText;
  }

  public static double averageCategory() {
    double total = 0;
    for (Hurricane hurricane : listOfHurricanes) {
      total += hurricane.getCategory();
    }
    return total / listOfHurricanes.size();
  }

  public static List<Integer> mostActiveYears() {
    Map<Integer, Integer> yearAggregation = aggregateByYear();
    List<Integer> topYears = new ArrayList<Integer>();

    int count, maxCount = 0;
    for (Integer year : yearAggregation.keySet()) {
      count = yearAggregation.get(year);
      if (count > maxCount) {
        topYears.clear();
        maxCount = count;
      }

      if (count == maxCount) {
        topYears.add(year);
      }
    }

    return topYears;
  }

  public static int mostActiveYearCount() {
    Map<Integer, Integer> yearAggregation = aggregateByYear();
    int maxCount = 0;
    for (Integer count : yearAggregation.values()) {
      if (count > maxCount) {
        maxCount = count;
      }
    }
    return maxCount;
  }

  public static int[] aggregateByCategory() {
    int[] categories = new int[5];

    for (Hurricane hurricane : listOfHurricanes) {
      categories[hurricane.getCategory() - 1]++;
    }

    return categories;

  }

  public static Map<Integer, Integer> aggregateByYear() {
    Map<Integer, Integer> yearAggregation = new HashMap<Integer, Integer>();

    int year;

    for (Hurricane hurricane : listOfHurricanes) {
      year = hurricane.getYear();
      yearAggregation.putIfAbsent(year, 0);
      yearAggregation.put(year, yearAggregation.get(year) + 1);
    }

    return yearAggregation;
  }

}
