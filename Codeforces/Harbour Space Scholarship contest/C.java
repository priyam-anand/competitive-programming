import java.io.*;
import java.util.*;

public class C {
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		out:
		while(test-->0)
		{
			char ch[]=f.next().toCharArray();
			char ch2[]=new char[ch.length];
			for(int i=0;i<ch.length;i++)
				ch2[i]=ch[i];
			int n=ch.length;
			for(int i=0;i<n;i++)
			{
				if(i%2==0 && ch[i]=='?')
					ch[i]='1';
				if(i%2!=0 && ch[i]=='?')
					ch[i]='0';
			}
			for(int i=0;i<n;i++)
			{
				if(i%2==0 && ch2[i]=='?')
					ch2[i]='0';
				if(i%2!=0 && ch2[i]=='?')
					ch2[i]='1';
			}
			int val1=time(ch);
			int val2=time(ch2);
			
			sb.append(Math.min(val1,val2)+"\n");
		}
		System.out.println(sb);
	}
	
	static int time(char ch[])
	{
		int n=ch.length;
		int a=0,b=0;
		int chanceA=5,chanceB=5;
		//a is first player
		
		for(int i=0;i<n;i++)
		{
			if(i%2==0)
			{	
				if(ch[i]=='1')
					a++;
				chanceA--;
			}
			else if(i%2!=0)
			{
				if(ch[i]=='1')
					b++;
				chanceB--;
			}
			if(a>b && (a-b)>chanceB)
				return (i+1);
			if(b>a && (b-a)>chanceA)
				return (i+1);
		}
		return 10;
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