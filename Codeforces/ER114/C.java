import java.io.*;
import java.util.*;

public class C {
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int n=f.nextInt();
		
		List<Long> a=new ArrayList<>();
		long sum=0;
		for(int i=0;i<n;i++)
		{
			long temp=f.nextLong();
			sum+=temp;
			a.add(temp);
		}
		Collections.sort(a);
		
		int d=f.nextInt();
		while(d-->0)
		{
			long x=f.nextLong();
			long y=f.nextLong();
			
			int idx=Collections.binarySearch(a,x);
//			System.out.println(idx);
			long ans=Long.MAX_VALUE;
			if(idx>=0)
			{
				if(y>sum-a.get(idx));
					ans=y-(sum-a.get(idx));
			}
			else
			{
				idx+=2;
				idx*=-1;
//				System.out.println(idx);
				// look one ahead of has
				long val1=Long.MAX_VALUE,val2=Long.MAX_VALUE;
				if(idx<n-1)
				{
					long temp=a.get(idx+1);
					if(x>temp)
						val1=(x-temp);
					else
						val1=0;
					if(y>(sum-temp))
						val1+=(y-(sum-temp));
				}
				// look behind if possible
				if(idx>=0)
				{
					long temp=a.get(idx);
					if(x>temp)
						val2=(x-temp);
					else 
						val2=0;
					if(y>(sum-temp))
						val2+=(y-(sum-temp));
				}
				
				ans=Math.min(val1,val2);
			}
			sb.append(Math.max(ans, 0)+"\n");
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
