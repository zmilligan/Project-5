import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class is used to get the station IDs from the file and store them in an arrayList. 
 * @author Zandi
 * @version 04-23-19
 */
public class HammingDist
{
	/**
	 * ArrayList to hold the IDs of the other stations
	 */
	private ArrayList<String> cities;
	
	/**
	 * The name of the file to be read.
	 */
	private String filename = "Mesonet.txt";
	
	/**
	 * The number of cities to be read in from the above file.
	 */
	private final int NUM_CITIES = 120;
	
	/**
	 * Constructor for the MesoEqual object. It initializes StID and reads an ArrayList in to initialize cities.
	 * @param StID String the Station ID
	 */
	public HammingDist()
	{		
		//ensures no issues with reading the file
		try
    	{
    		readFile();
    	}
    	catch(IOException e)
    	{
    		System.out.println("Error reading from file!\n");
    		e.printStackTrace();
    	}
	}
	
	
	/**
	 * This method reads from the file and saves the abbreviated city names into the cities ArrayList
	 * 
	 * @throws IOException Throw this exception if a major issue with the file occurs.
	 */
	private void readFile() throws IOException
	{
		cities = new ArrayList<String>(NUM_CITIES);	
		Scanner scnr = new Scanner(new FileReader(filename));
		        
		// read in the first three unimportant lines
		scnr.nextLine();
		scnr.nextLine();
		scnr.nextLine();
		
		while(scnr.hasNext())
		{
		   	cities.add(scnr.next());
		   	scnr.nextLine();
		}
		
		// close reader
		scnr.close();
	}
	
	/**
	 * This method finds the hamming distances between the given city and all other cities in the file. It saves those distances in
	 * an int array
	 * 
	 * @param city String the name of the city to compare
	 * @return int[] an array of hamming distances. Index 0 holds the number of those of hamming dist 0, index 1 holds the number of
	 * those of hamming dist 1, and indexes 2, 3 and 4 for distances 2, 3 and 4 respectively. 
	 */
	public int[] compareHammingDist(String city)
	{
		//temporary hamming distance variables
		int[] distances = new int[5];
		int dist0 = 0;
		int dist1 = 0;
		int dist2 = 0;
		int dist3 = 0;
		int dist4 = 0;
		
		//steps through each string in the cities array
		for(String comp : cities)
		{
			int tempDist = findHammingDist(city, comp);
			// update the correct variable based on the hamming distance
			if(tempDist == 0)
				++dist0;
			if(tempDist == 1)
				++dist1;
			if(tempDist == 2)
				++dist2;
			if(tempDist == 3)
				++dist3;
			if(tempDist == 4)
				++dist4;
		}
		
		//put the distances into the array at the proper index
		distances[0] = dist0;
		distances[1] = dist1;
		distances[2] = dist2;
		distances[3] = dist3;
		distances[4] = dist4;
		
		return distances;
	}
	
	/**
	 * This method determines the hamming distance (1, 2, 3, 4) between the two given cities
	 * 
	 * @param original String the first city
	 * @param compare String the second city to be compared to the first
	 * @return int number 1-4 representing the hamming distance between the two given cities
	 */
	public int findHammingDist(String original, String compare)
	{
		//temporary hamming distance variable
		int dists = 0;
		
		//steps through each character and determines if they are the same for both Strings
		for(int index = 0; index < original.length() && index < compare.length(); ++index)
		{
			//if the characters are not the same, increment the  temporary hamming distance variable
			if(original.charAt(index) != compare.charAt(index))
			{
				++dists;
			}
		}
		
		return dists;
	}
	
	/**
	 * This method uses the given Station ID and creates an ArrayList containing the other cities which are the given hamming distance away
	 * 
	 * @return the ArrayList of ID's of the given hamming distance
	 */
	public ArrayList<String> findGivenHammingDist(String orig, int dist) 
	{
		ArrayList<String> distAway = new ArrayList<String>();
		
		for(String comp : cities)
		{
			if(findHammingDist(orig, comp) == dist)
			{
				distAway.add(comp);
			}
		}
		return distAway;
	}
	
	/**
	 * Accessor method for the cities array containing all the Station IDs
	 * @return cities arraylist
	 */
	public ArrayList<String> getCities()
	{
		return cities;
	}
	
	/**
	 * Adds the given station ID to the cities ArrayList if not already present
	 * @param id The station ID to be added to the cities array
	 */
	public void addCity(String id)
	{
		// this ensures that the id is uppercase and the appropriate length
		String official = (id.toUpperCase() + "    ").substring(0, 4);
		if(!cities.contains(official))
		{
			cities.add(official);
			Collections.sort(cities);
		}
	}
	
	/**
	 * retrieves the average of the station's ID and inputs them into an array in the following order:
	 * [0] The ceiling of the average
	 * [1] The floor of the average
	 * [2] The average (ceiling if decimal >= 0.5, floor if  < 0.5)
	 * @return array containing average values
	 */
	public int[] calAverage(String id)
	{
		double average = getAverage(id);
		
		int[] ave = new int[3];
		ave[0] = (int)Math.ceil(average);
		ave[1] = (int)Math.floor(average);
		ave[2] = (int)Math.round(average);
		
		return ave;
	}
	
	/**
	 * determines the letter represented by the average of the station ID
	 * @return the character representing the average
	 */
	public char letterAverage(String id)
	{
		return (char)calAverage(id)[2];
	}
	
	/**
	 * This method determines the average Ascii value of the four characters making up the MesoStation ID
	 * @return the average Ascii value
	 */
	private double getAverage(String id)
	{
		int total = 0;
		double num = id.length();
		
		for(int i = 0; i < num; ++i)
		{
			char c = id.charAt(i);

			//Note: Java automatically translates the characters into their int Ascii values
			total += c;
		}
		
		double average = total / num;
		
		return average;
	}
}
