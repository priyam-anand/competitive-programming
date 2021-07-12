import java.io.*;
import java.util.*;

public class julyLong21_C {

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			int k=f.nextInt();
			
			int values[]=new int[35];
			long arr[]=new long[n];
			for(int i=0;i<n;i++)
			{
				arr[i]=f.nextInt();
				long curr=1;
				int idx=0;
				while(curr<=arr[i])
				{	
					if((arr[i]&curr)>0)
						values[idx]++;
					idx++;
					curr*=2;
				}
			}
			long ans=0;
			for(int i=0;i<values.length;i++)
			{	
				ans+=values[i]/k;
				if(values[i]%k!=0)
					ans++;
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
