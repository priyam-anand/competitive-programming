import java.io.*;
import java.util.*;

public class julyLong21_D {
	
	static int[] a,b,c;
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			a=new int[(int)1e5 + 5];
			b=new int[(int)1e5 + 5];
			c=new int[(int)1e5 + 5];
			
			int n=f.nextInt();
			for(int i=1;i<=n;i++)
				a[i]=f.nextInt();
			
			Arrays.sort(a,1,n+1);
			preCalc(n);
			
			long sum=0,ans=0;
			for(int i=1;i<=n;i++)
				sum+=(long)a[i];
			
			long min=Long.MAX_VALUE;
			for(int i=1;i<n+1;i++)
	        {
	            ans=(sum-a[i]+gcd(c[i-1],b[i+1]))/gcd(c[i-1],b[i+1]);
	            if(ans<min)
	            	min=ans;
	        }
			sb.append(min+"\n");
		}
		System.out.println(sb);
	}
	
	static void preCalc(int n)
	{
		c[1]=a[1];b[n]=a[n];
	    for(int i=n-1;i>0;i--)
	       b[i]=gcd(b[i+1],a[i]);

	    for(int i=2;i<n+1;i++)
	       c[i]=gcd(c[i-1],a[i]);
	}
	
	static int gcd(int a, int b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b);
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
