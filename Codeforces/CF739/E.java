import java.io.*;
import java.util.*;

public class E {	
	
	public static void main(String[] args) {
		
		FastReader f = new FastReader();
		StringBuffer sb=new StringBuffer();
		
		int test=f.nextInt();
		while(test-->0)
		{
			char ch[]=f.next().toCharArray();
			
			int n=ch.length;
			int last[]=new int[26];
			int freq[]=new int[26];
			
			for(int i=0;i<26;i++)
				last[i]=-1;
			
			for(int i=0;i<n;i++)
			{
				last[ch[i]-'a']=i;
				freq[ch[i]-'a']++;
			}
			List<Pair> list=new ArrayList<>();
			for(int i=0;i<26;i++)
			{
				if(last[i]>-1)
					list.add(new Pair(last[i],(char)('a'+i)));
			}
			Collections.sort(list);
			
			StringBuilder ogs = new StringBuilder(),ogt=new StringBuilder(),imitate=new StringBuilder();
			for(int i=0;i<list.size();i++)
			{	
				Pair p=list.get(i);
				ogs.append(p.c);
				freq[p.c-'a']/=(i+1);
			}
			for(int i=0;i<n;i++)
			{
				if(freq[ch[i]-'a']==0)
					break;
				freq[ch[i]-'a']--;
				ogt.append(ch[i]);
			}

			String cS=ogt.toString();
			imitate.append(cS);
			boolean poss=true;
			for(int i=0;i<list.size();i++)
			{
				
				cS=cS.replace(list.get(i).c+"","");
				imitate.append(cS);
				if(imitate.length()>ch.length)
				{
					poss=false;
					break;
				}
			}
//			System.out.println("imitate = "+imitate.toString());
			char im[]=imitate.toString().toCharArray();
			if(im.length!=ch.length)
				poss=false;
			else
			{
				for(int i=0;i<ch.length;i++)
				{	
					if(ch[i]!=im[i])
					{
						poss=false;
							break;
					}
				}
			}
				
			
			if(poss)
				sb.append(ogt.toString()+" "+ogs.toString()+"\n");
			else
				sb.append("-1\n");
		}
		System.out.println(sb);
	}
	
	static class Pair implements Comparable<Pair>
	{
		char c;
		int i;
		
		Pair(int i,char c)
		{
			this.i=i;
			this.c=c;
		}
		@Override
		public int compareTo(Pair o) {
			return Integer.compare(i,o.i);
		}
		
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
