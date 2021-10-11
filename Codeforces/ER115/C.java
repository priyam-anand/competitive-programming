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
			long sum=0;
			Map<Long,Integer> map=new HashMap<>();
			for(int i=0;i<n;i++)
			{
				a[i]=f.nextInt();
				map.put((long)a[i], map.getOrDefault((long)a[i], 0)+1);
				sum+=(long)a[i];
			}
			double k = sum/(double)n;
			double minus = sum - k*(n-2);
			
			if(minus!=(long)minus)
			{
				sb.append("0\n");
				continue;
			}
			long ans=0;
//			System.out.println(map);
			for(int i=0;i<n;i++)
			{
				long req=(long)(minus-(long)a[i]);
//				System.out.println("req = "+req);
				if(req==a[i])
					ans+=(long)map.getOrDefault(req,1)-1L;
				else
					ans+=(long)map.getOrDefault(req,0);
//				System.out.println("ans = "+ans+"\n");
				map.put((long)a[i], map.get((long)a[i])-1);
			}
			sb.append(ans+"\n");
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
