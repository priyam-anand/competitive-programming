import java.io.*;
import java.util.*;

public class julyLong21_E {
	
	static long mod = (long)1e9 + 7;
	static long[] a=new long[(int)1e5+5],prefixArr=new long[(int)1e5+5];

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		preCalc();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int l=f.nextInt(),r=f.nextInt();
			long pow = prefixArr[r]-prefixArr[l];
			long ans = fastPow(a[l],pow);
			
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
	
	static void preCalc()
	{
		for(int i=1;i<=100001;i++){
	        a[i]=getVal(i);
	        prefixArr[i]=prefixArr[i-1]+a[i];
	    }
	}
	
	static long fastPow(long a,long b)
	{
		long res=1;
	    while(b!=0)
	    {
	        if(b%2==0)
	        {
	            a=((a%mod)*(a%mod))%mod;
	            b=b/2;
	        }
	        else
	        {
	            res=((res%mod)*(a%mod))%mod;
	            b=b-1;
	        }
	    }
	    return res;
	}
	
	static long getVal(long x)
	{
		long one=x,two=0;
	    
	    if(x<10)
	        two=one;
	    else if(x>=10)
	    {
	        x=x/10;
	        while(x!=0)
	        {
	            one=((one*10)+(x%10));
	            x=x/10;
	        }
	        two=one;
	    }
	    return two;
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
