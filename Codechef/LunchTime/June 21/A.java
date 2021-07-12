import java.io.*;
import java.util.*;

public class A {

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			char ch[]=f.next().toCharArray();
			int i=0;
			boolean flag=false;
			for(i=0;i<ch.length;i++)
			{
				if(i==0 && ch[i]!='1')
				{
					sb.append('1');
					flag=!flag;
					break;
				}
				else if(i!=0 && ch[i]!='0')
				{
					sb.append('0');
					flag=!flag;
					break;
				}
				else
				{
					sb.append(ch[i]);
				}
			}
			for(;i<ch.length;i++)
			{
				sb.append(ch[i]);
			}
			if(!flag)
			{
				sb.append('0');
			}
			sb.append("\n");
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
