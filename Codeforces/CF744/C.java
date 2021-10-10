import java.io.*;
import java.util.*;

 public class C {
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			int n = f.nextInt();
            int m = f.nextInt();
            int d = f.nextInt();
            String[] str = new String[n];
            for (int i = 0; i < n; i++) {
                String num = f.nextLine();
                str[i] = num;
            }
 
            int[][] left = new int[n][m];
            int[][] right = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (str[i].charAt(j) == '*') {
                        if (i > 0 && j > 0) {
                            left[i][j] = left[i - 1][j - 1] + 1;
                        } else {
                            left[i][j] = 1;
                        }
 
                        if (i > 0 && j < m - 1) {
                            right[i][j] = right[i - 1][j + 1] + 1;
                        } else {
                            right[i][j] = 1;
                        }
                    }
                }
            }
 
            boolean[][] vis = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (str[i].charAt(j) == '*') {
                        int min = Math.min(right[i][j], left[i][j]);
                        min--;
 
                        if (d <= min) {
 
                            for (int dist = 0; dist <= min; dist++) {
                                vis[i - dist][j - dist] = true;
                                vis[i - dist][j + dist] = true;
                            }
                        }
                    }
                }
            }
 
            int tag = 0;
            for (int i = 0; i < n; i++) 
                for (int j = 0; j < m; j++) 
                    if (str[i].charAt(j) == '*' && vis[i][j] == false) 
                    {
                        tag = 1;
                        break;
                    }
            if (tag == 0) 
                sb.append("YES\n");
            else 
                sb.append("NO\n");
            
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
