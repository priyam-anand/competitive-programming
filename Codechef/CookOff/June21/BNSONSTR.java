import java.io.*;
import java.util.*;

class B {

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		int test=f.nextInt();
		out:
		while(test-->0)
		{
			int n=f.nextInt();
			List<Integer> list=getDivs(n);
			char ch[]=f.next().toCharArray();
			int zero=0,one=0;
			for(int i=0;i<n;i++)
				if(ch[i]=='0')
					zero++;
			one=n-zero;
			if(zero==n)
			{
				sb.append("1\n");
				continue;
			}
						
			int min=Integer.MAX_VALUE;
			for(int dif:list)
			{	
				int start=0;
				while(start<dif)
				{			
					int on=one,ze=zero;
					int val=0;
					for(int i=start;i<n;i+=dif)
					{
						if(ch[i]=='1')
							on--;
						if(ch[i]!='1')
							val++;
					}	
					
					val+=on;
					min=Math.min(min,val);
					start++;
				}
			}
			sb.append(min+"\n");
		}
		System.out.println(sb);
	}
	
	static List<Integer> getDivs(int n)
	{	
		List<Integer> list=new ArrayList<>();
		for(int i=1;i*i<=n;i++)
		{
			if(n%i==0)
			{
				if(n/i==i)
					list.add(i);
				else
				{
					list.add(i);
					list.add(n/i);
				}
			}
		}
		return list;
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
