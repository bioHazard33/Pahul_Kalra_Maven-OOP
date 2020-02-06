package epam.maven;

import java.util.Comparator;

public class SortByWeight implements Comparator<Chocolate> {
	public int compare(Chocolate c1,Chocolate c2) {
		return c1.getWeight()-c2.getWeight();
	}
}