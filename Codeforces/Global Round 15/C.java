import java.io.*;
import java.util.*;

public class C {
	
	
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			int k=f.nextInt();
			
			Set<Integer> list=new HashSet<>();
			for(int i=1;i<=2*n;i++)
				list.add(i);
			int used[][]=new int[k][2];
			for(int i=0;i<k;i++)
			{
				used[i][0]=f.nextInt();
				used[i][1]=f.nextInt();

				list.remove(used[i][0]);
				list.remove(used[i][1]);
			}
			List<Integer> notUsed=new ArrayList<>();
			for(int i:list)
				notUsed.add(i);
			Collections.sort(notUsed);
			int left=n-k;
//			System.out.println("left = "+left);
//			System.out.println(notUsed);
			long ans=0;
			if(left>=2)
				ans+=getNcR(left,2);
//			System.out.println("ans after = "+ans);
			for(int i=0;i<k;i++)
			{
				int l=Math.min(used[i][0],used[i][1]);
				int r=Math.max(used[i][0],used[i][1]);
				
				int lIdx=Collections.binarySearch(notUsed,l);
				int rIdx=Collections.binarySearch(notUsed,r);
				lIdx++;
				lIdx*=-1;
				
				rIdx++;
				rIdx*=-1;				
				int sum=(Math.min(rIdx,lIdx))+(notUsed.size()-Math.max(rIdx,lIdx));
				int dif=Math.min(Math.abs(rIdx-lIdx),sum);
				ans+=dif;
			}
			for(int i=0;i<k;i++)
			{	
				int currX=Math.min(used[i][0],used[i][1]);
				int currY=Math.max(used[i][0],used[i][1]);
				for(int j=i+1;j<k;j++)
				{
					int x=Math.min(used[j][0],used[j][1]);
					int y=Math.max(used[j][0],used[j][1]);
					int count=0;
					if((x>currX && x<currY))
						count++;
					if((y>currX && y<currY))
						count++;
					if(count==1)
						ans++;
				}
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
	
	static long getNcR(int n, int r)
    {
        long p = 1, k = 1;
        if (n - r < r) {
            r = n - r;
        }
        if (r != 0) {
            while (r > 0) {
                p *= n;
                k *= r;
                long m = __gcd(p, k);
                p /= m;
                k /= m;
                n--;
                r--;
            }
        }
        else {
            p = 1;
        }
        return p;
    }
 
    static long __gcd(long n1, long n2)
    {
        long gcd = 1;
 
        for (int i = 1; i <= n1 && i <= n2; ++i) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
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