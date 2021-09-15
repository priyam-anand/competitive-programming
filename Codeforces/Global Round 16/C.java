import java.io.*;
import java.util.*;

public class C {
	 
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
	   int test=f.nextInt();
	   while(test-->0)
	   {
		   int n=f.nextInt();
		   char s1[]=f.next().toCharArray();
		   char s2[]=f.next().toCharArray();
		   
		   long ans=0;
		   List<List<Character>> seg=new ArrayList<>();
		   List<Character> list=new ArrayList<>();
		   for(int i=0;i<n;i++)
		   {
			   if(s1[i]!=s2[i])
			   {
				   ans+=2;
				   if(list.size()>0)
					   seg.add(list);
				   list=new ArrayList<>();
			   }
			   else
				   list.add(s1[i]);
		   }
		   if(list.size()>0)
			   seg.add(list);
		   
		   for(List<Character> l:seg)
			   ans+=count(l);
		   sb.append(ans+"\n");
	   }
	   System.out.println(sb);
	}
	
	static int count(List<Character> list)
	{	
		int ans=0;
		int z=0;
		for(char c:list)
			if(c=='0')
				z++;
		for(int i=0;i<list.size()-1;i++)
		{
			if(list.get(i)!=list.get(i+1))
			{
				ans+=2;
				z--;
				i++;
			}
		}
		ans+=z;
		
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