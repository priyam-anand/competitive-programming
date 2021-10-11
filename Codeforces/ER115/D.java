import java.io.*;
import java.util.*;

public class D {
		
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			int a[][]=new int[n][2];
			for(int i=0;i<n;i++)
			{
				a[i][0]=f.nextInt();
				a[i][1]=f.nextInt();
			}
			long ans = ((long)n*(long)(n-1)*(long)(n-2))/6L;
			long minus = RightAngled(a,n);
			
			sb.append((ans-minus) +"\n");
		}
		System.out.println(sb);
		
	}
	
	
	static long RightAngled(int a[][],int n)
	{
	    HashMap<Integer,Long> xpoints  = new HashMap<>();
	    HashMap<Integer,Long> ypoints  = new HashMap<>();
	 
	    for (int i = 0; i < n; i++)
	    {
	        if(xpoints.containsKey(a[i][0]))
	        {
	            xpoints.put(a[i][0], xpoints.get(a[i][0])+1L);
	        }
	        else
	        {
	            xpoints.put(a[i][0], 1L);
	        }
	        if(ypoints.containsKey(a[i][1]))
	        {
	            ypoints.put(a[i][1], ypoints.get(a[i][1])+1L);
	        }
	        else
	        {
	            ypoints.put(a[i][1],1L);
	        }
	    }
		long count = 0;
	 
	    for (int i = 0; i < n; i++)
	    {
	        if (xpoints.get(a[i][0]) >= 1 && ypoints.get(a[i][1]) >= 1)
	            count+=(long)((xpoints.get(a[i][0])-1L)*(ypoints.get(a[i][1])-1L));
	    }
	 
	    return count;
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