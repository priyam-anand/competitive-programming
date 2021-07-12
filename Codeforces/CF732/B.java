import java.io.*;
import java.util.*;

public class B {

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		
		int test=f.nextInt();
		while(test-->0)
		{	
			StringBuffer sb=new StringBuffer();

			int n=f.nextInt();
			int m=f.nextInt();
			
			int ch[][]=new int[m][26];
			
			for(int i=0;i<n;i++)
			{
				char s[]=f.next().toCharArray();
				for(int j=0;j<m;j++)
				{	
					char c=s[j];
					ch[j][c-'a']++;
				}
			}
//			System.out.println();
//			for(int c[]:ch)
//			{
//				for(int x:c)
//					System.out.print(x+" ");
//				System.out.println();
//			}
			for(int i=0;i<n-1;i++)
			{
				char s[]=f.next().toCharArray();
				for(int j=0;j<m;j++)
				{	
					char c=s[j];
					ch[j][c-'a']--;
				}
			}
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<26;j++)
				{
					if(ch[i][j]!=0)
					{
						sb.append((char)('a'+j));
						break;
					}
				}
			}
			System.out.println(sb);
		}
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
