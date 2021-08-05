class Solution {
    List<Integer> g[];
    int vis[];
    public int findCircleNum(int[][] mat) {
        
        int n=mat.length;
        g=new ArrayList[n+1];
        vis=new int[n+1];
        
        for(int i=0;i<=n;i++)
            g[i]=new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==1 && i!=j)
                {
                    g[i+1].add(j+1);
                }
            }
        }
        
        int count=0;
        for(int i=1;i<=n;i++)
        {
            if(vis[i]!=1)
            {
                count++;
                dfs(i);
            }    
        }
        return count;
    }
    public void dfs(int n)
    {
        vis[n]=1;
        
        for(int child:g[n])
        {
            if(vis[child]!=1)
                dfs(child);
        }
    }
}