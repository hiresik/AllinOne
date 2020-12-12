
public class ReplaceString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{
			String str = "I use selenium webdriver. selenium is a tool for web applications automation.";
			System.out.println(str);
			String toBeReplaced = "tool";
			String toReplacedWith = "Firefox";
			String[] astr = str.split(toBeReplaced);
			System.out.println(astr.length);
			for (String a : astr)
	            System.out.println(a);
	    
			StringBuffer strb = new StringBuffer();
			for ( int i = 0; i <= astr.length - 1; i++ ) {
			strb = strb.append( astr[i] );
			if (i != astr.length - 1) {
			strb = strb.append(toReplacedWith);
			}
			}
			System.out.println(strb);

			}
	}

}
