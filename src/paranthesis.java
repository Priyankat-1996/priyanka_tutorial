
import java.util.Scanner;
import java.util.Stack;
 
 class parenthesis 
 {
    public static void main(String[] args) 
    {
 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Expression: ");
        String brackets = sc.nextLine();
 
        Stack<Character> stack = new Stack<>();
        boolean isBalanced = true;
 
        for (int i = 0; i < brackets.length(); i++) 
        {
            char bracket = brackets.charAt(i);
            if (bracket == '{' || bracket == '[' || bracket == '(') 
            {
                stack.push(bracket);
            } 
            else 
            {
                if (bracket == '}') 
                {
                    bracket = '{';
                } 
                else if (bracket == ')') 
                {
                    bracket = '(';
                } 
                else if (bracket == ']') 
                {
                    bracket = '[';
                }
 
                if (stack.empty()) 
                {
                    isBalanced = false;
                    break;
                }
 
                if (bracket == stack.peek()) 
                {
                    stack.pop();
                } 
                else 
                {
                    isBalanced = false;
                    break;
                }
            }
        }
 
        if (isBalanced) 
        {
            System.out.println("Balanced Paranthesis");
        } else 
        {
            System.out.println("Oops..Not a Balanced Paranthesis");
        }
    }
}
