import java.util.Scanner;

/* The only error checking in this program is for valid menu input
 * It is assumed that the other input is valid
 */
// COMP 248 - A4 - One possible solution
public class MamaNanciaPizzeria {
	public static void main(String[] args) {
		//Variables
		Scanner keyIn = new Scanner(System.in);
		int maxNumberOfPizzas;
		int mainMenuChoice;
		
		//Welcome message
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n"+
				           "         Welcome to MAMA NANCIA's PIZZERIA\n" +
				           "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n\n");
		System.out.println("Good morning Mama Nancia! How many pizzas can you make today? ");
		maxNumberOfPizzas = keyIn.nextInt();
		DeluxePizza[] todaysPizzas = new DeluxePizza[maxNumberOfPizzas];
		
		//------------------
		// MAIN MENU CONTROL
		//------------------
		do
		{
			System.out.print("Mama Nancia what do you want to do?\n" +
				           "   1. Enter a new pizza order (password required)\n"+ 
				           "   2. Change information of a specific order (password required)\n"+ 
				           "   3. Display details for all pizzas of a specific size (s/m/l)\n" + 
				           "   4. Statistics on today’s pizzas\n" +
				           "   5. Quit\nPlease enter your choice >");
			mainMenuChoice = keyIn.nextInt();
			switch(mainMenuChoice)
			{
			// MAIN MENU CHOICE 1 - add pizzas
			// ------------------
				case 1: 
				if(passwordOK())
				{
					System.out.print("How many pizzas are in this order?");
					int num = keyIn.nextInt();
					// check if enough space in array to add - if not adjust number can add
					if( num + DeluxePizza.getNumOfPizzas() > todaysPizzas.length)
					{
						num = todaysPizzas.length - DeluxePizza.getNumOfPizzas();
						System.out.println("Sorry have ingredients for "+ num+ 
								           " pizzas only left.");
					}
					// add requested number of pizzas
					for(int i = 1; i <= num; i++)
					{
						System.out.print("Pizza number " + i + " size please (s/m/l): ");
						String size = keyIn.next(); 
						size = size.toLowerCase();
						System.out.println("Cheese in dough(y/any key for no)? ");
						String stuff = keyIn.next();
						boolean stuffed = stuff.equalsIgnoreCase("y");
						System.out.println("Number of cheese, pepperoni, mushroom,and veggie toppings: ");
						int c = keyIn.nextInt();
						int p = keyIn.nextInt();
						int m = keyIn.nextInt();
						int v = keyIn.nextInt();
						todaysPizzas[DeluxePizza.getNumOfPizzas()]= new DeluxePizza(size,c,p,m,stuffed,v);						
					}
				}
				break;
				
			// MAIN MENU CHOICE 2 - Modify a pizza
			// ------------------
			case 2: 
				if(passwordOK())
				{
				boolean valid = false, another = false;
				int num; // pizza to edit;
				do
				{
					System.out.print("Which pizza do you wish to modify?");
					num = keyIn.nextInt();
					valid = num < DeluxePizza.getNumOfPizzas() && num <todaysPizzas.length;
					if(!valid)
					{
						System.out.println("Sorry no such pizza.\n"+ 
								"Mama do you want to enter another pizza number or quit the modify order(quit to end)? ");
						String quit = keyIn.next();
						another = quit.equalsIgnoreCase("quit");
					}
				}while (!valid || another);
				if(valid)// if valid number then make changes
				{
					// show pizza info
					System.out.println("Pizza # "+ num + "\n" + todaysPizzas[num]);
					//ask what Mama wants to change
					int choice;
					do
					{
						System.out.print("Mama Nancia, what would you like to change?\n"+ 
								         "  1. Size\n  2. Cheese filled or not\n  3. Number of cheese toppings\n"+
								         "  4. Number of pepperoni toppings\n  5. Number of mushroom toppings\n" +
								         "  6. Number of vegetable toppings\n  7. Quit\nEnter choice >");
						choice = keyIn.nextInt();
						switch(choice)
						{
						case 1:
							System.out.println("New size please (s/m/l): ");
							String size = keyIn.next(); 
							todaysPizzas[num].setSize(size);
							break;
						case 2:
							System.out.println("Cheese Filled dough? (y/any key for no): ");
							String c = keyIn.next(); 
							todaysPizzas[num].setStuffedWithCheese(c.equalsIgnoreCase("y"));
							break;
						case 3:
							System.out.println("Number of cheese toppings?: ");
							int ct = keyIn.nextInt(); 
							todaysPizzas[num].setCheeseTopping(ct);
							break;
						case 4:
							System.out.println("Number of pepperoni toppings?: ");
							int pt = keyIn.nextInt(); 
							todaysPizzas[num].setPepperoniTopping(pt);
							break;
						case 5:
							System.out.println("Number of mushroom toppings?: ");
							int mt = keyIn.nextInt(); 
							todaysPizzas[num].setMushroomTopping(mt);
							break;
						case 6:
							System.out.println("Number of vegetable toppings?: ");
							int vt = keyIn.nextInt(); 
							todaysPizzas[num].setVeggieTopping(vt);
							break;	
						case 7: break;
						}
					}while (choice != 7);
				}
				} // if passwork ok
				break;
				
			// MAIN MENU CHOICE 3 - display info of pizzas of a certain size
			// ------------------ 
			case 3:
				System.out.println("\nMama Nancia, what size pizza do you want a list of?(s/m/l)? ");
				String sz= keyIn.next();
				for(int i = 0; i <todaysPizzas.length; i++)
					if(sz.equalsIgnoreCase(todaysPizzas[i].getSize()))
						System.out.println("Pizza # "+ i + "\n" + todaysPizzas[i]);				
				break;
				
			// MAIN MENU CHOICE 4 - statistics
			// ------------------
			case 4:
				int choice;
				do{
					System.out.println("Mama Nancia, what information would you like?\n" +
							           "  1. Cost and details of cheapest pizza\n" +
							           "  2. Cost and details of most costly pizza\n" +
							           "  3. Number of pizzas sold today\n" +
							           "  4. Number of pizzas of a specific size\n" +
							           "  5. Average cost of pizzas\n  6. Quit\nEnter your choice > ");
					choice = keyIn.nextInt();
					switch(choice)
					{
					case 1: // cost and details of cheapest pizza
						int cheap = lowestPrice(todaysPizzas);
						System.out.println("Pizza # "+ cheap + "is the cheapest pizza\n" +
								            todaysPizzas[cheap] + "\n");
						break;
					case 2: // cost an details of most costly pizza
						int high = highestPrice(todaysPizzas);
						System.out.println("Pizza # "+ high + "is the cheapest pizza\n" +
								            todaysPizzas[high] + "\n");
						break;
					case 3: // number of pizzas sold today
						System.out.println("Number of pizzas sold today to date is " + 
								DeluxePizza.getNumOfPizzas());						
						break;
					case 4: // number of pizzas of a specific size
						System.out.print("What size pizza do you want?(s/m/l) ");
						sz = keyIn.next();
						System.out.println("Number of " + sz + "pizzas made today " 
								+ numberOfPizzasOfSize(sz, todaysPizzas));
						break;
					case 5: // average cost of pizza
						double sum = 0;
						if(todaysPizzas == null)
							System.out.println(">>> Sorry no pizzas made yet ....");
						else
						{
							for(int i = 0;i < DeluxePizza.getNumOfPizzas(); i++)
								sum += todaysPizzas[i].calcCost();
							System.out.println("Average cost of pizzas sold todat today is $" + 
									sum /DeluxePizza.getNumOfPizzas());
						}
						break;
					case 6:  // quit this level
					}
				}while(choice != 6);
					break;
				
			// MAIN MENU CHOICE 5	
			case 5:
				System.out.println("\nAnother days work done!!!");
				break;
			default: System.out.println("Sorry that is not a legal choice, please enter a choice between 1 and 5 inclusive\n");
			}
		}while (mainMenuChoice != 5); // main menu
		keyIn.close();
		
	}//end main


