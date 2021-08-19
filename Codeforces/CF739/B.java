import java.io.*;
import java.util.*;

public class B {
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int a=f.nextInt(),b=f.nextInt(),c=f.nextInt();
			int dif=Math.abs(a-b);
			int size=2*dif;
			if(a>size || b>size || c>size)
			{
				sb.append("-1\n");
				continue;
			}
			else
			{
				int val1=c+dif;
				int val2=c-dif;
//				System.out.println("val1 = "+val1);
//				System.out.println("val2 = "+val2);
				if(val1<=size)
					sb.append(val1+"\n");
				else
					sb.append(val2+"\n");
			}
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
