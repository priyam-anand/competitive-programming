import java.io.*;
import java.util.*;

public class C {
	
	static long dp[][];
	static int a[],n;
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
//		int test=f.nextInt();
//		while(test-->0)
//		{
		
		n=f.nextInt();
		dp=new long[n+1][n+1];
		
		a=new int[n+1];
		for(int i=1;i<=n;i++)
			a[i]=f.nextInt();
		
		for(int i=0;i<n+1;i++)
			for(int j=0;j<n+1;j++)
				dp[i][j]=-1;
		
		for(int i=0;i<n+1;i++)
			dp[i][0]=0;
		
		
		for(int i=1;i<=n;i++)
		{
			for(int k=1;k<=i;k++)
			{	
				if(dp[i-1][k-1]+a[i]<0 || dp[i-1][k-1]<0)
					dp[i][k]=dp[i-1][k];
				else
					dp[i][k]=Math.max(dp[i-1][k-1]+a[i],dp[i-1][k]);
			}
		}
//		for(long arr[]:dp)
//		{
//			for(long x : arr)
//				System.out.print(x+" ");
//			System.out.println();
//		}
				
		int max=0;
		for(int i=1;i<n+1;i++)
		{
			for(int j=0;j<n+1;j++)
			{
				if(dp[i][j]>=0)
					max=Math.max(max,j);
			}
		}
		System.out.println(max);
//		}
//		System.out.println(sb);
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
