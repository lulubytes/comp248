// COMP 248 - A4 - One possible solution
public class DeluxePizza {
	private String size;
	private int cheeseTopping;
	private int pepperoniTopping;
	private int mushroomTopping;
	private boolean stuffedWithCheese;
	private int veggieTopping;
	private static int numOfPizzas=0;
	
	
	// Constructors
	//-------------
	// Default constructor
	public DeluxePizza()
	{
		size = "";
		numOfPizzas++;
	}
	
	//Constructor that sets all data members to a passed value
	public DeluxePizza(String sz, int cheese, int pepperoni, int mushroom, boolean cheeseYN,
						int veggie)
	{
		size = sz.toUpperCase();
		cheeseTopping = cheese;
		pepperoniTopping = pepperoni;
		mushroomTopping = mushroom;	
		stuffedWithCheese = cheeseYN;
		veggieTopping = veggie;
		numOfPizzas++;
	}
	// Copy constructor
	public DeluxePizza(DeluxePizza p)
	{
		size = p.size;
		cheeseTopping = p.cheeseTopping;
		pepperoniTopping = p.pepperoniTopping;
		mushroomTopping = p.mushroomTopping;	
		stuffedWithCheese = p.stuffedWithCheese;
		veggieTopping = p.veggieTopping;
		numOfPizzas++;
	}
	// Accessor methods
	//-----------------
	public String getSize()
	{ return size;
	}
	
	public int getCheeseTopping()
	{
	return cheeseTopping;
	}
	
	public int getPepperoniTopping()
	{
		return pepperoniTopping;
	}
	
	public int getMushroomTopping()
	{
		return mushroomTopping;
	}
	public boolean getStuffedWithCheese()
	{
		return stuffedWithCheese;
	}
	public int getVeggieTopping()
	{
		return veggieTopping;
	}
	public int getNumberOfPizzas()
	{
		return numOfPizzas;
	}
	public static int getNumOfPizzas()
	{
		return numOfPizzas;
	}
	
	//Mutator methods
	//---------------
	public void setSize(String sz)
	{
		size = sz.toUpperCase();
	}
	
	public void setCheeseTopping(int cheese)
	{
		cheeseTopping = cheese;
	}
	
	public void setPepperoniTopping(int pepperoni)
	{
		pepperoniTopping = pepperoni;
	}
	
	public void setMushroomTopping(int mushroom)
	{
		mushroomTopping = mushroom;
	}
	
	public void setStuffedWithCheese(boolean yn)
	{
		stuffedWithCheese = yn;
	}
	public void setVeggieTopping(int v)
	{
		veggieTopping = v;
	}
	
	// Other methods
	public int calcCost()
	{
		int cost = 0;
		if(size.equals("SMALL"))
			if (stuffedWithCheese)
				cost = 10 + 2;
			else
				cost = 10;
		else if (size.equals("MEDIUM"))
			if (stuffedWithCheese)
				cost = 12 + 4;
			else
				cost = 12;
		else if (size.equals("LARGE"))
			if (stuffedWithCheese)
				cost = 14 + 6;
			else
				cost = 14;
		return cost + (cheeseTopping + pepperoniTopping + mushroomTopping) * 2 + veggieTopping * 3;	
	}
	
	public boolean equals(DeluxePizza pizza2)
	{
		return size.equals(pizza2.size) && cheeseTopping == pizza2.cheeseTopping
		&& pepperoniTopping == pizza2.pepperoniTopping 
		&& mushroomTopping == pizza2.mushroomTopping
		&& veggieTopping == pizza2.veggieTopping
		&& stuffedWithCheese == pizza2.stuffedWithCheese;
	}
	
	public String toString()
	{
		return "  Pizza size: " + size + "\n  Cheese filled dough: " +stuffedWithCheese +
		       "\n  Number of cheese toppinbgs: "+ cheeseTopping + "\n  Number of pepperoni toppings:  " +
		       pepperoniTopping + "\n  Number of mushroom toppings:  " + mushroomTopping +
		       "\n  Number of veggie toppings:  " + veggieTopping + "\n  Cost: $"+ calcCost();
	}

}
