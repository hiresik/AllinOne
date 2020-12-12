import java.io.FileNotFoundException;

public class PatternPrint {
	public static void main( String[] args ) throws FileNotFoundException {
		int p = 0;
		for( int i=1; i<=5; i++ ){
		for( int j=1; j<=i; j++ ){
		System.out.print ( j );
		}
		System.out.println (); //to print new line for each iteration of outer loop
		}
		
	
	
	for( int i=1; i<=5; i++ ){
	for( int k=1; k<=5-i; k++ ){
	System.out.print (" ");
	}
	for( int j=1; j<=i; j++ ){
	System.out.print ("*");
	}
	System.out.println ();
	p=p+1;
	}
	}
}
