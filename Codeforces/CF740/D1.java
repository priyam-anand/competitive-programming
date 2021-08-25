import java.io.*;
import java.util.*;

public class D {
		
	static long mod;
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int n=f.nextInt();
		mod=f.nextLong();
		
		long dp[]=new long[n+1];
		dp[1]=1;
		
		long prefix=1;
		for(int i=2;i<=n;i++)
		{
			dp[i]=prefix;
			for(int j=1;j*j<=i;j++)
			{
				int times=((i/j)-(i/(j+1)));
//				System.out.println("times = "+times);
				dp[i]=(dp[i]%mod + (dp[j]*times)%mod)%mod;
				
				if(i/j!=j && j>1)
					dp[i]=(dp[i]+dp[i/j])%mod;
			}
			prefix=(prefix+ dp[i])%mod;
//			System.out.println("prefix = "+prefix);
//			793019428
		}
		
		System.out.println(dp[n]);
	}
	
	static class FastReader 
	{ 
	    BufferedReader br; 
	    StringTokenizer st; 
 
	    public FastReader() {
	    	br = new BufferedReader(new
	                 InputStreamReader(System.in)); 
	    }
	    String next() { 
	        while (st == null || !st.hasMoreElements()) { 
	            try{ 
	                st = new StringTokenizer(br.readLine()); 
	            } 
	            catch (IOException  e) { 
	                e.printStackTrace(); 
	            } 
	        } 
	        return st.nextToken(); 
	    } 
	    int nextInt() { 
	        return Integer.parseInt(next()); 
	    } 
	    long nextLong() { 
	        return Long.parseLong(next()); 
	    } 
	    double nextDouble() { 
	        return Double.parseDouble(next()); 
	    } 
	    String nextLine() { 
	        String str = ""; 
	        try{ 
	            str = br.readLine(); 
	        } 
	        catch (IOException e) { 
	            e.printStackTrace(); 
	        } 
	        return str; 
	    } 
	} 
}
