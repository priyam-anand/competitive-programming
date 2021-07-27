	import java.io.*;
	import java.util.*;
	
	 class A {
	
		public static void main(String[] args) {
			
			FastReader f = new FastReader();
			StringBuffer sb=new StringBuffer();
			
			int n=f.nextInt();
			int q=f.nextInt();
			
			List<Integer> list=new ArrayList<>();
			for(int i=0;i<n;i++)
				list.add(f.nextInt());
			Collections.sort(list);
		
			while(q-->0)
			{
				int x=f.nextInt();
				int idx=Collections.binarySearch(list, x);
				if(idx>=0)
				{
					sb.append("0\n");
					continue;
				}
				idx++;
				idx*=-1;
				int neg=idx;
				
				if(neg%2!=0)
					sb.append("NEGATIVE\n");
				else
					sb.append("POSITIVE\n");
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
