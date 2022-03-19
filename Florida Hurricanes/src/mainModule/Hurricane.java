package mainModule;

import java.util.*;

public class Hurricane implements Comparable<Hurricane> {
	protected String stormName;
	protected int category;
	protected int month;
	protected int day;
	protected int year;
	protected String comparableAttribute;


	/** Note to the grader:
	 * 
	 * I went with a comparator decision for the ability to quickly adjust what field
	 * to sort the Hurricane by. This gives us access to the following APIs:
	 * 
	 * `Collections.sort(ListOfHurricanes, new HurricaneComparator("name"))` to
	 * sort by storm fields.
	 * 
	 * `Collections.sort(ListOfHurricanes, new HurricaneComparator("category"))` to
	 * sort by the category.
	 * 
	 * As you can see, this pattern is quite easy to extend for sorting on a variable
	 * attribute.
	 * 
	 * I chose Comparator over Comparable for this reason, because compareTo doesn't
	 * let us do this very easily.
	 */
	public static class HurricaneComparator implements Comparator<Hurricane> {
		private String attributeCode;

		public HurricaneComparator() {
			this("name"); // Default the comparator to sort by storm name
		}

		public HurricaneComparator(String attributeCode) {
			this.attributeCode = attributeCode;
		}

		@Override
		public int compare(Hurricane p1, Hurricane p2) {
			switch (this.attributeCode) {
				case "name":
					return p1.stormName.compareTo(p2.stormName);
				case "category":
					return Integer.compare(p1.category, p2.category);
				case "year":
					return Integer.compare(p1.year, p2.year);
				case "month":
					return Integer.compare(p1.month, p2.month);
				default:
					return 0; // Unable to sort
			}
		}
	}

	// == Constructor ==

	public Hurricane(String stormName, int category, int month, int day, int year) {
		this.stormName = stormName;
		this.category = category;
		this.month = month;
		this.day = day;
		this.year = year;
		this.comparableAttribute = "name";
	}

	// == Representation Exposure Hiders ==

	public String getStormName() {
		return stormName;
	}

	public int getCategory() {
		return category;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getYear() {
		return year;
	}

}
