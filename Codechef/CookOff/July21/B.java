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
			int a[]=new int[n];
			int bits[][]=new int[n][32];
			for(int i=0;i<n;i++)
			{
				a[i]=f.nextInt();
				int b[]=decToBinary(a[i]);
				for(int j=0;j<32;j++)
					bits[i][j]=b[j];
			}
			
//			for(int i[]:bits)
//			{
//				for(int j:i)
//					System.out.print(j+" ");
//				System.out.println();
//			}
			int val=0;
			for(int j=0;j<32;j++)
			{	
				boolean poss=true;
				for(int i=0;i<n;i++)
				{
					if(bits[i][j]!=1)
					{
						poss=false;
						break;
					}
				}
				if(poss)
					val+=(int)Math.pow(2,j);
			}
			for(int i=0;i<n;i++)
				a[i]=a[i]^val;
			int ans=0;
			for(int i:a)
				ans=ans|i;
			sb.append(val+" "+ans+"\n");
		}
		System.out.println(sb);
	}
	
	public static int[] decToBinary(int n)
    {
        // Size of an integer is assumed to be 32 bits
		int a[]=new int[32];
        for (int i = 31; i >= 0; i--) {
            int k = n >> i;
            if ((k & 1) > 0)
                a[i] = 1;
            else
            	a[i] = 0;
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
