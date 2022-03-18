package mainModule;

import java.io.IOException;

import javax.swing.JOptionPane;		// Dialog Box
//import java.util.StringTokenizer; // Array token

public class GUI {
	
	private float userChoiceOfActivity = 0;
	
	//GUI::GUI
	//Constructor
	public GUI()
	{
		
	}
	
	/************************************Methods
	 * @throws IOException *******************************/
	
	//MarkupCalculator:getUserInput
	//Get user input
	public void userOptions() throws IOException
	{
		Logic logic;
		float userChoiceOfActivity = 0;
		this.userChoiceOfActivity = userChoiceOfActivity;
		String inputUserChoiceOfActivity;
		
		// Prompt user to input activity number he wants to perform.
		inputUserChoiceOfActivity = JOptionPane.showInputDialog("Florida Major Hurricanes 1950-2020\n\n" + "Press 1 to Sort by Storm Name\n" + "Press 2 to Sort by Storm Category\n" + 
				"Press 3 to Sort by Storm Year\n" + "Press 4 to Sort by Storm Month\n" + "Press 5 to Display Average Storm Category\n" +
				"Press 6 to Display the Most Active Year\n" + "Press 7 to Display Total by Category\n" + "Press 8 to Display Total by Year\n" + "Press 9 to Exit");
		
		// User input validation
		while ((Float.parseFloat(inputUserChoiceOfActivity)) < 1 || (Float.parseFloat(inputUserChoiceOfActivity)) > 9)	
		{
			// Reprompt user to input activity number he want to perform.
			inputUserChoiceOfActivity = JOptionPane.showInputDialog("Enter a POSITIVE number between 1 and 9.");
		}
		
		userChoiceOfActivity = Float.parseFloat(inputUserChoiceOfActivity);			// Convert String input value to a float
		this.userChoiceOfActivity = userChoiceOfActivity;							// pass the value to global attribute userChoiceOfActivity
		
		if (this.userChoiceOfActivity == 1)
		{
			String inputUserSortChoice;
			// Prompt user to input sort option number ascending vs descending.
			inputUserSortChoice = JOptionPane.showInputDialog("Florida Major Hurricanes 1950-2020\n\n" + "Sort by Storm Name\n\n" + "Press 1 for Ascending Order\n" +
					"Press 2 for Descending Order\n");
			float userSortChoice = Float.parseFloat(inputUserSortChoice);
			
			while (userSortChoice != 1 && userSortChoice != 2)
			{
				inputUserSortChoice = JOptionPane.showInputDialog("Florida Major Hurricanes 1950-2020\n\n" + "Sort by Storm Name\n\n" + 
						"PLEASE enter either 1 or 2\n\n" + "Press 1 for Ascending Order\n" + "Press 2 for Descending Order\n");
			}
			logic = new Logic();
			if (userSortChoice == 1)
			{
				logic.driverSortedInputFileAscending();
			}else if (userSortChoice == 2)
			{
				logic.driverSortedInputFileDescending();
			}
			
		}else if (this.userChoiceOfActivity == 2)
		{
			String inputUserSortChoice;
			// Prompt user to input sort option number ascending vs descending.
			inputUserSortChoice = JOptionPane.showInputDialog("Florida Major Hurricanes 1950-2020\n\n" + "Sort by Storm Hurricane Category\n\n" + "Press 1 for Ascending Order\n" +
					"Press 2 for Descending Order\n");
			float userSortChoice = Float.parseFloat(inputUserSortChoice);
			
			while (userSortChoice != 1 && userSortChoice != 2)
			{
				inputUserSortChoice = JOptionPane.showInputDialog("Florida Major Hurricanes 1950-2020\n\n" + "Sort by Hurricane Category\n\n" + 
						"PLEASE enter either 1 or 2\n\n" + "Press 1 for Ascending Order\n" + "Press 2 for Descending Order\n");
			}
			
			if (userSortChoice == 1)
			{
				
			}else if (userSortChoice == 2)
			{
				
			}
		}else if (this.userChoiceOfActivity == 3)
		{
			String inputUserSortChoice;
			// Prompt user to input sort option number ascending vs descending.
			inputUserSortChoice = JOptionPane.showInputDialog("Florida Major Hurricanes 1950-2020\n\n" + "Sort by Hurricane Year\n\n" + "Press 1 for Ascending Order\n" +
					"Press 2 for Descending Order\n");
			float userSortChoice = Float.parseFloat(inputUserSortChoice);
			
			while (userSortChoice != 1 && userSortChoice != 2)
			{
				inputUserSortChoice = JOptionPane.showInputDialog("Florida Major Hurricanes 1950-2020\n\n" + "Sort by Hurricane Year\n\n" + 
						"PLEASE enter either 1 or 2\n\n" + "Press 1 for Ascending Order\n" + "Press 2 for Descending Order\n");
			}
			
			if (userSortChoice == 1)
			{
				
			}else if (userSortChoice == 2)
			{
				
			}
		}else if (this.userChoiceOfActivity == 4)
		{
			String inputUserSortChoice;
			// Prompt user to input sort option number ascending vs descending.
			inputUserSortChoice = JOptionPane.showInputDialog("Florida Major Hurricanes 1950-2020\n\n" + "Sort by Hurricane Month\n\n" + "Press 1 for Ascending Order\n" +
					"Press 2 for Descending Order\n");
			float userSortChoice = Float.parseFloat(inputUserSortChoice);
			
			while (userSortChoice != 1 && userSortChoice != 2)
			{
				inputUserSortChoice = JOptionPane.showInputDialog("Florida Major Hurricanes 1950-2020\n\n" + "Sort by Hurricane Month\n\n" + 
						"PLEASE enter either 1 or 2\n\n" + "Press 1 for Ascending Order\n" + "Press 2 for Descending Order\n");
			}
			
			if (userSortChoice == 1)
			{
				
			}else if (userSortChoice == 2)
			{
				
			}
		}else if (this.userChoiceOfActivity == 5)
		{
			
		}else if (this.userChoiceOfActivity == 6)
		{
			
		}else if (this.userChoiceOfActivity == 7)
		{
			
		}else if (this.userChoiceOfActivity == 8)
		{
			
		}else if (this.userChoiceOfActivity == 9)
		{
			System.exit(0);
		}
		
	}
	
	//Order of execution
	public void driver() 
	{
		try {
			userOptions();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
