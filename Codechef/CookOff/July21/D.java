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
			List<Integer> list=new ArrayList<>();
			for(int i=0;i<n;i++)
				list.add(f.nextInt());
				
			Collections.sort(list);
			
			int start=0;
			int curr=list.get(0);
			while(start<n && list.get(start)==curr)
				start++;
			
//			System.out.println("start = "+start);
			int min=Integer.MAX_VALUE;
			for(int i=start;i<n;i++)
				min=Math.min((list.get(i)-1)/2,min);
//			System.out.println("min = "+min);
			if(list.get(0)>min)
			{
				sb.append(n+"\n");
				continue;
			}
			int i=0;
			for(i=0;i<start;i++)
			{
				int val=list.get(i);
				if(val>min)
					break;
			}
			int ans=n-i;
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
