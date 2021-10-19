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
		    int arr[]=new int[n];
		    for(int i=0;i<n;i++)
		    	arr[i]=f.nextInt();
		    Arrays.sort(arr);
		    int ans=0;
		    for(int i=1;i<n;i++)
		        ans=gcd(ans,arr[i]-arr[i-1]);
		    if(ans==0){
		        sb.append("-1\n");
		        continue;
		    }
		    sb.append(ans+"\n");
		}
		System.out.println(sb);
		
	}
	
	static boolean allEqual(List<Integer> list)
	{
		for(int i=1;i<list.size();i++)
			if(list.get(i-1)!=list.get(i))
				return false;
		return true;
			
	}
	
	static int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
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