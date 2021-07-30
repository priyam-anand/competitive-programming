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
			int k=f.nextInt();
					
			int a[]=new int[n];
			for(int i=0;i<n;i++)
				a[i]=f.nextInt();
			long max=Long.MIN_VALUE;
			for(int i=n-1;i>=Math.max(0,n-200);i--)
			{
				for(int j=i-1;j>=Math.max(0,n-200);j--)
					max=Math.max(max,((long)(i+1)*(j+1) - (long)k*(a[i]|a[j])));
			}
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
