import java.util.Scanner;

public class ReverseaStringStringBuffer {
	public static String Reverse1(String a){
		String reverse = "";
		int len = a.length();
	    	for (int i = len - 1 ; i >= 0 ; i-- )
	        reverse += a.charAt(i);
	    	return reverse;
	}
	public static StringBuffer Reverse2(String a){
		StringBuffer sb = new StringBuffer(a);
		return sb.reverse();
	}
	
	   /* Function to print reverse of the passed string */
	
    
    public static String Reverse3(String str){
    	String reverse = "";
        if(str.length() == 1){
            return str;
        } else {
            //reverse += str.charAt(str.length()-1)+Reverse3(str.substring(0,str.length()-1));
        	
            return Reverse3(str.substring(1)) + str.charAt(0);
          //  return reverse;
        }
    }
	
	public static void main(String args[]){
		String original="The icon is blue in color";
	//	Scanner in = new Scanner(System.in);
       //         System.out.println("Enter a string to reverse: ");
       //         original = in.nextLine();
				System.out.println("Original string is: "+(original));
				System.out.println("Reverse with charat: "+Reverse1(original));
                System.out.println("Reverse stringbuffer.reverse(): "+Reverse2(original));
              //  Reverse3(original);
                System.out.println("Reverse recursive: "+Reverse3(original));
                //in.close();
	}
}