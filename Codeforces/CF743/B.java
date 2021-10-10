import java.io.*;
import java.util.*;

public class B {	
	
	public static void main(String[] args)throws Exception{
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			int a[]=new int[n];
			int b[]=new int[n];
			
			for(int i=0;i<n;i++)
				a[i]=f.nextInt();
			for(int i=0;i<n;i++)
				b[i]=f.nextInt();
			
			List<Integer> prefix=new ArrayList<>();
			prefix.add(b[0]);
			for(int i=1;i<n;i++)
				prefix.add(Math.max(prefix.get(i-1),b[i]));
		
			int ans=Integer.MAX_VALUE;
			for(int i=0;i<n;i++)
			{
				int curr=a[i];
				// search the first element greater than the curr
				int idx=Collections.binarySearch(prefix,curr);
				int toAdd=(idx+1)*-1;
				int temp=i+toAdd;
				ans=Math.min(temp,ans);
			}
			sb.append(ans+"\n");
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