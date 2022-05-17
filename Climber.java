public class Climber
{
    //Find the shortest distance through the path
    public Path shortestPath(Path current)
    {
        //initialize values
        Path singleSwap;
        int counter = 0;

        //Run 1000 iterations, if value does not decrease assume we found the best path
        while (counter < 100)
        {
            //Call method to create new path with 2 nodes swapped.
            singleSwap = singleSwapPath(new Path(current));
            //If this new path is shorter, set it as current path.
            if (singleSwap.getTotalPathLength() <= current.getTotalPathLength())
            {
                counter = 0;
                current = new Path(singleSwap);
            }

            //increment counter
            counter++;
        }

        return current;
    }

    //Method to swap two elements in the path
    private Path singleSwapPath(Path p)
    {
        //2 temp int
        int city1 = 0, city2 = 0;

        //if the 2 temps are equal, randomize.
        do
        {
            city1 = (int) (p.getPath().size() * Math.random());
            city2 = (int) (p.getPath().size() * Math.random());
        }
        while (city1 == city2);

        //Get city objects at that index
        City c1 = p.getPath().get(city1);
        City c2 = p.getPath().get(city2);

        //swap those 2 indexes.
        p.getPath().set(city2, c1);
        p.getPath().set(city1, c2);

        return p;
    }





}
