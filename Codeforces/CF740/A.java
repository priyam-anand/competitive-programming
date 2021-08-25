import java.io.*;
import java.util.*;

public class A {
	
	public static void main(String[] args) {
		
		FastReader f=new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++)
				a[i]=f.nextInt();
			int curr=0;
			int count=0;
			while(!isSorted(a))
			{
				for(int i=curr;i<n-1;i+=2)
				{
					if(a[i]>a[i+1])
					{
						int temp=a[i];
						a[i]=a[i+1];
						a[i+1]=temp;
					}
				}
				curr=curr^1;
				count++;
			}
			sb.append(count+"\n");
		}
		System.out.println(sb);
	}
	static boolean isSorted(int a[])
	{
		for(int i=1;i<a.length;i++)
		{
			if(a[i]<a[i-1])
				return false;
		}
		return true;
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
