package Practice;

import java.io.*;
import java.util.*;

public class C {

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		out:
		while(test-->0)
		{
			int k=f.nextInt(),n=f.nextInt(),m=f.nextInt();
			int a[]=new int[n];
			int b[]=new int[m];
			
			for(int i=0;i<n;i++)
				a[i]=f.nextInt();
			for(int i=0;i<m;i++)
				b[i]=f.nextInt();
			
			int i=0,j=0;
			
			List<Integer> ans=new ArrayList<>();
			
			while(i<n && j<m)
			{	
				if(a[i]==0)
				{
					k++;
					i++;
					ans.add(0);
				}
				else if(b[j]==0)
				{
					k++;
					j++;
					ans.add(0);
				}
				else if(a[i]<=k)
				{	
					ans.add(a[i]);
					i++;
				}
				else if(b[j]<=k)
				{
					ans.add(b[j]);
					j++;
				}
				else
				{
					sb.append("-1\n");
					continue out;
				}
			}
			while(i<n)
			{
				if(a[i]==0)
				{
					k++;
					i++;
					ans.add(0);
				}
				else if(a[i]<=k)
				{	
					ans.add(a[i]);
					i++;
				}
				else
				{
					sb.append("-1\n");
					continue out;
				}
			}
			while(j<m)
			{
				if(b[j]==0)
				{
					k++;
					j++;
					ans.add(0);
				}
				else if(b[j]<=k)
				{	
					ans.add(b[j]);
					j++;
				}
				else
				{
					sb.append("-1\n");
					continue out;
				}
			}
			
			for(int x : ans)
				sb.append(x+" ");
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
