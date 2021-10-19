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
			int n=f.nextInt(),k=f.nextInt();
			List<Integer> arr=new ArrayList<>();
		    for(int i=0;i<k;i++)
		        arr.add(f.nextInt());
		    Collections.sort(arr);
		    int val=0,ct=0;
		    for(int i=k-1;i>=0;i--){
		        if(val+n-arr.get(i)<=n){
		            ct++;
		            val+=n-arr.get(i);
		        }
		        else
		            break;
		    }
		    int ans=ct,pos=0,st=k-ct;
		    for(int i=k-ct;i<k;i++){
		        if(pos>=arr.get(i)){
		            pos+=n-arr.get(st);
		            st++;
		            ans--;
		        }
		        pos+=n-arr.get(i);
		    }
		    sb.append(ans+"\n");
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
