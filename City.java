public class City
{
    private int location;
    private double x;
    private double y;

    //constructor
    public City(int loc, double xCoord, double yCoord)
    {
        this.location = loc;
        this.x = xCoord;
        this.y = yCoord;
    }

    //getter methods
    public double getLoc(){   return location;   }
    public double getX(){   return x;   }
    public double getY(){   return y;   }

    //setter methods
    public void setX(double val){   x = val;    }
    public void setY(double val)    {   y = val;    }

    //print out all info.  Unused now
    public void printInfo()
    {
        System.out.println("Location:" + location + " x:" + x + " y:" + y);
    }

    //print just the index of a node.  +1 because i indexed from 0, prompt indexes from 1
    public void printIndex()
    {
        System.out.println(location + 1);
    }

    //calculate distance between cities.
    public int distanceBetween(City a)
    {
        double distance;

        double x1 = this.getX();
        double x2 = a.getX();
        double y1 = this.getY();
        double y2 = a.getY();

        distance = Math.round(Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)));

        return (int)distance;
    }
}
