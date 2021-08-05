class Solution {
    
    int par[],extra=0;

    public int makeConnected(int n, int[][] conn) {
        
        int len=conn.length;
        if(len<n-1)
            return -1;
        
        par=new int[n];
        for(int i=0;i<n;i++)
            par[i]=i;
        
        for(int i=0;i<conn.length;i++)
        {
            int x=conn[i][0];
            int y=conn[i][1];
            
            int a=find_set(x);
            int b=find_set(y);
            
            if(a!=b)
                par[a]=b;
        }
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<n;i++)
        {
            int a=find_set(i);
            set.add(a);
        }
        return set.size()-1;
    }
    
    public void make_set(int v)
    {
        par[v]=v;
    }
    public int find_set(int a)
    {
        if(a==par[a])
            return a;
        return par[a]=find_set(par[a]);
    }
}