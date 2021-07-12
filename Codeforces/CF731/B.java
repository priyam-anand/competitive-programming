package Practice;

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
			char ch[]=f.next().toCharArray();
			int idx=-1;
			for(int i=0;i<ch.length;i++)
				if(ch[i]=='a') {
					idx=i;
					break;
				}
			if(idx==-1)
			{
				sb.append("NO\n");
				continue;
			}
			char curr='b';
			int r=idx+1;
			int l=idx-1;
			
			while(r<ch.length && l>=0)
			{
				if(ch[r]==curr)
				{
					curr++;
					r++;
				}
				else if(ch[l]==curr)
				{
					curr++;
					l--;
				}
				else
				{
					sb.append("NO\n");
					continue out;
				}
			}
			
			while(r<ch.length)
			{
				if(ch[r]==curr)
				{
					curr++;
					r++;
				}
				else
				{
					sb.append("NO\n");
					continue out;
				}
			}
			while(l>=0)
			{
				if(ch[l]==curr)
				{
					curr++;
					l--;
				}
				else
				{
					sb.append("NO\n");
					continue out;
				}
			}
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
