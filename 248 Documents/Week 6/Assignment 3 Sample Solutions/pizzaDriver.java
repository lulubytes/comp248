import java.util.Scanner;
public class pizzaDriver {
	public static void main(String[] args) {
		// Welcome Header
		System.out.println("--------------------------------------------\n"+
				"Welcome to Fancy Nancy's Pizza Shop ....\n"+
				"--------------------------------------------\n");
		// Variable declarations
		//----------------------
		Scanner keyIn = new Scanner(System.in);
		// Create first one with the default constructor
		String size;
		int cheese, pepperoni, mushroom;
		Pizza pizza1 = new Pizza();
		
		// Prompt user for the content of the next 2 pizzas
		System.out.print("Please place order for 1st pizza:\n" +
		"Size:small, medium or large?  "); 
		size = keyIn.next();
		size = size.toUpperCase();
		System.out.print("Indicate the number of each of the following toppings: cheese, pepperoni and mushroom\n");
		cheese = keyIn.nextInt();
		pepperoni = keyIn.nextInt();
		mushroom = keyIn.nextInt();
		Pizza pizza2 = new Pizza(size, cheese, pepperoni, mushroom);
		
		System.out.print("Please place order for 2nd pizza:\n" +
		"Size:small, medium or large?  "); 
		size = keyIn.next();
		size = size.toUpperCase();
		System.out.print("Indicate the number of each of the following toppings: cheese, pepperoni and mushroom\n");
		cheese = keyIn.nextInt();
		pepperoni = keyIn.nextInt();
		mushroom = keyIn.nextInt();
		Pizza pizza3 = new Pizza(size, cheese, pepperoni, mushroom);
		
		//Display the content and cost of each pizza 
		System.out.print("\nHere are the three pizzas:\n");
		System.out.println(pizza1);
		System.out.println(pizza2);
		System.out.println(pizza3);

		// Check if any are the same
		System.out.println("\nResults of comparisons:");
		if(pizza1.equals(pizza2) && pizza2.equals(pizza3))
			System.out.println("All three pizzas are identical.");
		else if(pizza1.equals(pizza2))
			System.out.println("First and second pizza are the same.");
		else if (pizza1.equals(pizza3))
			System.out.println("First and third pizza are the same");
		else if(pizza2.equals(pizza3))
			System.out.println("Second and third pizza are the same");
		else
			System.out.println("None of the pizzas are the same");
		System.out.println("\n\nResults of comparisons after changing one of the pizzas ....");
		
		// Set 1st pizza to be the same as one of the other two
		pizza1.setSize(pizza2.getSize());
		pizza1.setCheeseTopping(pizza2.getCheeseTopping());
		pizza1.setPepperoniTopping(pizza2.getPepperoniTopping());
		pizza1.setMushroomTopping(pizza2.getMushroomTopping());
		
		// Check now if any are the same
		if(pizza1.equals(pizza2) && pizza2.equals(pizza3))
		{
			System.out.println(pizza1);
			System.out.println("All three pizzas are identical.");
		}
		else if(pizza1.equals(pizza2))
			System.out.println("First and second pizza are the same.\n   " + pizza1 + 
					"\nPizza 3:\n   " + pizza3);
		else if (pizza1.equals(pizza3))
			System.out.println("First and third pizza are the same\n\t." + pizza1 + 
					"\nPizza 2:\n   " + pizza2);
		else if(pizza2.equals(pizza3))
			System.out.println("Second and third pizza are the same \n\t." + pizza2 + 
					"\nPizza 1:\n   " + pizza1);
		else
			System.out.println("None of the pizzas are identical\n\t" + pizza1 + 
					"\n\t" + pizza2 + "\n\t" + pizza3);
		System.out.println("\n\nEnjoy the pizzas ... Don't forget your TUMS on the way out.");
		keyIn.close();
		
	}
}
