
import java.util.Scanner;

public class HealthyBurger extends Hamburger
{
	 int price1;
	HealthyBurger()
	{
		String Bread_Roll = "Brown";
		String meat = "Beef";
	}
	public int additional()
	{
		price1 = super.price;
		char ans;
		
		do 
		{
		    Scanner sc = new Scanner(System.in);
			System.out.println("\t\tSelect Toppings: ");
			System.out.println("\t\t\t1. Panner");
			System.out.println("\t\t\t2. Corn");
	    	int topping = sc.nextInt();
			switch(topping)
			{
				case 1: price1=price1+30;
						break;
				case 2: price1=price1+20;
						break;
			}
			System.out.println("\nDo you want to add more toppings for Healthy Burger ..?");
	        ans = sc.next().charAt(0);
		}while(ans=='y');
		
		return(price1);
		
	}
}
