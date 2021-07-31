import java.io.*;
import java.util.*;

public class C {
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		out:
		while(test-->0)
		{
			int n=f.nextInt();
			int row1[]=new int[n];
			int row2[]=new int[n];
			int mat[][]=new int[2][n];
			for(int i=0;i<n;i++)
				mat[0][i]=f.nextInt();
			for(int i=0;i<n;i++)
				mat[1][i]=f.nextInt();
			
			row1[0]=mat[0][0];
			for(int i=1;i<n;i++)
				row1[i]=row1[i-1]+mat[0][i];
			row2[0]=mat[1][0];
			for(int i=1;i<n;i++)
				row2[i]=row2[i-1]+mat[1][i];

			int min=Integer.MAX_VALUE;
			for(int i=0;i<n;i++)
			{	
				int sum1=row1[n-1]-row1[i],sum2=0;
				if(i>0)
					sum2=row2[i-1];
				
				
				min=Math.min(min,Math.max(sum1,sum2));
			}
			sb.append(min+"\n");
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