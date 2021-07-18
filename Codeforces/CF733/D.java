import java.io.*;
import java.util.*;

public class D {

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			int a[]=new int[n+1];
			int ans[]=new int[n+1];
			for(int i=1;i<=n;i++)
				a[i]=f.nextInt();
			int ansVal=0;
			Set<Integer> set=new HashSet<>();
			for(int i=1;i<=n;i++)
				set.add(i);
			Set<Integer> empty=new HashSet<>();
			for(int i=1;i<=n;i++)
			{
				if(set.contains(a[i]))
				{
					ans[i]=a[i];
					set.remove(a[i]);
				}
				else
				{
					ans[i]=-1;
					empty.add(i);
				}
			}
			ansVal=n-empty.size();
			sb.append(ansVal+"\n");
//			System.out.println("empty = "+empty);
//			System.out.println("set = "+set);
//			System.out.print("sweep 1 = ");
//			for(int i=1;i<=n;i++)
//				System.out.print(ans[i]+" ");
//			System.out.println();
			
			List<Integer> list=new ArrayList<>();
			for(int i:set)
				list.add(i);
			int idx=0;
			for(int i:empty)
			{
				ans[i]=list.get(idx);	
				set.remove(ans[i]);
				idx++;
			}
//			System.out.print("sweep 2 = ");
//			for(int i=1;i<=n;i++)
//				System.out.print(ans[i]+" ");
//			System.out.println();
			list=new ArrayList<>();
			for(int i=1;i<=n;i++)
			{
				if(ans[i]==i)
					list.add(i);
			}
			if(list.size()==1)
			{
				ans[list.get(0)]=a[list.get(0)];
				for(int i=1;i<=n;i++)
				{
					if(i!=list.get(0) && ans[i]==a[list.get(0)])
					{
						ans[i]=list.get(0);
						break;
					}
				}
						
			}
			else
			{
				for(int i=1;i<list.size();i++)
				{
					//swap i-1 ans i
					int temp=ans[list.get(i-1)];
					ans[list.get(i-1)]=ans[list.get(i)];
					ans[list.get(i)]=temp;
				}
			}
			
			for(int i=1;i<=n;i++)
				sb.append(ans[i]+" ");
			sb.append("\n");
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
