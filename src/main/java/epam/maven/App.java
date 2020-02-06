package epam.maven;

import java.util.*;

public class App 
{
	
	static Scanner input=new Scanner(System.in);
	static ArrayList<Chocolate> chocolates=new ArrayList<Chocolate>();
	static ArrayList<Sweet> sweets=new ArrayList<Sweet>();
	static HashMap<String , Integer> nameToWeight=new HashMap<String,Integer>();
	static HashMap<String , Integer> nameToPrice=new HashMap<String,Integer>();
	
    public static void main( String[] args )
    {
		inputChocolates();
		inputSweets();
		
		System.out.println("Total Weight of the Gift is : "+calculateTotalWeight());
		
		System.out.println("What factor to be taken to sort the chocolates : 1.Price  2.Weight");
		int sortType=input.nextInt();
		
		if(sortType==1) {
			Collections.sort(chocolates,new SortByPrice());
		}
		else if(sortType==2) {
			Collections.sort(chocolates,new SortByWeight());
		}
		else {
			System.out.println("Wrong Choice!!");
			System.exit(0);
		}
		
		System.out.println("Sorted Result : ");
		for(Chocolate chocolate:chocolates) {
			System.out.println(chocolate.getPrice());
		}
		
		calcRange(sortType);
    }
    
    public static void inputChocolates() {
    	System.out.println("Enter the no. of chocolates in the gift : ");
    	int noc=input.nextInt();
    	
    	for(int chocoCount=1;chocoCount<=noc;chocoCount++) {
 
    		System.out.println("Enter the price of chocolate : ");
    		int chocoPrice=input.nextInt();

    		System.out.println("Enter the weight of chocolate : ");
    		int chocoWeight=input.nextInt();
    		
    			
			System.out.println("Enter the name of Candy : ");

			String candyName = input.next();

			if (nameToWeight.containsKey(candyName)) {
				nameToWeight.put(candyName, (int) nameToWeight.get(candyName) + chocoWeight);
			} else
				nameToWeight.put(candyName, chocoWeight);

			if (nameToPrice.containsKey(candyName)) {
				nameToPrice.put(candyName, (int) nameToPrice.get(candyName) + chocoPrice);
			} else
				nameToPrice.put(candyName, chocoPrice);
			
			Chocolate chocolate=new Chocolate(chocoPrice,chocoWeight);
			chocolates.add(chocolate);
    	}
    }
    
    public static void inputSweets() {
    	System.out.println("Enter the no. of sweets in the gift : ");
    	int nos=input.nextInt();
    	
    	for(int sweetCount=1;sweetCount<=nos;sweetCount++) {
 
    		System.out.println("Enter the price of sweet : ");
    		int sweetPrice=input.nextInt();

    		System.out.println("Enter the weight of sweet : ");
    		int sweetWeight=input.nextInt();
    		
    			
			System.out.println("Enter the name of Sweet : ");

			String sweetName = input.next();

			if (nameToWeight.containsKey(sweetName)) {
				nameToWeight.put(sweetName, (int) nameToWeight.get(sweetName) + sweetWeight);
			} else
				nameToWeight.put(sweetName, sweetWeight);

			if (nameToPrice.containsKey(sweetName)) {
				nameToPrice.put(sweetName, (int) nameToPrice.get(sweetName) + sweetPrice);
			} else
				nameToPrice.put(sweetName, sweetPrice);
    	}
    }
    
    public static int calculateTotalWeight() {
    	
    	int totalWeight=0;
    	
    	for(Chocolate chocolate:chocolates) {
    		totalWeight+=(int)chocolate.getPrice();
    	}
    	
    	for(Sweet sweet:sweets) {
    		totalWeight+=(int)sweet.getPrice();
    	}
    	
    	return totalWeight;
    }
    
    public static void calcRange(int rangeType) {

    	Set<String> filteredSet=new HashSet<String>();
    	int lowerLimit=0;
    	int higherLimit=0;
    	
    	if(rangeType==1) {
    		System.out.println("Enter Lower limit of Price : ");
    		lowerLimit=input.nextInt();

    		System.out.println("Enter Higher limit of Price : ");
    		higherLimit=input.nextInt();
    		
    		for(Map.Entry<String,Integer> giftElement:nameToPrice.entrySet()) {
    			int currPrice=(Integer)giftElement.getValue();
    			if(currPrice>=lowerLimit && currPrice<=higherLimit)	filteredSet.add((String)giftElement.getKey());
    		}
    	}else {
    		System.out.println("Enter Lower limit of Weight : ");
    		lowerLimit=input.nextInt();

    		System.out.println("Enter Higher limit of Weight : ");
    		higherLimit=input.nextInt();
    		
    		for(Map.Entry<String,Integer> giftElement:nameToWeight.entrySet()) {
    			int currWeight=(Integer)giftElement.getValue();
    			if(currWeight>=lowerLimit && currWeight<=higherLimit)	filteredSet.add((String)giftElement.getKey());
    		}
    	}
    	
    	System.out.println("Filtered out Elements are : ");
    	for(String filteredElement:filteredSet) {
    		System.out.println(filteredElement);
    	}
    }
}