package epam.maven;

public class Chocolate implements NewYearGift{
	int price;
	int weight;
	
	Chocolate(int price , int weight){
		this.price=price;
		this.weight=weight;
	}
	
	public int getPrice() {
		return this.price;	
	}
	
	public int getWeight() {
		return this.weight;
	}
}