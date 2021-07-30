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
			char ch[]="abcdefghijklmnopqrstuvwxyz".toCharArray();
			if(n<=26)
			{
				for(int i=0;i<n;i++)
					sb.append(ch[i]);
				sb.append("\n");
				continue;
			}
			if(n%2!=0)
			{
				int a=n-6;
				
				for(int i=0;i<((a+1)/2);i++)
					sb.append("a");
				for(int i=0;i<3;i++)
					sb.append("b");
				for(int i=0;i<a/2;i++)
					sb.append("a");
				sb.append("c");
				sb.append("bb");
				sb.append("\n");
				continue;
			}
			else
			{
				if((n/2)%2==0)
				{
					int a=n/2-1;
					for(int i=0;i<((a+1)/2);i++)
						sb.append("a");
					sb.append("b");
					for(int i=0;i<a/2;i++)
					sb.append("a");
					for(int i=0;i<((a+1)/2);i++)
						sb.append("c");
					sb.append("d");
					for(int i=0;i<a/2;i++)
					sb.append("c");
					sb.append("\n");
					continue;
				}
				else
				{
					int a=n/2 - 6;
					for(int i=0;i<((a+1)/2);i++)
						sb.append("a");
					for(int i=0;i<3;i++)
						sb.append("b");
					for(int i=0;i<a/2;i++)
						sb.append("a");
					sb.append("c");
					sb.append("bb");
					
					for(int i=0;i<((a+1)/2);i++)
						sb.append("d");
					for(int i=0;i<3;i++)
						sb.append("e");
					for(int i=0;i<a/2;i++)
						sb.append("d");
					sb.append("f");
					sb.append("ee");
					
					sb.append("\n");
					continue;
				}
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
