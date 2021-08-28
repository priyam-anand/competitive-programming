import java.io.*;
import java.util.*;

import javax.script.Compilable;

public class C {
		
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			char ch[]=f.next().toCharArray();
			
			if(allOne(ch))
			{	
				sb.append(1+" "+(n-1)+" "+(2)+" "+n+"\n");
				continue;
			}
			else 
			{
				int idx=-1;
				for(int i=1;i<=n;i++)
					if(ch[i-1]=='0')
					{
						idx=i;
						break;
					}
//				System.out.println("idx = "+idx);
				if(idx<=n/2)
					sb.append(idx+" "+n+" "+(idx+1)+" "+n+"\n");
				else
					sb.append(1+" "+(idx)+" "+1+" "+(idx-1)+"\n");
			}
		}
		System.out.println(sb);
	}

	static boolean allOne(char ch[])
	{
		for(int i=0;i<ch.length;i++)
			if(ch[i]!='1')
				return false;
		return true;
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