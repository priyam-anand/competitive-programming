import java.io.*;
import java.util.*;

public class B {	

	public static void main(String[] args)throws Exception{
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		FileWriter fWriter = new FileWriter("C:\\Users\\priya\\OneDrive\\Desktop\\hacker cup input\\output1.txt");
		
		int caseNo=1;
		int test=f.nextInt();
		while(test-->0)
		{
			int n=f.nextInt();
			int m=f.nextInt();
			
			int a=f.nextInt();
			int b=f.nextInt();
			
			if(a<(n+m-1)||b<(n+m-1))
			{
				sb.append("Case #"+caseNo+": Impossible\n");
				caseNo++;
				continue ;
			}
			int ans[][]=new int[n][m];
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					ans[i][j]=1000;
			for(int i=0;i<n;i++)
			{
				ans[i][0]=1;
				ans[i][m-1]=1;
			}
			for(int i=0;i<m;i++)
				ans[n-1][i]=1;
			
			ans[0][0]=(a-(n+m-2));
			ans[0][m-1]=(b-(n+m-2));
			
			sb.append("Case #"+caseNo+": Possible\n");
			for(int i[]:ans)
			{
				for(int j:i)
					sb.append(j+" ");
				sb.append("\n");
			}
			caseNo++;
		}
		fWriter.write(sb.toString());
		fWriter.close();
	}
	
	static class FastReader 
	{ 
	    BufferedReader br; 
	    StringTokenizer st; 
 
	    public FastReader() throws Exception{
	    	File file = new File("C:\\Users\\priya\\OneDrive\\Desktop\\hacker cup input\\input1.txt");
	    	br = new BufferedReader(new FileReader(file)); 
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