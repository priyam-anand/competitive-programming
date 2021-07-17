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
			int a=f.nextInt();
			int b=f.nextInt();
			
			char ch[]=f.next().toCharArray();
			
			if(b>=0)
			{
				long ans=a*n + n*b;
				sb.append(ans+"\n");
				continue;
			}
			
			long ans=a*n;
			long z=func(ch,'0');
			long o=func(ch,'1');
			
			ans+=((Math.min(z,o)*b)+b);
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
	
	static long func(char ch[],char c)
	{
		long ans=0;
		int len=0;
		for(int i=0;i<ch.length;i++)
		{
			if(ch[i]==c)
				len++;
			else
			{	
				if(len>0)
					ans++;
				len=0;
			}
		}
		if(len>0)
			ans++;
		return ans;
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