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
			int a[]=new int[n+1];
			for(int i=1;i<=n;i++)
				a[i]=f.nextInt();
			
			int count=0;
			for(int i=1;i<=n;i++)
			{
				int req=a[i]-(i%a[i]);
//				System.out.println("req = "+req);
				while(req<=n)
				{	
//					System.out.println("i = "+i+" req = "+req);
					if(req<=i)
					{
						req+=a[i];
						continue;
					}
					long val1=(long)a[i]*a[req];
					long val2=i+req;
//					System.out.println("val1 - "+val1);
//					System.out.println("val2 = "+val2);
					if(val1==val2)
						count++;
					req+=a[i];
				}
			}
			sb.append(count+"\n");
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
