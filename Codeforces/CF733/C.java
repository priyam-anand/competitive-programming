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
			List<Integer> a=new ArrayList<>(),b=new ArrayList<>();
			for(int i=0;i<n;i++)
				a.add(f.nextInt());
			for(int i=0;i<n;i++)
				b.add(f.nextInt());
			
			Collections.sort(a,Collections.reverseOrder());
			Collections.sort(b,Collections.reverseOrder());
			
			PriorityQueue<Integer> pqa=new PriorityQueue<>();
			PriorityQueue<Integer> pqb=new PriorityQueue<>(Collections.reverseOrder());

			long suma=0,sumb=0;
			
			int k=n-(int)Math.ceil(n/4);
			for(int i=0;i<k;i++)
			{
				suma+=a.get(i);
				sumb+=b.get(i);
				pqa.add(a.get(i));
			}
			for(int i=k;i<n;i++)
				pqb.add(b.get(i));
//			System.out.println("suma = "+suma);
//			System.out.println("sumb = "+sumb);
//			
//			System.out.println("pqa = "+pqa);
//			System.out.println("pqb = "+pqb);
			if(suma>=sumb)
			{
				sb.append("0\n");
				continue;
			}
			int count=0;
			while(suma<sumb)
			{
				suma+=100;
				pqa.add(100);

				n++;
				if(n%4==0)
				{	
//					System.out.println("n was mod 4");
					if(!pqa.isEmpty())
					{	
//						System.out.println("sumA = "+suma);
						suma-=pqa.poll();
					}
//					if(!pqb.isEmpty())
//						sumb+=pqb.poll();
				}
				else
				{
					if(!pqb.isEmpty())
					sumb+=pqb.poll();
				}
				count++;
				
//				System.out.println("suma = "+suma);
//				System.out.println("sumb = "+sumb+"\n");
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