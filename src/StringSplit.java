
public class StringSplit 
{
	public static void main(String[] args) 
	{
		String state= "He is a very very good boy, isn't he?";
		int len=state.length();
		String c=" ";
		
		int count=1;
		for(int i=0;i<len;i++) 
		{
			if(state.charAt(i)==' ')
			{
				count++;
			}
		}
		System.out.println(count);
		
		char array1[] = state.toCharArray();
		
		
		for (int i = 0; i < state.length(); i++) 
		{
			if (Character.isLetter(array1[i])) 
			{
				System.out.print(state.charAt(i));
			}
			 if(state.charAt(i)=='\'' || state.charAt(i)==' ')
			{ 
				System.out.println(" ");
			}
		}
	}
}
