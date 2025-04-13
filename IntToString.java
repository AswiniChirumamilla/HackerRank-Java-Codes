You are given an integer , you have to convert it into a string.

Please complete the partially completed code in the editor. If your code successfully converts  into a string  the code will print "Good job". Otherwise it will print "Wrong answer".

 can range between  to  inclusive.
Sample Input 0
100
Sample Output 0
Good job

##############         CODE ###################333

import java.util.*;
import java.security.*;
public class IntToString {
	public static void main(String[] args) {
		
		Do_Not_Terminate.forbidExit();

		try{
			Scanner in = new Scanner(System.in);
			int n=in.nextInt();
      String s = Integer.toString(n);
      if(n==Integer.parseInt(s))
			{
				System.out.println("Good job");
			}
			else
			{
				System.out.println("Wrong answer.");
			}
		}
		catch (Do_Not_Terminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}
}
