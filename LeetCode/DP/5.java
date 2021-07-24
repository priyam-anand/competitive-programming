class Solution {
    int dp[][];
    public String longestPalindrome(String s) {
        
        int max=0;
        String ans="";
        
        for(int i=0;i<s.length();i++)
        {
            String str=solveOdd(s,i);
            if(str.length()>max)
            {
                max=str.length();
                ans=str;
            }
        }
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                String str=solveEven(s,i-1,i);
                if(str.length()>max)
                {
                    max=str.length();
                    ans=str;
                }
            }
        }
        return ans;
    }
    public String solveOdd(String x,int idx)
    {   
        int l=idx-1,r=idx+1;
        int count=1;
        while(l>=0 && r<x.length())
        {
            if(x.charAt(l)==x.charAt(r))
                count+=2;
            else
                break;
            l--;r++;
        }
        String s=x.substring(l+1,r);
        return s;
    }
    public String solveEven(String x,int idx1,int idx2)
    {
        int l=idx1-1,r=idx2+1;
        int count=2;
        while(l>=0 && r<x.length())
        {
            if(x.charAt(l)==x.charAt(r))
                count+=2;
            else
                break;
            l--;r++;
        }
        String s=x.substring(l+1,r);
        return s;        
    }
}