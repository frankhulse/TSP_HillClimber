/***********************************************************************************************************************
 * Frank Hulse
 * AiHW12
 * CSCI4463-091
 * Completed 5/4/22
 * This program aims to calculate the shortest path for the TSP problem.  I used a hill climbing algorithm to randomly
 * swap nodes looking for a faster path.  If this is completed 100 times without finding a new fastest path, it is
 * assumed that the path we found is the solution.  TSP problems are found in the puzzles folder, .TSP files from online.
 **********************************************************************************************************************/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TSP
{
    public static void main(String[] args) throws IOException
    {
        //Get user input as string.  This is the filename of the game to be played
        System.out.print("What file would you like to try: ");
        Scanner input = new Scanner(System.in);
        String t = (input.nextLine());

        //Create vars for later
        String line;                                    //For reading file
        boolean enter = false;                          //For cutting off comments at beginning of file
        int loc = -1;                                   //Tracking what location we are on.  (City # - 1)
        ArrayList<City> cities = new ArrayList<City>(); //For storing data on cities

        //Scanner reads file in, loop through file until end
        Scanner scanner = new Scanner(new File("src/puzzles/" + t +".tsp"));
        while (scanner.hasNextLine())
        {
            //Get the line we are on
            line = scanner.nextLine();

            //Some files contain and "EOF" delimiter.  Break loop to avoid throwing exception
            if(line.contains("EOF"))
            {
                break;
            }

            //We want this part of the file.  Start entering values into 2d array (cities)
            if (enter)
            {
                //inc index
                loc++;

                //Clean data
                int locFirstSpace = line.indexOf(" ");
                line = line.substring(locFirstSpace + 1);
                int locSecondSpace = line.indexOf(" ");

                //store coordinates as doubles
                double xCoord = Double.parseDouble(line.substring(0, locSecondSpace));
                double yCoord = Double.parseDouble(line.substring(locSecondSpace));

                //add to cities arraylist
                cities.add(new City(loc, xCoord, yCoord));
            }

            //We want the data in the file after this line.  Set boolean to true to hit other part of loop.
            if (line.contains("NODE_COORD_SECTION"))
            {
                enter = true;
            }
        }


        //Create a path.  This constructor will add all cities in cities, and randomize the order.
        Path initialPath = new Path(cities);
        //Start the climbing algorithm.  This will find the shortest path
        Path climber = new Climber().shortestPath(initialPath);

        //Output results from climber as specified in prompt
        System.out.println(climber.getTotalPathLength());
        for (City city : climber.getPath())
        {
            city.printIndex();
        }







    }
}
