import java.io.*;
import java.util.*;

public class D {
		
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		out:
		while(test-->0)
		{
			int n=f.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++)
				a[i]=f.nextInt();
			PriorityQueue<Pair> pq=new PriorityQueue<>();
			for (int i=0; i<n; i++) 
				if (a[i]>0) 
					pq.add(new Pair(i+1, a[i]));
			ArrayList<Integer> ans=new ArrayList<>();
			while (pq.size()>1) 
			{
				Pair aa=pq.remove(), b=pq.remove();
				aa.x--;
				b.x--;
				ans.add(aa.id);
				ans.add(b.id);
				if (aa.x>0) 
					pq.add(aa);
				if (b.x>0) 
					pq.add(b);
			}
//			System.out.println(ans);
			sb.append((ans.size()/2) +"\n");
			for (int i=0; i<ans.size(); i+=2) {
				sb.append(ans.get(i)+" "+ans.get(i+1)+"\n");
			}
		}
		System.out.println(sb);
		
	}
	
	static class Pair implements Comparable<Pair> {
		int id, x;
		public Pair(int id, int x) {
			this.id=id;
			this.x=x;
		}
		public int compareTo(Pair o) {
			return -Integer.compare(x, o.x);
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