import java.io.*;
import java.util.*;

public class B {	
	
	public static void main(String[] args){
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		out:
		while(test-->0)
		{
			long n=f.nextLong();
			char zz[]={'0','0'},tf[]= {'2','5'},fif[]= {'5','0'},sf[]= {'7','5'};
			
			int ans=times(n,zz);
			ans=Math.min(ans, times(n,tf));
			ans=Math.min(ans,times(n,fif));
			ans=Math.min(ans,times(n,sf));
			
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}

	static int times(long n, char ch[])
	{
		int count=0;
		int i=1;
		while(n>0 && i>=0)
		{
			int d=(int)(n%10);
			if(d==ch[i]-'0')
				i--;
			else
			{
				count++;
			}
			n/=10;
		}
		if(i!=-1)
			return 100000;
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