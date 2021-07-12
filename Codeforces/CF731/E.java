package Practice;

import java.io.*;
import java.util.*;

public class E {

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		out:
		while(test-->0)
		{
			int n=f.nextInt();
			int k=f.nextInt();
			int a[]=new int[k+1];
			TreeMap<Integer,Integer> ac = new TreeMap<>();
			for(int i=1;i<=k;i++)
				a[i]=f.nextInt();
			int t[]=new int[k+1];
			for(int i=1;i<=k;i++)
			{
				t[i]=f.nextInt();
				ac.put(a[i],t[i]);
			}
			
			int ans[]=new int[n+1];
			for(int i=0;i<=n;i++)
				ans[i]=Integer.MAX_VALUE;
			
			int first=ac.firstKey();
			int curr=ac.get(first);
			ans[first]=Math.min(ans[first], curr);
			for(int i=first+1;i<n+1;i++)
			{	
				curr++;
				if(ac.containsKey(i))
				{	
					int val=ac.get(i);
					if(val<curr)
					{
						curr=val;
					}
				}
				ans[i]=Math.min(curr,ans[i]);
			}
			int last=ac.lastKey();
			curr=ac.get(last);
			ans[last]=Math.min(ans[last],curr);
			for(int i=last-1;i>0;i--)
			{
				curr++;
				if(ac.containsKey(i))
				{	
					int val=ac.get(i);
					if(val<curr)
						curr=val;
				}
				ans[i]=Math.min(curr,ans[i]);
			}
			for(int i=1;i<=n;i++)
				sb.append(ans[i]+" ");
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
