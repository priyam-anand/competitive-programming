import java.io.*;
import java.util.*;

public class C {
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			String str[]=new String[n];
			for(int i=0;i<n;i++)
				str[i]=f.next();
			int max=0;
			for(char ch='a';ch<='e';ch++)
				max=Math.max(max,solve(str,ch));
			sb.append(max+"\n");
		}
		System.out.println(sb);
	}
	
	static int solve(String str[],char ch)
	{	
		int count=0;
		int adv=0,equal=0;
		int totalAdv=0;
		List<Integer> c=new ArrayList<>();
		for(int i=0;i<str.length;i++)
		{		
			int countC=0;
			int countTtl=0;
			for(int j=0;j<str[i].length();j++)
			{
				if(str[i].charAt(j)==ch)
					countC++;
				else
					countTtl++;
			}
			if(countC>countTtl)
			{
				adv++;
				totalAdv+=(countC-countTtl);
			}
			else if(countC==countTtl)
				equal++;
			else
				c.add(Math.abs(countTtl-countC));
		}
		if(adv>0)
			count+=adv+equal;
		
		Collections.sort(c);
		for(int i:c)
		{
			if(totalAdv>i)
			{
				totalAdv-=i;
				count++;
			}
		}
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