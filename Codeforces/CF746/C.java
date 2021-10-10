import java.io.*;
import java.util.*;

public class C {
	
	static Set<Integer> g[];
	static int vis[],currXor[],a[];
	 
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		out:
		while(test-->0)
		{
			int n=f.nextInt();
			int k=f.nextInt();
			
			a=new int[n+1];
			for(int i=1;i<=n;i++)
				a[i]=f.nextInt();
			
			g=new HashSet[n+1];
			vis=new int[n+1];
			currXor=new int[n+1];
			
			for(int i=0;i<=n;i++)
				g[i]=new HashSet<>();
			
			for(int i=0;i<n-1;i++)
			{
				int x=f.nextInt();
				int y=f.nextInt();
				
				g[x].add(y);
				g[y].add(x);
			}
			
			int xor=a[0];
			for(int i=1;i<=n;i++)
				xor=xor^a[i];
//			System.out.println("xor = "+xor);
			if(xor==0)
			{
				sb.append("YES\n");
				continue;
			}
			if(k==2)
			{
				sb.append("NO\n");
				continue;
			}
			// find a subtree which as xor = ourXor
			boolean poss=false;
			int node = -1;
			dfs(1);
//			for(int i:currXor)
//				System.out.print(i+" ");
//			System.out.println();
			for(int i=2;i<=n;i++)
			{
				if(currXor[i]==0)
				{
					sb.append("YES\n");
					continue out;
				}
				if(currXor[i]==xor)
				{
					node = i;
					poss=true;
				}
			}
			if(!poss)
			{
				sb.append("NO\n");
				continue;
			}
			// delete all the occ of node from the tree
			for(int i=0;i<=n;i++)
			{
				if(g[i].contains(node))
					g[i].remove(node);
			}
			g[node]=new HashSet<>();
			vis=new int[n+1];
			currXor=new int[n+1];
			
			dfs(1);
			poss=false;
			for(int i=1;i<=n;i++)
			{
				if(currXor[i]==xor)
				{
					poss=true;
					break;
				}
			}
			if(poss)
			{
				sb.append("YES\n");
				continue;
			}
			sb.append("NO\n");
        }
		System.out.println(sb);
	}
	
	static int dfs(int n)
	{
		currXor[n]=a[n];
		vis[n]=1;
		for(int child:g[n])
		{
			if(vis[child]==0)
			{
				currXor[n]=currXor[n]^dfs(child);
			}
		}
		return currXor[n];
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
