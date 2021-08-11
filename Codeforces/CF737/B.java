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
			int n=f.nextInt();
			int k=f.nextInt();
			int a[]=new int[n],b[]=new int[n];;
			for(int i=0;i<n;i++)
			{
				a[i]=f.nextInt();
				b[i]=a[i];
			}
			Arrays.sort(b);
			Map<Integer,Integer> map=new HashMap<>();
			for(int i=0;i<n;i++)
				map.put(b[i],i);
			int count=solve(a,n,map,b);
//			System.out.println("count = "+count);
			if(count<=k)
				sb.append("Yes\n");
			else
				sb.append("No\n");
		}
		System.out.println(sb);
	}
	
	static int solve(int a[],int n,Map<Integer,Integer> map,int b[])
	{	
		int count=1;
		for(int i=1;i<n;i++)
		{
			int curr=a[i];
			int idx=map.get(curr);
			if(idx==0 || b[idx-1]!=a[i-1])
				count++;
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
