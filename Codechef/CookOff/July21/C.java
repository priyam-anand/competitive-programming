import java.io.*;
import java.util.*;

 class C {
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		int test=f.nextInt();
		out:
		while(test-->0)
		{	
			int n=f.nextInt();
			List<Integer> a=new ArrayList<>();
			for(int i=0;i<n;i++)
				a.add(f.nextInt());
			
			Collections.sort(a);
			
			Set<String> set=new HashSet<>();
			Map<Integer,ArrayList<Integer>> map=new HashMap<>();
			for(int i:a)
			{
				if(map.containsKey(i))
				{
					ArrayList<Integer> l=map.get(i);
					int x=l.get(0);
					int y=l.get(1);
					if(x!=i-1 && y!=1)
					{
						x++;
						y--;
						String s=x+" "+y;
						set.add(s);
						ArrayList<Integer> temp=new ArrayList<>();
						temp.add(x);
						temp.add(y);
						
						map.put(i,temp);
					}
				}
				else
				{
					ArrayList<Integer> l=new ArrayList<>();
					int x=1;
					int y=i-1;
					l.add(x);
					l.add(y);
					set.add(x+" "+y);
					map.put(i,l);
				}
			}
			sb.append(set.size()+"\n");
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