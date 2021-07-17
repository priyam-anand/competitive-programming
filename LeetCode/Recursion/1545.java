class Solution {
    int len[]=new int[25];
    public char findKthBit(int n, int k) 
    {
        len[1]=1;
        for(int i=2;i<25;i++)
            len[i]=(2*len[i-1])+1;
        
        int val=solve(n,k);
        
        return (char)(val+'0');
    }
    public int solve(int n,int k)
    {   
        if(n==1)
            return 0;
        if(k==(len[n]+1)/2)
            return 1;
        
        if(k<(len[n]+1)/2)
            return solve(n-1,k);
        
        else 
        {
            int dif=k-(len[n]+1)/2;
            int newK=(len[n]+1)/2 - dif;
            return 1^solve(n-1,newK);
        }
    }
}