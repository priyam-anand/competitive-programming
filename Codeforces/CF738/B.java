import java.io.*;
import java.util.*;

public class B {
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			char ch[]=f.next().toCharArray();
			
			char ans[]=new char[n];
			int start=0;
			while(start<n && ch[start]=='?')
				start++;
			if(start==n)
			{	
				int point=0;
				for(int i=0;i<n;i++)
				{
					if(point==1)
						ans[i]='R';
					else
						ans[i]='B';
					point=point^1;
				}
				for(char c:ans)
					sb.append(c);
				sb.append("\n");
				continue;
			}
			for(int i=start;i<n;i++)
			{
				if(ch[i]!='?')
					ans[i]=ch[i];
				else
				{
					if(ans[i-1]=='R')
						ans[i]='B';
					else
						ans[i]='R';
				}
			}
			if(start>0)
			{	
				int point = -1;
				if(ch[start]=='R' && point==-1)
					point = 1;
				else if(ch[start]=='B' && point==-1)
					point = 0;
				int i=start-1;
				while(i>=0)
				{
					if(point==0)
						ans[i]='R';
					else
						ans[i]='B';
					point=point^1;
					i--;
				}
			}
			for(char c:ans)
				sb.append(c);
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
