	import java.io.*;
	import java.util.*;
	
	 class A {
	
		public static void main(String[] args) {
			
			FastReader f = new FastReader();
			StringBuffer sb=new StringBuffer();
			
			int test=f.nextInt();
		
			while(test-->0)
			{
				int n=f.nextInt();
				List<Integer> list=new ArrayList<>();
				for(int i=0;i<n;i++)
					list.add(f.nextInt());
				long ans=0;
				Collections.sort(list);
//				System.out.println(list);
				for(int i=0;i<n;i++)
				{	
					int key=list.get(i)+1;
					int idx=firstOcc(list,key);
//					System.out.println("curr Idx = "+idx);
					if(idx<0)
					{
						idx=Collections.binarySearch(list,key);
						idx++;
						idx*=-1;
					}
//					System.out.println("idx fnl = "+idx);
					long add=2L*(n-idx);
//					System.out.println("add = "+add);
					ans+=add;
				}
				sb.append(ans+"\n");
			}
			System.out.println(sb);
		}
	
		static int firstOcc(List<Integer> list,int key)
		{
			int l=0,r=list.size()-1;
			int ans=-1;
			while(l<=r)
			{
				int mid=(l+r)/2;
				int val=list.get(mid);
				if(val==key)
				{
					ans=mid;
					r=mid-1;
				}
				else if(val>key)
					r=mid-1;
				else
					l=mid+1;
			}
			return ans;
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
