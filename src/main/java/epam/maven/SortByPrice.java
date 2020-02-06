package epam.maven;

import java.util.Comparator;

public class SortByPrice implements Comparator<Chocolate> {
	public int compare(Chocolate c1,Chocolate c2) {
		return c1.getPrice()-c2.getPrice();
	}
}