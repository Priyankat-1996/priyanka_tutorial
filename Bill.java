

import java.util.Scanner;

public class Bill 
{
	 public static void main(String[] args) 
	 {
		Hamburger burger=new Hamburger();
		HealthyBurger bug =new HealthyBurger();
		DeluxeBurger bug1 =new DeluxeBurger();
		char ans;
		int total = 0,a,b,c;
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\tBurger Point");
		do
		{
			System.out.println("\n\t\t You want which type of Burger..? ");
			System.out.println("\t\t\t1. Normal Burger");
			System.out.println("\t\t\t2. Healthy Burger");
			System.out.println("\t\t\t3. Deluxe Burger");
			System.out.println("\t\t\t4. Exit");
	    	int choice = sc.nextInt();
	    	switch(choice)
	    	{
		    	case 1: a = burger.toppings();
		    			System.out.println("\n\tPrice of Hamburger is :" + a);
		    			total= total + a;
		    			break;
		    	case 2:  b= bug.additional();
		    			System.out.println("\n\tPrice of Heaithy Burger is :" + b);
		    			total= total + b;
		    			break;
		    	case 3:  c=bug1.additional();
		    			System.out.println("\n\tPrice of Deluxe Burger is :" + c);
		    			total= total + c;
		    	 		break;
		    	case 4: 
		    			break;
	    	}
	    	System.out.println("\n\tDo you want to add more  ..?");
	        ans = sc.next().charAt(0);
		}while(ans=='y');
		System.out.println("----------------------------");
		System.out.println("\n\tTotal Bill: " + total);
		System.out.println("----------------------------");
		System.out.println("\nThank you.. ! Visit again..");
	}
}
