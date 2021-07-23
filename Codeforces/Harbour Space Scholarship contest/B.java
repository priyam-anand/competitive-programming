import java.io.*;
import java.util.*;

public class B {

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		int test=f.nextInt();
		out:
		while(test-->0)
		{	
			String s=f.next();
			String t=f.next();
			
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i)==t.charAt(0))
				{	
					if(isValid(s,t,i))
					{
						sb.append("YES\n");
						continue out;
					}
				}
			}
			sb.append("NO\n");
		}
		System.out.println(sb);
	}
	
	static boolean isValid(String s,String t,int idx)
	{	
		int i=idx,j=0;
		int n=s.length();
		int m=t.length();
		
		while(i<n && j<m && s.charAt(i)==t.charAt(j))
		{	
			i++;
			j++;
			int x=i-1;
			int y=j-1;
//			System.out.println("x = "+x+" y = "+y);
			while(x>=0 && y<m && s.charAt(x)==t.charAt(y))
			{
				x--;
				y++;
			}
			if(y==m)
			{	
//				System.out.println("y is equal to m");
				return true;
			}
			
		}
//		System.out.println("j = "+j);
		if(j==m)
			return true;
		return false;
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
