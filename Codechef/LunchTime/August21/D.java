import java.io.*;
import java.util.*;

 class D {
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			int m=f.nextInt();
			
			int a[]=new int[n];
			for(int i=0;i<n;i++)
				a[i]=f.nextInt();
			
			int ans=Integer.MAX_VALUE;
			long pf[]=new long[n+1];
			for(int i=1;i<=n;i++)
			{
				pf[i]=pf[i-1]+(long)a[i-1];
				if(pf[i]%m==0)
				{
					int count=calc(n-i);
					ans=Math.min(ans,count);
				}
			}
			
			for(int r=1;r<=n;r++)
			{	
				for(int l=r;;l=(l-1)&r)
			    {
					if(l+r>=n)
					{
						if(l==0) 
							break;
						continue;
					}
					long sumVal = pf[n-r]-pf[l];
					if(sumVal%m==0)
						ans=Math.min(ans,calc(r));
					if(l==0)
						break;
			    }
			}
			if(ans==Integer.MAX_VALUE)
				sb.append("-1\n");
			else
				sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
	
	static int calc(int a)
	{	
		int count=0;
		while(a>0)
		{
			if(a%2==1)
				count++;
			a/=2;
		}
		return count;
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
