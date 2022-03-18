package mainModule;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
	
	public void outputFileSortedByName()
	{
		try 
		{
			File outSortByName = new File("C:\\SFC\\COP2552\\Project4\\SortByName.txt");
	
		    FileWriter outSortByNameWriter = new FileWriter("SortByName.txt");
		    //outSortByNameWriter.write(Logic.listOfHurricanes);
		    outSortByNameWriter.close();
		} catch (IOException e) 
		{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	public void outputFileSortedByCategory()
	{
		try 
		{
			File outSortByCategory = new File("C:\\SFC\\COP2552\\Project4\\SortByCategory.txt");
	
		    FileWriter outSortByCategoryWriter = new FileWriter("SortByCategory.txt");
		    //outSortByCategoryWriter.write(Logic.listOfHurricanes);
		    outSortByCategoryWriter.close();
		} catch (IOException e) 
		{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	public void outputFileSortedByYear()
	{
		try 
		{
			File outSortByYear = new File("C:\\SFC\\COP2552\\Project4\\SortByYear.txt");
	
		    FileWriter outSortByYearWriter = new FileWriter("SortByYear.txt");
		    //outSortByYearWriter.write(Logic.listOfHurricanes);
		    outSortByYearWriter.close();
		} catch (IOException e) 
		{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
	
	public void outputFileSortedByMonth()
	{
		try 
		{
			File outSortByMonth = new File("C:\\SFC\\COP2552\\Project4\\SortByMonth.txt");
	
		    FileWriter outSortByMonthWriter = new FileWriter("SortByMonth.txt");
		    //outSortByMonthWriter.write(Logic.listOfHurricanes);
		    outSortByMonthWriter.close();
		} catch (IOException e) 
		{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
}
