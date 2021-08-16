import java.io.*;
import java.util.*;

public class C {
		
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		out:
		while(test-->0)
		{
			int n=f.nextInt();
			int a[]=new int[n];
			for(int i=0;i<a.length;i++)
				a[i]=f.nextInt();
			
			if(a[0]==1)
			{
				sb.append((n+1)+" ");
				for(int i=1;i<=n;i++)
					sb.append(i+" ");
				sb.append("\n");
				continue;
			}
			else if(a[n-1]==0)
			{
				for(int i=1;i<=n;i++)
					sb.append(i+" ");
				sb.append((n+1)+" ");
				sb.append("\n");
				continue;
			}
			else
			{
				List<Integer> ans=new ArrayList<>();
				boolean poss=false;
				for(int i=0;i<n-1;i++)
				{
					if(a[i]==0 && a[i+1]==1 && !poss)
					{
						ans.add(i+1);
						ans.add(n+1);
						ans.add(i+1+1);
						i++;
						poss=true;
					}
					else
						ans.add(i+1);
				}
				if(!ans.contains(n))
				ans.add(n);
				for(int i:ans)
					sb.append(i+" ");
				sb.append("\n");
			}
		}
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