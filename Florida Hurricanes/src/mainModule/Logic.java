package mainModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Logic {
	private String stName;
	private int intCat;
	private int intMonth;
	private int intDay;
	private int intYear;
	
	
	ArrayList<Hurricane> listOfHurricanes;
	WriteToFile writeToFile;

	public void readInInputFile() throws IOException
	{
	    // path to the inputFile
	    File inputFile = new File("NamedFloridaHurricanes.txt");	// alternative way*** "C:\\SFC\\COP2552\\Project4\\NamedFloridaHurricanes.txt"
	    Scanner scaner = new Scanner(inputFile);
	    listOfHurricanes = new ArrayList<Hurricane>();
	    
	    while (scaner.hasNextLine())
	    {
	    	String line = scaner.nextLine();		//read in next line from input file (1st line on 1st iteration)
	    	String[] array1 = line.split(",");		//splits storm data into name and rest
			this.stName = array1[0];			    //holds the name of storm
			String[] array2 = array1[1].split(":");	//splits rest of storm data  into category and date
			String category = array2[0];			//holds the category of storm
			String[] array3 = array2[1].split("/");	//splits the date into month, day, and year
			String mm = array3[0];					//holds the category of storm
			String dd = array3[1];					//holds the category of storm
			String yyyy = array3[2];				//holds the category of storm
			
			this.intCat = Integer.parseInt(category);
			this.intMonth = Integer.parseInt(mm);
			this.intDay = Integer.parseInt(dd);
			this.intYear = Integer.parseInt(yyyy);
	    	
			Hurricane tempData = new Hurricane(this.stName, this.intCat, this.intMonth, this.intDay, this.intYear);   //temporary holder for 1 line(1 hurricane data)
			listOfHurricanes.add(tempData);		//add tempData to ArrayList listOfHurricanes
			
	    }
	    scaner.close();
		
	    
	}
	
/*
	public class Hurricane implements Comparable<Hurricane>
	{
		String stName;
		int intCat;
		int intMonth;
		int intDay;
		int intYear;
		Hurricane(String stName, int intCat, int intMonth, int intDay, int intYear)
		{
			this.stName = stName;
			this.intCat = intCat;
			this.intMonth = intMonth;
			this.intDay = intDay;
			this.intYear = intYear;
		}
		 
		@Override
		public int compareTo(Hurricane listOfHurricanes)
		{
			// we sort objects on the basis of Hurricane Category
			return (this.intCat - listOfHurricanes.intCat);
		}
	}
*/

	
	//Logic::sortInputFileAscending
	// Sort input file in ascending order (a-z)
	public void sortInputFileAscending()
	{
		Collections.sort(listOfHurricanes);
		JOptionPane.showInputDialog("Florida Major Hurricanes 1950-2020\n\n" + "Sort by Storm Name in Ascending order\n\n" + "Name\tCategory\tDate" + listOfHurricanes);
		System.out.println("Content of ArrayLiList Ascending:"); 
		System.out.println(listOfHurricanes);
	}
	
	//Logic::sortInputFileDescending
	// Sort input file in descending order (z-a)
	public void sortInputFileDescending()
	{
		//ArrayList<Hurricane> sortHurricaneNameDescending = new ArrayList<Hurricane>();
		//sortHurricaneNameDescending = Collections.sort(listOfHurricanes, Collections.reverseOrder());
		Collections.sort(listOfHurricanes, Collections.reverseOrder());
		JOptionPane.showInputDialog("Florida Major Hurricanes 1950-2020\n\n" + "Sort by Storm Name in Desscending order\n\n" + "Name\tCategory\tDate" + listOfHurricanes);
		System.out.println("Content of ArrayLiList reverse:"); 
		System.out.println(listOfHurricanes);
	}
	
	public void driverSortedInputFileAscending() throws IOException
	{
		readInInputFile();
		sortInputFileAscending();
		//writeToFile.outputFileSortedByName();
		
	}
	
	public void driverSortedInputFileDescending() throws IOException
	{
		readInInputFile();
		sortInputFileDescending();
		//writeToFile.outputFileSortedByName();
	}
	
	//Hurricane::totalByCategory
	//find total by category
	public void totalByCategory(ArrayList<Hurricane> listOfHurricanes)	//window 7
	{
		ArrayList<Integer> years = new ArrayList<Integer>();
		int[][] totals = new int[years.size()][2];
		for (int i = 0; i < listOfHurricanes.size(); i++)
		{
			int tempCategory = listOfHurricanes.get(i).getCat();
			boolean found = false;
			for (int j = 0; j < years.size(); j++)
			{
				if (tempCategory == years.get(i))
				{
					found = true;
					break;
				}else
				{
					found = false;
				}
			}
		
			if (found)
			{
				continue;
			}else
			{
				years.add(tempCategory);
			}
		}
		
		for (int i = 0; i < years.size(); i++)
		{
			totals[i][0] = years.get(i);
			int sum = 0;
			for (int j = 0; j < listOfHurricanes.size(); j++)
			{
				if (listOfHurricanes.get(i).getCat() == totals[i][0])
				{
					sum++;
				}
			}
			totals[i][1] = sum;
		}
	}
	
	
	
}
