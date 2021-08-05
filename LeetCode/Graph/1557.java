class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int inDeg[]=new int[n];
        for(List<Integer> l:edges)
        {
            int y=l.get(1);
            inDeg[y]++;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(inDeg[i]==0)
                ans.add(i);
        }
        return ans;
    }
}