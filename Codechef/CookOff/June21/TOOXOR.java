import java.io.*;
import java.util.*;

class C {

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		
		int test=f.nextInt();
		while(test-->0)
		{
			StringBuffer sb=new StringBuffer();
			int n=f.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++)
				a[i]=f.nextInt();
//			long count=0;
			int idx1=-1,idx2=-1;
			List<String> ans=new ArrayList<>();
			
			if(n==1)
				System.out.println(0);
			else if(n==2)
			{	
				if(a[0]==a[1])
					System.out.println(-1);
				else
					System.out.println(0);
			}
			else if(allZero(a))		
				System.out.println(-1);	
			else if(n==3)
			{	
				boolean poss=false;
				if(a[1]==0)
				{
					if(a[0]!=0)
						ans.add("1 2 3");
					else
						ans.add("2 3 1");
					poss=true;
				}
				else if(a[0]==a[2])
				{	
					if(a[0]!=0)
						ans.add("1 3 2");
					poss=true;
				}
				if(poss)
				{
					System.out.println(ans.size());
					for(String s:ans)
						System.out.println(s);
				}
				else
					System.out.println(-1);
			}
			else
			{
				for(int i=2;i<n;i++)
				{
					if(a[i]!=a[i-2])
					{
						idx1=i+1;
						idx2=i-1;
						break;
					}
				}
				if(idx1==-1 && idx2==-1)
					for(int i=2;i<=n;i+=2)
						ans.add("1 3 "+i);
				else if(idx1%2==1)
				{
					for(int i=2;i<=n;i+=2)
						ans.add(idx1+" "+idx2+" "+i);
					for(int i=1;i<=n;i+=2)
						ans.add("2 4 "+i);
				}
				else 
				{
					for(int i=1;i<=n;i+=2)
						ans.add(idx1+" "+idx2+" "+i);
					for(int i=2;i<=n;i+=2)
						ans.add("1 3 "+i);
				}
				System.out.println(ans.size());
				for(String s:ans)
					System.out.println(s);
			}
		}
	}
	
	static boolean allZero(int a[])
	{
		for(int i=0;i<a.length;i++)
		{
			if(a[i]!=0)
				return false;
		}
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