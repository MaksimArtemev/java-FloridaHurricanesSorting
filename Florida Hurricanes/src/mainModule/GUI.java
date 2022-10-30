//Written By Maksim Artemev

package mainModule;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane; // Dialog Box


public class GUI {
  // GUI::GUI
  // Constructor
  public GUI() {

  }

  /**
   * Helper that asks the user to type in 1 if they want ascending order, or 2
   * if they want descending order. Given the prompt
   * 
   * @return True if the user wants to sort the list in ascending order
   */
  protected boolean getSortOrder(String prompt) {
    return true; 
  }

  /**
   * Dialogue box that outputs a Jformatted text of data
   * 
   * @param category
   * @param ascendingOrder
   * @param linesToPrint
   */
  protected void hurricaneDataDialogueBox(List<String> linesToPrint) {
	  JOptionPane.showInputDialog(linesToPrint);
  }

  /**
   * Menu option 1
   */
  protected void outputHurricanesByStormName() {
    boolean sortOrder = getSortOrder("Sort by Hurricane Name");
    Logic.sortHurricanesBy("name", sortOrder);
    List<String> hurricaneData = Logic.serializeHurricanes();
    WriteToFile.writeToFile("SortByName.txt", hurricaneData);
    hurricaneDataDialogueBox(hurricaneData);
  }

  /**
   * Menu option 2
   */
  protected void outputHurricanesByStormCategory() {
    boolean sortOrder = getSortOrder("Sort by Hurricane Category");
    Logic.sortHurricanesBy("category", sortOrder);
    List<String> hurricaneData = Logic.serializeHurricanes();
    WriteToFile.writeToFile("SortByCategory.txt", hurricaneData);
    hurricaneDataDialogueBox(hurricaneData);
  }

  /**
   * Menu option 3
   */
  protected void outputHurricanesByStormYear() {
    boolean sortOrder = getSortOrder("Sort by Hurricane Year");
    Logic.sortHurricanesBy("year", sortOrder);
    List<String> hurricaneData = Logic.serializeHurricanes();
    WriteToFile.writeToFile("SortByYear.txt", hurricaneData);
    hurricaneDataDialogueBox(hurricaneData);
  }

  /**
   * Menu option 4
   */
  protected void outputHurricanesByStormMonth() {
    boolean sortOrder = getSortOrder("Sort by Hurricane Month");
    Logic.sortHurricanesBy("month", sortOrder);
    List<String> hurricaneData = Logic.serializeHurricanes();
    WriteToFile.writeToFile("SortByMonth.txt", hurricaneData);
    hurricaneDataDialogueBox(hurricaneData);
  }

  /**
   * Menu option 5
   */
  protected void showAverageCategory() {
    double averageCategory = Logic.averageCategory();

    // Show dialogue box:
    // Average Storm Category by Saffir-Simpson Scale
    // Average storm category is: averageCategory
    JOptionPane.showInputDialog("Major Florida Hurricanes 1950-2020\n\n" + "Average Storm Category by Saffir-Simpson Scale\n\n" +
    		"Average storm category is: " + averageCategory);

  }

  /**
   * Menu option 6
   */
  protected void showMostActiveYear() {
    List<Integer> mostActiveYears = Logic.mostActiveYears();
    int stormCount = Logic.mostActiveYearCount();

    if (mostActiveYears.size() == 1) {
        // Show dialogue box:
        // Most Active Year
        // Most active storm year is {mostActiveYears.get(0)}
        // having {stormCount} named storms
    	JOptionPane.showInputDialog("Major Florida Hurricanes 1950-2020\n\n" + "Most Active Year\n\n" + "Most active storm year is tied with " +
    			 mostActiveYears.get(0) + "\n and " + mostActiveYears.get(1) + " each having " + stormCount + "named storms");
    } else if (mostActiveYears.size() == 2) {   //???????????????????????????????????????????????????????
      // Show dialogue box:
      // Most Active Year
      // Most active storm year is tied with {mostActiveYears.get(0)}
      // and {mostActiveYears.get(1)} each having {stormCount} named storms
    	JOptionPane.showInputDialog("Major Florida Hurricanes 1950-2020\n\n" + "Most Active Year\n\n" + "Most active storm year is tied with " +
   			 mostActiveYears.get(0) + "\n and " + mostActiveYears.get(1) + " each having " + stormCount + "named storms");
    } //else {
      
    //}
  }

