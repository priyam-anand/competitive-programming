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
			List<Integer> list[]=new ArrayList[n];
			for(int i=0;i<n;i++)
				list[i]=new ArrayList<>();
			List<Pair> caves=new ArrayList<>();
			for(int i=0;i<n;i++)
			{
				int k=f.nextInt();
				int max=0;
				for(int j=0;j<k;j++)
				{
					int curr=f.nextInt();
					list[i].add(curr);
					max=Math.max(max,curr-(j-1));
				}
				caves.add(new Pair(max,k));
			}
			Collections.sort(caves);
//			for(Pair p:caves)
//				System.out.println(p.minReq+" "+p.gain);
			int curr=0;int ans=0;
			for(Pair p:caves)
			{		
				int val=p.minReq;
				if(val>curr)
				{
					int dif=val-curr;
					curr+=dif;
					ans+=dif;
				}
				curr+=p.gain;
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
	
	static class Pair implements Comparable<Pair>
	{
		int minReq,gain;
		Pair(int minReq,int gain)
		{
			this.minReq=minReq;
			this.gain=gain;
		}
		@Override
		public int compareTo(Pair o) {
			return Integer.compare(minReq,o.minReq);
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