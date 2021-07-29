import java.io.*;
import java.util.*;

class E {

	static int dp[][];
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{	
			int n=f.nextInt();
			int k=f.nextInt();
			int a[]=new int[n];
			int max=0;
			for(int i=0;i<n;i++)
			{
				a[i]=f.nextInt();
				max=Math.max(a[i],max);
			}
			dp=new int[k+1][n+1];
			
			int last[]=new int[max+1];
			Arrays.fill(last,-1);
			for(int i=1;i<=n;i++)
			{
				if(last[a[i-1]]==-1)
					dp[0][i]=1;
				else
					dp[0][i]=1+dp[0][last[a[i-1]]];
				last[a[i-1]]=i;
			}
			
			for(int i=1;i<=k;i++)
			{	
				int currMax=0;
				Arrays.fill(last,-1);
				for(int j=1;j<=n;j++)
				{	
					if(last[a[j-1]]==-1)
					{
						dp[i][j]=1+currMax;
						last[a[j-1]]=j;
					}
					else
					{
						dp[i][j]=Math.max(1+dp[i][last[a[j-1]]],1+currMax);
						last[a[j-1]]=j;
					}
					currMax=Math.max(currMax,dp[i-1][j]);
				}
			}

			max=0;
			for(int i[]:dp)
				for(int j:i)
					max=Math.max(max,j);
			sb.append(max+"\n");
		}
		System.out.println(sb);
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
