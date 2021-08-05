class Solution {
    
    List<Integer> g[];
    int vis[];
    public int minReorder(int n, int[][] conn) {
    
        g=new ArrayList[n];
        vis=new int[n];
        for(int i=0;i<n;i++)
            g[i]=new ArrayList<>();
    
        for(int a[]:conn)
        {
            g[a[0]].add(a[1]);
            g[a[1]].add(-a[0]);
        }

        return dfs(0);
    }
    
    public int dfs(int n) {
        
        int ans=0;
        vis[n]=1;
        for(int child:g[n])
        {
            if(vis[Math.abs(child)]!=1)
                ans+=dfs(Math.abs(child))+(child>0?1:0);
        }
        return ans;
    }
}

