
import java.util.Scanner;

public class DeluxeBurger extends Hamburger
{
	int price2;
	DeluxeBurger()
	{
		String Bread_Roll = "Brown";
		String meat = "Beef";
	}
	public int additional()
	{
		int price2 = super.price;
		char ans;
		do 
		{
		    Scanner sc = new Scanner(System.in);
			System.out.println("\t\tSelect Toppings: ");
			System.out.println("\t\t\t1. Fish Burger");
			System.out.println("\t\t\t2. Toast ad  Jam");
	    	int topping = sc.nextInt();
			switch(topping)
			{
				case 1: price2=price2+30;
						break;
				case 2: price2=price2+20;
						break;
			}
			System.out.println("\nDo you want to add more toppings ..?");
	        ans = sc.next().charAt(0);
		}while(ans=='y');
		
		return(price2);
	}
}
