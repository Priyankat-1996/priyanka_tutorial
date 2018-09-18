
public class PrimeNum 
{
	public static void main(String[] args) 
	{
       int limit = 50;
		
		System.out.println("Prime numbers between 1 and " + limit);
		for(int i=1; i < 50; i++){
			
			boolean isPrime = true;
			for(int j=2; j < i ; j++){
				
				if(i % j == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime)
				System.out.print(i + " ");
		}
	}

}
