
import java.util.*;
import java.io.*;
import static java.lang.Math.min;

public class linkedList 
{
	public static void main(String[] args) 
	{
		Scanner in= new Scanner(System.in);
		char answer;
		LinkedList<Integer> l=new LinkedList<Integer>();
		List<Integer> subItems = l.subList(0, min(l.size(), 3));
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		System.out.println("Linked List:" +l);
		Collections.reverse(l);
		System.out.println("\nCreate a Reversed Linked List:");
		for(Integer str: l)
		{
            System.out.println(str);
		}
		System.out.println("\nLinked List with size 3: ");
		 subItems = l.subList(0, min(l.size(), 3));
		 System.out.println(subItems);
		 
		 do
			{
				System.out.println("Enter element:");
				int ele = in.nextInt();
				if(subItems.contains(ele))
				{
					int i=l.indexOf(ele);
					int a=l.get(0);
					int b=l.get(1);
					if(i==2)
					{
						l.set(0, ele);
						l.add(1, a);
						l.add(2, b);
					}
					if(i==1)
					{
						
						l.set(0, ele);
						l.set(i, a);
					}
					
					
					
				}
				else
				{
					l.addFirst(ele);
				}
				
				System.out.println("Do you want to continue: ");
				answer = in.next().charAt(0);
			}while(answer=='y');
		 subItems = l.subList(0, min(l.size(), 3));
		 System.out.println("Linked List :" +subItems);
		 
	}
	
}

