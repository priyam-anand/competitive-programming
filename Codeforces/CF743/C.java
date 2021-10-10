import java.io.*;
import java.util.*;

public class C {
	 
	static Set<Integer> g[];
	static int[] indegree;
	static List<Integer> order;
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			
			indegree=new int[n+1];
			g=new HashSet[n+1];
			
			for(int i=0;i<=n;i++)
				g[i]=new HashSet<>();
			
			for(int i=1;i<=n;i++)
			{
				int c=f.nextInt();
				for(int j=0;j<c;j++)
				{
					int y=f.nextInt();
					g[y].add(i);
				}
			}
			order=new ArrayList<>();
			if(!topologicalSort())
			{
				sb.append("-1\n");
				continue ;
			}
			int ans=1;
			for(int i=1;i<order.size();i++)
			{
				if(order.get(i-1)>order.get(i)) {
					ans++;
				}
			}
			
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
	
	 static public boolean topologicalSort()
	 {
	  
		 for(Set<Integer> list:g)
		 {
			 for(int i:list)
				 indegree[i]++;
		 }
	 
	        
	        PriorityQueue<Integer> q
	            = new PriorityQueue<Integer>();
	        for (int i = 1; i <g.length; i++) {
	            if (indegree[i] == 0)
	                q.add(i);
	        }
	        PriorityQueue<Integer> currQ
            = new PriorityQueue<Integer>();
	        
	        for(int i:q)
	        	currQ.add(i);
	        
	        int cnt = 0;
	 
	        List<Integer> topOrder = new ArrayList<Integer>();
	        
	        while(!q.isEmpty())
	        {
	        	currQ=new PriorityQueue<Integer>();
	        	for(int i:q)
	        		currQ.add(i);
	        	q=new PriorityQueue<Integer>();
	        	while(!currQ.isEmpty())
	        	{
	        		int u = currQ.poll();
	        		topOrder.add(u);
	 
	           
	        		for (int node : g[u]) {
	               
	        			if (--indegree[node] == 0)
	                    {
	        				if(node<u)
	        					q.add(node);
	        				else
	        					currQ.add(node);
	                    }
	        		}
	        		cnt++;
	        	}
	        }
	 
	        if (cnt != g.length-1) {
	            return false;
	        }
	        for(int i:topOrder)
	        	order.add(i);
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