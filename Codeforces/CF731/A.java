package Practice;

import java.io.*;
import java.util.*;

public class A {

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		out:
		while(test-->0)
		{
			int x1=f.nextInt();
			int x2=f.nextInt();
			
			int y1=f.nextInt();
			int y2=f.nextInt();
			
			int fx=f.nextInt();
			int fy=f.nextInt();
			
			int ans = Math.abs(x1 - y1) + Math.abs(x2 - y2);
	        if ((x1 == y1 && x1 == fx && Math.min(x2, y2) < fy && fy < Math.max(x2, y2))
	                || (x2 == y2 && x2 == fy && Math.min(x1, y1) 
	                < fx && fx < Math.max(x1, y1)))
	            ans += 2;
	        sb.append(ans+"\n");
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
