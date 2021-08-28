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
			int q=f.nextInt();
			
			char ch[]=f.next().toCharArray();
			int prefix[]=new int[n+1];
			int sign=1;
			for(int i=0;i<n;i++)
			{
				prefix[i+1]=prefix[i]+(sign)*(ch[i]=='+'?1:-1);
				sign*=-1;
			}
			
			while(q-->0)
			{
				int l=f.nextInt()-1;
				int r=f.nextInt();
				
				int currSum=Math.abs(prefix[r]-prefix[l]);
				if(currSum==0)
					sb.append("0\n");
				else if(currSum%2==0)
					sb.append("2\n");
				else
					sb.append("1\n");
			}
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
