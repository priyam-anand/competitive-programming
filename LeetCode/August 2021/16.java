class Solution {
    // int dp[][][];
    public int threeSumClosest(int[] num, int target) {
        
        int n=num.length;
        Arrays.sort(num);
        
        int ans=num[n-1]+num[n-2]+num[n-3];
        for(int i=0;i<n-2;i++) 
        {
            int l=i+1,r=n-1;
            while(l<r) 
            {
                int curr=num[i]+num[l]+num[r];
                
                if(Math.abs(curr-target)<Math.abs(ans-target)) 
                    ans=curr;
                
                if(curr>target) 
                    r--;
                else 
                    l++;
            }
        }
        
        return ans;
        
    }
}