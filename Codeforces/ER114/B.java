import java.io.*;
import java.util.*;

public class B {	
	
	public static void main(String[] args)throws Exception{
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			long arr[]=new long[3];
			for(int i=0;i<3;i++)
				arr[i]=f.nextLong();
			
			long m=f.nextLong();
			Arrays.sort(arr);
			
			long max=arr[0]+arr[1]+arr[2]-3;
			long min=arr[2]-(arr[0]+arr[1]+1);
			
			if(m<=max && m>=min)
				sb.append("YES\n");
			else
				sb.append("NO\n");
				
//			System.out.println(max+" "+min);
			
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