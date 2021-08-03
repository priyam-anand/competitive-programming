class Solution {
    Set<List<Integer>> ans=new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        solve(nums,0,new ArrayList<>());
        List<List<Integer>> a=new ArrayList<>();
        for(List<Integer> l: ans)
            a.add(l);
        return a;
    }
    public void solve(int a[],int n,List<Integer> l)
    {
        if(n==a.length)
        {   
            // add to global
            Collections.sort(l);
            ans.add(l);
            return;
        }   
        
        List<Integer> m1=new ArrayList<>();
        for(int i:l)
            m1.add(i);
        m1.add(a[n]);
        solve(a,n+1,m1);
        m1=new ArrayList<Integer>();
        for(int i:l)
            m1.add(i);
        solve(a,n+1,m1);
    }
}