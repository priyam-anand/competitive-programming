import java.io.*;
import java.util.*;

public class D {
		
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		long count=1;
		List<String> list=new ArrayList<>();
		while(count<=1e18)
		{
			String str="";
			long copy=count;
			while(copy>0)
			{
				long d=copy%10;
				str=d+""+str;
				copy/=10;
			}
			count*=2L;
			list.add(str);
		}
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			String s="";
			while(n>0)
			{
				int d=n%10;
				s=d+""+s;
				n/=10;
			}
			int min=Integer.MAX_VALUE;
			for(String y:list)
			{
				int outcome = LCS(s,y,s.length(),y.length());
				min=Math.min(min,outcome);
			}
			sb.append(min+"\n");
		}
		System.out.println(sb);
	}
	
	static int LCS(String x,String y,int n,int m)
	{	
		int ans=0;int idx=0;
		char ch[]=y.toCharArray();
		for(int i=0;i<n;i++)
		{	
			if(idx<m && x.charAt(i)==ch[idx])
				idx++;
			else
				ans++;
		}
		ans+=m-idx;
		return ans;
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
