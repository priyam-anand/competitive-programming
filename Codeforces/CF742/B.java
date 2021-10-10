import java.io.*;
import java.util.*;

public class B {	

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			int m=f.nextInt();
			
			int curr=computeXOR(n-1);
			
			if(curr==m)
				sb.append(n+"\n");
			else
			{
				if((curr^m)!=n)
					sb.append((n+1)+"\n");
				else
					sb.append((n+2)+"\n");
			}
		}
		System.out.println(sb);
	}

	static int computeXOR(int n)
    {
        if (n % 4 == 0)
            return n;
      
        if (n % 4 == 1)
            return 1;
      
        if (n % 4 == 2)
            return n + 1;
      
        return 0;
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