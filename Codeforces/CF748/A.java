import java.io.*;
import java.util.*;

public class A {	
		
	public static void main(String[] args) throws Exception
	{
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		out:
		while(test-->0)
		{
			int a=f.nextInt(),b=f.nextInt(),c=f.nextInt();
			int max=Math.max(a,Math.max(b,c));
			
			// if all are equal
			if(a==b&&b==c)
			{
				sb.append("1 1 1\n");
				continue;
			}
			if(a==b && b==max)
			{
				sb.append("1 1 "+(max-c+1)+"\n");
				continue;
			}
			if(b==c && b==max)
			{
				sb.append((max-a+1)+" 1 1\n");
				continue;
			}
			if(a==c && a==max)
			{
				sb.append("1 "+(max-b+1)+" 1\n");
				continue;
			}
			sb.append((max-a+(max==a?0:1))+" "+(max-b+(max==b?0:1))+" "+(max-c+(max==c?0:1))+"\n");
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