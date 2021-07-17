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
			long a[]=new long[n];
			long b[]=new long[n];
			long sum=0;
			for(int i=0;i<n;i++)
			{
				a[i]=f.nextInt();
				sum+=(long)a[i];
			}
			if(n==1)
			{
				sb.append("0\n");
				continue;
			}
			long avg=sum/n;
			for(int i=0;i<n;i++)
				b[i]=a[i]=avg;
			a[0]+=sum%n;
			long v=sum%n;
			int i=0;
			while(v>0)
			{
				b[i]++;
				i++;v--;
			}
			
			long opt1=0;
			if(a[0]!=a[1])
				opt1=(a[0]-a[1])*(n-1);
			long opt2=0;
			if(i>0)
				opt2=(b[0]-b[i])*(n-i)*i;
//			System.out.println(opt1+" "+opt2);
			sb.append(Math.min(opt1,opt2)+"\n");
//			for(int i=0;i<n;i++)
//				System.out.print(a[i]+" ");
//			System.out.println();
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