// STATIC METHODS
//---------------

public static boolean passwordOK()
{
	final String passwrd = "deluxepizza";
	Scanner keyIn = new Scanner(System.in);
	String input;
	int count = 0;
	boolean valid;
	do{
		System.out.print("Password please: ");
		input = keyIn.next();
		valid = input.equals(passwrd);
		if(!valid) count++;		
	}while (count < 3 && !valid);
	if(!valid) System.out.println("Sorry - you are not authorized to perform requested action!\n");
	return valid;
}

public static int numberOfPizzasOfSize(String sz, DeluxePizza [] tp)
{
	int count = 0;
	for(int i = 0;i < DeluxePizza.getNumOfPizzas(); i++)
	{
		if (tp[i].getSize().equalsIgnoreCase(sz))
		{
			System.out.println("Pizza # "+ i + "\n" + tp[i] + "\n");
			count++;
		}
	}
	return count;
}

public static int lowestPrice(DeluxePizza [] tp) 
{
	int loc = 0;
	for(int i = 0;i < DeluxePizza.getNumOfPizzas(); i++)
	{
		if (tp[i].calcCost()< tp[loc].calcCost())
		loc = i;
	}
	return loc;
}
public static int highestPrice (DeluxePizza [] tp) 
{
	int loc = 0;
	for(int i = 0;i < DeluxePizza.getNumOfPizzas(); i++)
	{
		if (tp[i].calcCost()> tp[loc].calcCost())
		loc = i;
	}
	return loc;
}
public static void cheaperThan(double price, DeluxePizza [] tp) 
{
	System.out.println("\nList of pizzas cheaper than " + price);
	for(int i = 0;i < DeluxePizza.getNumOfPizzas(); i++)
		if (tp[i].calcCost()< price)
			System.out.println("Pizza # "+ i + "\n" + tp[i] + "\n");	
}
}//end MamaNanciPizzeria class
