import java.io.*;
import java.util.*;

public class B {	

	public static void main(String[] args)throws Exception{
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int caseNo=1;
		int test=f.nextInt();
		while(test-->0)
		{
			char ch[]=f.next().toCharArray();
			List<Character> list=new ArrayList<>();
			char curr=' ';
			for(int i=0;i<ch.length;i++)
			{
				if(ch[i]!=curr)
				{
					list.add(ch[i]);
					curr=ch[i];
				}
			}
//			System.out.println(list);
			if(list.size()==1)
			{
				if(list.get(0)=='1')
					sb.append("0\n");
				else
					sb.append("1\n");
				continue;
			}
			if(list.size()==2)
			{
				sb.append("1\n");
				continue;
			}
			if(list.size()==3)
			{
				if(list.get(0)=='1' && list.get(1)=='0' && list.get(2)=='1')
				{
					sb.append("1\n");
					continue;
				}
			}
			sb.append("2\n");
		}
		System.out.println(sb);
	}
	
	static boolean inOrder(char ch[])
	{
		char curr='1';
		int count=0;
		if(ch[0]=='0')
			return false;
		for(int i=0;i<ch.length;i++)
		{
			if(ch[i]!=curr)
			{
				curr=ch[i];
				count++;
			}
		}
		System.out.println("count = "+count);
		return count==2;
	}
	
	static int junc(char ch[])
	{
		int count=0;
		for(int i=1;i<ch.length;i++)
			if(ch[i]!=ch[i-1])
				count++;
		return count;
	}
	
	static boolean allx(char ch[],char c)
	{
		for(char cc:ch)
			if(cc!=c)
				return false;
		return true;
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