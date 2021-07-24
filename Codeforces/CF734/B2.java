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
			
			int a[]=new int[n],ans[]=new int[n],times[]=new int[k+1];
			List<Integer> idx[]=new ArrayList[n+1];
			for(int i=0;i<=n;i++)
				idx[i]=new ArrayList<Integer>();
			for(int i=0;i<n;i++)
			{
				a[i]=f.nextInt();
				idx[a[i]].add(i);
			}
			Set<Integer> comp=new HashSet<Integer>();
			for(int i=1;i<idx.length;i++)
			{	
				List<Integer> l=idx[i];
				if(l.size()>=k)
				{	
					comp.add(i);
					int curr=1;
					for(int m:l)
					{	
						if(curr>k)
							break;
						ans[m]=curr;
						times[curr]++;
						curr++;
					}
				}
			}
			int curr=1;
			for(int i=1;i<idx.length;i++)
			{
				if(comp.contains(i))
					continue;
				List<Integer> l=idx[i];
				for(int m:l)
				{
					ans[m]=curr;
					curr++;
					if(curr>k)
						curr=1;
				}
				if(curr>k)
					curr=1;
			}
			int arr[]=new int[k+1];
			for(int i=0;i<n;i++)
				arr[ans[i]]++;
			int min=10000000;
			for(int i=1;i<=k;i++)
				min=Math.min(arr[i],min);
			for(int i=0;i<n;i++)
			{
				if(arr[ans[i]]>min)
				{
					arr[ans[i]]--;
					ans[i]=0;
				}
			}
			for(int i=0;i<n;i++)
				sb.append(ans[i]+" ");
			sb.append("\n");
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
