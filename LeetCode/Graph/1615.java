class Solution {
    Set<Integer> g[];
    public int maximalNetworkRank(int n, int[][] roads) {
        
        g=new HashSet[n];
        for(int i=0;i<n;i++)
            g[i]=new HashSet<>();
        
        for(int i=0;i<roads.length;i++)
        {
            int x=roads[i][0];
            int y=roads[i][1];
            
            g[x].add(y);
            g[y].add(x);
        }
        int max=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int curr=g[i].size()+g[j].size();
                if(g[i].contains(j) || g[j].contains(i))
                    curr--;
                max=Math.max(max,curr);
            }
        }
        return max;
    }
}