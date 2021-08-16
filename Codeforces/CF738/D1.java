import java.io.*;
import java.util.*;

public class D {
		
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int n=f.nextInt();
		int m1=f.nextInt();
		int m2=f.nextInt();
		
		int p1[]=new int[n+1];
		int p2[]=new int[n+1];
		
		int s1[]=new int[n+1],s2[]=new int[n+1];
		
		for(int i=1;i<=n;i++)
		{
			p1[i]=i;
			p2[i]=i;
			s1[i]=1;
			s2[i]=1;
		}
		
		for(int i=0;i<m1;i++)
		{
			int x=f.nextInt();
			int y=f.nextInt();
			
			if(root(p1,x)!=root(p1,y))
				union(p1,s1,x,y);
		}
		for(int i=0;i<m2;i++)
		{
			int x=f.nextInt();
			int y=f.nextInt();
			
			if(root(p2,x)!=root(p2,y))
				union(p2,s2,x,y);
		}
		List<String> ans=new ArrayList<>();
		
		for(int i=1;i<=n;i++)
		{
			for(int j=i+1;j<=n;j++)
			{
				int x=i;
				int y=j;
				
				if(root(p1,x)!=root(p1,y) && root(p2,x)!=root(p2,y))
				{
					ans.add(i+" "+j);
					union(p1,s1,x,y);
					union(p2,s2,x,y);
				}
			}
		}
		System.out.println(ans.size());
		for(String s:ans)
			System.out.println(s);
		
	}
	
	public static void union(int Arr[ ],int size[ ],int A,int B)
	{
	    int root_A = root(Arr,A);
	    int root_B = root(Arr,B);
	    if(size[root_A] < size[root_B ])
	    {
	    	Arr[ root_A ] = Arr[root_B];
	    	size[root_B] += size[root_A];
	    }
	    else
	    {
	    	Arr[root_B]=Arr[root_A];
	    	size[root_A]+=size[root_B];
	    }

	}
	
	public static int root (int arr[ ] ,int i)
	{
	    while(arr[i]!=i)
	    {
	        arr[i]=arr[arr[i]] ; 
	        i=arr[i]; 
	    }
	    return i;
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
