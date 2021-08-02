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
			char b[]=f.next().toCharArray();
			char a[]=f.next().toCharArray();
			
			int count=0;
			for(int i=0;i<n;i++)
			{
				if(a[i]=='1')
				{
					if(b[i]=='0')
						count++;
					else if(i>0 && b[i-1]=='1')
					{
						count++;
						b[i-1]='5';
					}
					else if(i<n-1 && b[i+1]=='1')
					{
						count++;
						b[i+1]='5';
					}
				}
			}
			sb.append(count+"\n");
		}
		System.out.println(sb);
	}
	
	static int[] min(int a[],int b[])
	{
		for(int i=0;i<a.length;i++)
		{	
			if(a[i]>b[i])
				return b;
			else if(a[i]<b[i])
				return a;
		}
		return a;
	}
	
	static int[] go(int a[],int b[],int k)
	{	
		int ans[]=new int[a.length];
		for(int i=0;i<a.length;i++)
			ans[i]=(a[i]+b[(i+k)%a.length])%a.length;
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
