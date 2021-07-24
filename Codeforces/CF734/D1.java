import java.io.*;
import java.util.*;

public class D {
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			int m=f.nextInt();
			int k=f.nextInt();
			int y=((n*m)/2)-k;
			
			if(m==1 && k>0)
			{
				sb.append("No\n");
				continue;
			}
			if(n==1 && y>0)
			{
				sb.append("No\n");
				continue;
			}
			
			if(n%2!=0)
			{
				int min=m/2;
				if(k<min)
				{
					sb.append("No\n");
					continue;
				}
				k-=min;
				n--;
			}
			if(m%2!=0)
			{
				int min=n/2;
				if(y<min)
				{
					sb.append("No\n");
					continue;
				}
				y-=min;
				m--;
			}
			if(k%2==0)
				sb.append("Yes\n");
			else
				sb.append("No\n");
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
