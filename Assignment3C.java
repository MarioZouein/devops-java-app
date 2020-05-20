
import java.util.*;

interface Container{
	public double volume();
}

class Can implements Container{
    private double radius;
    private double height;
    Can(double r, double h) {
        radius = r; height = h;
    }
    public double volume() {
        return 3.14*radius*radius*height;
    }
}

class Carton implements Container {
    private double length;
    private double width;
    private double height;
    Carton(double l, double w, double h) {
        length = l; width = w; height = h;
    }
    public double volume() {
        return length*width*height;
    }
}

public class Assignment3C {

	
	public static double price(Container c)
	{
		return 2*c.volume();
	}
	
	public static <T> List <T> evens(List <T> contain)
	{
		List <T> evensContainer = new ArrayList<T>();
		for (int i=0; i < contain.size(); i++)
		{
			if (i%2==0) {
				evensContainer.add(contain.get(i));
			}
		}
		return evensContainer;
	}
	
	public static <T extends Container> int numLarger(List <T> contain,double v)
	{
		int n=0;
		for (int i=0; i<contain.size();i++)
		{
			if(contain.get(i).volume() > v)
				n++;
		}
		return n;
	}

    public static void main(String[] args) {
        List<Can> canList = new ArrayList<Can>() {{
            add(new Can(1.5,10.0));
            add(new Can(2.5,10.0));
            add(new Can(2.5,12.0));
            add(new Can(3.0,10.0));
        }};
        List<Carton> cartonList = new ArrayList<Carton>() {{
            add(new Carton(2.5,2.5,10.0));
            add(new Carton(5.0,5.0,10.0));
            add(new Carton(5.0,5.0,15.0));
            add(new Carton(5.0,10.0,10.0));
            add(new Carton(7.5,10.0,10.0));
        }};
        // Test price
        Can c1 = canList.get(2);
        System.out.println(price(c1));
        Carton c2 = cartonList.get(1);
        System.out.println(price(c2));
        // Test evens
        List<Can> canList2 = evens(canList);
        System.out.println(canList2.size());
        List<Carton> cartonList2 = evens(cartonList);
        System.out.println(cartonList2.size());
        // Test numLarger
        System.out.println(numLarger(canList, 250.0));
        System.out.println(numLarger(cartonList, 250.0));
    }

}
