class NumArray {
    
    int a[],prefix[];
    
    public NumArray(int[] nums) 
    {
        int n=nums.length;
        a=new int[n+1];
        
        prefix=new int[n+1];
        
        for(int i=0;i<n;i++)
        {
            a[i+1]=nums[i];
            prefix[i+1]=prefix[i]+a[i+1];
        }
    }
    
    public int sumRange(int left, int right) {
        left++;
        right++;
        
        int ans=prefix[right]-prefix[left-1];
        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */