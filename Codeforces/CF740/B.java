import java.io.*;
import java.util.*;

public class B {
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{	
			TreeSet<Integer> set=new TreeSet<>();
			int a=f.nextInt(),b=f.nextInt();
			if(a==0 || b==0)
			{
				set.add((int)Math.ceil((a+b)/2.0));
				set.add((int)Math.floor((a+b)/2.0));
			}
			else if(Math.abs(a-b)==1)
			{
				for(int i=0;i<=a+b;i++)
					set.add(i);
			}
			else 
			{
				int min=((a+b)/2);
				int start=min-Math.min(a, b);
				for(int i=start,j=Math.min(a, b);j>=0;i+=2,j--)
					set.add(i);
				min=((a+b+1)/2);
				start=min-Math.min(a, b);
				for(int i=start,j=Math.min(a, b);j>=0;i+=2,j--)
					set.add(i);
			}
			sb.append(set.size()+"\n");
			for(int i:set)
				sb.append(i+" ");
			sb.append("\n");
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