  /**
   * Menu option 7
   */
  protected void showAggregateByCategory() {
    int[] categoryTotals = Logic.aggregateByCategory();
    int totalStorms = 0;
    for (int count : categoryTotals) {
      totalStorms += count;
    }

    // Show dialogue box:
    // Aggregate Totals by category (Saffir-Simpson scale)
    // Total number of major hurricanes listed: {totalStorms}

    // Total category 5 hurricanes: {categoryTotals[4]}
    // ...
    // Total category 1 hurricanes: {categoryTotals[0]}
	JOptionPane.showInputDialog("Major Florida Hurricanes 1950-2020\n\n" + "Aggregate Totals by category (Saffir-Simpson scale)\n\n" + "Total number of major hurricanes listed: " +
			totalStorms + "\n\n Total category 5 hurricanes:  " + categoryTotals[4] + "\nTotal category 4 hurricanes: " + categoryTotals[3] + "\nTotal category 3 hurricanes: " + categoryTotals[2] +
			"\nTotal category 2 hurricanes: " + categoryTotals[1] + "\nTotal category 1 hurricanes: " + categoryTotals[0]);

  }

  /**
   * Menu option 8
   */
  protected void showAggregateByYear() {
    Map<Integer, Integer> yearAggregations = Logic.aggregateByYear();

    // Show dialogue box:

    // Aggregate Totals by Year
    // Year \t Number of Storms

    Integer stormCount;
    for (Integer year : yearAggregations.keySet()) {
      stormCount = yearAggregations.get(year);

      // dialogue: {year} \t {stormCount}
  	JOptionPane.showInputDialog("Major Florida Hurricanes 1950-2020\n\n" + "Aggregate Totals by Year\n\n" + "Year\t Number of Storms\n" + year + "\t " + stormCount);
    }
  }

  protected int mainMenu() {
    
	  // Prompt user to input activity number he wants to perform.
    String rawUserChoice = JOptionPane.showInputDialog("Florida Major Hurricanes 1950-2020\n\n"
        + "Press 1 to Sort by Storm Name\n" + "Press 2 to Sort by Storm Category\n" +
        "Press 3 to Sort by Storm Year\n" + "Press 4 to Sort by Storm Month\n"
        + "Press 5 to Display Average Storm Category\n" +
        "Press 6 to Display the Most Active Year\n" + "Press 7 to Display Total by Category\n"
        + "Press 8 to Display Total by Year\n" + "Press 9 to Exit");

    // User input validation
    int userChoice = -1;

    try {
      userChoice = Integer.parseInt(rawUserChoice);
    } catch (NumberFormatException e) {
      userChoice = -1;
    }

    while (userChoice < 1 || userChoice > 9) {
      // Reprompt user to input activity number he wants to perform.
      rawUserChoice = JOptionPane.showInputDialog("Enter a POSITIVE number between 1 and 9.");
      userChoice = Integer.parseInt(rawUserChoice);
    }

    return userChoice;
  }

  // MarkupCalculator:getUserInput
  // Get user input
  public void run() throws IOException {
	  boolean run = true;
	  int userChoice = mainMenu();
	  
      while(userChoice != 9)
      {
    	  
    	  
          switch (userChoice) {
	          case (1):
	        	  outputHurricanesByStormName();
	            break;
	          case (2):
	            outputHurricanesByStormCategory();
	            break;
	          case (3):
	            outputHurricanesByStormYear();
	            break;
	          case (4):
	            outputHurricanesByStormMonth();
	            break;
	          case (6):
	            showAverageCategory();
	            break;
	          case (7):
	            showAggregateByCategory();
	            break;
	          case (8):
	            showAggregateByYear();
	            break;
          }
          mainMenu();
          userChoice = mainMenu();
      }
      System.exit(0);
  }

  // Order of execution
  public void driver() {
    try {
    	Logic.readInInputFile();
    	run();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
