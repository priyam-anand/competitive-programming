	import java.io.*;
	import java.util.*;
	
	public class A {
	
		public static void main(String[] args) {
			
			FastReader f = new FastReader();
			StringBuffer sb=new StringBuffer();
			
			int test=f.nextInt();
			while(test-->0)
			{
				int n=f.nextInt();
				int a=0,b=0;
				if(n%3==0)
					a=b=n/3;
				else
				{ 
					a=n/3;
					b=n/3;
					if(n%3==1)
						a++;
					else
						b++;
				}
				sb.append(a+" "+b+"\n");
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
