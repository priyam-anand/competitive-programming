import java.io.*;
import java.util.*;

public class B {
	
	static boolean prime[];
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		out:
		while(test-->0)
		{	
			int k=f.nextInt();
			char ch[]=f.next().toCharArray();
			int freq[]=new int[10];
			for(int i=0;i<ch.length;i++)
			{
				if(ch[i]!='2' && ch[i]!='3' && ch[i]!='5' && ch[i]!='7')
				{
					sb.append("1\n");
					sb.append(ch[i]+"\n");
					continue out;
				}
				else
					freq[(int)(ch[i]-'0')]++;
			}
			for(int i=1;i<10;i++)
			{
				if(freq[i]>1)
				{
					sb.append("2\n");
					sb.append(i+""+i+"\n");
					continue out;
				}
			}
			prime=seive(10000);
			for(int i=2;i<=10000;i++)
			{	
				if(!prime[i] && contains(i,ch))
				{		
					int len=0;
					int c=i;
					while(c>0)
					{
						c/=10;
						len++;
					}
					sb.append(len+"\n");
					sb.append(i+"\n");
					continue out;
				}
			}
		}
		System.out.println(sb);
	}
	static boolean contains(int n,char ch[])
	{	
		int i=ch.length-1;
		
		while(n>0)
		{
			int d=n%10;
//			System.out.println("d = "+d);
//			System.out.println("i = "+i);
			for(;i>=0;i--)
			{
				if(ch[i]-'0' == d)
				{	
//					System.out.println("found = "+d);
					i--;
					n/=10;
					break;
				}
			}
			
			if(i<0 && n>0)
				return false;
			
		}
		return true;
	}
	static boolean[] seive(int n)
	{
		boolean prime[] = new boolean[n + 1];
        for (int i=0;i<=n;i++)
            prime[i]=true;
 
        for(int p=2;p*p<=n;p++)
        {
            if(prime[p]==true)
            {
                for(int i=p*p;i<=n;i+=p)
                    prime[i]=false;
            }
        }
        return prime;
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
