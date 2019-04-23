import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
	 * Accessor method for the cities array containing all the Station IDs
	 * @return cities arraylist
	 */
	public ArrayList<String> getCities()
	{
		return cities;
	}
}
