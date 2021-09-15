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
			int m=f.nextInt();
			
			List<Integer> a=new ArrayList<>();
			List<Integer> org = new ArrayList<>();
			
			Map<Integer,PriorityQueue<Pair>> map=new HashMap<>();
			
 			for(int i=0;i<n;i++)
 			{
 				for(int j=0;j<m;j++)
 				{
 					int x=f.nextInt();
 					a.add(x);
 					org.add(x);
 				}
 			}
 					
		
 			Collections.sort(a);
 			
 			int k=0;
			int mat[][]=new int[n][m];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<m;j++)
				{
					mat[i][j]=a.get(k);
					
					PriorityQueue<Pair> pq=map.getOrDefault(mat[i][j], 
							new PriorityQueue<Pair>());
					
					pq.add(new Pair(i,j));
					map.put(mat[i][j],pq);
					
					k++;
				}
			}
			
			int ans[][]=new int[n][m];
			int val=0;
			for(int idx:org)
			{
				PriorityQueue<Pair> pq=map.get(idx);
				Pair p=pq.poll();
				int x=p.x;
				int y=p.y;
				
				for(int i=0;i<y;i++)
					val+=ans[x][i];
				
				ans[x][y]=1;
			}
			sb.append(val+"\n");
		}
		System.out.println(sb);
	}
	
	static class Pair implements Comparable<Pair>
	{

		int x,y;
		Pair(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
		@Override
		public int compareTo(Pair o) {
			if(x!=o.x)
				return Integer.compare(x,o.x);
			return -Integer.compare(y,o.y);
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