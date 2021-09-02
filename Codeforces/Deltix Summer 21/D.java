import java.io.*;
import java.util.*;

public class D {
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int n=f.nextInt(),k=f.nextInt();
		List<Integer> list=new ArrayList<>();
		
		// get sum of 1,2
		System.out.println("and 1 2");
		int sum12=f.nextInt();
		System.out.println("or 1 2");
		sum12+=f.nextInt();
		
		System.out.println("and 2 3");
		int sum23=f.nextInt();
		System.out.println("or 2 3");
		sum23+=f.nextInt();
		
		System.out.println("and 1 3");
		int sum13=f.nextInt();
		System.out.println("or 1 3");
		sum13+=f.nextInt();
		
		int a1=Math.abs(sum12-sum23+sum13)/2;
		list.add(a1);
		int a3=sum13-a1;
		list.add(a3);
		
		int prev=0;
		if(sum12>sum23)
		{
			int max=Math.max(a1,a3);
			int a2=sum12-max;
			list.add(a2);
			prev=sum23-a2;
		}
		else 
		{
			int max=Math.max(a1,a3);
			int a2=sum23-max;
			list.add(a2);
			prev=sum23-a2;
		}
		
		int i=3;
		while(i<n)
		{		
			System.out.println("and "+i+" "+(i+1));
			int and=f.nextInt();
			System.out.println("or "+i+" "+(i+1));
			int or=f.nextInt();
			
			int sum=and+or;
			int curr=sum-prev;
			
			list.add(curr);
			prev=curr;
			
			i++;
		}
		Collections.sort(list);
		System.out.println("finish "+list.get(k-1));
	}
	
	static int calc(int a)
	{	
		int count=0;
		while(a>0)
		{
			if(a%2==1)
				count++;
			a/=2;
		}
		return count;
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
