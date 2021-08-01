import java.io.*;
import java.util.*;

 class B {

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		int test=f.nextInt();
		out:
		while(test-->0)
		{			
			int n=f.nextInt();
			int a[]=new int[n];
			int b[]=new int[n];
			
			Map<Integer,List<Integer>> map=new HashMap<>();
			for(int i=0;i<n;i++)
				a[i]=f.nextInt()%n;
			for(int j=0;j<n;j++)
			{
				b[j]=f.nextInt()%n;
				List<Integer> l=map.getOrDefault(b[j],new ArrayList<>());
				l.add(j);
				map.put(b[j],l);
			}

			int min[]=go(a,b,0);
			int req=(n-a[0])%n;
//			System.out.println("map = "+map);
			while(true)
			{	
//				System.out.println("req = "+req);
				if(map.containsKey(req))
				{	
//					System.out.println("map contains = "+req);
					List<Integer> list=map.get(req);
					for(int i:list)
					{
						int val[]=go(a,b,i);
//						for(int j:val)
//							System.out.print(j+" ");
//						System.out.println();
						min=min(val,min);
					}
					break;
				}
				req++;
				req%=n;
			}
			
			for(int i:min)
				sb.append(i+" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static int[] min(int a[],int b[])
	{
		for(int i=0;i<a.length;i++)
		{	
			if(a[i]>b[i])
				return b;
			else if(a[i]<b[i])
				return a;
		}
		return a;
	}
	
	static int[] go(int a[],int b[],int k)
	{	
		int ans[]=new int[a.length];
		for(int i=0;i<a.length;i++)
			ans[i]=(a[i]+b[(i+k)%a.length])%a.length;
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
