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
			int k=f.nextInt();
			int x=f.nextInt();
			
			List<Integer> list=new ArrayList<>();
			for(int i=0;i<n;i++)
				list.add(f.nextInt());
			Collections.sort(list,Collections.reverseOrder());
			long ans=0;
			for(int i=0;i<n;i++)
			{
				if(i<n-1 && k>0 && list.get(i)+list.get(i+1) > x)
				{
					ans+=(long)x;
					k--;
					i++;
				}
				else
					ans+=(long)list.get(i);
			}
			sb.append(ans+"\n");
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
