class Solution {
    public int minFlipsMonoIncr(String s) {
        
        char ch[]=s.toCharArray();
        int n=ch.length;
        int z[]=new int[n],o[]=new int[n];
        
        z[0]=ch[0]=='0'?0:1;
        o[n-1]=ch[n-1]=='1'?0:1;
        
        for(int i=1;i<n;i++)
        {   
            z[i]=z[i-1];
            if(ch[i]=='1')
                z[i]++;
        }
        for(int i=n-2;i>=0;i--)
        {
            o[i]=o[i+1];
            if(ch[i]=='0')
                o[i]++;
        }
        
        int min=Math.min(o[0],z[n-1]);
        for(int i=1;i<n;i++)
            min=Math.min(Math.min(o[i-1]+z[i],o[i]+z[i-1]),min);
        return min;
    }
}