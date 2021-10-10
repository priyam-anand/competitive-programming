import java.io.*;
import java.util.*;

public class A {	
		

	public static void main(String[] args) throws Exception
	{
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		out:
		while(test-->0)
		{
			int n=f.nextInt();
			int h=f.nextInt();
			
			List<Integer> a=new ArrayList<>();
			for(int i=0;i<n;i++)
				a.add(f.nextInt());
			
			Collections.sort(a,Collections.reverseOrder());
			
			int sum=a.get(0)+a.get(1);
			
			int times = 2*(h/sum);
			int left = h%sum;
			if(left>0)
			{
				if(left>a.get(0) && left>a.get(1))
					times+=2;
				else
					times++;
			}
			sb.append(times+"\n");
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