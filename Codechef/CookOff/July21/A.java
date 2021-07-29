	import java.io.*;
	import java.util.*;
	
	 class A {
	
		public static void main(String[] args) {
			
			FastReader f = new FastReader();
			StringBuffer sb=new StringBuffer();
			
			int test=f.nextInt();
		
			while(test-->0)
			{
				int x=f.nextInt();
				int y=f.nextInt();
				
				if(gcd(x,y)>1)
					sb.append("0\n");
				else
				{	
					int min=Math.min(x,y);
					int max=Math.max(x, y);
					
					if(x%2==0 || y%2==0)
						sb.append("1\n");
					else if(gcd(min+1,max)>1 || gcd(min,max+1)>1)
						sb.append("1\n");
					else
						sb.append("2\n");
				}
			}
			System.out.println(sb);
		}
		
		static int gcd(int a, int b)
	    {
	      if (b == 0)
	        return a;
	      return gcd(b, a % b);
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
