import java.io.*;
import java.util.*;

public class B {	
	
	public static void main(String[] args){
		
		FastReader f = new FastReader();
		
		
		int test=f.nextInt();
		while(test-->0)
		{
			StringBuffer sb=new StringBuffer();
			int n=f.nextInt();
			int count=0;
			List<Integer> a=new ArrayList<>(),copy=new ArrayList<>();
			for(int i=0;i<n;i++)
			{
				int x=f.nextInt();
				copy.add(x);
				a.add(x);
			}
			Collections.sort(copy);
			for(int i=0;i<n;i++)
			{
				int req=copy.get(i);
				int idx=idx(a,req,i);
				int left=i+1;
				if(idx-i <= 0)
					continue;
				sb.append(left+" "+n+" "+(idx-i)+"\n");
							count++;

				List<Integer> newList = new ArrayList<>();
				for(int j=0;j<i;j++)
					newList.add(a.get(j));
				newList.add(req);
//				System.out.println("at one = "+newList);
				
				for(int j=idx+1;j<n;j++)
					newList.add(a.get(j));
//				System.out.println("at two = "+newList);
				
				for(int j=i;j<idx;j++)
					newList.add(a.get(j));
//				System.out.println("at three = "+newList);
//				System.out.println();
				a=newList;
			}
			System.out.println(count);
			System.out.println(sb);
		}
	}
	
	static int idx(List<Integer> a,int val,int after)
	{
		for(int i=after;i<a.size();i++)
			if(a.get(i)==val)
				return i;
		return 0;
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