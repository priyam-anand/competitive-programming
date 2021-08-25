	import java.io.*;
	import java.util.*;
	
	 class A {
		
		public static void main(String[] args) {
			
			FastReader f=new FastReader();
			StringBuffer sb=new StringBuffer();
			
			int test=f.nextInt();
			while(test-->0)
			{
				int n=f.nextInt();
				int a[]=new int[n];
				Map<Integer,Integer> map=new HashMap<>();
				for(int i=0;i<n;i++)
				{
					a[i]=f.nextInt();
					map.put(a[i], map.getOrDefault(a[i],0)+1);
				}
				if(n<=2)
				{
					sb.append("0\n");
					continue;
				}
				int max=0;
				for(int key:map.keySet())
					max=Math.max(max,map.get(key));
				if(max==1)
					max=2;
				sb.append((n-max)+"\n");
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
