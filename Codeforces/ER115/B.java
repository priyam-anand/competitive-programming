import java.io.*;
import java.util.*;

public class B {	
	
	public static void main(String[] args){
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		out:
		while(test-->0)
		{
			int n=f.nextInt();
			int arr[][]=new int[n][5];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<5;j++)
					arr[i][j]=f.nextInt();
			}
			for(int day1=0;day1<4;day1++)
			{
				Set<Integer> set1=new HashSet<>();
				for(int i=0;i<n;i++)
				{
					if(arr[i][day1]==1)
						set1.add(i);
				}
				if(set1.size()<n/2)
					continue;
				for(int day2=day1+1;day2<5;day2++)
				{
					int count=0;
					for(int i=0;i<n;i++)
					{
						if(!set1.contains(i) && arr[i][day2]==1)
							count++;
					}
					if(count>=n/2)
					{
						sb.append("YES\n");
						continue out;
					}
					if(count+set1.size()<n)
						continue;
					int setSize=set1.size();
					for(int i:set1)
					{
						if(setSize==n/2)
							break;
						if(arr[i][day2]==1)
						{
							setSize--;
							count++;
						}
					}
					if(setSize==n/2 && count==n/2)
					{
						sb.append("YES\n");
						continue out;
					}
				}	
			}
			sb.append("NO\n");
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