	import java.io.*;
	import java.util.*;
	
	public class A {
	
		public static void main(String[] args) {
			
			FastReader f = new FastReader();
			StringBuffer sb=new StringBuffer();
			
			List<Integer> list=new ArrayList<>();
			for(int i=0;i<15000;i++)
			{
				if(i%3==0 || i%10==3)
					continue;
				list.add(i);
			}
			
			int test=f.nextInt();
			while(test-->0)
			{
				int n=f.nextInt();
				
				sb.append(list.get(n-1)+"\n");
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
