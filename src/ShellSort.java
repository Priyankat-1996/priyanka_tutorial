package assignment5;

import java.util.Scanner;

public class ShellSort 
{
	public static void main(String[] args) 
	{
		Scanner in =new Scanner(System.in);
		int n,gap,i;
		
		System.out.println("\t Shell Sort");
		System.out.println("Enter number of elements: ");
		n=in.nextInt();
		int array[] = new int[n];
		System.out.println("Enter Elements in array: ");
		for(i=0;i<n;i++)
		{
			array[i]=in.nextInt();
		}
		System.out.println("Before Sorting Elements in array: ");
		printArray(array);
		shell(array,n);
		System.out.println("\nAfter Sorting Elements in array: ");
		printArray(array);
		
	}
	public static void shell(int array[],int n)
	{
		 int gap = array.length / 2;
	        while (gap > 0) 
	        {
	            for (int i = gap; i < array.length; i++) 
	            {
	                int j ;
	                int temp = array[i];
	                for (j = i;j >= gap && array[j - gap] > temp;j-=gap) 
	                {
	                	
	                	array[j] = array[j - gap];
	                    
	                }
	                array[j] = temp;
	            }
	            gap=gap/2;
	 
	        }
	}
	static void printArray(int array[]) 
    {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }

}

 