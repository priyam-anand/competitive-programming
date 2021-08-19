import java.io.*;
import java.util.*;

public class C {
		
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		List<Integer> list=new ArrayList<>();
		for(int i=1;i<=100000;i++)
		{
			if((long)i*i>2*1e9)
				break;
			list.add(i*i);
		}
		int test=f.nextInt();
		out:
		while(test-->0)
		{
			
			int k=f.nextInt();
			if(k==1)
			{
				sb.append("1 1\n");
				continue;
			}
			int i=0;
			for(;i<list.size();i++)
			{
				if(k<=list.get(i))
					break;
			}
//			System.out.println("i = "+i);
			int len=list.get(i)-list.get(i-1);
//			System.out.println("len = "+len);
			int start=list.get(i-1);
//			System.out.println("start = "+start);
			int dif=k-start;
			if(dif<=(len+1)/2)
			{	
				
				int x=dif;
				int y=i+1;
				sb.append(x+" "+y+"\n");
				continue;
			}
			else
			{	
				int x=i+1;
				int y=i+1-(dif-(len+1)/2);
				sb.append(x+" "+y+"\n");
				continue;
			}
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