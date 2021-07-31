import java.io.*;
import java.util.*;

public class B {

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		int test=f.nextInt();
		out:
		while(test-->0)
		{			
			int W=f.nextInt();
			int H=f.nextInt();
			
			int x1=f.nextInt();
			int y1=f.nextInt();
			int x2=f.nextInt();
			int y2=f.nextInt();
			
			int w=f.nextInt();
			int h=f.nextInt();
			
			if(h+(y2-y1)>H && w+(x2-x1)>W)
			{
				sb.append("-1\n");
				continue;
			}
			double ans=1000000000;
			int x=0,y=0;
			if(W-Math.abs(x1-x2)>=w)
			{
				//move x
				int n=Math.max(x1,W-x2);
				if(n<w)
					x=w-n;
				ans=Math.min(x, ans);
			}
			if(H-Math.abs(y2-y1)>=h)
			{
				// move y
				int n=Math.max(y1,H-y2);
				if(n<h)
					y=h-n;
				ans=Math.min(ans,y);
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
