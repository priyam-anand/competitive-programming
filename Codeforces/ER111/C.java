import java.io.*;
import java.util.*;

public class C {

	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		out:
		while(test-->0)
		{
			int n=f.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++)
				a[i]=f.nextInt();
			
			int count=n+n-1;
			outer:
			for(int i=0;i<n;i++)
			{	
				for(int j=i+2;j<n;j++)
				{	
					if(((j-i)+1)>=5)
						break;
					if(((j-i)+1)==3)
					{	
						if((a[i]<=a[i+1] && a[i+1]<=a[i+2])||(a[i]>=a[i+1] && a[i+1]>=a[i+2]))
							continue outer;
						else
							count++;
					}
					else if(((j-i)+1)==4)
					{	
//						System.out.println("is equal to 4");
						
						for(int l=i;l<i+4;l++)
						{
							for(int m=l+1;m<i+4;m++)
							{
								for(int o=m+1;o<i+4;o++)
								{	
//									System.out.println("l,m,o = "+l+","+m+","+o);
									if((a[l]<=a[m]&&a[m]<=a[o]) || 
									   (a[l]>=a[m]&&a[m]>=a[o]))
									{
										continue outer;
									}
								}
							}
						}
						count++;
					}
//					System.out.println("count = "+count+"\n");
				}
			}
			sb.append(count+"\n");
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