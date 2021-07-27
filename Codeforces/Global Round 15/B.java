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
			int r[][]=new int[n][5];
			for(int i=0;i<n;i++)
				for(int j=0;j<5;j++)
					r[i][j]=f.nextInt();
			
			int curr=0;
			for(int i=1;i<n;i++)
			{
				if(isBetter(curr,i,r))
					curr=i;
			}
			for(int i=0;i<n;i++)
			{	
				if(i!=curr && isBetter(curr,i,r))
				{
					sb.append("-1\n");
					continue out;
				}
			}
			curr++;
			sb.append(curr+"\n");
		}
		System.out.println(sb);
	}
	
	static boolean isBetter(int curr,int person,int r[][])
	{		
		int count=0;
		for(int i=0;i<5;i++)
		{
			if(r[person][i]<r[curr][i])
				count++;
		}
		if(count>=3)
			return true;
		return false;
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
