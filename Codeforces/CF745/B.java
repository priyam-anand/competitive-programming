import java.io.*;
import java.util.*;

public class B {	
	
	public static void main(String[] args){
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			long n=f.nextLong();
			long m=f.nextLong();
			long k=f.nextLong()-2;
			
			long max=(n*(n-1))/2;
			
			if(m<(n-1) || m>max || k<0)
				sb.append("NO\n");
			else if(k==0)
			{
				if(n==1)
					sb.append("YES\n");
				else 
					sb.append("NO\n");
			}
			else if(k==1)
			{
				if(m==max)
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}
			else if(k>1)
				sb.append("YES\n");
			
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