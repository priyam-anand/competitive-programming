import java.io.*;
import java.util.*;

public class C {
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int n=f.nextInt();
		int a[]=new int[n];
		long ans=0;
		for(int i=0;i<n;i++)
			a[i]=f.nextInt();
		
		
		for(int i=0;i<n-n%2;i+=2)
		{	
//			System.out.println("adding = "+(Math.min(a[i],a[i+1])));
			long till= a[i]-a[i+1];
			ans+=(long)(Math.min(a[i],a[i+1]));
			if(till<0)
				continue;
			for(int j=i+2;j<n-n%2;j+=2)
			{
//				System.out.println("till = "+till);
				if(a[j]+(till-(a[i]-a[i+1]))>a[j+1])
				{
//					System.out.println("not eligible = "+(a[j]-a[j+1]));
					till+=(long)(a[j]-a[j+1]);
					continue;
				}
				else
					ans+=(long)Math.min(a[i]-a[i+1],
							a[j+1]-(a[j]+till-(a[i]-a[i+1])))+1L;
//				System.out.println("adding in = "+(Math.min(a[i]-a[i+1],a[j+1]-
//						(a[j]+till-(a[i]-a[i+1])))+1L));
				till+=(long)(a[j]-a[j+1]);
				if(till<0)
					break;
			}
		}
		System.out.println(ans);
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