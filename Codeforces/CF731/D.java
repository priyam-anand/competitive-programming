package Practice;

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
			int x[]=new int[n];
			for(int i=0;i<n;i++)
				x[i]=f.nextInt();
			int y[]=new int[n];
			boolean flag=true;
			for(int i=0;i<n-1;i++)
			{
				if((x[i]&x[i+1])!=x[i])
				{
					flag = false;
					break;
				}
			}
			if(flag)
			{
				for(int i:y)
					sb.append(i+" ");
				sb.append("\n");
				continue;
			}
			ArrayList<Integer> curr = new ArrayList<>();
			ArrayList<Integer> next = new ArrayList<>();
			
			for(int i=0;i<n-1;i++)
			{	
//				System.out.println(x[i]+" "+x[i+1]);
				curr = decToBinary(x[i]);
				next = decToBinary(x[i+1]);
//				System.out.println(curr);
//				System.out.println(next);
				for(int j=0;j<curr.size();j++)
				{
					if(j>=next.size())
					{	
						if(curr.get(j)==1)
							y[i+1]+=Math.pow(2,j);
					}
					else {
						if(curr.get(j)==1 && next.get(j)!=1)
							y[i+1]+=Math.pow(2,j);
					}
				}
				x[i+1]=x[i+1]^y[i+1];
			}
			for(int i:y)
				sb.append(i+" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static ArrayList<Integer> decToBinary(int n)
    {
        ArrayList<Integer> list = new ArrayList<>();
        
        if(n==0)
        	list.add(0);
        while (n > 0) 
        {
        	list.add(n%2);
            n = n / 2;
        }
    
        return list;
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
