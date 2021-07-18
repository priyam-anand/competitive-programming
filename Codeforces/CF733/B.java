import java.io.*;
import java.util.*;

public class B {

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		out:
		while(test-->0)
		{	
			int n=f.nextInt();
			int m=f.nextInt();
			
			int ans[][]=new int[n][m];
			
			for(int j=0;j<n;j+=2)
			{	
				if(j==n-2)
				{
					j--;
					continue;
				}
				if(j>0 && j<n-1)
				{
					ans[j][0]=1;
					ans[j][m-1]=1;
					continue;
				}
				for(int i=0;i<m;i+=2)
					ans[j][i]=1;
			}
			for(int i[]:ans)
			{
				for(int j:i)
					System.out.print(j);
				System.out.println();
			}
			System.out.println();
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
