
public class pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i,j,k,m,n;
		k=4;
		m=9;
		String str;
		
		for(i=1;i<=4;i++)
		{
		
			//n=k-4;
			for(n=0;n<4-k;n++)
			{
				System.out.print(" ");
			}
			for(j=1;j<=k;j++)
			{
				
				System.out.print(m);
				m--;
				
			}
			System.out.println("");
			k--;
		}
	}

}
