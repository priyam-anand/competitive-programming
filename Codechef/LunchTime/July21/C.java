import java.io.*;
import java.util.*;

class C {
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		out:
		while(test-->0)
		{
			int n=f.nextInt();
			int k=f.nextInt();
			int s=f.nextInt();
			
			int a[]=new int[n];
			List<Integer> pre=new ArrayList<>();
			for(int i=0;i<n;i++)
				a[i]=f.nextInt();
			pre.add(a[0]);
			for(int i=1;i<n;i++)
				pre.add(pre.get(i-1)+a[i]);

			int go[][]=new int[n][32];
			for(int i=0;i<n;i++)
				Arrays.fill(go[i],-1);
			
			for(int i=0;i<n;i++)
			{		
				int idx=Collections.binarySearch(pre,pre.get(i)-a[i]+s);
				if(idx>=0)
					idx++;
				if(idx<0)
				{
					idx++;
					idx*=-1;
				}
				go[i][0]=idx;
			}
			
			for(int i=0;i<n-1;i++)
			{
				for(int j=1;j<32;j++)
				{	
//					System.out.print(go[i][j-1]+" ");
					if(go[i][j-1]==-1 || go[i][j-1]==n)
						break;
					go[i][j]=go[go[i][j-1]][j-1];
				}
//				System.out.println();
			}
//			System.out.println();
//			for(int i=0;i<n;i++)
//			{
//				for(int j=0;j<5;j++)
//					System.out.print(go[i][j]+" ");
//				System.out.println();
//			}
			List<Integer> jump=new ArrayList<>();
			for(int i=32;i>0;i--)
			{
				if(isOk(k,i))
					jump.add(i-1);
			}
			int max=0;
//			System.out.println(jump);
			for(int i=0;i<n;i++)
			{	
				int curr=i;
				for(int j:jump)
				{
					curr=go[curr][j];
					if(curr==-1 || curr==n)
					{
						curr=n;
						break;
					}
				}
				max=Math.max(max,(curr-i));
			}
			sb.append(max+"\n");
		}	
		System.out.println(sb);
	}
	
	static boolean isOk(int n,int k)
	{
		if(((n>>(k-1))&1) > 0)
			return true;
		return false;
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