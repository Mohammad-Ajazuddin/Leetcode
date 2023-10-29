import java.util.*;
public class CodeTask1
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array(atleast 4)");
		int n = sc.nextInt();

        int[] evens;
        int[] odds;
        
		if(n%2==0)
		{
		    evens = new int[n/2];
		    odds = new int[n/2];
		}
		else
		{
		    evens = new int[n/2 + 1];
		    odds = new int[n/2];
		}
		
		int even = 0, odd = 0;
		
		System.out.println("Enter elements");
		for(int i=0;i<n;i++)
		{
	        if(i%2==0)
	        {
	            evens[even++] = sc.nextInt();
	        }
	        else{
	            odds[odd++] = sc.nextInt();
	        }
		}
		
		Arrays.sort(evens);
		Arrays.sort(odds);
		
		System.out.println("Sum of 2nd largest values at even and odd indices = " + (evens[evens.length - 2] + odds[odds.length - 2]));
	}
}
