package epam.maven;

public class Sweet implements NewYearGift{
	int price;
	int weight;
	
	Sweet(int price , int weight,String type){
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