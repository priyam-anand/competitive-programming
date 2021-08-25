import java.io.*;
import java.util.*;

 class E {	
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		List<Integer> preComp=new ArrayList<>();
		preComp.add(1);
		int curr=2;
		while(preComp.size()<1000)
		{
			int currLen=preComp.size()-1;
			for(int i=0;i<currLen;i++)
				preComp.add(preComp.get(i));
			preComp.add(curr);
			curr++;
		}
		
		int test=f.nextInt();
		while(test-->0)
		{	
			int n=f.nextInt();
			for(int i=0;i<n;i++)
				sb.append(preComp.get(i)+" ");
			sb.append("\n");
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