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
			int m=f.nextInt();
			
			if(m<n)
			{
				sb.append("0\n");
				continue;
			}
			int nD[]=decToBinary(n);
							
			int curr=0,extra=0;;
			while(true)
			{	
				curr=0;
				for(int i=0;i<32;i++)
					if(nD[i]==1)
						curr+=(int)Math.pow(2,i);
				if(curr>m)
					break;
				
				extra=0;
				for(int i=0;i<32;i++)
				{
					if(nD[i]==0)
					{
						extra+=(int)Math.pow(2,i);
						if((curr)+extra>m)
						{
							nD[i]=1;
							break;
						}
					}		
				}
			}
			sb.append((n^curr)+"\n");
		}
		System.out.println(sb);
	}
	
	public static int[] decToBinary(int n)
    {	
		int a[]=new int[32];
        for (int i=31;i>=0;i--) {
            int k=n>>i;
            if((k&1)>0)
            	a[i]=1;
            else
            	a[i]=0;
        }
        return a;
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