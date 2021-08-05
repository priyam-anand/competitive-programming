class Solution {
    
    List<Integer> g[];
    int n;
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) 
    {
        n=graph.length;
        g=new ArrayList[n];
        for(int i=0;i<n;i++)
            g[i]=new ArrayList<Integer>();
        
        for(int i=0;i<n;i++)
        {
            for(int j:graph[i])
                g[i].add(j);
        }
        
        dfs(0,new ArrayList<>());
        return ans;
    }
    public void dfs(int curr,List<Integer> list)
    {            
        list.add(curr);
        if(curr==n-1)
        {
            ans.add(list);
            return;
        }
        
        for(int child:g[curr])
        {
            List<Integer> newL=new ArrayList<>();
            for(int i:list)
                newL.add(i);
            dfs(child,newL);
        }            
    }
}