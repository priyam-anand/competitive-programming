import java.io.*;
import java.util.*;

public class julyLong21_G {
	
	static List<Integer> g[];
	static int[] lvl,par;
	static int IthPar[][];
	static int maxN,n;
	static long ans;
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		
		int test=f.nextInt();
		while(test-->0)
		{		
			StringBuffer sb=new StringBuffer();
			n=f.nextInt();
			int q=f.nextInt();
			
			maxN=(int)(Math.log(n)/Math.log(2))+1;
			g=new ArrayList[n+1];
			lvl=new int[n+1];
			par=new int[n+1];
			IthPar=new int[n+1][maxN];
			
			for(int i=0;i<=n;i++)
				g[i]=new ArrayList<>();
			for(int i=0;i<=n;i++)
			{
				for(int j=0;j<maxN;j++)
					IthPar[i][j]=-1;
			}
			
			for(int i=1;i<n;i++)
			{
				int x=f.nextInt();
				int y=f.nextInt();
				
				g[x].add(y);
				g[y].add(x);
			}
			initialize();
			
			while(q-->0)
			{	
				ans=0;
				int k=f.nextInt();
				int d=f.nextInt();
				
				int v[]=new int[k];
				for(int i=0;i<k;i++)
					v[i]=f.nextInt();
				
				for(int i=0;i<k;i++)
				{
					for(int j=i+1;j<k;j++)
					{	
						int a=v[i],b=v[j];
						if(lvl[a]>lvl[b])
						{
							int temp = a;
							a=b;
							b=temp;
						}
						int lca = LCA(a,b);
						if(lca==a || lca==b)
						{
							if(lvl[b]-lvl[a] == d)
								ans++;
						}
						else
						{
							int dist = Math.abs((lvl[lca]-lvl[a])) + Math.abs(lvl[lca]-lvl[b]);
							if(dist==d)
								ans++;
						}
					}
				}
				sb.append(ans+"\n");
			}
			System.out.println(sb);
		}
	}
	
	static void initialize()
	{
		dfs(1,-1,1);
		
		for(int j=1;j<maxN;j++)
		{
			for(int i=1;i<=n;i++)
			{
				if(IthPar[i][j-1]!=-1)
				{
					int par=IthPar[i][j-1];
					IthPar[i][j]=IthPar[par][j-1];
				}
			}	
		}
	}
	
	static void dfs(int n,int parent,int curr)
	{
		IthPar[n][0]=parent;
		lvl[n]=curr;
		for(int child : g[n])
		{
			if(child!=parent)
				dfs(child,n,curr+1);
		}
	}
	
	static int LCA(int a,int b)
	{
		int d = lvl[b]-lvl[a];
		
		while(d>0)
		{
			int i=(int)(Math.log(d)/Math.log(2));
			b=IthPar[b][i];
			d-= 1<<i;
		}
		if(a==b)
			return a;
		
		for(int i=maxN-1;i>=0;i--)
		{
			if(IthPar[a][i] !=-1 && (IthPar[a][i] != IthPar[b][i]))
			{
				a=IthPar[a][i];
				b=IthPar[b][i];
			}
		}
		return IthPar[a][0];
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
