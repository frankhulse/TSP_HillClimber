import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Path
{
    //Initialize List of cities we have visited
    private ArrayList<City> visited = new ArrayList<City>();

    //getter method
    public ArrayList<City> getPath(){   return visited;  }

    //Print list as array
    public String toString()
    {
        return Arrays.toString(visited.toArray());
    }

    //Constructor.  Adds all visited cities to a path and randomizes the order
    public Path(ArrayList<City> visited)
    {
        //Add all cities to path
        this.visited.addAll(visited);
        //Randomize order.  Found this online to be much easier than manually coding a random shuffle
        Collections.shuffle(this.visited);
    }

    //Overloaded Constructor for making path with path
    public Path(Path path)
    {
        visited.addAll(path.visited);
    }

    //Compute the total distance of a path up to this point.
    public int getTotalPathLength()
    {
        //initialize int
        int distance = 0;

        //go through entire path, adding distances as we go.
        for (int i = 0; i < visited.size() - 1; i++)
        {
            //Get current city and next city
            City a = visited.get(i);
            City b = visited.get(i + 1);

            //calculate distance between cities.
            distance += a.distanceBetween(b);
        }

        return distance;
    }


}
