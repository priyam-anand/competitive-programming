class Solution {
    int par[];
    public int[] findRedundantConnection(int[][] edges) {
        
        int n=edges.length;
        
        par=new int[n+1];
        for(int i=1;i<=n;i++)
            par[i]=i;
        
        int ans[]=new int[2];
        for(int i=0;i<n;i++)
        {
            int x=edges[i][0];
            int y=edges[i][1];
            
            int a=find_set(x);
            int b=find_set(y);
            
            if(a!=b)
                par[a]=b;
            else
            {
                ans[0]=x;
                ans[1]=y;
                break;
            }    
        }
        return ans;
    }
    public int find_set(int a)
    {
        if(par[a]==a)
            return a;
        return par[a]=find_set(par[a]);
    }
}