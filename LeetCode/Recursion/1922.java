class Solution {
    long mod = (long)(1e9)+7;
    public int countGoodNumbers(long n) {
        long len=n;
        
        long even=(len+1)/2;
        long odd=len/2;
        long evenNo=5;
        long oddNo=4;
        
        long ans = ((fastPow(evenNo,even))%mod * (fastPow(oddNo,odd))%mod)%mod;                            
        return (int)ans;
    }
    public long fastPow(long n,long x)
    {
        long res=1;
        while(x>0)
        {
            if(x%2!=0)
                res=((res%mod)*(n%mod))%mod;
            n=((n%mod)*(n%mod))%mod;
            x=x/2;
        }
        return res%mod;
    }
}