import java.io.*;
import java.util.*;

public class B {
	
	static List<Integer> g[];
	static int vis[],dist[];
	public static void main(String[] args)throws Exception {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		FileWriter fWriter = new FileWriter("C:\\Users\\priya\\OneDrive\\Desktop\\Facebook hacker cup inputs\\Outputs\\Question 2.txt");
		
		
		int test=f.nextInt();
		int testCase=1;
		out:
		while(test-->0)
		{	
			char ch[]=f.next().toCharArray();
			int n=ch.length;
			
			g=new ArrayList[27];
			vis=new int[27];
			dist=new int[27];
			for(int i=0;i<27;i++)
				g[i]=new ArrayList<>();
			
			int k=f.nextInt();
			for(int i=0;i<k;i++)
			{
				char c[]=f.next().toCharArray();
				int x=c[0]-'A';
				int y=c[1]-'A';
				
				g[y].add(x);
			}
			long ans=Long.MAX_VALUE;
			outer:
			for(int i=0;i<=26;i++)
			{
				//TODO reinitialize visited and distance array
				Arrays.fill(vis, 0);
				Arrays.fill(dist,-1);
				bfs(i);

				long temp=0;
				for(int j=0;j<n;j++)
				{
					int x=ch[j]-'A';
					int cd=dist[x];
					if(cd==-1)
						continue outer;
					temp+=(long)cd;
				}
				ans=Math.min(ans,temp);
			}
			
			if(ans!=Long.MAX_VALUE)
				sb.append("Case #"+testCase+": "+ans+"\n");
			else
				sb.append("Case #"+testCase+": "+(-1)+"\n");
			testCase++;
		}
		fWriter.write(sb.toString());
		fWriter.close();
	}
	
	static void bfs(int n)
	{
		vis[n]=1;
		Queue<Integer> q=new LinkedList<>();
		q.add(n);
		dist[n]=0;
		while(!q.isEmpty())
		{
			int curr=q.poll();
			for(int child:g[curr])
			{	
				if(vis[child]==1)
					continue;
				vis[child]=1;
				q.add(child);
				dist[child]=dist[curr]+1;
			}
		}
	}
	
	static class FastReader 
	{ 
	    BufferedReader br; 
	    StringTokenizer st; 
 
	    public FastReader()throws Exception {
	    	File file = new File("C:\\Users\\priya\\OneDrive\\Desktop\\Facebook hacker cup inputs\\Inputs\\consistency_chapter_2_input.txt");
	    	br = new BufferedReader(new FileReader(file)); 
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
