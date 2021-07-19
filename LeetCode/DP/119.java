class Solution {
    public List<Integer> getRow(int n) {
        List<Integer> curr=new ArrayList<>();
        curr.add(1);
        if(n==0)
            return curr;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {       
            ans=new ArrayList<>();
            for(int j=0;j<i+2;j++)
            {
                if(j==0 || j==i+1)
                    ans.add(1);
                else
                {
                    int val=curr.get(j-1)+curr.get(j);
                    ans.add(val);
                }
            }
            curr=ans;
        }
        return ans;
    }
}