class Solution {
    public int maxProfit(int[] a) {
        int ans=0;
        int n=a.length;
        int curr=a[0];
        for(int i=1;i<n;i++)
        {
            while(i<n && a[i]<a[i-1])
                i++;
            curr=a[i-1];
            // System.out.println("curr - "+curr);
            while(i<n && a[i]>=a[i-1])   
                i++;
            ans+=(a[i-1]-curr);
        }
        return ans;
    }
}