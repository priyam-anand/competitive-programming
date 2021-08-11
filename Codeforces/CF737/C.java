import java.io.*;
import java.util.*;

public class C {
	
	static int mod=(int)1e9+7;;
	static int N=200009;
	static long[] factorialNumInverse = new long[N + 1];
	static long[] naturalNumInverse = new long[N + 1];
	static long[] fact = new long[N + 1];
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		InverseofNumber();
	    InverseofFactorial();
	    factorial();
	     
		int test=f.nextInt();
		out:
		while(test-->0)
		{
			int n=f.nextInt();
			int k=f.nextInt();
			
			long odd=0,even=0;
			
			for(int i=0;i<n;i++)
			{
				if(i%2==0)
					even=((even%mod)+(nCrModP(n,i)%mod))%mod;
				else
					odd=((odd%mod)+(nCrModP(n,i)%mod))%mod;
			}
			long dp[][]=new long[k+1][2];
			dp[0][0]=1;
			for(int i=0;i<k;i++)
			{
				dp[i+1][1] = ((dp[i+1][1]%mod)+(dp[i][1]*odd)%mod)%mod;
		        dp[i+1][1] = ((dp[i+1][1]%mod)+(dp[i][1]*even)%mod)%mod;
		        dp[i+1][0] = ((dp[i+1][0]%mod)+(dp[i][0]*even)%mod)%mod;
		        dp[i+1][1] = ((dp[i+1][1]%mod)+(dp[i][1]))%mod;
		        if (n%2==1) 
		        	dp[i+1][0] = ((dp[i+1][0]%mod)+(dp[i][0]%mod))%mod;
		        else 
		        	dp[i+1][1] = ((dp[i+1][1]%mod)+(dp[i][0]%mod));
			}
			long ans=((dp[k][0]%mod)+(dp[k][1]%mod))%mod;
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
	
	public static void InverseofNumber()
	{
	    naturalNumInverse[0] = naturalNumInverse[1] = 1;
	     
	    for(int i = 2; i <= N; i++)
	        naturalNumInverse[i] = naturalNumInverse[mod % i] *
	                                 (long)(mod - mod / i) % mod;
	}
	 
	public static void InverseofFactorial()
	{
	    factorialNumInverse[0] = factorialNumInverse[1] = 1;
	 
	    for(int i = 2; i <= N; i++)
	        factorialNumInverse[i] = (naturalNumInverse[i] *
	                           factorialNumInverse[i - 1]) % mod;
	}
	 
	public static void factorial()
	{
	    fact[0] = 1;
	 
	    for(int i = 1; i <= N; i++)
	    {
	        fact[i] = (fact[i - 1] * (long)i) % mod;
	    }
	}
	 
	public static long nCrModP(int N, int R)
	{
	     
	    long ans = ((fact[N] * factorialNumInverse[R]) %
	                       mod * factorialNumInverse[N - R]) % mod;
	     
	    return ans;
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