import java.io.*;
import java.util.*;

public class B {	

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			int a[]=new int[n],a2[]=new int[n];
			for(int i=0;i<n;i++)
				a[i]=a2[i]=f.nextInt()%2;
			
			TreeSet<Integer> odd=new TreeSet<Integer>(),even=new TreeSet<>();
			for(int i=0;i<n;i++)
			{
				if(a[i]%2==0)
					even.add(i);
				if(a[i]%2!=0)
					odd.add(i);
			}
			if(Math.abs(even.size()-odd.size())>1)
			{
				sb.append("-1\n");
				continue;
			}
		
			int ans=0;
			for(int i=0;i<n;i++)
			{			
//				System.out.println("odd = "+odd);
//				System.out.println("even = "+even);
				if(i%2==0)
				{
//					System.out.println("need even = "+a[i]);
					if(a[i]!=0)
					{	
						if(even.isEmpty())
						{
							ans=Integer.MAX_VALUE;
							break;
						}
						int idx=even.pollFirst();
//						System.out.println("polled = "+idx);
						a[i]=0;
						a[idx]=1;
						odd.add(idx);
						odd.remove(i);
						ans+=Math.abs(idx-i);
//						System.out.println("adding = "+Math.abs(idx-i));
					}
					else
						even.remove(i);
				}
				else
				{
					if(a[i]!=1)
					{
						if(odd.isEmpty())
						{
							ans=Integer.MAX_VALUE;
							break;
						}
						int idx=odd.pollFirst();
						a[i]=1;
						a[idx]=0;
						even.add(idx);
						even.remove(i);
						ans+=Math.abs(idx-i);
					}
					else
						odd.remove(i);
				}
			}
			
			odd=new TreeSet<Integer>();even=new TreeSet<>();
			for(int i=0;i<n;i++)
			{
				if(a2[i]%2==0)
					even.add(i);
				if(a2[i]%2!=0)
					odd.add(i);
			}
			//starting odd here
			int ans2=0;
			for(int i=0;i<n;i++)
			{
				if(i%2==0)
				{
					//we want odd here
					if(a2[i]!=1)
					{
						if(odd.isEmpty())
						{
							ans2=Integer.MAX_VALUE;
							break;
						}
						int idx=odd.pollFirst();
						a2[i]=1;
						a2[idx]=0;
						even.add(idx);
						even.remove(i);
						ans2+=Math.abs(idx-i);
					}
					else
						odd.remove(i);
				}
				else
				{
					//we want even here
					if(a2[i]!=0)
					{
						if(even.isEmpty())
						{
							ans2=Integer.MAX_VALUE;
							break;
						}
						int idx=even.pollFirst();
						a2[i]=0;
						a2[idx]=1;
						odd.add(idx);
						odd.remove(i);
						ans2+=Math.abs(idx-i);
					}
					else
						even.remove(i);
				}
			}
//			System.out.println("ans = "+ans);
//			System.out.println("ans2 = "+ans2);
			sb.append(Math.min(ans,ans2)+"\n");
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