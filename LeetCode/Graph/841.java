class Solution {
    
    List<List<Integer>> g;
    int vis[];
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        g=rooms;
        vis=new int[rooms.size()];
        int count=0;
        for(int i=0;i<rooms.size();i++)
        {
            if(vis[i]!=1)
            {
                count++;
                dfs(i);
            }
        }
        return count==1?true:false;
    }
    public void dfs(int n)
    {
        vis[n]=1;
        for(int child:g.get(n))
        {
            if(vis[child]!=1)
                dfs(child);
        }
    }
}