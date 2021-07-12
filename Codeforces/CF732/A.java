import java.io.*;
import java.util.*;

public class A {

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			int a[]=new int[n];
			int b[]=new int[n];
			
			int sum1=0,sum2=0;
			for(int i=0;i<n;i++)
			{
				a[i]=f.nextInt();
				sum1+=a[i];
			}
			for(int i=0;i<n;i++)
			{
				b[i]=f.nextInt();
				sum2+=b[i];
			}
			if(sum1!=sum2)
			{
				sb.append("-1\n");
				continue;
			}
			List<Integer> smaller = new ArrayList<>(),bigger=new ArrayList<>();
			for(int i=0;i<n;i++)
			{	
				if(a[i]<b[i])
				{
					int dif=b[i]-a[i];
					while(dif-->0)
						smaller.add((i+1));
				}
				else if(a[i]>b[i])
				{
					int dif=a[i]-b[i];
					while(dif-->0)
						bigger.add((i+1));
				}
			}
			int ans = bigger.size();
			sb.append(ans+"\n");
			for(int i=0;i<bigger.size();i++)
				sb.append(bigger.get(i)+" "+smaller.get(i)+"\n");
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
