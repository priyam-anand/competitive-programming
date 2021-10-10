import java.io.*;
import java.util.*;

public class B {	
	
	public static void main(String[] args){
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			int x=f.nextInt();
			
			int a[]=new int[n];
			int copy[]=new int[n];
			for(int i=0;i<n;i++)
			{
				int curr=f.nextInt();
				a[i]=curr;
				copy[i]=curr;
			}
			Arrays.sort(copy);
			if(isValid(a,copy,x))
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		System.out.println(sb);
	}
	
	static boolean isValid(int a[],int copy[],int x)
	{
		int n=a.length;
		for(int i=0;i<n;i++)
		{
			if(a[i]!=copy[i] && i<x && (n-i-1)<x)
				return false;
		}
		return true;
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