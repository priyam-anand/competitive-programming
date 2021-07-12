import java.io.*;
import java.util.*;

public class julyLong21_F {
	
	static List<Integer> g[];
	static int[] visited,level,parent;
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			g=new ArrayList[n+1];
			for(int i=0;i<=n;i++)
				g[i]=new ArrayList<Integer>();
			
			for(int i=1;i<n;i++)
			{
				int x=f.nextInt();
				int y=f.nextInt();
				g[x].add(y);
				g[y].add(x);
			}
			visited=new int[n+1];
			level=new int[n+1];
			parent=new int[n+1];
			
			bfs();
			
			int q=f.nextInt();
			for(int x=1;x<=q;x++)
			{
				int k=f.nextInt();
				int nodes[]=new int[k];
				int maxDepth = 0,currNode=-1;
				
				for(int i=0;i<k;i++)
				{
					nodes[i]=f.nextInt();
					if(level[nodes[i]]>maxDepth)
					{
						maxDepth=level[nodes[i]];
						currNode=nodes[i];
					}
				}
				boolean ans = getAns(currNode,nodes,x);
				if(ans)
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}
	
	static boolean getAns(int currNode,int[] query,int flag)
	{
		preProcess(currNode, flag);
		int maxDepth = 0;
		currNode = -1;
		for(int q : query) {
			if(visited[q] != flag && level[q] > maxDepth) 
			{
				maxDepth = level[q];
				currNode = q;
			}
		}
		if(currNode == -1) 
			return true;
	 
		while(visited[currNode] != flag) 
		{
			visited[currNode] = flag;
			currNode = parent[currNode];
		}
	 
		for(int q : query) 
		{
			if(visited[q] != flag || 
					level[q] < level[currNode]) 
				return false;
		}
		return true;
	}
	
	static void preProcess(int currNode,int flag) 
	{
		visited[currNode] = flag;
		while(parent[currNode] != -1) 
		{
			currNode = parent[currNode];
			visited[currNode] = flag;
		}
	}
	
	static void bfs()
	{
		boolean[] visited = new boolean[level.length];
		Queue<Integer> q = new LinkedList<>();
		
		int u = 1;
		parent[u] = -1;
		level[u] = 0;
		q.add(u);
		visited[u] = true;
	 
		while(!q.isEmpty()) 
		{
			int n = q.size();
			while(n-- > 0) 
			{
				int parentNode = q.poll();
				for(Integer child : g[parentNode]) 
				{
					if(!visited[child]) 
					{
						parent[child] = parentNode;
						level[child] = level[parentNode]+1;
						visited[child] = true;
						q.add(child);
					}
				}
			}
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