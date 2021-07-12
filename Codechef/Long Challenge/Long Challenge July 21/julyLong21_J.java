import java.io.*;
import java.util.*;

public class julyLong21_J {

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			int x=f.nextInt();
			
			int c[]=new int[n];
			for(int i=0;i<n;i++)
				c[i]=f.nextInt();
			int T[]=new int[n-1];
			long ans=0;
			for(int i=0;i<n-1;i++)
				T[i]=f.nextInt();
			
//			for(int i:c)
//				System.out.print(i+" ");
//			System.out.println();
//			for(int i:T)
//				System.out.print(" "+i);
//			System.out.println();
			int k=n-1;
			while(k>=0 && c[k]==0)
				k--;
//			System.out.println("k = "+k);
			if(k<0)
			{
				sb.append("0\n");
				continue;
			}
			for(int i=k;i>0;i--)
				ans+=(long)T[i-1];
//			System.out.println("ans = "+ans);
			long q=c[k];
			while(k>0)
			{
				q = q - (long)Math.min(T[k-1],q) + (long)c[k-1];
				k--;
			}
			
//			System.out.println("final q = "+q);
			ans+=q;
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
