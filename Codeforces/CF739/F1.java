import java.io.*;
import java.util.*;

public class E {	
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		TreeSet<Long> one=new TreeSet<>();
		TreeSet<Long> two=new TreeSet<>();
		
		for(int i=1;i<=9;i++)
		{	
			long no=0;
			for(int j=1;j<=10;j++)
			{
				no=no*10L+i;
				one.add(no);
			}
		}
		
		for(int i=0;i<10;i++) 
		{
			for(int j=i+1;j<10;j++) 
	        {
	            for(int k=1;k<11;k++) 
	            {
	                for(int l=0;l<(1<<k);++l) 
	                {
	                    long curr_num = 0;
	                    for(int m=0;m<k;++m) 
	                    {
	                        if (((1<<m)&l)!=0) 
	                            curr_num+=p10(m)*i; 
	                        else 
	                            curr_num+=p10(m)*j;
	                    }
	                    two.add(curr_num);
	                }
	            }
	        }
	    }
//		System.out.println(two.size());
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			int k=f.nextInt();
			if(k==1)
				sb.append(one.ceiling((long)n)+"\n");
			else
				sb.append(two.ceiling((long)n)+"\n");
		}
		System.out.println(sb);
	}
	
	static long p10(int a) {
	    long ans=1;
	    for (int i=0;i<a;i++) {
	        ans*=10;
	    }
	    return ans;
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
