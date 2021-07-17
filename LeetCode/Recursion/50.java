class Solution {
    public double myPow(double x, int n) {
        
        double val=power(x,Math.abs(n));
        if(n<0)
            return 1/val;
        else 
            return val;
        
    }
    public double power(double x, long y)
    {       
        y=Math.abs(y);
        double res=1;
        while(y>0)
        {
            if(y%2!=0)
                res=res*x;
            y=y/2; 
            x=x*x;  
        }
        return res;
    }
}