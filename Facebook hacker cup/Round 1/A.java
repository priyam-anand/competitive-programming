import java.io.*;
import java.util.*;

public class A {	
	
	public static void main(String[] args)throws Exception {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		FileWriter fWriter = new FileWriter("C:\\Users\\priya\\OneDrive\\Desktop\\hacker cup input\\output1.txt");
		
		int caseNo=1;
		int test=f.nextInt();
		out:
		while(test-->0)
		{	
			int n=f.nextInt();
			char ch[]=f.next().toCharArray();
			int count=0;
			char curr='a';
			for(int i=0;i<n;i++)
			{
				if(ch[i]=='F' || ch[i]==curr)
					continue;
				else
				{
					count++;
					curr=ch[i];
				}	
			}
			int ans=Math.max(0,count-1);
			sb.append("Case #"+caseNo+": "+ans+"\n");
			caseNo++;
		}
		fWriter.write(sb.toString());
		fWriter.close();
	}
	
	static class FastReader 
	{ 
	    BufferedReader br; 
	    StringTokenizer st; 
 
	    public FastReader() throws Exception{
	    	File file = new File("C:\\Users\\priya\\OneDrive\\Desktop\\hacker cup input\\input1.txt");
	    	br = new BufferedReader(new FileReader(file)); 
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