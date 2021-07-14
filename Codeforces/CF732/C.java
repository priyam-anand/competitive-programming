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
			ArrayList<Integer> a=new ArrayList<>(),b=new ArrayList<>();
			Map<Integer,ArrayList<Integer>[]> org=new HashMap<>(),sorted=new HashMap<>();
			for(int i=0;i<n;i++)
			{
				int v=f.nextInt();
				ArrayList<Integer> temp[];
				if(org.containsKey(v))
					temp=org.get(v);
				else
				{
					temp=new ArrayList[2];
					temp[0]=new ArrayList<>();
					temp[1]=new ArrayList<>();
				}
				if(i%2==0)
					temp[0].add(i);
				else
					temp[1].add(i);
				org.put(v, temp);
				a.add(v);
				b.add(v);
			}
			Collections.sort(b);
			for(int i=0;i<n;i++)
			{
				int v=b.get(i);
				ArrayList<Integer> temp[];
				if(sorted.containsKey(v))
					temp=sorted.get(v);
				else
				{
					temp=new ArrayList[2];
					temp[0]=new ArrayList<>();
					temp[1]=new ArrayList<>();
				}
				if(i%2==0)
					temp[0].add(i);
				else
					temp[1].add(i);
				sorted.put(v, temp);
			}
			for(int key : sorted.keySet())
			{
				int Ssize0=sorted.get(key)[0].size();
				int Ssize1=sorted.get(key)[1].size();
				int Osize0=org.get(key)[0].size();
				int Osize1=org.get(key)[1].size();
				
				if(Ssize0!=Osize0 || Ssize1!=Osize1)
				{
					sb.append("NO\n");
					continue out;
				}
			}
			sb.append("YES\n");
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