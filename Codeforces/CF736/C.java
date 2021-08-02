import java.io.*;
import java.util.*;

public class C {
	
	static TreeSet<Integer> g[];
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
//		int test=f.nextInt();
//		out:
//		while(test-->0)
//		{
			//leaves which are bigger than thier parents will survive
			int n=f.nextInt();
			int m=f.nextInt();
			
			g=new TreeSet[n+1];
			for(int i=0;i<=n;i++)
				g[i]=new TreeSet<>();
			for(int i=0;i<m;i++) 
			{
				int x=f.nextInt();
				int y=f.nextInt();
				g[x].add(y);
				g[y].add(x);
			}
			Set<Integer> set=new HashSet<>();
			
			for(int i=1;i<=n;i++)
			{
				if(g[i].size()==0)
					set.add(i);
				else if(g[i].last()<i)
					set.add(i);	
			}
			
			int q=f.nextInt();
			while(q-->0)
			{
				int type=f.nextInt();
				if(type==1)
				{
					int x=f.nextInt();
					int y=f.nextInt();
					
					if(set.contains(x))
						set.remove(x);
					if(set.contains(y));
						set.remove(y);
					
					g[x].add(y);
					g[y].add(x);
					
					if(g[x].size()==0 || g[x].last()<x)
						set.add(x);
					if(g[y].size()==0 || g[y].last()<y)
						set.add(y);
				}
				if(type==2)
				{
					int x=f.nextInt();
					int y=f.nextInt();
					
					if(set.contains(x))
						set.remove(x);
					if(set.contains(y));
						set.remove(y);
						
					g[x].remove(y);
					g[y].remove(x);
					
					if(g[x].size()==0 || g[x].last()<x)
						set.add(x);
					if(g[y].size()==0 || g[y].last()<y)
						set.add(y);
				}
				if(type==3)
					sb.append(set.size()+"\n");
			}
//		}	
		System.out.println(sb);
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