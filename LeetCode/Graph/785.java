class Solution {
    Set<Integer> g[];
    int[] vis,col;
    public boolean isBipartite(int[][] graph) {
        
        int n=graph.length;
        g=new HashSet[n];
        vis=new int[n];
        col=new int[n];
        
        for(int i=0;i<n;i++)
        {
            g[i]=new HashSet<>();
            col[i]=-1;
        }    
        for(int i=0;i<n;i++)
        {
            int x=i;
            for(int j=0;j<graph[i].length;j++)
            {
                int y=graph[i][j];
                g[x].add(y);
                g[y].add(x);
            }
        }
        boolean ans=true;
        for(int i=0;i<n;i++)
        {
            if(vis[i]!=1)
                ans=ans&dfs(i,0);
        }
        return ans;
        
    }
    public boolean dfs(int n,int c)
    {
        vis[n]=1;
        col[n]=c;
        boolean ret=true;
        for(int child:g[n])
        {
            if(vis[child]==0)
                 ret&=dfs(child,c^1);
            else if(col[child]==c)
                ret&=false;
        }
        return ret;
    }
}