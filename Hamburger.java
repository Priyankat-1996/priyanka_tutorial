
import java.util.Scanner;

public class Hamburger 
{
	String Breadrolltype;
	String meat;
	int price;
	String name;
	int price1,price2;
	Hamburger()
	{
	  Breadrolltype="White";
		String meat="Bacon";
		price =40;
		name="Burger";
	}

	public int toppings()
	{
		
		char ans;
		do 
		{
		    Scanner sc = new Scanner(System.in);
			System.out.println("\t\tSelect Toppings: ");
			System.out.println("\t\t\t1. Lettuce");
			System.out.println("\t\t\t2. Tomato");
			System.out.println("\t\t\t3. Carrot");
			System.out.println("\t\t\t4. Cheese");
			System.out.println("\t\t\t5. No Toppings");
	    	int topping = sc.nextInt();
			switch(topping)
			{
				case 1: price=price+30;
						break;
				case 2: price=price+20;
						break;
				case 3: price=price+25;
						break;
				case 4: price=price+35;
						break;
				case 5: price=40;
						break;
			}
			System.out.println("\nDo you want to add more toppings for HamBurger ..?");
	        ans = sc.next().charAt(0);
	       
		}while(ans=='y');
		
		
		return (price);
		

	}
}
