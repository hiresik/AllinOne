import java.util.Scanner;


public class reversenumber {

	 public static void main(String args[]) {

		    // enter the number to reverse eg., 5467 
		    // (pass this as command line argument if required)
		   int value;
		    Scanner user_input = new Scanner(System.in);
		  System.out.println("Enter Value : ");
		  //value = user_input.next();
		  value = user_input.nextInt();
		     
		  
		   // store the original number in a temporary variable so you can
		   // compare it to the end value
		   int real = value;
		    
		   int result = 0, remainder = 0, quotient = 0;
/*System.out.println("before result " + result);
System.out.println("before remainder " + remainder);
System.out.println("before quotient " + result);
*/
		   while(value>0)
		   {
			quotient = value / 10;
			remainder = value - quotient * 10;
			result = remainder + result * 10; 
			value= quotient;
	/*		System.out.println("after quotient " + quotient);
			System.out.println("after remainder " + remainder);
			System.out.println("after result " + result);
			System.out.println("after value " + value);
*/
		   }
		   

		   System.out.println("Result = " + result); 
		   System.out.println("Original value = " + real); // 5467 in this case
				
		    
		  }

}
