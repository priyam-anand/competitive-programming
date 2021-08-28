import java.io.*;
import java.util.*;

public class A {
	
	public static void main(String[] args) throws Exception {
		
		FastReader f=new FastReader();
		StringBuffer sb=new StringBuffer();
		FileWriter fWriter = new FileWriter("C:\\Users\\priya\\OneDrive\\Desktop\\Facebook hacker cup inputs\\Outputs\\Question 1.txt");
		
		int test=f.nextInt();
		int cn=1;
		while(test-->0)
		{
			char ch[]=f.next().toCharArray();
			int n=ch.length;
			String v="AEIOU";
			int ans=Integer.MAX_VALUE;
			for(char curr='A';curr<='Z';curr++)
			{	
				int currCost=0;
				for(int i=0;i<n;i++)
				{
					if(ch[i]==curr)
						continue;
					// vowel to vowel
					if(v.lastIndexOf(curr)>=0 && v.lastIndexOf(ch[i])>=0)
						currCost+=2;
					// consonant to consonant
					else if(v.lastIndexOf(curr)<0 && v.lastIndexOf(ch[i])<0)
						currCost+=2;
					// vowel to consonant
					else
						currCost++;
				}
				ans=Math.min(ans,currCost);
			}
			sb.append("Case #"+cn+": "+ans+"\n");
			cn++;
		}
		fWriter.write(sb.toString());
		fWriter.close();
	}
	
	static int solve(int n, List<Integer> a)
	{
		Collections.sort(a);
		int max=1;
		int len=1;
		for(int i=1;i<n;i++)
		{
			if(Math.abs(a.get(i)-a.get(i-1))<=1)
				len++;
			else
				len=0;
			
			max=Math.max(max,len);
		}
		return max;
	}
	
	static class FastReader 
	{ 
	    BufferedReader br; 
	    StringTokenizer st; 
 
	    public FastReader() throws Exception{
	    	File file = new File("C:\\Users\\priya\\OneDrive\\Desktop\\Facebook hacker cup inputs\\Inputs\\consistency_chapter_1_input.txt");
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
