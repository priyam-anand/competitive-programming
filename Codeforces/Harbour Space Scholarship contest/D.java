import java.io.*;
import java.util.*;

public class D {

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			String x=f.next();
			String y=f.next();
			
			int n=x.length();
			int m=y.length();
			
			if(solve(x,y,n,m))
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		System.out.println(sb);
	}
	
	static boolean solve(String s,String t,int n,int m)
	{	
		if(n<m)
			return false;
		int start=(n-m)%2;
		int k=0;
		int curr=1;
		for(int i=start;i<n;i++)
		{		
			if(k==m)
				break;
			if(curr==0)
				curr=curr^1;
			else if(s.charAt(i)==t.charAt(k))
				k++;
			else
				curr=curr^1;
		}
		if(k==m)
			return true;
		return false;
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
