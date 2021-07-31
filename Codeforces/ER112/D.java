import java.io.*;
import java.util.*;

public class D {
		
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		
		int n=f.nextInt();
		int m=f.nextInt();
			
		char ch[]=f.next().toCharArray();
		int prefix[][]=new int[6][n];
		
		String perm[]= {"abc","acb","bac","bca","cab","cba"};
		
		for(int j=0;j<n;j++)
			for(int i=0;i<6;i++)
			{	
				if(j>0)
					prefix[i][j]=prefix[i][j-1]+(ch[j]!=perm[i].charAt(j%3)?1:0);
				else 
					prefix[i][j]=(ch[j]!=perm[i].charAt(j%3)?1:0);	
			}
		
		while(m-->0)
		{
			int l=f.nextInt()-1;
			int r=f.nextInt()-1;
			
			int min=Integer.MAX_VALUE;
			for(int i=0;i<6;i++)
				min=Math.min(min,prefix[i][r]-(l>0?prefix[i][l-1]:0));
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
